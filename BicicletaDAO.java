package org.example.persistencia;

import org.example.modelo.Bicicleta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BicicletaDAO implements InterfazDAO {
    public BicicletaDAO() {
    }
        public ArrayList<Bicicleta> obtenertodo() {
            return null;
        }

        public boolean insertar(Bicicleta bicicleta) {
            return false;
        }



        public boolean update(Bicicleta bicicleta) {
            return false;
        }

        @Override
        public boolean insertar(Object obj) throws SQLException {
            String sqlInsert = "INSERT INTO bicicleta(nombre,tamaño,color,tipo,url) VALUES(?,?,?,?,?)";
            int rowCount = 0;
            PreparedStatement pstm = ConexionSingleton.getInstance("bicicletaDB.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1, ((Bicicleta) obj).getNombre());
            pstm.setString(2, ((Bicicleta) obj).getTamaño());
            pstm.setInt(3, ((Bicicleta) obj).getColor());
            pstm.setString(4, ((Bicicleta) obj).getTipo());
            pstm.setString(5, ((Bicicleta) obj).getUrl());
            rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }

        @Override
        public boolean update(Object obj) throws SQLException {
            String sqlUpdate = "UPDATE bicicleta SET nombre = ?,tamaño = ?, color = ?, tipo = ?, url = ? WHERE id = ?; ";
            int rowCount = 0;
            PreparedStatement pstm = ConexionSingleton.getInstance("bicicletaDB.db").getConnection().prepareStatement(sqlUpdate);
            pstm.setString(1, ((Bicicleta) obj).getNombre());
            pstm.setString(2, ((Bicicleta) obj).getTamaño());
            pstm.setInt(3, ((Bicicleta) obj).getColor());
            pstm.setString(4, ((Bicicleta) obj).getTipo());
            pstm.setString(5, ((Bicicleta) obj).getUrl());
            pstm.setInt(6, ((Bicicleta) obj).getId());
            rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }

        @Override
        public boolean delete(String id) throws SQLException {
            String sqlDelete = "DELETE FROM bicicleta WHERE id = ?;";
            int rowCount = 0;
            PreparedStatement pstm = ConexionSingleton.getInstance("bicicletaDB.db").getConnection().prepareStatement(sqlDelete);
            pstm.setInt(1, Integer.parseInt(id));
            rowCount = pstm.executeUpdate();

            return rowCount > 0;
        }

        @Override
        public ArrayList obtenerTodo() throws SQLException {
            String sql = "SELECT * FROM bicicleta";
            ArrayList<Bicicleta> resultado = new ArrayList<>();

            Statement stm = ConexionSingleton.getInstance("bicicletaDB.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                resultado.add(new Bicicleta(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6)));
            }

            return resultado;
        }

        @Override
        public Object buscarPorId(String id) throws SQLException {


            String sql = "SELECT * FROM bicicleta WHERE id;";
            Bicicleta bicicleta = null;

            PreparedStatement pstm = ConexionSingleton.getInstance("bicicletaDB.db").getConnection().prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            ResultSet rst = pstm.executeQuery();
            if (rst.next()) {
                bicicleta = new Bicicleta(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6));
                return bicicleta;
            }
            return null;
        }
    }

