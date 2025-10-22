package com.example.parcial2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RegistroInmuebles {
    private static final ObservableList<Inmueble> listaInmuebles = FXCollections.observableArrayList();
    public static void agregarInmueble(Inmueble inmueble) {
        listaInmuebles.add(inmueble);
    }

    public static boolean eliminarInmueble(Inmueble inmueble) {
        return listaInmuebles.remove(inmueble);
    }

    public static ObservableList<Inmueble> getListaInmuebles() {
        return listaInmuebles;
    }
}