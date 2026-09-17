package com.cms.model;

public class Vehicle {
    private int id;
    private String model;
    private String registration;
    private int year;
    private String color;
    private double mileage;

    public Vehicle() {}

    public Vehicle(int id, String model, String registration, int year, String color, double mileage) {
        this.id = id;
        this.model = model;
        this.registration = registration;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getRegistration() { return registration; }
    public void setRegistration(String registration) { this.registration = registration; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public double getMileage() { return mileage; }
    public void setMileage(double mileage) { this.mileage = mileage; }
}
