/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import ExcepcionesPropias.InicioSesionFallido;
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
public class PanelLogin extends javax.swing.JPanel {

    VentanaPrincipal v;
    Tienda t;
    /**
     * Creates new form PanelLogin
     */
    public PanelLogin(VentanaPrincipal v, Tienda t) {
        this.t=t;
        this.v=v;
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        espacioDerecha = new javax.swing.JLabel();
        espacioAbajo = new javax.swing.JLabel();
        espacioIzquierda = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        textopassword = new javax.swing.JPasswordField();
        Login = new javax.swing.JButton();
        espacioIzquierdaBoton = new javax.swing.JLabel();
        espacioderechaboton = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 800));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(400, 400));
        setLayout(new java.awt.BorderLayout(50, 130));
        add(espacioDerecha, java.awt.BorderLayout.LINE_END);
        add(espacioAbajo, java.awt.BorderLayout.PAGE_END);
        add(espacioIzquierda, java.awt.BorderLayout.LINE_START);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 255, 255), null), javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 102, 102))));
        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 102, 102)));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        labelUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuario.setText("Usuario");
        labelUsuario.setPreferredSize(new java.awt.Dimension(40, 16));
        jPanel3.add(labelUsuario);
        jPanel3.add(textoUsuario);

        labelPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelPassword.setForeground(new java.awt.Color(255, 255, 255));
        labelPassword.setText("Contraseña");
        labelPassword.setPreferredSize(new java.awt.Dimension(40, 16));
        jPanel3.add(labelPassword);
        jPanel3.add(textopassword);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        Login.setText("Iniciar Sesion");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel1.add(Login, java.awt.BorderLayout.CENTER);

        espacioIzquierdaBoton.setText("                         ");
        jPanel1.add(espacioIzquierdaBoton, java.awt.BorderLayout.LINE_START);

        espacioderechaboton.setText("                         ");
        jPanel1.add(espacioderechaboton, java.awt.BorderLayout.LINE_END);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        
        
        String user;
        String pass;

        user= textoUsuario.getText();
        pass= String.valueOf(textopassword.getPassword()); //get password lo devuelve como un array de caracteres
        
        PersonalTienda p = null;
        // si no te devuelve el usuario muestras con un JOptionPane el mensaje de la excepcion
        try {
            p = t.dameElEmpleadoLogueado(user,pass);
        } catch (InicioSesionFallido ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        if(p!=null)
            JOptionPane.showMessageDialog(this, p);
        
    /*    
        //esto compara si el usuario y contraseña introducidos coincide con los del gerente
        if(user.equals(t.getGerenteTienda().getCredenciales().getNombreUsuario()) && pass.equals(t.getGerenteTienda().getCredenciales().getContraseña()))
            JOptionPane.showMessageDialog(this, "Bro eres el gerente");
        
        for (int i = 0; i < t.getDependientesTienda().size(); i++) {
            if(user.equals(t.getDependientesTienda().get(i).getCredenciales().getNombreUsuario()) && 
                    pass.equals(t.getDependientesTienda().get(i).getCredenciales().getContraseña()) )
                JOptionPane.showMessageDialog(this, "Eres el dependiente "+ t.getDependientesTienda().get(i));
            
        }
*/
    }//GEN-LAST:event_LoginActionPerformed

    

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        Image fondo = null;
        try {
            fondo = ImageIO.read(new File("src/IMG/login-bg.jpg")); //esto lo he tenido que buscar en internet
        } catch (IOException ex) {
            Logger.getLogger(PanelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image fondoEscalado = fondo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        
        g.drawImage(fondoEscalado, 0, 0, this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JLabel espacioAbajo;
    private javax.swing.JLabel espacioDerecha;
    private javax.swing.JLabel espacioIzquierda;
    private javax.swing.JLabel espacioIzquierdaBoton;
    private javax.swing.JLabel espacioderechaboton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextField textoUsuario;
    private javax.swing.JPasswordField textopassword;
    // End of variables declaration//GEN-END:variables
}
