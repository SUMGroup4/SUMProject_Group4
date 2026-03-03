package com.example.marstravelsbookings.Main.repositories;

import com.example.marstravelsbookings.Main.models.Customer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CustomerRepository {
    private static final CustomerRepository INSTANCE = new CustomerRepository();
    private final Map<String, Customer> customersById = new LinkedHashMap<>();

    private CustomerRepository() {
    }

    public static CustomerRepository getInstance() {
        return INSTANCE;
    }

    public void seedIfEmpty(List<Customer> customers) {
        if (!customersById.isEmpty()) {
            return;
        }
        for (Customer customer : customers) {
            customersById.put(customer.getId(), customer);
        }
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customersById.values());
    }

    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(customersById.get(id));
    }
}
