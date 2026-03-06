package com.example.marstravelsbookings.Main.controllers;

import com.example.marstravelsbookings.Main.services.NavigationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RootLayoutController
{
    @FXML
    private Button nextViewButton;

    @FXML
    private Button previousViewButton;

    @FXML
    private BorderPane rootPane;

    @FXML
    private Button saveButton;

    @FXML
    private Label selectedPriceLabel;

    final List<String> viewPaths;

    public RootLayoutController()
    {
        viewPaths = Arrays.asList(
                "/views/Evenemang.fxml",
                "/views/Hyttar.fxml");
    }

    @FXML
    public void initialize() {
        // Registrera root
        NavigationService.setRoot(rootPane);

        // Visa startsida
        NavigationService.loadView(viewPaths.getFirst());
    }

    @FXML
    public void setNextView(ActionEvent event)
    {
        NavigationService.loadView(viewPaths.get(1));
    }

    @FXML
    public void setPreviousView(ActionEvent event)
    {
        NavigationService.loadView(viewPaths.get(0));
    }
        NavigationService.loadView("/views/Evenemang.fxml");
    } // test
}