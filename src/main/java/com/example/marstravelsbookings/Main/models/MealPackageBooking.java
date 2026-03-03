package com.example.marstravelsbookings.Main.models;

import java.time.LocalDateTime;

public class MealPackageBooking {
    private final String customerId;
    private final String category;
    private final String packageName;
    private final String price;
    private final String description;
    private final LocalDateTime createdAt;

    public MealPackageBooking(String customerId,
                              String category,
                              String packageName,
                              String price,
                              String description,
                              LocalDateTime createdAt) {
        this.customerId = customerId;
        this.category = category;
        this.packageName = packageName;
        this.price = price;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCategory() {
        return category;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
