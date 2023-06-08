package org.example.vista;

import org.example.controlador.ControladorBicicleta;
import org.example.persistencia.BicicletaDAO;
import org.example.vista.VentanaBicicleta;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        VentanaBicicleta view = new VentanaBicicleta("Proyecto Final de Programación");
        ControladorBicicleta controller = new ControladorBicicleta(view);

    }
}
