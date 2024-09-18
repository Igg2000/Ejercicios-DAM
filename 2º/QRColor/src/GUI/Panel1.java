/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import data.App;
import data.Instituto;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class Panel1 extends javax.swing.JPanel {

    
    App a;
    
    
    public Panel1(App a) {
        initComponents();
        this.a=a;
        crearListaDeInstis();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("asfasf");
        add(jLabel1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void crearListaDeInstis() {
        jLabel1.setText("<html>");
        // queria meterle css en el head
         //jLabel1.setText(jLabel1.getText()+);
        List<Instituto> instis= a.getInstis();
        String separador="<br>";
        
        for (Instituto insti : instis) {
            jLabel1.setText(jLabel1.getText()+insti.getNombre()+separador);
        }
        
        
    }
}
