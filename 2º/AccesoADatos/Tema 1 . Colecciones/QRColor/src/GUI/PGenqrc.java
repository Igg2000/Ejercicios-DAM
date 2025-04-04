/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import GUI.PVisqrc;
import data.App;
import data.Instituto;
import data.QRC;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class PGenqrc extends javax.swing.JPanel {

    /**
     * Creates new form PVisqrc
     */
    
    QRC qrc;
    App a;
    int numeroInstiActual=0;
    public PGenqrc(QRC qrc, App a) {
        this.qrc=qrc;
        this.a=a;
        minitComponents();
        funcionalidadBotones();
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelQueContieneQReInstiActual = new javax.swing.JPanel();
        notjPanel1 = new javax.swing.JPanel();
        panelInstiActual = new javax.swing.JPanel();
        textoAgregarCiclo = new javax.swing.JLabel();
        notpanelVisInstis = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bRojo = new javax.swing.JButton();
        bAzul = new javax.swing.JButton();
        bVerde = new javax.swing.JButton();
        bAmarillo = new javax.swing.JButton();
        bNegro = new javax.swing.JButton();
        bBlanco = new javax.swing.JButton();
        bBorrar = new javax.swing.JButton();
        bBorrarTodo = new javax.swing.JButton();
        panelLeyenda = new javax.swing.JPanel();
        leyenda = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        panelQueContieneQReInstiActual.setLayout(new java.awt.BorderLayout());
        panelQueContieneQReInstiActual.add(notjPanel1, java.awt.BorderLayout.CENTER);

        textoAgregarCiclo.setText("Estas añadiendo ciclos al instituto:");
        panelInstiActual.add(textoAgregarCiclo);

        panelQueContieneQReInstiActual.add(panelInstiActual, java.awt.BorderLayout.NORTH);

        add(panelQueContieneQReInstiActual, java.awt.BorderLayout.CENTER);

        jButton1.setText("jButton1");
        notpanelVisInstis.add(jButton1);

        add(notpanelVisInstis, java.awt.BorderLayout.EAST);

        bRojo.setText("Rojo");
        jPanel2.add(bRojo);

        bAzul.setText("Azul");
        jPanel2.add(bAzul);

        bVerde.setText("Verde");
        jPanel2.add(bVerde);

        bAmarillo.setText("Amarillo");
        jPanel2.add(bAmarillo);

        bNegro.setText("Negro");
        jPanel2.add(bNegro);

        bBlanco.setText("Blanco");
        jPanel2.add(bBlanco);

        bBorrar.setText("Borrar");
        jPanel2.add(bBorrar);

        bBorrarTodo.setText("Borrar Todo");
        jPanel2.add(bBorrarTodo);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        panelLeyenda.setBackground(new java.awt.Color(0, 102, 153));

        leyenda.setText("DAM - Rojo    DAW - Azul   ASIR - Verde  Comercio - Amarillo  STI - Negro");
        panelLeyenda.add(leyenda);

        add(panelLeyenda, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

private void minitComponents() {

        jPanel1 = new PVisqrc(qrc);
        jPanel2 = new javax.swing.JPanel();
        bRojo = new NBoton("Rojo", Color.orange.darker(),Color.red);
        bAzul = new NBoton("Azul", Color.blue,Color.cyan);
        bVerde = new NBoton("Verde", Color.yellow,Color.green);
        bAmarillo = new NBoton("Amarillo", Color.orange.darker(),Color.yellow);
        bNegro = new NBoton("Negro", Color.black,Color.lightGray);
        bBlanco = new NBoton("Blanco", Color.gray,Color.white);
        bBorrar = new NBoton("Borrar", Color.white,Color.pink);
        bBorrarTodo = new NBoton("Borrar Todo", Color.white,Color.pink);
        
        panelLeyenda = new javax.swing.JPanel();
        leyenda = new javax.swing.JLabel();
        textoAgregarCiclo = new javax.swing.JLabel();
        panelVisInstis = new PInstis(a);
        panelQueContieneQReInstiActual = new javax.swing.JPanel();
        panelInstiActual = new javax.swing.JPanel();
        
        setLayout(new java.awt.BorderLayout());


        panelQueContieneQReInstiActual.setLayout(new java.awt.BorderLayout());
        panelQueContieneQReInstiActual.add(jPanel1, java.awt.BorderLayout.CENTER);

        textoAgregarCiclo.setFont(new Font("Segoe UI",1,28));
        textoAgregarCiclo.setText("Estas añadiendo ciclos al instituto: "+a.getInstis().get(numeroInstiActual).getNombre());
        panelInstiActual.add(textoAgregarCiclo);

        panelQueContieneQReInstiActual.add(panelInstiActual, java.awt.BorderLayout.NORTH);

        add(panelQueContieneQReInstiActual, java.awt.BorderLayout.CENTER);

        add(panelVisInstis, java.awt.BorderLayout.EAST);


        jPanel2.add(bRojo);
        jPanel2.add(bAzul);
        jPanel2.add(bVerde);
        jPanel2.add(bAmarillo);
        jPanel2.add(bNegro);
        jPanel2.add(bBlanco);
        jPanel2.add(bBorrar);
        jPanel2.add(bBorrarTodo);

        add(jPanel2, java.awt.BorderLayout.NORTH);
        

        javax.swing.GroupLayout panelLeyendaLayout = new javax.swing.GroupLayout(panelLeyenda);
        
        
        panelLeyenda.setBackground(new java.awt.Color(0, 102, 153));
        leyenda.setForeground(Color.white);
        leyenda.setText("DAM - Rojo        DAW - Azul        ASIR - Verde        Comercio - Amarillo        STI - Negro        Siguiente Insti - Blanco");
        panelLeyenda.add(leyenda);

        add(panelLeyenda, java.awt.BorderLayout.SOUTH);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAmarillo;
    private javax.swing.JButton bAzul;
    private javax.swing.JButton bBlanco;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bBorrarTodo;
    private javax.swing.JButton bNegro;
    private javax.swing.JButton bRojo;
    private javax.swing.JButton bVerde;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel leyenda;
    private javax.swing.JPanel notjPanel1;
    private javax.swing.JPanel notpanelVisInstis;
    private javax.swing.JPanel panelInstiActual;
    private javax.swing.JPanel panelLeyenda;
    private javax.swing.JPanel panelQueContieneQReInstiActual;
    private javax.swing.JLabel textoAgregarCiclo;
    // End of variables declaration//GEN-END:variables
    private PVisqrc jPanel1;
    private PInstis panelVisInstis;
            
    private void funcionalidadBotones() {
        bRojo.addActionListener(e ->{
            funcionBotonColor(Color.red);
        });
        bAzul.addActionListener(e ->{
            funcionBotonColor(Color.blue);
        });
        bVerde.addActionListener(e ->{
            funcionBotonColor(Color.green);
        });
        bAmarillo.addActionListener(e ->{
            funcionBotonColor(Color.yellow);
        });
        bNegro.addActionListener(e ->{
            funcionBotonColor(Color.black);
        });
        bBlanco.addActionListener(e ->{
            
            if(PGenqrc.this.numeroInstiActual<PGenqrc.this.a.getInstis().size()-1){
                PGenqrc.this.numeroInstiActual++;
                PGenqrc.this.textoAgregarCiclo.setText("Estas añadiendo ciclos al instituto: "+a.getInstis().get(numeroInstiActual).getNombre());
            }else{
                JOptionPane.showMessageDialog(PGenqrc.this, "No hay mas institutos");
                return;
            }
            PGenqrc.this.jPanel1.getQrc().agregaColor(Color.white);
            PGenqrc.this.jPanel1.repaint();
        });
        bBorrar.addActionListener(e ->{
            Color colorBorrado=null;

            colorBorrado=PGenqrc.this.jPanel1.getQrc().borrarUltimoColor();
            if(colorBorrado==null)
                return;

            if(colorBorrado==Color.white){
                PGenqrc.this.numeroInstiActual--;
                textoAgregarCiclo.setText("Estas añadiendo ciclos al instituto: "+a.getInstis().get(numeroInstiActual).getNombre());
            }
            
            a.getInstis().get(numeroInstiActual).borrarCiclo(colorBorrado);
            
            PGenqrc.this.panelVisInstis.crearListaDeInstis();
            PGenqrc.this.jPanel1.repaint();
        });
        bBorrarTodo.addActionListener(e ->{
            PGenqrc.this.numeroInstiActual=0;
            textoAgregarCiclo.setText("Estas añadiendo ciclos al instituto: "+a.getInstis().get(numeroInstiActual).getNombre());
            PGenqrc.this.a.borrarTodosLosCiclosDeLosInstis();
            PGenqrc.this.panelVisInstis.crearListaDeInstis();
            PGenqrc.this.jPanel1.getQrc().borrarTodo();
            PGenqrc.this.jPanel1.repaint();
        });
    }

    private void funcionBotonColor(Color c) {
                
            try {  
                PGenqrc.this.a.getInstis().get(numeroInstiActual).addCiclos(c);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(PGenqrc.this, ex);
                return;
            }
            PGenqrc.this.jPanel1.getQrc().agregaColor(c);
            PGenqrc.this.panelVisInstis.crearListaDeInstis();
            PGenqrc.this.jPanel1.repaint();
    }
}
