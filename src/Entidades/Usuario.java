/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entidades;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String dni;

    public Usuario(String dni) {
        this.dni = dni;
    }
    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Usuario(ResultSet rs) {
        try{
            this.idUsuario = rs.getInt(1);
            this.nombre = rs.getString(2);
            this.dni = rs.getString(3);
        }catch(Exception e){
            
        }
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getUsuarioText(){
        return "" +idUsuario+ " - " + nombre + " - " + dni;
    }
}
