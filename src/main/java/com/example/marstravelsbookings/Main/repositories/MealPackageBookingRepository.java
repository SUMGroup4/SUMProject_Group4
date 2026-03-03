package com.example.marstravelsbookings.Main.repositories;

import com.example.marstravelsbookings.Main.models.MealPackageBooking;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MealPackageBookingRepository {
    private static final MealPackageBookingRepository INSTANCE = new MealPackageBookingRepository();
    private final Map<String, MealPackageBooking> bookingByCustomerId = new LinkedHashMap<>();

    private MealPackageBookingRepository() {
    }

    public static MealPackageBookingRepository getInstance() {
        return INSTANCE;
    }

    public void save(MealPackageBooking booking) {
        bookingByCustomerId.put(booking.getCustomerId(), booking);
    }

    public Optional<MealPackageBooking> findByCustomerId(String customerId) {
        return Optional.ofNullable(bookingByCustomerId.get(customerId));
    }

    public List<MealPackageBooking> findAll() {
        return new ArrayList<>(bookingByCustomerId.values());
    }

    public void clearAll() {
        bookingByCustomerId.clear();
    }
}
