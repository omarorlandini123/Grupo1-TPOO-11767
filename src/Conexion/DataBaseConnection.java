/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Interfaz.Frm_Usuario;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
   
import Entidades.Usuario;
import java.util.List;
/**
 *
 * @author PC
 */
public class DataBaseConnection {
    Connection cn = null;
            
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=DB_EMERGENCIA;encrypt=true;trustServerCertificate=true;";
    private static final String usuario = "user";
    private static final String contraseña = "123456";
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, usuario, contraseña);
            System.out.println("Conexion establecida exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar, error: "+e.toString());
        }
        return connection;
    }
    
    public static void main(String[] args) {
        //Iniciar Interfaz
        Frm_Usuario frmUsuario = new Frm_Usuario();
        frmUsuario.setVisible(true);
        frmUsuario.setSize(500, 400);        
    }
}
