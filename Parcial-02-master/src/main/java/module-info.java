module com.example.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parcial2 to javafx.fxml;
    exports com.example.parcial2;
}