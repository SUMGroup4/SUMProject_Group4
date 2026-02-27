package com.example.marstravelsbookings.Main.models;

public class Traveler {
    private final String firstName;
    private final String lastName;
    private final String idNumber;
    private final String notes;

    public Traveler(String firstName, String lastName, String idNumber, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.notes = notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getNotes() {
        return notes;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
