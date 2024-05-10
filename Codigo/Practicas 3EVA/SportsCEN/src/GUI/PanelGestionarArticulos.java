/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import data.Gerente;
import data.PersonalTienda;
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
public class PanelGestionarArticulos extends javax.swing.JPanel {

    /**
     * Creates new form PanelMenuGerente
     */
    VentanaPrincipal v;
    Tienda t;
    PersonalTienda pt;
    
    public PanelGestionarArticulos(VentanaPrincipal v, Tienda t, PersonalTienda pt) {
        this.t=t;
        this.v=v;
        this.pt=pt;
        v.setSize(600, 600);
        v.setLocationRelativeTo(null);
        
        initComponents();
        
        nombreGerente.setText("Bienvenido a "+ t.getNombre()+", "+pt.getNombreCompleto());
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

        jPanel1 = new javax.swing.JPanel();
        bAñadirArticulos = new javax.swing.JButton();
        bEliminarArticulos = new javax.swing.JButton();
        bMostrarArticulos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nombreGerente = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bVolver = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(100, 150, 100, 150));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 50));

        bAñadirArticulos.setText("Añadir Articulos");
        jPanel1.add(bAñadirArticulos);

        bEliminarArticulos.setText("Eliminar Articulos");
        bEliminarArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarArticulosActionPerformed(evt);
            }
        });
        jPanel1.add(bEliminarArticulos);

        bMostrarArticulos.setText("Mostrar Articulos");
        bMostrarArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMostrarArticulosActionPerformed(evt);
            }
        });
        jPanel1.add(bMostrarArticulos);

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

        jPanel3.setOpaque(false);

        bVolver.setText("Volver");
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });
        jPanel3.add(bVolver);

        add(jPanel3, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        // TODO add your handling code here:
        //esto vuelve al menu principal
        if(pt.getClass()==Gerente.class)
            this.v.ponPanel(Paneles.PMenuGerente, pt);
        
            
    }//GEN-LAST:event_bVolverActionPerformed

    private void bMostrarArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMostrarArticulosActionPerformed
        // TODO add your handling code here:
        
        if(pt.getClass()==Gerente.class)
            this.v.ponPanel(Paneles.PMostrarArticulos, pt);
        
    }//GEN-LAST:event_bMostrarArticulosActionPerformed

    private void bEliminarArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarArticulosActionPerformed
        // TODO add your handling code here:
         
        if(pt.getClass()==Gerente.class)
            this.v.ponPanel(Paneles.PEliminarArticulos, pt);
        
    }//GEN-LAST:event_bEliminarArticulosActionPerformed

   
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
    private javax.swing.JButton bAñadirArticulos;
    private javax.swing.JButton bEliminarArticulos;
    private javax.swing.JButton bMostrarArticulos;
    private javax.swing.JButton bVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nombreGerente;
    // End of variables declaration//GEN-END:variables
}
