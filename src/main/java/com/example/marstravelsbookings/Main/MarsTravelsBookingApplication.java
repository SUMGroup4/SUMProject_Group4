package com.example.marstravelsbookings.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MarsTravelsBookingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MarsTravelsBookingApplication.class.getResource("/UC#7/Bokning_av_matpaket.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        stage.setTitle("UC7 – Bokning av matpaket");
        stage.setScene(scene);
        stage.show();
    }
}
