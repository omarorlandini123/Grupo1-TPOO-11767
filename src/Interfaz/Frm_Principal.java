/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Conexion.DataAccesUsuario;
import Conexion.DataBaseConnection;
import Entidades.Usuario;
import java.awt.Color;

import Interfaz.Frm_Principal;
import Interfaz.Frm_Usuario;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class Frm_Principal extends javax.swing.JFrame {
    private Connection conexion;
    private Statement st;
    /**
     * Creates new form Frm_Principal
     */
    public Frm_Principal() {
        try {
            // Obtener la conexión centralizada
            conexion = DataBaseConnection.getInstancia().getConexion();
            st = conexion.createStatement();
            initComponents();
        } catch (SQLException e) {
            System.err.println("Error al crear el Statement: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Dni = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAyuda = new javax.swing.JButton();
        btnAdministrador = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txt_Contraseña = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido");
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setToolTipText("");
        background.setMinimumSize(new java.awt.Dimension(0, 0));
        background.setPreferredSize(new java.awt.Dimension(875, 814));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Centro de Asistencia de Emergencia");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 620, 58));

        background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 70));

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel2.setText("DNI:");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, 30));

        txt_Dni.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txt_Dni.setForeground(new java.awt.Color(153, 153, 153));
        txt_Dni.setText("Ingrese su DNI");
        txt_Dni.setBorder(null);
        txt_Dni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_DniMousePressed(evt);
            }
        });
        background.add(txt_Dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 380, 30));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        background.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 390, 1));

        btnAyuda.setBackground(new java.awt.Color(196, 112, 27));
        btnAyuda.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnAyuda.setForeground(new java.awt.Color(255, 255, 255));
        btnAyuda.setText("Llamar para ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        background.add(btnAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 170, 30));

        btnAdministrador.setBackground(new java.awt.Color(0, 153, 153));
        btnAdministrador.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        btnAdministrador.setText("Acceso a administrador");
        btnAdministrador.setBorder(null);
        btnAdministrador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
            }
        });
        background.add(btnAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 210, 30));

        btnRegistrar.setBackground(java.awt.SystemColor.activeCaption);
        btnRegistrar.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        btnRegistrar.setText("Registrarse");
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        background.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 110, 20));

        txt_Contraseña.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txt_Contraseña.setForeground(new java.awt.Color(153, 153, 153));
        txt_Contraseña.setText("Ingrese su contraseña");
        txt_Contraseña.setBorder(null);
        txt_Contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_ContraseñaMousePressed(evt);
            }
        });
        background.add(txt_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 380, 30));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        background.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 390, 1));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel4.setText("Contraseña:");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 160, 30));

        btnIngresar.setBackground(new java.awt.Color(204, 0, 51));
        btnIngresar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        background.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 210, 30));

        getContentPane().add(background);
        background.setBounds(0, 0, 630, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_DniMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_DniMousePressed
        if(txt_Dni.getText().equals("Ingrese su DNI")){
            txt_Dni.setText("");
            txt_Dni.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_DniMousePressed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
         try {
            JOptionPane.showMessageDialog(this, "Llamando ayuda...", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException headlessException) {
        }

    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed
        java.awt.Point location = this.getLocation();
        DataBaseConnection.pantallaContraseña.setLocation(location);
        this.setVisible(false);
        DataBaseConnection.pantallaContraseña.setVisible(true);
    }//GEN-LAST:event_btnAdministradorActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        java.awt.Point location = this.getLocation();
        DataBaseConnection.pantallaRegistrarUsuario.setLocation(location);
        DataBaseConnection.pantallaRegistrarUsuario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txt_ContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ContraseñaMousePressed
        if(txt_Contraseña.getText().equals("Ingrese su contraseña")){
            txt_Contraseña.setText("");
            txt_Contraseña.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_ContraseñaMousePressed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
            String dni = txt_Dni.getText();
            String contraseña = txt_Contraseña.getText();
            Usuario user = new Usuario(dni, contraseña);
            buscarUsuario(user, dni, contraseña);
    }//GEN-LAST:event_btnIngresarActionPerformed

 
    private void buscarUsuario(Usuario user, String dni, String contraseña){
        DataAccesUsuario dao = new DataAccesUsuario(st, user);
        try {
            Usuario usuarioEncontrado = dao.buscarUsuarioPorDni();
            if (usuarioEncontrado != null) {
                JOptionPane.showMessageDialog(this,"Bienvenido " + usuarioEncontrado.getBienvenido());
                java.awt.Point location = this.getLocation();
                DataBaseConnection.pantallaUsuario.setLocation(location);
                DataBaseConnection.pantallaUsuario.setVisible(true);
                this.setVisible(false);
                Interfaz.Frm_Usuario.txt_dni.setText(dni);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al buscar el usuario: " + ex.getMessage());
        }
    } 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAdministrador;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txt_Contraseña;
    private javax.swing.JTextField txt_Dni;
    // End of variables declaration//GEN-END:variables
}