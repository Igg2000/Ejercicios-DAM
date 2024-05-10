/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import data.Dependiente;
import data.Gerente;
import data.Tienda;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author grovy
 */
public class PanelMenuDependiente extends javax.swing.JPanel {

    /**
     * Creates new form PanelMenuGerente
     */
    VentanaPrincipal v;
    Tienda t;
    Dependiente d;
    
    public PanelMenuDependiente(VentanaPrincipal v, Tienda t, Dependiente d) {
        this.t=t;
        this.v=v;
        this.d=d;
        v.setSize(600, 600);
        v.setLocationRelativeTo(null);
        
        initComponents();
        
        nombreGerente.setText("Bienvenido a "+ t.getNombre()+", "+d.getNombreCompleto());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        espacioAbajo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BGestionarEjemplares = new javax.swing.JButton();
        BGestionarClientes = new javax.swing.JButton();
        BGestionarVentas = new javax.swing.JButton();
        BCerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nombreGerente = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));
        setLayout(new java.awt.BorderLayout());

        espacioAbajo.setText("     ");
        add(espacioAbajo, java.awt.BorderLayout.PAGE_END);

        jLabel3.setText("                                    ");
        add(jLabel3, java.awt.BorderLayout.LINE_START);

        jLabel4.setText("                                    ");
        add(jLabel4, java.awt.BorderLayout.LINE_END);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(0, 2, 20, 20));

        BGestionarEjemplares.setText("Ejemplares");
        jPanel1.add(BGestionarEjemplares);

        BGestionarClientes.setText("Clientes");
        jPanel1.add(BGestionarClientes);

        BGestionarVentas.setText("Ventas");
        jPanel1.add(BGestionarVentas);

        BCerrar.setText("Cerrar Aplicacion");
        BCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(BCerrar);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        nombreGerente.setFont(new java.awt.Font("FOT-Cezanne Pro B", 1, 18)); // NOI18N
        nombreGerente.setForeground(new java.awt.Color(255, 255, 255));
        nombreGerente.setText("Bienvenido \"Nombre Empleado\"");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(35, 119, 29, 95);
        jPanel2.add(nombreGerente, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void BCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCerrarActionPerformed
        
        //este boton cierra la ventana
        v.dispose();
    }//GEN-LAST:event_BCerrarActionPerformed

   
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        Image fondo = null;
        try {
            fondo = ImageIO.read(new File("src/IMG/fondoMenus.jpg")); //esto lo he tenido que buscar en internet
        } catch (IOException ex) {
            Logger.getLogger(PanelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image fondoEscalado = fondo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        
        g.drawImage(fondoEscalado, 0, 0, this);
        this.repaint();
        this.revalidate();
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCerrar;
    private javax.swing.JButton BGestionarClientes;
    private javax.swing.JButton BGestionarEjemplares;
    private javax.swing.JButton BGestionarVentas;
    private javax.swing.JLabel espacioAbajo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nombreGerente;
    // End of variables declaration//GEN-END:variables
}
