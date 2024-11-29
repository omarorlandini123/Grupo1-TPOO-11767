/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Entidades.Emergencia;
import Entidades.Solicitud;
import Entidades.Usuario;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class DataAccesSolicitud {
    private Statement st;
    private Solicitud solicitud;
    private Usuario user;
    private Emergencia emergencia;
    private JFrame parentFrame;
    
    public DataAccesSolicitud(Statement st) {
        this.st = st;
    }
    
    public DataAccesSolicitud(Statement st, Solicitud solicitud) {
        this.st = st;
        this.solicitud = solicitud;
    }
    
    public DataAccesSolicitud(Statement st, Solicitud solicitud,JFrame parentFrame) {
        this.st = st;
        this.solicitud = solicitud;
        this.parentFrame = parentFrame;
    }
        
    public  List<Solicitud> getListaSolicitudesPersonal(String dni) throws SQLException{
        List<Solicitud> solicitudes = new ArrayList<>();
        String query = "SELECT ID, DNI_Usuario, ID_Emergencia, Descripcion, Direccion, Fecha, Estado FROM Solicitud WHERE DNI_Usuario = '" + dni + "'";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            solicitudes.add(new Solicitud(rs));
        }
        return solicitudes;
    }

    public  List<Solicitud> getListaSolicitudes() throws SQLException{
        ResultSet rs = st.executeQuery("SELECT ID, DNI_Usuario, ID_Emergencia, Descripcion, Direccion, Fecha, Estado FROM Solicitud");
        List<Solicitud> solicitudes = new ArrayList<>();
        while (rs.next()){
            Solicitud solicitud = new Solicitud(rs);
            solicitudes.add(solicitud);
        }
        return solicitudes;
    }
    
    public List<Emergencia> getEmergencias() throws SQLException {
        List<Emergencia> emergencias = new ArrayList<>();
        String query = "SELECT ID, Nombre FROM Emergencia";

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            String id = rs.getString("ID");
            String nombre = rs.getString("Nombre");
            emergencias.add(new Emergencia(id, nombre));
        }

        return emergencias;
    }
    public void insertarSolicitud() throws SQLException {
        try {
            String nuevoDni = solicitud.getUsuario().getDni();
            String nuevaEmergencia = solicitud.getEmergencia().getId();
            String nuevaDescripcion = solicitud.getDescripcion();
            String nuevaDireccion = solicitud.getDireccion();
            String nuevaFecha = solicitud.getFecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String nuevoEstado = solicitud.getEstado();
            
            st.execute("INSERT INTO Solicitud (DNI_Usuario, ID_Emergencia, Descripcion, Direccion, Fecha, Estado) VALUES ('" + nuevoDni + "', '" + nuevaEmergencia + "','" + nuevaDescripcion + "','" + nuevaDireccion+ "','"+ nuevaFecha + "','" +nuevoEstado + "')");
            JOptionPane.showMessageDialog(parentFrame, "Solicitud insertada correctamente");
        } catch (HeadlessException headlessException) {
            System.out.print("Error al ingresar datos");
        }
    }
     public List<Solicitud> filtrarSolicitudes(String estado, String orden, String idEmergencia, String dni) throws SQLException {
        
        StringBuilder query = new StringBuilder("SELECT ID, DNI_Usuario, ID_Emergencia, Descripcion, Direccion, Fecha, Estado FROM Solicitud WHERE DNI_Usuario = '").append(dni).append("'");

        if (estado != null && !estado.isEmpty()) {
            query.append(" AND Estado = '").append(estado).append("'");
        }
                
        if (idEmergencia != null && !idEmergencia.isEmpty()) {
            query.append(" AND ID_Emergencia = '").append(idEmergencia).append("'");
        }
        
        if (orden != null && !orden.isEmpty()) {
            query.append(" ORDER BY Fecha ").append(orden);
        }
        
        List<Solicitud> solicitudes = new ArrayList<>();
        
        System.out.println(query);
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query.toString()); // Ejecutar la consulta con Statement
            while (rs.next()) {
                solicitudes.add(new Solicitud(rs)); // Crear objetos Solicitud a partir del ResultSet
            }
        } finally {
            if (rs != null) rs.close(); // Cerrar el ResultSet
        }

        return solicitudes;
    }
    public void actualizarEstadoSolicitud() throws SQLException {
        try {
            String query = "UPDATE Solicitud SET Estado = '" + solicitud.getEstado() + "' WHERE ID = " + solicitud.getId();
            st.execute(query);
            System.out.println("Estado de la solicitud actualizado correctamente.");
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar el estado de la solicitud: " + e.getMessage());
        }
    }
}
