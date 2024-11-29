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
import java.util.List;

/**
 *
 * @author PC
 */
public class Solicitud {

    private int id;
    private Usuario usuario;
    private Emergencia emergencia;
    private String descripcion;
    private String direccion;
    private LocalDateTime fecha;
    private String estado; //Pendiente//En proceso//Completado-Cancelado//

    public Solicitud(int id, Usuario usuario, Emergencia emergencia, String descripcion, String direccion, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.emergencia = emergencia;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.fecha = LocalDateTime.now();
        this.estado = estado;
    }
    
    public Solicitud(int id) {
        this.id = id;
    }
    
    public Solicitud(Usuario usuario, Emergencia emergencia, String descripcion, String direccion, String estado) {
        this.usuario = usuario;
        this.emergencia = emergencia;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.fecha = LocalDateTime.now();
        this.estado = estado;
    }

    public Solicitud(ResultSet rs) {
        try{
            this.id = rs.getInt("ID");
            this.usuario = new Usuario(rs.getString("DNI_Usuario"));
            this.emergencia = new Emergencia(rs.getString("ID_Emergencia"));
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
    public Emergencia getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(Emergencia emergencia) {
        this.emergencia = emergencia;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
