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
public class PanelMostrarDependientes extends javax.swing.JPanel {

    /**
     * Creates new form PanelMenuGerente
     */
    VentanaPrincipal v;
    Tienda t;
    PersonalTienda pt;
    
    public PanelMostrarDependientes(VentanaPrincipal v, Tienda t, PersonalTienda pt) {
        this.t=t;
        this.v=v;
        this.pt=pt;
        v.setSize(600, 600);
        v.setLocationRelativeTo(null);
        
        initComponents();
        Gerente g= (Gerente)pt;
        nombreGerente.setText("Bienvenido a "+ t.getNombre()+", "+pt.getNombreCompleto());
        //recibo la lista de dependientes y la pongo en el cuadro de texto
        jTextArea1.setText(g.mostrarDependientes(t.getDependientesTienda()));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        bVolverAtras = new javax.swing.JButton();
        bVolverMenu = new javax.swing.JButton();
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
        jPanel1.setLayout(new java.awt.BorderLayout(0, 10));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 51, 51));
        jTextArea1.setColumns(19);
        jTextArea1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setOpaque(false);

        bVolverAtras.setText("Volver atras");
        bVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverAtrasActionPerformed(evt);
            }
        });
        jPanel3.add(bVolverAtras);

        bVolverMenu.setText("Volver al menu");
        bVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverMenuActionPerformed(evt);
            }
        });
        jPanel3.add(bVolverMenu);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

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

    private void bVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverMenuActionPerformed
        // TODO add your handling code here:
        //esto vuelve al menu principal
        if(pt.getClass()==Gerente.class)
            this.v.ponPanel(Paneles.PMenuGerente, pt);

    }//GEN-LAST:event_bVolverMenuActionPerformed

    private void bVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverAtrasActionPerformed
        // TODO add your handling code here:
        if(pt.getClass()==Gerente.class)
            this.v.ponPanel(Paneles.PGestionarDependientes, pt);
    }//GEN-LAST:event_bVolverAtrasActionPerformed

   
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
    private javax.swing.JButton bVolverAtras;
    private javax.swing.JButton bVolverMenu;
    private javax.swing.JLabel espacioAbajo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel nombreGerente;
    // End of variables declaration//GEN-END:variables
}
