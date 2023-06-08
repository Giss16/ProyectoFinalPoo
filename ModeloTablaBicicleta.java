package org.example.modelo;

import org.example.persistencia.BicicletaDAO;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaBicicleta implements TableModel {
    public static final int COLS = 6;
    private ArrayList<Bicicleta> datos;
    private BicicletaDAO bdao;

    public ModeloTablaBicicleta() {
        bdao = new BicicletaDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaBicicleta(ArrayList<Bicicleta> datos) {
        this.datos = datos;
        bdao = new BicicletaDAO();
    }


    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Tamaño";
            case 3:
                return "Color";
            case 4:
                return "Tipo";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return Integer.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bicicleta tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getTamaño();
            case 3:
                return tmp.getColor();
            case 4:
                return tmp.getTipo();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).setId();
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setTamaño(Integer.parseInt((String) aValue));
                break;
            case 3:
                datos.get(rowIndex).setTipo(Integer.parseInt((String) aValue));
                break;
            case 4:
                datos.get(rowIndex).setColor((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
            default:
                System.out.println("No se ha modificado nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos() {
        ArrayList<Bicicleta> tirar = bdao.obtenertodo();
        System.out.println(tirar);
        datos = bdao.obtenertodo();

    }

    public boolean agregarBicicleta(Bicicleta bicicleta) {
        boolean resultado = false;
        if (bdao.insertar(bicicleta)) {
            datos.add(bicicleta);
            resultado = true;
        } else {
            resultado = false;
        }

        return resultado;
    }

    public boolean eliminarBicicleta(String id){
        boolean resultado = false;
        try{
            if (!bdao.delete(id)) {
                resultado = false;
            } else {
                resultado = true;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }


    public boolean actualizarDatos(Bicicleta bicicleta) {
        boolean resultado = false;

        if (bdao.update(bicicleta)) {
            System.out.println("Modificaste la bicicleta");
            resultado = true;
        } else {
            System.out.println("No se pudo modificar la bicicleta");
            resultado = false;
        }
        return resultado;
    }

    public Bicicleta getValueAt(int index) {
        return null;
    }

    public boolean actualizarBicicleta(Bicicleta bicicleta) {
        return false;
    }

    public void borrarBici(String index) {
    }
}

