/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import GUI.PVisqrc;
import data.QRC;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Nacho
 */
public class PGenqrc extends javax.swing.JPanel {

    /**
     * Creates new form PVisqrc
     */
    
    QRC qrc;
    public PGenqrc(QRC qrc) {
        this.qrc=qrc;
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

        notjPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bRojo = new javax.swing.JButton();
        bAzul = new javax.swing.JButton();
        bVerde = new javax.swing.JButton();
        bAmarillo = new javax.swing.JButton();
        bNegro = new javax.swing.JButton();
        bBlanco = new javax.swing.JButton();
        bBorrar = new javax.swing.JButton();
        bBorrarTodo = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout notjPanel1Layout = new javax.swing.GroupLayout(notjPanel1);
        notjPanel1.setLayout(notjPanel1Layout);
        notjPanel1Layout.setHorizontalGroup(
            notjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        notjPanel1Layout.setVerticalGroup(
            notjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(notjPanel1, java.awt.BorderLayout.CENTER);

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
        bBorrarTodo = new NBoton("Borrar", Color.white,Color.pink);
        
        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel notjPanel1;
    // End of variables declaration//GEN-END:variables
    private PVisqrc jPanel1;
            
    private void funcionalidadBotones() {
        bRojo.addActionListener(e ->{
            PGenqrc.this.jPanel1.getQrc().agregaColor(Color.red);
            PGenqrc.this.jPanel1.repaint();
        });
        bAzul.addActionListener(e ->{
            PGenqrc.this.jPanel1.getQrc().agregaColor(Color.blue);
            PGenqrc.this.jPanel1.repaint();
        });
        bVerde.addActionListener(e ->{
            PGenqrc.this.jPanel1.getQrc().agregaColor(Color.green);
            PGenqrc.this.jPanel1.repaint();
        });
        bAmarillo.addActionListener(e ->{
            PGenqrc.this.jPanel1.getQrc().agregaColor(Color.yellow);
            PGenqrc.this.jPanel1.repaint();
        });
        bNegro.addActionListener(e ->{
            PGenqrc.this.jPanel1.getQrc().agregaColor(Color.black);
            PGenqrc.this.jPanel1.repaint();
        });
        bBlanco.addActionListener(e ->{
            PGenqrc.this.jPanel1.getQrc().agregaColor(Color.white);
            PGenqrc.this.jPanel1.repaint();
        });
        bBorrar.addActionListener(e ->{
            PGenqrc.this.jPanel1.getQrc().borrarUltimoColor();
            PGenqrc.this.jPanel1.repaint();
        });
        bBorrarTodo.addActionListener(e ->{
            PGenqrc.this.jPanel1.getQrc().borrarTodo();
            PGenqrc.this.jPanel1.repaint();
        });
    }
}
