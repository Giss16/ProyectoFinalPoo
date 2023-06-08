package org.example.controlador;

import org.example.modelo.ModeloTablaBicicleta;
import org.example.modelo.Bicicleta;
import org.example.vista.VentanaBicicleta;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorBicicleta extends MouseAdapter {
    private VentanaBicicleta view;
    private ModeloTablaBicicleta modelo;

    public ControladorBicicleta(VentanaBicicleta view) {
        this.view = view;
        modelo = new ModeloTablaBicicleta();
        this.view.getTblBicicleta().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblBicicleta().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Boton Cargar
        if (e.getSource() == this.view.getBtnCargar()) {

            modelo.cargarDatos();
            this.view.getTblBicicleta().setModel(modelo);
            this.view.getTblBicicleta().updateUI();
        }

        //Boton Agregar
        if (e.getSource() == this.view.getBtnAgregar()) {
            Bicicleta bicicleta = new Bicicleta();
            bicicleta.setId(0);
            bicicleta.setNombre(this.view.getTxtNombre().getText());
            bicicleta.setTamaño(Integer.parseInt(this.view.getTxtTamaño().getText()));
            bicicleta.setColor(Integer.parseInt(this.view.getTxtColor().getText()));
            bicicleta.setTipo(this.view.getTxtTipo().getText());
            bicicleta.setUrl(this.view.getTxtUrl().getText());
            if (modelo.agregarBicicleta(bicicleta)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso!!!", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblBicicleta().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se logró registrar en la base de datos. Por favor revise su conexión",
                        "Error al Insertar", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Tabla
        if (e.getSource() == this.view.getTblBicicleta()) {
            System.out.println("Evento sobre la Tabla");
            int index = this.view.getTblBicicleta().getSelectedRow();
            Bicicleta tmp = modelo.getValueAt(index);

            try {
                this.view.getImagenBicicleta().setIcon(tmp.getImagen());

            } catch (MalformedURLException mfue) {
                System.out.println(e.toString());
            }

        }

        //Boton Actualizar
        if (e.getSource() == this.view.getBtnActualizar()) {

            String nombre = this.view.getTxtNombre().getText();
            String tamaño = this.view.getTxtTamaño().getText();
            String color = this.view.getLblColor().getText();
            String tipo = this.view.getTxtTipo().getText();
            String url = this.view.getTxtUrl().getText();

            if (e.getSource() == this.view.getBtnBorrar()) {
                int row = this.view.getTblBicicleta().getSelectedRow();
                String index = String.valueOf(this.modelo.getValueAt(row, 0));

                System.out.println(index);

                int respuesta = JOptionPane.showConfirmDialog(view, "Deseas eliminar la bicicleta?", "Elige una bicicleta", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_NO_OPTION) {
                    modelo.borrarBici(index);
                    JOptionPane.showMessageDialog(view, "La bicicleta ha sido eliminada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(view, "La bicicleta no fue eliminada", "Error al borrar la bicicleta", JOptionPane.ERROR_MESSAGE);
                }
                modelo.cargarDatos();
                this.view.getTblBicicleta().setModel(modelo);
                this.view.getTblBicicleta().updateUI();
                this.view.limpiar();
            }

            if (e.getSource() == this.view.getBtnActualizar()) {
                int row = this.view.getTblBicicleta().getSelectedRow();
                String index = String.valueOf(this.modelo.getValueAt(row, 0));

                Bicicleta bicicleta = new Bicicleta();

                bicicleta.setNombre(this.view.getTxtNewNombre().getText());
                bicicleta.setTamaño(Integer.parseInt(this.view.getTxtNewTamaño().getText()));
                bicicleta.setColor(Integer.parseInt(this.view.getTxtNewColor().getText()));
                bicicleta.setTipo(this.view.getTxtNewTipo().getText());
                bicicleta.setUrl(this.view.getTxtNewUrl().getText());
                bicicleta.setId(Integer.parseInt(index));


                if (modelo.actualizarBicicleta(bicicleta)) {
                    JOptionPane.showMessageDialog(view, "Modificaste la bicicleta", "Aviso!!!", JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblBicicleta().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "No se logro modificar la bicicleta", "Error!!!", JOptionPane.ERROR_MESSAGE);
                    this.view.getTblBicicleta().updateUI();
                }

                modelo.cargarDatos();
                this.view.getTblBicicleta().setModel(modelo);
                this.view.getTblBicicleta().updateUI();

            }
            this.view.limpiar();
        }

    }
}
