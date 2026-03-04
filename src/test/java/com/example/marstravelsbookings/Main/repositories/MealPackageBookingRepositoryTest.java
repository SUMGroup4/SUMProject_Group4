package com.example.marstravelsbookings.Main.repositories;

import com.example.marstravelsbookings.Main.EmilsLåda.MealPackageBooking;
import com.example.marstravelsbookings.Main.EmilsLåda.MealPackageBookingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MealPackageBookingRepositoryTest {

    private final MealPackageBookingRepository repository = MealPackageBookingRepository.getInstance();

    @AfterEach
    void tearDown() {
        repository.clearAll();
    }

    @Test
    void save_and_findByCustomerId_saves_booking_for_right_customer() {
        MealPackageBooking bookingA = new MealPackageBooking(
                "CUST-1001",
                "Budget",
                "Budget 1",
                "27 000 kr/pers",
                "Samtliga måltider under resan intas på MarsDonalds.",
                LocalDateTime.of(2026, 2, 27, 10, 0)
        );
        MealPackageBooking bookingB = new MealPackageBooking(
                "CUST-2002",
                "Lyx",
                "Lyx 2",
                "150 000 kr/pers",
                "Frukost och mellanmål intas på Tellus Home medan lunch och middag intas på SpaceView.",
                LocalDateTime.of(2026, 2, 27, 11, 0)
        );

        repository.save(bookingA);
        repository.save(bookingB);

        MealPackageBooking fetchedA = repository.findByCustomerId("CUST-1001").orElse(null);
        MealPackageBooking fetchedB = repository.findByCustomerId("CUST-2002").orElse(null);

        assertNotNull(fetchedA);
        assertNotNull(fetchedB);
        assertEquals("CUST-1001", fetchedA.getCustomerId());
        assertEquals("Budget 1", fetchedA.getPackageName());
        assertEquals("CUST-2002", fetchedB.getCustomerId());
        assertEquals("Lyx 2", fetchedB.getPackageName());
    }

    @Test
    void save_overwrites_existing_booking_for_same_customer() {
        MealPackageBooking first = new MealPackageBooking(
                "CUST-1001",
                "Budget",
                "Budget 1",
                "27 000 kr/pers",
                "Samtliga måltider under resan intas på MarsDonalds.",
                LocalDateTime.of(2026, 2, 27, 10, 0)
        );
        MealPackageBooking updated = new MealPackageBooking(
                "CUST-1001",
                "Mellan",
                "Mellan 2",
                "90 000 kr/pers",
                "All måltider förutom middag intas på Marsian Buffé. Middagarna intas på Tellus Home.",
                LocalDateTime.of(2026, 2, 27, 12, 0)
        );

        repository.save(first);
        repository.save(updated);

        MealPackageBooking fetched = repository.findByCustomerId("CUST-1001").orElse(null);

        assertNotNull(fetched);
        assertEquals("Mellan 2", fetched.getPackageName());
        assertEquals("Mellan", fetched.getCategory());
    }

    @Test
    void findByCustomerId_returns_empty_when_missing() {
        assertTrue(repository.findByCustomerId("UNKNOWN").isEmpty());
    }
}
