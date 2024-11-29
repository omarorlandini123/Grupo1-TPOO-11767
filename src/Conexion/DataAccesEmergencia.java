/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Entidades.Emergencia;
import Entidades.Solicitud;
import Entidades.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DataAccesEmergencia {
    private Statement st;
    private Emergencia emergencia;
    private Usuario user;

    public DataAccesEmergencia(Statement st, Emergencia emergencia) {
        this.st = st;
        this.emergencia = emergencia;
    }

    public DataAccesEmergencia(Statement st) {
        this.st = st;
    }

    public DataAccesEmergencia(Statement st, Usuario user) {
        this.st = st;
        this.user = user;
    }
    public  List<Emergencia> getListaEmergencias() throws SQLException{
        ResultSet rs = st.executeQuery("SELECT ID, Nombre, Telefono FROM Emergencia");
        List<Emergencia> emergencias = new ArrayList<>();
        while (rs.next()){
            Emergencia emergencia = new Emergencia(rs);
            emergencias.add(emergencia);
        }
        return emergencias;
    }
    public void actualizarEmergencia() throws SQLException {
        try {
            String query = "UPDATE Emergencia SET Nombre = '" + emergencia.getNombre()+ "',Telefono = '"+ emergencia.getTelefono()+"' WHERE ID = '" + emergencia.getId() + "'";
            st.execute(query);
            System.out.println("Emergencia actualizada correctamente.");
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar la emergencia : " + e.getMessage());
        }
    }
}
