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
            String nuevoDni = solicitud.getDni_Usuario();
            String nuevaEmergencia = solicitud.getId_emergencia();
            String nuevaDescripcion = solicitud.getDescripcion();
            String nuevaDireccion = solicitud.getDireccion();
            String nuevaFecha = solicitud.getFecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String nuevoEstado = solicitud.getEstado();
            
            st.execute("INSERT INTO Solicitud (DNI_Usuario, ID_Emergencia, Descripcion, Direccion, Fecha, Estado) VALUES ('" + nuevoDni + "', '" + nuevaEmergencia + "','" + nuevaDescripcion + "','" + nuevaDireccion+ "','"+ nuevaFecha + "','" +nuevoEstado + "')");
            JOptionPane.showMessageDialog(parentFrame, "Solicitud insertada correctamente");
        } catch (HeadlessException headlessException) {
        }
    }
}
