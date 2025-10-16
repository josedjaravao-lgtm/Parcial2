package com.example.parcial2;

public class Inmueble {
    private String tipo;
    private String ciudad;
    private String numeroH;
    private String numeroP;
    private String precio;
    public Inmueble(String tipo, String ciudad, String numero, String numeroP, String precio) {
        this.tipo = tipo;
        this.ciudad =ciudad;
        this.numeroH = numero;
        this.precio= precio;
        this.numeroP=numeroP;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getciudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    public String getNumeroH() {
        return numeroH;
    }
    public void setNumeroH(String numeroH) {
        this.numeroH = numeroH;
    }
    public String getNumeroP() {
        return numeroP;
    }
    public void setNumero(String numeroP) {
        this.numeroP = numeroP;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Tipo='" + tipo + '\'' +
                ",ciudad='" + ciudad + '\'' +
                ",numero de habitaciones='" + numeroH + '\'' +
                ",numero de Pisos ='" + numeroP + '\'' +
                ",precio='" + precio + '\'' +
                '}';
    }
}
