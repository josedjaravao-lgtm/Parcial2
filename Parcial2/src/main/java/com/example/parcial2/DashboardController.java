package com.example.parcial2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {



    @FXML
    public TableColumn<Inmueble, String> cEliminate; // Corregido el error de tipos en la columna
    @FXML
    private TextField txtTipo;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtNumeroH;
    @FXML
    private TextField txtNumeroP;
    @FXML
    private TextField txtPrecio;
    @FXML
    private Button guardar;
    @FXML
    private TableColumn<Inmueble,String> cType;
    @FXML
    private TableColumn<Inmueble,String> cRooms;
    @FXML
    private TableColumn<Inmueble,String> cFloors;
    @FXML
    private TableColumn <Inmueble,String>cCities;
    @FXML
    private TableColumn <Inmueble,String>cPrice;
    @FXML
    private TableView<Inmueble> tablaDatos;

    private ObservableList<Inmueble> Inmuebles = FXCollections.observableArrayList();
    private Button btneliminar;


    public void initialize(URL url, ResourceBundle resourceBundle){
        cType.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        cType.setStyle("-fx-alignment: CENTER-LEFT");
        cFloors.setCellValueFactory(new PropertyValueFactory<>("Numero de  pisos"));
        cFloors.setStyle("-fx-alignment: CENTER-LEFT");
        cRooms.setCellValueFactory(new PropertyValueFactory<>("Numero de habitaciones"));
        cRooms.setStyle("-fx-alignment: CENTER-LEFT");
        cCities.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        cCities.setStyle("-fx-alignment: CENTER-LEFT");
        cPrice.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        cPrice.setStyle("-fx-alignment: CENTER-LEFT");


        cEliminate.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        cEliminate.setStyle("-fx-alignment: CENTER");

        Callback<TableColumn<Inmueble, String>, TableCell<Inmueble, String>> construirCEliminar = (param) -> {
            final TableCell<Inmueble, String> cell = new TableCell<Inmueble, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty); // Llamada a super
                    if(empty ) {
                        setGraphic(null);
                        setText(null);
                    }else{

                        btneliminar = createButton("Eliminar");
                        btneliminar.setOnAction((event) -> {
                            Inmueble inmuebles = getTableView().getItems().get(getIndex());
                            tablaDatos.getItems().remove(inmuebles);
                        });
                        setGraphic(btneliminar);
                        setText(null);
                    }
                }
            };
            return cell;
        };
        cEliminate.setCellFactory(construirCEliminar);
        tablaDatos.setItems(Inmuebles); // Inicializar la tabla
    }


    public void guardarDatosClick(ActionEvent actionEvent) {


        if(!"".equals(txtTipo.getText().trim()) &&
                !"".equals(txtCiudad.getText().trim()) &&
                !"".equals(txtPrecio.getText().trim()) &&
                !"".equals(txtNumeroH.getText().trim()) &&
                !"".equals(txtNumeroP.getText().trim()))
        {
            Inmuebles.add(new Inmueble(txtTipo.getText().trim(), txtCiudad.getText().trim(),txtPrecio.getText().trim(),txtNumeroH.getText().trim(),txtNumeroP.getText().trim()));

            txtTipo.setText("");
            txtCiudad.setText("");
            txtNumeroH.setText("");
            txtNumeroP.setText("");
            txtPrecio.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("No deje los espacios en blanco");
            alert.showAndWait();
        }
    }

    private Button createButton(String tooltip) {
        Button btn = new Button();
        btn.setTooltip(new Tooltip(tooltip));
        btn.setText("Eliminar");
        return btn;
    }
}