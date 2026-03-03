package com.example.marstravelsbookings.Main.EmilsLåda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmilsMatpaketPreviewApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmilsMatpaketPreviewApplication.class.getResource("/UC#7/Emils-matpaket.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        stage.setTitle("Matpaket – Förhandsvisning");
        stage.setScene(scene);
        stage.show();
    }
}
