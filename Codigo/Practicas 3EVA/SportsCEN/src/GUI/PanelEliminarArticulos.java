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
import javax.swing.JOptionPane;

/**
 *
 * @author grovy
 */
public class PanelEliminarArticulos extends javax.swing.JPanel {

    /**
     * Creates new form PanelMenuGerente
     */
    private VentanaPrincipal v;
    private Tienda t;
    private PersonalTienda pt;
    private String[] articulosSplit;
    
    public PanelEliminarArticulos(VentanaPrincipal v, Tienda t, PersonalTienda pt) {
        this.t=t;
        this.v=v;
        this.pt=pt;
        //v.setSize(600, 600);
        //v.setLocationRelativeTo(null);
        
        initComponents();
        
        nombreGerente.setText("Bienvenido a "+ t.getNombre()+", "+pt.getNombreCompleto());
        
            //lo de abajo añade a la lista los dependientes
            Gerente g= (Gerente) pt;
            
            String cad=g.mostrarArticulos(t.getArticulosTienda());
            //como esta funcion  te los da todos juntos separados por saltos de linea , 
            //y setlistdata nos pide un array de String con un split del salto de linea lo convertimos a array
            String[] articulosSplit = cad.split("\n");
            lista.setListData(articulosSplit);
            this.articulosSplit= articulosSplit;
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        nombreGerente = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        bVolverAtras = new javax.swing.JButton();
        bVolverMenu = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLabel3.setText("                                    ");
        add(jLabel3, java.awt.BorderLayout.LINE_START);

        jLabel4.setText("                                    ");
        add(jLabel4, java.awt.BorderLayout.LINE_END);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout(0, 2));

        jPanel3.setOpaque(false);

        bEliminar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(bEliminar);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        lista.setBackground(new java.awt.Color(0, 51, 51));
        lista.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        lista.setForeground(new java.awt.Color(255, 255, 255));
        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lista);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

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

        jPanel4.setOpaque(false);

        bVolverAtras.setText("Volver atras");
        bVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverAtrasActionPerformed(evt);
            }
        });
        jPanel4.add(bVolverAtras);

        bVolverMenu.setText("Volver al menu");
        bVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverMenuActionPerformed(evt);
            }
        });
        jPanel4.add(bVolverMenu);

        add(jPanel4, java.awt.BorderLayout.SOUTH);
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
            this.v.ponPanel(Paneles.PGestionarArticulos, pt);
    }//GEN-LAST:event_bVolverAtrasActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        
        //si no seleccionas ningun elemento te salta el mensaje y no ejecuta el resto del codigo
        if(lista.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(this, "Debes elegir un elemento de la lista");
            return;
        }
        
        Gerente g= (Gerente) pt;
        int elegidoLista=lista.getSelectedIndex();
        
        //borra de la lista de dependientes el dependiente que esté en la posicion que tu hayas elegido
        t.getArticulosTienda().remove((t.getArticulosTienda().get(elegidoLista)));

        
        //copaindo lo que he hecho al principio consigo actualizar la lista    
           String cad=g.mostrarArticulos(t.getArticulosTienda());
            //como mostrar dependientes te los da todos juntos separados por saltos de linea , 
            //y setlistdata nos pide un array de String con un split del salto de linea lo convertimos a array
            this.articulosSplit = cad.split("\n");
            lista.setListData(articulosSplit);
        
    }//GEN-LAST:event_bEliminarActionPerformed

   
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
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bVolverAtras;
    private javax.swing.JButton bVolverMenu;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lista;
    private javax.swing.JLabel nombreGerente;
    // End of variables declaration//GEN-END:variables
}
