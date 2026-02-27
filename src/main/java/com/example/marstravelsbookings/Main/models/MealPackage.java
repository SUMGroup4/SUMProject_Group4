package com.example.marstravelsbookings.Main.models;

public class MealPackage {
    private final String name;
    private final String type;
    private final String allergens;
    private final String price;
    private final String seats;
    private final String status;

    public MealPackage(String name, String type, String allergens, String price, String seats, String status) {
        this.name = name;
        this.type = type;
        this.allergens = allergens;
        this.price = price;
        this.seats = seats;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAllergens() {
        return allergens;
    }

    public String getPrice() {
        return price;
    }

    public String getSeats() {
        return seats;
    }

    public String getStatus() {
        return status;
    }
}
