package com.example.marstravelsbookings.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MarsTravelsBookingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MarsTravelsBookingApplication.class.getResource("/views/RootLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("Mars Travels Bokningssystem");
        stage.setScene(scene);
        stage.show();
    }
}