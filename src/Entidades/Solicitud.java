/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Solicitud {
    private int id;
    private String dni_Usuario;
    private String id_emergencia;
    private String descripcion;
    private String direccion;
    private LocalDateTime fecha;
    private String estado; //Pendiente//En proceso//Completado-Cancelado//

    public Solicitud(String dni_Usuario, String id_emergencia, String descripcion, String direccion, String estado) {
        this.dni_Usuario = dni_Usuario;
        this.id_emergencia = id_emergencia;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.fecha = LocalDateTime.now();
        this.estado = estado;
    }

    public Solicitud(ResultSet rs) {
        try{
            this.id = rs.getInt("ID");
            this.dni_Usuario = rs.getString("DNI_Usuario");
            this.id_emergencia = rs.getString("ID_Emergencia");
            this.descripcion = rs.getString("Descripcion");
            this.direccion = rs.getString("Direccion");
            this.fecha = rs.getTimestamp("Fecha").toLocalDateTime();
            this.estado = rs.getString("Estado");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni_Usuario() {
        return dni_Usuario;
    }

    public void setDni_Usuario(String dni_Usuario) {
        this.dni_Usuario = dni_Usuario;
    }

    public String getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(String id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
