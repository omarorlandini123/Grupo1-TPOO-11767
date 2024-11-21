/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import Entidades.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class DataAccesUsuario {
    private Statement st;
    private Usuario user;
    private JFrame parentFrame;
    
    public DataAccesUsuario(Statement st) {
        this.st = st;
    }
    
    public DataAccesUsuario(Statement st, Usuario user) {
        this.st = st;
        this.user = user;
    }
    
    public DataAccesUsuario(Statement st, Usuario user,JFrame parentFrame) {
        this.st = st;
        this.user = user;
        this.parentFrame = parentFrame;

    }
    
    public  List<Usuario> getListaUsuarios() throws SQLException{
        ResultSet rs = st.executeQuery("SELECT * FROM Usuario");
        List<Usuario> usuarios = new ArrayList<>();
        while (rs.next()){
            Usuario usuario = new Usuario(rs);
            usuarios.add(usuario);
        }
        return usuarios;
    }
    //InsertarUsuario
    public void insertarUsuario() throws SQLException {
        try {
            String nuevoDni = user.getDni();
            String nuevoNombre = user.getNombre();
            String nuevoTelefono = user.getTelefono();
            String nuevoCorreo = user.getCorreo();
            String nuevaContraseña = user.getContraseña();

            st.execute("INSERT INTO Usuario (DNI_Usuario, Nombre, Telefono, Correo, Contraseña) VALUES ('" + nuevoDni + "', '" + nuevoNombre + "','" + nuevoTelefono + "','" + nuevoCorreo + "','" + nuevaContraseña + "')");
            JOptionPane.showMessageDialog(parentFrame, "Usuario insertado correctamente");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(parentFrame, "Error al insertar usuario: Ingrese los datos correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //EliminarUsuario
    public void eliminarUsuario() throws SQLException {
        try {
            st.execute("DELETE FROM Usuario WHERE DNI_Usuario = " + user.getDni());
            System.out.print("Usuario eliminado correctamente.");
        } catch (SQLException sQLException) {
            throw new IllegalArgumentException("Error eliminando usuario.");
        }
    }  
    public Usuario buscarUsuarioPorDni() throws SQLException {
        Usuario usuarioEncontrado = null;
        try {
            ResultSet rs = st.executeQuery(    "SELECT * FROM Usuario WHERE DNI_Usuario = '" + user.getDni() + "' AND Contraseña = '" + user.getContraseña() + "'");
            if (rs.next()) {
                usuarioEncontrado = new Usuario(rs);
            } else {
            }
        } catch (SQLException e) {
            throw new SQLException("Error al buscar el usuario: " + e.getMessage());
        }
        return usuarioEncontrado;
    }    
}
