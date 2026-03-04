package com.example.marstravelsbookings.Main.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class NavigationService {

    private static BorderPane rootPane;

    public static void setRoot(BorderPane pane) {
        rootPane = pane;
    }

    public static void loadView(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    NavigationService.class.getResource(fxml)
            );

            Parent view = loader.load();
            rootPane.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}