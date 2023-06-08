package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Bicicleta {
    private int id;
    private String nombre;
    private int tamaño;
    private int color;
    private String tipo;
    private String url;

    public Bicicleta() {
    }

    public Bicicleta(int id, String nombre, int tamaño, int color, String tipo, String url) {
        this.id = id;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.color = color;
        this.tipo = tipo;
        this.url = url;
    }

    public Bicicleta(int anInt, String string, String string1, int anInt1, String string2, String string3) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamaño() {
        return String.valueOf(tamaño);
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tamaño=" + tamaño +
                ", color=" + color +
                ", tipo='" + tipo + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen()throws MalformedURLException {
        URL urlImage = new URL(this.url);
        return new ImageIcon(urlImage);
    }

    public void setTipo(int parseInt) {
    }

    public void setColor(String aValue) {
    }
}
