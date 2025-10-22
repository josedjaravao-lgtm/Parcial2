package com.example.parcial2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private BorderPane mainDashboard;

    private final DashboardApp vistaGenerator = new DashboardApp();

    private VBox formularioPane;
    private VBox listadoPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        formularioPane = vistaGenerator.crearPanelFormulario();
        listadoPane = vistaGenerator.crearPanelListado();

        mainDashboard.setCenter(formularioPane);
    }

    @FXML
    private void showFormulario() {
        mainDashboard.setCenter(formularioPane);
    }

    @FXML
    private void showListado() {
        vistaGenerator.actualizarTablaListado();
        mainDashboard.setCenter(listadoPane);
    }
}