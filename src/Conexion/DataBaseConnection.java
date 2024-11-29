/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
   
import Entidades.Usuario;
import Interfaz.Frm_Administrador;
import Interfaz.Frm_CambiarContra;
import Interfaz.Frm_Contraseña;
import Interfaz.Frm_Principal;
import Interfaz.Frm_Registrar_Usuario;
import Interfaz.Frm_Usuario;
import java.util.List;
/**
 *
 * @author PC
 */
public class DataBaseConnection {
    Connection cn = null;
    
    public static Frm_Principal pantallaPrincipal = new Frm_Principal();
    public static Frm_Usuario pantallaUsuario = new Frm_Usuario();
    public static Frm_Registrar_Usuario pantallaRegistrarUsuario = new Frm_Registrar_Usuario();
    public static Frm_Administrador pantallaAdministrador = new Frm_Administrador();
    public static Frm_Contraseña pantallaContraseña = new Frm_Contraseña();
    public static Frm_CambiarContra pantallaCambiarContra = new Frm_CambiarContra();
    
    private static DataBaseConnection instancia;
    private Connection conexion;

    private DataBaseConnection(){
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DB_EMERGENCIA;encrypt=true;trustServerCertificate=true;";
            String usuario = "user";
            String contrasena = "123456";
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión establecida.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    
    public static DataBaseConnection getInstancia() {
        if (instancia == null) {
            instancia = new DataBaseConnection();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public static void main(String[] args) {
        pantallaPrincipal.setVisible(true);
        pantallaPrincipal.setSize(640, 530);
    }
}
