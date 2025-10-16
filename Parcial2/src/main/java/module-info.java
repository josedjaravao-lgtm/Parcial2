module com.example.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens com.example.parcial2 to javafx.fxml;
    exports com.example.parcial2;
}