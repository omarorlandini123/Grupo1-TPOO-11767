/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class Emergencia {
    private String id;
    private String nombre;
    private String telefono;
    private String descripcion;
    
    public Emergencia(String nombre) {
        this.nombre = nombre;
    }
    public Emergencia(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Emergencia(ResultSet rs) {
        try{
            this.id = rs.getString(1);
            this.nombre = rs.getString(2);
            this.telefono = rs.getString(3);
            this.descripcion = rs.getString(4);
        }catch(Exception e){
            
        }
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
