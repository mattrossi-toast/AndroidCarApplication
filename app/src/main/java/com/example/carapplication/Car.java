package com.example.carapplication;


public class Car {
    CarType carType;
    DriveType driveType;
    MaintenanceSchedule maintenanceSchedule;
    int mileage;

    Car(CarType carType, DriveType driveType, int mileage){
        this.carType = carType;
        this.driveType = driveType;
        this.mileage = mileage;
        this.maintenanceSchedule = new MaintenanceSchedule(this);

    }

    Car(CarType carType, DriveType driveType){
        this.carType = carType;
        this.driveType = driveType;
    }

    public double getOneMaintenanceInterval(MaintenanceItem maintenanceItem){

        double next = this.maintenanceSchedule.nextMaintenance.get(maintenanceItem.getName());

        return next;

    }

}
