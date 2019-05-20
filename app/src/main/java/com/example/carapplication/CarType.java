package com.example.carapplication;

public enum CarType {
    SPORTS_CAR("Sportscar", 1.25),
    DAILY_DRIVER("Daily Driver", 1);


    private String name;

    private double modifier;

    CarType(String name, double modifier) {
        this.name = name;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public double getModifier() {
        return modifier;
    }

    public static CarType getCarTypeFromName(String name){

        for (CarType value : CarType.values()){
            if(value.getName() == name){
                return value;
            }
        }

        return CarType.DAILY_DRIVER;
    }
}
