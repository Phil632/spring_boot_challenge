package com.codingChallenge.businessLocation;

public class BusinessLocation {
    private final String locationId;
    private final String name;
    private final String shortName;
    private final String shortType;

    public BusinessLocation(String locationId, String name, String shortName, String shortType) {
        this.locationId = locationId;
        this.name = name;
        this.shortName = shortName;
        this.shortType = shortType;
    };

    public String getLocationId() {
        return locationId;
    };

    public String getName() {
        return name;
    };

    public String getShortName() {
        return shortName;
    };

    public String getShortType() {
        return shortType;
    };

}
