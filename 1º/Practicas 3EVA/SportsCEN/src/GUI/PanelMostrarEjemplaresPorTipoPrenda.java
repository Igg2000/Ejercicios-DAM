/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import data.Gerente;
import data.Marcas;
import data.PersonalTienda;
import data.Prendas;
import data.Tienda;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author grovy
 */
public class PanelMostrarEjemplaresPorTipoPrenda extends javax.swing.JPanel {

    /**
     * Creates new form PanelMenuGerente
     */
    VentanaPrincipal v;
    Tienda t;
    PersonalTienda pt;
    
    PanelMostrarEjemplaresPorTipoPrenda(VentanaPrincipal v, Tienda t, PersonalTienda pt) {
        this.t=t;
        this.v=v;
        this.pt=pt;
        //v.setSize(600, 600);
        //v.setLocationRelativeTo(null);
        
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
        bGorra = new javax.swing.JButton();
        bChaqueta = new javax.swing.JButton();
        bCamiseta = new javax.swing.JButton();
        bSudadera = new javax.swing.JButton();
        bPantalon = new javax.swing.JButton();
        bZapatillas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nombreGerente = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bVolverAtras = new javax.swing.JButton();
        bVolver = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 110, 20, 110));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(0, 2, 20, 20));

        bGorra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGorraActionPerformed(evt);
            }
        });
        jPanel1.add(bGorra);

        bChaqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChaquetaActionPerformed(evt);
            }
        });
        jPanel1.add(bChaqueta);

        bCamiseta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCamisetaActionPerformed(evt);
            }
        });
        jPanel1.add(bCamiseta);

        bSudadera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSudaderaActionPerformed(evt);
            }
        });
        jPanel1.add(bSudadera);

        bPantalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPantalonActionPerformed(evt);
            }
        });
        jPanel1.add(bPantalon);

        bZapatillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZapatillasActionPerformed(evt);
            }
        });
        jPanel1.add(bZapatillas);

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

        bVolverAtras.setText("Volver atras");
        bVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverAtrasActionPerformed(evt);
            }
        });
        jPanel3.add(bVolverAtras);

        bVolver.setText("Volver al menu");
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
        else
            this.v.ponPanel(Paneles.PMenuDependiente, pt);
            
    }//GEN-LAST:event_bVolverActionPerformed

    private void bCamisetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCamisetaActionPerformed
        // TODO add your handling code here:
        this.v.ponPanelMostrarLista(Paneles.PMostrarListas, pt, Paneles.PMostrarEjemplaresPorPrenda,
                pt.mostrarEjemPrenda(Prendas.Camiseta, t.getArticulosTienda()));
        
    }//GEN-LAST:event_bCamisetaActionPerformed

    private void bGorraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGorraActionPerformed
        // TODO add your handling code here:
                this.v.ponPanelMostrarLista(Paneles.PMostrarListas, pt, Paneles.PMostrarEjemplaresPorPrenda,
                pt.mostrarEjemPrenda(Prendas.Gorra, t.getArticulosTienda()));

    }//GEN-LAST:event_bGorraActionPerformed

    private void bChaquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChaquetaActionPerformed
        // TODO add your handling code here:
                this.v.ponPanelMostrarLista(Paneles.PMostrarListas, pt, Paneles.PMostrarEjemplaresPorPrenda,
                pt.mostrarEjemPrenda(Prendas.Chaqueta, t.getArticulosTienda()));

    }//GEN-LAST:event_bChaquetaActionPerformed

    private void bSudaderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSudaderaActionPerformed
        // TODO add your handling code here:
                this.v.ponPanelMostrarLista(Paneles.PMostrarListas, pt, Paneles.PMostrarEjemplaresPorPrenda,
                pt.mostrarEjemPrenda(Prendas.Sudadera, t.getArticulosTienda()));

    }//GEN-LAST:event_bSudaderaActionPerformed

    private void bVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverAtrasActionPerformed
        // TODO add your handling code here:
        this.v.ponPanel(Paneles.PMostrarEjemplares, pt);
    }//GEN-LAST:event_bVolverAtrasActionPerformed

    private void bPantalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPantalonActionPerformed
        // TODO add your handling code here:
        this.v.ponPanelMostrarLista(Paneles.PMostrarListas, pt, Paneles.PMostrarEjemplaresPorPrenda,
                pt.mostrarEjemPrenda(Prendas.Pantalon, t.getArticulosTienda()));
    }//GEN-LAST:event_bPantalonActionPerformed

    private void bZapatillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZapatillasActionPerformed
        // TODO add your handling code here:
        this.v.ponPanelMostrarLista(Paneles.PMostrarListas, pt, Paneles.PMostrarEjemplaresPorPrenda,
                pt.mostrarEjemPrenda(Prendas.Zapatillas, t.getArticulosTienda()));
    }//GEN-LAST:event_bZapatillasActionPerformed

   
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
        
        
        pintarBotones();
        
        //this.repaint();
        //this.revalidate();
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCamiseta;
    private javax.swing.JButton bChaqueta;
    private javax.swing.JButton bGorra;
    private javax.swing.JButton bPantalon;
    private javax.swing.JButton bSudadera;
    private javax.swing.JButton bVolver;
    private javax.swing.JButton bVolverAtras;
    private javax.swing.JButton bZapatillas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nombreGerente;
    // End of variables declaration//GEN-END:variables

   
    private void pintarBotones() {
        //@Nacho
        //esto pinta los logos en los botones
        
        //aqui no entiendo por que no puedo recibir la anchura y altura de boton, me dan un error que dice que valen 0
        
        ImageIcon logoChaqueta = new ImageIcon("src/IMG/Chaqueta.png"); //creamos un icono de imagen a partir de la imagen seleccionada
        bChaqueta.setIcon(new ImageIcon(logoChaqueta.getImage().getScaledInstance
        (bChaqueta.getWidth(), bChaqueta.getHeight(), Image.SCALE_SMOOTH))); 
    
        ImageIcon logoGorra = new ImageIcon("src/IMG/Gorra.png"); //creamos un icono de imagen a partir de la imagen seleccionada
        bGorra.setIcon(new ImageIcon(logoGorra.getImage().getScaledInstance
        (bGorra.getWidth(), bGorra.getHeight(), Image.SCALE_SMOOTH))); 
    
        ImageIcon logoSudadera = new ImageIcon("src/IMG/Sudadera.png"); //creamos un icono de imagen a partir de la imagen seleccionada
        bSudadera.setIcon(new ImageIcon(logoSudadera.getImage().getScaledInstance
        (bSudadera.getWidth(), bSudadera.getHeight(), Image.SCALE_SMOOTH))); 
    
        ImageIcon logoCamiseta = new ImageIcon("src/IMG/Camiseta.png"); //creamos un icono de imagen a partir de la imagen seleccionada
        bCamiseta.setIcon(new ImageIcon(logoCamiseta.getImage().getScaledInstance
        (bCamiseta.getWidth(), bCamiseta.getHeight(), Image.SCALE_SMOOTH)));
    
        ImageIcon logoPantalones = new ImageIcon("src/IMG/Pantalones.png"); //creamos un icono de imagen a partir de la imagen seleccionada
        bPantalon.setIcon(new ImageIcon(logoPantalones.getImage().getScaledInstance
        (bPantalon.getWidth(), bPantalon.getHeight(), Image.SCALE_SMOOTH))); 
    
        ImageIcon logoZapatillas = new ImageIcon("src/IMG/Zapatillas.png"); //creamos un icono de imagen a partir de la imagen seleccionada
        bZapatillas.setIcon(new ImageIcon(logoZapatillas.getImage().getScaledInstance
        (bZapatillas.getWidth(), bZapatillas.getHeight(), Image.SCALE_SMOOTH))); 
    
                
       }

}
