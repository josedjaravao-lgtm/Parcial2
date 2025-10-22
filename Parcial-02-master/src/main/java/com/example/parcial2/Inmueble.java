package com.example.parcial2;

public class Inmueble {

    private String tipo;
    private String ciudad;
    private int numHabitaciones;
    private int numPisos;
    private double precio;


    public Inmueble(String tipo, String ciudad, int numHabitaciones, int numPisos, double precio) {
        this.tipo = tipo;
        this.ciudad = ciudad;
        this.numHabitaciones = numHabitaciones;
        this.numPisos = numPisos;
        this.precio = precio;
    }


    public String getTipo() { return tipo; }
    public String getCiudad() { return ciudad; }
    public int getNumHabitaciones() { return numHabitaciones; }
    public int getNumPisos() { return numPisos; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return "Tipo='" + tipo + '\'' +
                ",ciudad='" + ciudad + '\'' +
                ",numero de habitaciones='" + numHabitaciones + '\'' +
                ",numero de Pisos ='" + numPisos + '\'' +
                ",precio='" + precio + '\'' +
                '}';
    }

}
