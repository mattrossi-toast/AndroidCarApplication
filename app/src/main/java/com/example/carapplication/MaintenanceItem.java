package com.example.carapplication;

public enum MaintenanceItem {
    OIL("Oil", 3000),
    OIL_FILTER("Oil Filter", 4000),
    AIR_FILTER("Air Filter", 6000),
    FUEL_FILTER("Fuel Filter", 4000),
    BRAKES("Brakes", 6500),
    TIMING_BELT("Timing Belt", 100000),
    SPARK_PLUGS("Spark Plugs", 100000);


    private final String name;

    public String getName() {
        return name;
    }

    public Integer getBaseInterval() {
        return baseInterval;
    }

    private final Integer baseInterval;

    MaintenanceItem(String name, Integer baseInterval){
        this.name = name;
        this.baseInterval = baseInterval;
    }

}
