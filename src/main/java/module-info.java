module com.example.marstravelsbookings {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.marstravelsbookings.Main.controllers to javafx.fxml;
    exports com.example.marstravelsbookings.Main;
}