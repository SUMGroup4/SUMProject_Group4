package com.example.marstravelsbookings.Main.models;

public class Customer {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;

    public Customer(String id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDisplayName() {
        return firstName + " " + lastName;
    }
}
