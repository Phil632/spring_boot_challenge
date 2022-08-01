package com.codingChallenge.businessLocation;

import com.codingChallenge.generalExceptions.InternalServerErrorException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

@Service
public class BusinessLocationService {

    private List<String[]> allData;

    public BusinessLocationService() {
        try {

            String inputFileName = new File(
                    "src/main/resources/static/DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv")
                            .getAbsolutePath();

            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader reader = new CSVReaderBuilder(new FileReader(inputFileName)).withCSVParser(parser).build();

            List<String[]> allData = reader.readAll();

            this.allData = allData;

        } catch (IOException exception) {
            System.out.println("IOException" + exception);
            throw new InternalServerErrorException(exception.getMessage());
        } catch (CsvException exception) {
            System.out.println("CsvException" + exception);
            throw new InternalServerErrorException(exception.getMessage());
        }
    }

    public BusinessLocation getLocationData(String locationId) {
        System.out.println("locationId " + locationId);

        String name = "";
        String shortName = "";
        String shortType = "";

        for (String[] line : allData) {

            if (line[1].toLowerCase().equals(locationId.toLowerCase())) {
                name = line[2];
                shortName = line[3];
                shortType = line[4];
                break;
            }
        }

        if (name.equals("")) {
            throw new BusinessLocationNotFoundException(locationId);
        }

        return new BusinessLocation(locationId, name, shortName, shortType);

    }
}
