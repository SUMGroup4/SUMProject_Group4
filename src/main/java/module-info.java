module com.example.marstravelsbookings {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.marstravelsbookings to javafx.fxml;
    exports com.example.marstravelsbookings;
    exports com.example.marstravelsbookings.Main;
    opens com.example.marstravelsbookings.Main to javafx.fxml;
}