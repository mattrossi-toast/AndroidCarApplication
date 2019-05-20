package com.example.carapplication;

public enum DriveType {
    SPIRITED("Spirited", 1.25),
    AVERAGE("Average", 1),
    SLOW_AND_STEADY("Slow and Steady" , 0.75);

    private String name;

    private double modifier;

    DriveType(String name, double modifier) {
        this.name = name;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public double getModifier() {
        return modifier;
    }


    public static DriveType getDriveTypeFromName(String name){

        for (DriveType value : DriveType.values()){
            if(value.getName() == name){
                return value;
            }
        }

        return DriveType.AVERAGE;
    }

}
