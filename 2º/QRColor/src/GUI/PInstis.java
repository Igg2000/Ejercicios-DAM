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
public class PInstis extends javax.swing.JPanel {

    
    App a;
    
    
    public PInstis(App a) {
        initComponents();
        this.a=a;
        crearListaDeInstis();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("asfasf");
        add(jLabel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void crearListaDeInstis() {
        jLabel1.setText("<html>");
        //Creo la lista estructurandola como una pagina html, usando css en el head y el html en el body
        String head="";
        
        head=agregarCSS();

        jLabel1.setText(jLabel1.getText()+head+"<body>");
        List<Instituto> instis= a.getInstis();
        
        //String separador="<br>";
        String separador="";
        
        for (Instituto insti : instis) {
            jLabel1.setText(jLabel1.getText()+"<h2>"+insti.getNombre()+"</h2>"+insti.getCiclosEnHTML()+separador);
        }
        jLabel1.setText(jLabel1.getText()+"</body>");
        
        
    }

    private String agregarCSS() {
        String cad=
                    """
                        <head>
                            <style>
                                body{
                                    background-color: #67a3d7;
                                    border: 10px solid #708090;
                                    font-family: 'Courier New', Courier, monospace;
                                }
                                h2{
                                    font-size: 26px;
                                    font-weight: bold;
                                }           
                                p{
                                    font-size: 20px;
                                }
                            </style>
                        </head>
                    """;
        
        return cad;
    }
}
