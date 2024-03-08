module com.example.csd214test3ankitkumar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.csd214test3ankitkumar to javafx.fxml;
    exports com.example.csd214test3ankitkumar;
}