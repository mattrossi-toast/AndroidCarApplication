package com.example.carapplication;

import java.util.HashMap;

public class MaintenanceSchedule {
    HashMap<String, Double> nextMaintenance;


    MaintenanceSchedule(HashMap<String, Double> nextMaintenance){
        this.nextMaintenance = nextMaintenance;
    }

    MaintenanceSchedule(Car car){
        HashMap<String, Double> baseMaintenance = new HashMap<>();

        for (MaintenanceItem value : MaintenanceItem.values()) {

            double baseInterval = value.getBaseInterval();

            double withDriveInterval = getDriveModifier(car.driveType, baseInterval);

            double withCarInterval = getCarModifier(car.carType, withDriveInterval);

            baseMaintenance.put(value.getName(), (double)(car.mileage + withCarInterval));
        }

        this.nextMaintenance = baseMaintenance;
    }

    public void updateMaintenance(MaintenanceItem maintenanceItem, Car car){

        double nextMaintenanceInterval = getNextMaintenanceInterval(maintenanceItem, car);

        this.nextMaintenance.put(maintenanceItem.getName(), nextMaintenanceInterval);

    }

    public double getNextMaintenanceInterval(MaintenanceItem maintenanceItem, Car car){

        double baseInterval = maintenanceItem.getBaseInterval();

        double withDriveInterval = getDriveModifier(car.driveType, baseInterval);

        double withCarInterval = getCarModifier(car.carType, withDriveInterval);

        return withCarInterval;


    }

    public double getDriveModifier(DriveType driveType, double baseInterval){
        return baseInterval * driveType.getModifier();
    }

    public double getCarModifier(CarType carType, double interval){
        return carType.getModifier() * interval;
    }

}
