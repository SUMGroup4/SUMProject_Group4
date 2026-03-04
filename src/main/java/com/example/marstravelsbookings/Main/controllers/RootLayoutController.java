package com.example.marstravelsbookings.Main.controllers;

import com.example.marstravelsbookings.Main.services.NavigationService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class RootLayoutController
{
    @FXML
    private Button bookButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button cancelButton1;

    @FXML
    private BorderPane rootPane;

    @FXML
    private Label selectedPriceLabel;
    @FXML
    public void initialize() {
        // Registrera root
        NavigationService.setRoot(rootPane);

        // Visa startsida
        NavigationService.loadView("/views/Evenemang.fxml");
    } // test
}