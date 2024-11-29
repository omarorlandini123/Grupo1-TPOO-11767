/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entidades;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author PC
 */
public class Usuario {
    private String dni;
    private String nombre;
    private String telefono;
    private String correo;
    private String contraseña;
    private List<Solicitud> solicitudes;

    public Usuario(String dni, String nombre, String telefono, String correo) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }


    public Usuario(String dni, String contraseña) {
        this.dni = dni;
        this.contraseña = contraseña;
    }
    
    public Usuario(String dni, String nombre, String telefono, String correo, String contraseña) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public Usuario(ResultSet rs) {
        try{
            this.dni = rs.getString(1);
            this.nombre = rs.getString(2);
            this.telefono = rs.getString(3);
            this.correo = rs.getString(4);
            this.contraseña = rs.getString(5);
        }catch(Exception e){
            
        }
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario(String dni) {
        this.dni = dni;
    }
    public String getUsuarioText(){
        return "" + dni + " - " + nombre + " - " + telefono + " - " + correo+ " - " + contraseña;
    }
    public String getBienvenido(){
        return "" + nombre + "";
    }
}
