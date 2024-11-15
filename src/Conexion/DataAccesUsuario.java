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
/**
 *
 * @author PC
 */
public class DataAccesUsuario {
    private Statement st;
    private Usuario user;

    public DataAccesUsuario(Statement st) {
        this.st = st;
    }
    
    public DataAccesUsuario(Statement st, Usuario user) {
        this.st = st;
        this.user = user;
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
            String nuevoUsuario = user.getNombre();
            String nuevoDni = user.getDni();
            
            st.execute("INSERT INTO Usuario (Nombre, DNI_Usuario) VALUES ('" + nuevoUsuario + "', '" + nuevoDni + "')");
            System.out.print("Usuario insertado correctamente.");
        } catch (SQLException sQLException) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
    }

    //EliminarUsuario
    public void eliminarUsuario() throws SQLException {
        try {
            st.execute("DELETE FROM Usuario WHERE ID_Usuario = " + user.getIdUsuario());
            System.out.print("Usuario eliminado correctamente.");
        } catch (SQLException sQLException) {
            throw new IllegalArgumentException("Error eliminando usuario.");
        }
    }  
    public Usuario buscarUsuarioPorDni() throws SQLException {
        Usuario usuarioEncontrado = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM Usuario WHERE DNI_Usuario = '" + user.getDni() + "'");
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
