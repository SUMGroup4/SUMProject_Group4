package com.example.marstravelsbookings.Main.controllers;

import com.example.marstravelsbookings.Main.models.MealPackage;
import com.example.marstravelsbookings.Main.models.Traveler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTill_Bokning_av_matpaket implements Initializable {
    @FXML private Button newBookingButton;
    @FXML private Button cancelButton;
    @FXML private TextField searchField;
    @FXML private CheckBox availableOnlyCheck;
    @FXML private Label topStatusLabel;

    @FXML private DatePicker fromDatePicker;
    @FXML private DatePicker toDatePicker;
    @FXML private Spinner<Integer> maxPriceSpinner;
    @FXML private CheckBox allergenGluten;
    @FXML private CheckBox allergenLactose;
    @FXML private CheckBox allergenNuts;
    @FXML private CheckBox allergenSoy;
    @FXML private Button clearFiltersButton;

    @FXML private TabPane wizardTabs;
    @FXML private Label availabilityHintLabel;
    @FXML private TableView<MealPackage> mealPackageTable;
    @FXML private TableColumn<MealPackage, String> colPkgName;
    @FXML private TableColumn<MealPackage, String> colPkgType;
    @FXML private TableColumn<MealPackage, String> colPkgAllergens;
    @FXML private TableColumn<MealPackage, String> colPkgPrice;
    @FXML private TableColumn<MealPackage, String> colPkgSeats;
    @FXML private TableColumn<MealPackage, String> colPkgStatus;
    @FXML private Label selectedPackageLabel;
    @FXML private Label packageErrorLabel;

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField customerIdField;
    @FXML private TextArea notesArea;
    @FXML private Label customerValidationLabel;

    @FXML private Button addTravelerButton;
    @FXML private Button removeTravelerButton;
    @FXML private TableView<Traveler> travelersTable;
    @FXML private TableColumn<Traveler, String> colTravelerFirstName;
    @FXML private TableColumn<Traveler, String> colTravelerLastName;
    @FXML private TableColumn<Traveler, String> colTravelerId;
    @FXML private TableColumn<Traveler, String> colTravelerNotes;
    @FXML private Label travelersHintLabel;
    @FXML private Label travelersValidationLabel;

    @FXML private Label summaryPackage;
    @FXML private Label summaryPrice;
    @FXML private Label summaryCustomer;
    @FXML private Label summaryContact;
    @FXML private Label summaryTravelerCount;
    @FXML private TableView<Traveler> summaryTravelersTable;
    @FXML private TableColumn<Traveler, String> colSumTravelerName;
    @FXML private TableColumn<Traveler, String> colSumTravelerId;
    @FXML private Label summaryErrorLabel;

    @FXML private Label statusLabel;
    @FXML private Button backButton;
    @FXML private Button nextButton;
    @FXML private Button confirmButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupMealPackageTable();
        setupTravelersTable();
        setupSummaryTable();
        setupPriceSpinner();
        seedDemoData();
    }

    private void setupMealPackageTable() {
        colPkgName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPkgType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPkgAllergens.setCellValueFactory(new PropertyValueFactory<>("allergens"));
        colPkgPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colPkgSeats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        colPkgStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void setupTravelersTable() {
        colTravelerFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colTravelerLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colTravelerId.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
        colTravelerNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));
    }

    private void setupSummaryTable() {
        colSumTravelerName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colSumTravelerId.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
    }

    private void setupPriceSpinner() {
        maxPriceSpinner.setEditable(true);
        maxPriceSpinner.setValueFactory(new javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5000, 1200, 50));
        maxPriceSpinner.getEditor().setTextFormatter(new javafx.scene.control.TextFormatter<>(new IntegerStringConverter(), 1200));
    }

    private void seedDemoData() {
        ObservableList<MealPackage> packages = FXCollections.observableArrayList(
                new MealPackage("Mars Deluxe", "Premium", "Laktos", "1 499", "8", "Tillgänglig"),
                new MealPackage("Orbit Vegan", "Vegansk", "Soja", "1 099", "0", "Fullbokad"),
                new MealPackage("Astro Kids", "Barn", "Gluten", "699", "12", "Tillgänglig"),
                new MealPackage("Zero-G Snack", "Lätt", "Nötter", "399", "5", "Få platser")
        );
        mealPackageTable.setItems(packages);

        ObservableList<Traveler> travelers = FXCollections.observableArrayList(
                new Traveler("Eva", "Sund", "850101-1234", "Vegetarian"),
                new Traveler("Max", "Lund", "920404-5678", "Barnmeny")
        );
        travelersTable.setItems(travelers);
        summaryTravelersTable.setItems(travelers);

        if (!packages.isEmpty()) {
            MealPackage selected = packages.get(0);
            selectedPackageLabel.setText(selected.getName());
            summaryPackage.setText(selected.getName());
            summaryPrice.setText(selected.getPrice() + " SEK");
        }

        summaryCustomer.setText("Eva Sund");
        summaryContact.setText("eva@example.se, +46 70 123 45 67");
        summaryTravelerCount.setText(String.valueOf(travelers.size()));
        topStatusLabel.setText("Förhandsvisning");
        statusLabel.setText("Redo att testa flödet");
        confirmButton.setDisable(false);
        backButton.setDisable(true);
    }
}
