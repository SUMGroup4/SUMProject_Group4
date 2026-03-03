package com.example.marstravelsbookings.Main.EmilsLåda;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class EmilsMatpaketController implements Initializable {
    @FXML private RadioButton budgetRadio;
    @FXML private RadioButton mellanRadio;
    @FXML private RadioButton lyxRadio;
    @FXML private ToggleGroup categoryGroup;
    @FXML private ComboBox<Customer> customerCombo;
    @FXML private ComboBox<String> packageCombo;
    @FXML private Label descriptionLabel;
    @FXML private Label priceLabel;
    @FXML private Label selectedPackageLabel;
    @FXML private Label selectedPriceLabel;
    @FXML private Label bookingStatusLabel;
    @FXML private Button cancelButton;
    @FXML private Button bookButton;

    private final Map<String, List<PackageInfo>> packageData = new LinkedHashMap<>();
    private final CustomerRepository customerRepository = CustomerRepository.getInstance();
    private final MealPackageBookingRepository bookingRepository = MealPackageBookingRepository.getInstance();
    private String activeCategory = "Budget";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seedCustomers();
        seedData();
        setupHandlers();
        setCategory("Budget");
        updateBookingStatus("Välj kund och paket för att boka.");
    }

    private void seedCustomers() {
        customerRepository.seedIfEmpty(List.of(
                new Customer("CUST-1001", "Eva", "Sund", "eva@example.se", "+46 70 123 45 67"),
                new Customer("CUST-1002", "Max", "Lund", "max@example.se", "+46 70 765 43 21"),
                new Customer("CUST-1003", "Lina", "Berg", "lina@example.se", "+46 72 222 33 44")
        ));
        ObservableList<Customer> customers = FXCollections.observableArrayList(customerRepository.findAll());
        customerCombo.setItems(customers);
        customerCombo.setPromptText("Välj kund (måste finnas i repository)");
        customerCombo.setCellFactory(listView -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Customer item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getDisplayName() + " (" + item.getId() + ")");
            }
        });
        customerCombo.setButtonCell(new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Customer item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getDisplayName() + " (" + item.getId() + ")");
            }
        });
    }

    private void seedData() {
        packageData.put("Budget", List.of(
                new PackageInfo("Budget 1", "Samtliga måltider under resan intas på MarsDonalds.", "27 000 kr/pers"),
                new PackageInfo("Budget 2", "All frukost och lunch intas på MarsDonalds medan mellanmål och middagarna intas på Marsian Buffé.", "40 000 kr/pers"),
                new PackageInfo("Budget 3", "Samtliga måltider under resan intas på Marsian Buffé.", "54 000 kr/pers")
        ));
        packageData.put("Mellan", List.of(
                new PackageInfo("Mellan 1", "All frukost intas på MarsDonalds, mellanmål och lunch på Marsian Buffé medan middagarna intas på Tellus Home.", "76 000 kr/pers"),
                new PackageInfo("Mellan 2", "All måltider förutom middag intas på Marsian Buffé. Middagarna intas på Tellus Home.", "90 000 kr/pers"),
                new PackageInfo("Mellan 3", "Samtliga måltider intas på Tellus Home.", "100 000 kr/pers")
        ));
        packageData.put("Lyx", List.of(
                new PackageInfo("Lyx 1", "All måltider förutom middag intas på Tellus Home medan middagarna intas på SpaceView.", "120 000 kr/pers"),
                new PackageInfo("Lyx 2", "Frukost och mellanmål intas på Tellus Home medan lunch och middag intas på SpaceView.", "150 000 kr/pers"),
                new PackageInfo("Lyx 3", "Samtliga måltider intas på SpaceView. För de som valt hyttalternativet Svit serveras frukosten i hytten från SpaceView.", "200 000 kr/pers")
        ));
    }

    private void setupHandlers() {
        categoryGroup.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null) {
                return;
            }
            if (newVal == budgetRadio) {
                setCategory("Budget");
            } else if (newVal == mellanRadio) {
                setCategory("Mellan");
            } else if (newVal == lyxRadio) {
                setCategory("Lyx");
            }
        });

        packageCombo.valueProperty().addListener((obs, oldVal, newVal) -> updateSelection(newVal));
        cancelButton.setOnAction(event -> clearSelection());
        bookButton.setOnAction(event -> handleBooking());
    }

    private void setCategory(String category) {
        activeCategory = category;
        List<PackageInfo> packages = packageData.getOrDefault(category, List.of());
        ObservableList<String> names = FXCollections.observableArrayList(packages.stream().map(p -> p.name).toList());
        packageCombo.setItems(names);
        packageCombo.getSelectionModel().clearSelection();
        descriptionLabel.setText("Välj kategori och paket för att se beskrivning.");
        priceLabel.setText("— kr/pers");
        selectedPackageLabel.setText("(inget valt)");
        selectedPriceLabel.setText("— kr/pers");
    }

    private void updateSelection(String name) {
        if (name == null) {
            clearSelection();
            return;
        }
        PackageInfo info = findPackage(name);
        if (info == null) {
            clearSelection();
            return;
        }
        descriptionLabel.setText(info.description);
        priceLabel.setText(info.price);
        selectedPackageLabel.setText(info.name);
        selectedPriceLabel.setText(info.price);
    }

    private PackageInfo findPackage(String name) {
        return packageData.values().stream()
                .flatMap(List::stream)
                .filter(p -> p.name.equals(name))
                .findFirst()
                .orElse(null);
    }

    private void clearSelection() {
        packageCombo.getSelectionModel().clearSelection();
        descriptionLabel.setText("Välj kategori och paket för att se beskrivning.");
        priceLabel.setText("— kr/pers");
        selectedPackageLabel.setText("(inget valt)");
        selectedPriceLabel.setText("— kr/pers");
    }

    private void handleBooking() {
        Customer customer = customerCombo.getValue();
        if (customer == null) {
            updateBookingStatus("Välj kund innan bokning kan sparas.");
            return;
        }
        String selectedPackage = packageCombo.getValue();
        if (selectedPackage == null) {
            updateBookingStatus("Välj ett paket innan bokning kan sparas.");
            return;
        }
        PackageInfo info = findPackage(selectedPackage);
        if (info == null) {
            updateBookingStatus("Kunde inte hitta paketet. Försök igen.");
            return;
        }
        MealPackageBooking booking = new MealPackageBooking(
                customer.getId(),
                activeCategory,
                info.name,
                info.price,
                info.description,
                LocalDateTime.now()
        );
        bookingRepository.save(booking);
        updateBookingStatus("Bokning sparad för " + customer.getDisplayName() + " (" + customer.getId() + ").");
    }

    private void updateBookingStatus(String message) {
        if (bookingStatusLabel != null) {
            bookingStatusLabel.setText(message);
        }
    }

    private static final class PackageInfo {
        private final String name;
        private final String description;
        private final String price;

        private PackageInfo(String name, String description, String price) {
            this.name = name;
            this.description = description;
            this.price = price;
        }
    }
}
