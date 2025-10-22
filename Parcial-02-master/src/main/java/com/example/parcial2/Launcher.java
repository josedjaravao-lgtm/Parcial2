package com.example.parcial2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        // Título actualizado
        stage.setTitle(" Registro de Inmuebles");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
