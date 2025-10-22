package com.example.parcial2;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DashboardApp extends Application {
    private TableView<Inmueble> tablaInmuebles; // Cambiado de Moto a Inmueble
    @Override
    public void start(Stage primaryStage) {
    }

    public void actualizarTablaListado() {
        if (tablaInmuebles != null) {
            tablaInmuebles.setItems(RegistroInmuebles.getListaInmuebles());
        }
    }

    public VBox crearPanelFormulario() {

        ComboBox<String> cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll("Casa", "Apartamento", "Finca", "Local");
        cmbTipo.getSelectionModel().selectFirst();

        TextField txtCiudad = new TextField();
        TextField txtHabitaciones = new TextField();
        TextField txtPisos = new TextField();
        TextField txtPrecio = new TextField();

        Label lblTipo = new Label("Tipo:");
        Label lblCiudad = new Label("Ciudad:");
        Label lblHabitaciones = new Label("Nº Habitaciones:");
        Label lblPisos = new Label("Nº Pisos:");
        Label lblPrecio = new Label("Precio:");

        Button btnGuardar = new Button("Guardar Inmueble");

        btnGuardar.setOnAction(e -> {
            try {
                String tipo = cmbTipo.getValue();
                String ciudad = txtCiudad.getText();
                int habitaciones = Integer.parseInt(txtHabitaciones.getText());
                int pisos = Integer.parseInt(txtPisos.getText());
                double precio = Double.parseDouble(txtPrecio.getText());

                if (tipo == null || ciudad.isEmpty() || habitaciones <= 0 || pisos <= 0 || precio <= 0) {
                    mostrarAlerta("Error", "Todos los campos son obligatorios y deben ser válidos.", Alert.AlertType.ERROR);
                    return;
                }

                Inmueble nuevoInmueble = new Inmueble(tipo, ciudad, habitaciones, pisos, precio);
                RegistroInmuebles.agregarInmueble(nuevoInmueble);

                cmbTipo.getSelectionModel().selectFirst();
                txtCiudad.clear();
                txtHabitaciones.clear();
                txtPisos.clear();
                txtPrecio.clear();

                mostrarAlerta("Éxito", "Inmueble registrado: " + nuevoInmueble.toString(), Alert.AlertType.INFORMATION);

            } catch (NumberFormatException ex) {
                mostrarAlerta("Error de Formato", "Habitaciones, Pisos y Precio deben ser números.", Alert.AlertType.ERROR);
            }
        });

        GridPane grid = new GridPane();
        grid.setVgap(10); grid.setHgap(10);
        grid.add(lblTipo, 0, 0); grid.add(cmbTipo, 1, 0);
        grid.add(lblCiudad, 0, 1); grid.add(txtCiudad, 1, 1);
        grid.add(lblHabitaciones, 0, 2); grid.add(txtHabitaciones, 1, 2);
        grid.add(lblPisos, 0, 3); grid.add(txtPisos, 1, 3);
        grid.add(lblPrecio, 0, 4); grid.add(txtPrecio, 1, 4);
        grid.add(btnGuardar, 1, 5);

        VBox formularioVbox = new VBox(20, new Label("Captura de Datos de Inmueble"), grid);
        formularioVbox.setPadding(new Insets(20));
        return formularioVbox;
    }

    public VBox crearPanelListado() {
        tablaInmuebles = new TableView<>();

        // Crear las columnas
        TableColumn<Inmueble, String> tipoCol = new TableColumn<>("Tipo");
        tipoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo()));

        TableColumn<Inmueble, String> ciudadCol = new TableColumn<>("Ciudad");
        ciudadCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCiudad()));

        TableColumn<Inmueble, Integer> habCol = new TableColumn<>("Habitaciones");
        habCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumHabitaciones()).asObject());

        TableColumn<Inmueble, Integer> pisosCol = new TableColumn<>("Pisos");
        pisosCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumPisos()).asObject());

        TableColumn<Inmueble, Double> precioCol = new TableColumn<>("Precio");
        precioCol.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrecio()).asObject());
        // Formatear el precio para que se vea como moneda (opcional)
        precioCol.setCellFactory(tc -> new TableCell<Inmueble, Double>() {
            @Override
            protected void updateItem(Double price, boolean empty) {
                super.updateItem(price, empty);
                if (empty || price == null) {
                    setText(null);
                } else {
                    setText(String.format("$%,.2f", price));
                }
            }
        });

        tablaInmuebles.getColumns().addAll(tipoCol, ciudadCol, habCol, pisosCol, precioCol);

        Button btnEliminar = new Button("Eliminar Inmueble Seleccionado");
        btnEliminar.setOnAction(e -> {
            Inmueble seleccionado = tablaInmuebles.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                RegistroInmuebles.eliminarInmueble(seleccionado); // Llama al método de eliminación
                mostrarAlerta("Eliminado", "El inmueble ha sido eliminado.", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "Por favor, seleccione un inmueble para eliminar.", Alert.AlertType.WARNING);
            }
        });

        tablaInmuebles.setItems(RegistroInmuebles.getListaInmuebles());

        VBox listadoVbox = new VBox(10,
                new Label("Listado de Inmuebles Registrados"),
                tablaInmuebles,
                btnEliminar
        );
        VBox.setVgrow(tablaInmuebles, Priority.ALWAYS);
        listadoVbox.setPadding(new Insets(20));
        return listadoVbox;
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}