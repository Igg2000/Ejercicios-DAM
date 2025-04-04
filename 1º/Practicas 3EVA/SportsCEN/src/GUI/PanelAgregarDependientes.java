/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import ExcepcionesPropias.*;
import static ExcepcionesPropias.DNIException.validarDNI;
import static ExcepcionesPropias.NombreException.validarNombre;
import static ExcepcionesPropias.TelefonoException.validarTelefono;
import data.Gerente;
import data.PersonalTienda;
import data.Tienda;
import data.Usuario;
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
public class PanelAgregarDependientes extends javax.swing.JPanel {

    /**
     * Creates new form PanelMenuGerente
     */
    VentanaPrincipal v;
    Tienda t;
    Gerente pt;
    
    public PanelAgregarDependientes(VentanaPrincipal v, Tienda t, PersonalTienda pt) {
        this.t=t;
        this.v=v;
        this.pt=(Gerente)pt;
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        bAgregarDependiente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tDNI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tPassword = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nombreGerente = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bVolverAtras = new javax.swing.JButton();
        bVolverMenu = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 153));
        setLayout(new java.awt.BorderLayout());

        jLabel3.setText("                               ");
        add(jLabel3, java.awt.BorderLayout.LINE_START);

        jLabel4.setText("                               ");
        add(jLabel4, java.awt.BorderLayout.LINE_END);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setOpaque(false);

        bAgregarDependiente.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        bAgregarDependiente.setText("Agregar Dependiente");
        bAgregarDependiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarDependienteActionPerformed(evt);
            }
        });
        jPanel5.add(bAgregarDependiente);

        jPanel1.add(jPanel5, java.awt.BorderLayout.SOUTH);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 51, 51)), javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0))));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel8.setText(" ");
        jPanel4.add(jLabel8, java.awt.BorderLayout.PAGE_START);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(0, 2, 10, 30));

        jLabel1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre Completo");
        jPanel6.add(jLabel1);

        tNombre.setBackground(new java.awt.Color(154, 219, 219));
        tNombre.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        tNombre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(tNombre);

        jLabel2.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DNI");
        jPanel6.add(jLabel2);

        tDNI.setBackground(new java.awt.Color(154, 219, 219));
        tDNI.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        tDNI.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(tDNI);

        jLabel5.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Telefono");
        jPanel6.add(jLabel5);

        tTelefono.setBackground(new java.awt.Color(154, 219, 219));
        tTelefono.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        tTelefono.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(tTelefono);

        jLabel6.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Usuario (opcional)");
        jPanel6.add(jLabel6);

        tUsuario.setBackground(new java.awt.Color(154, 219, 219));
        tUsuario.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        tUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(tUsuario);

        jLabel7.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Contraseña (opcional)");
        jPanel6.add(jLabel7);

        tPassword.setBackground(new java.awt.Color(154, 219, 219));
        tPassword.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        tPassword.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(tPassword);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jLabel10.setText("   ");
        jPanel4.add(jLabel10, java.awt.BorderLayout.LINE_END);

        jLabel11.setText(" ");
        jPanel4.add(jLabel11, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

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

        bVolverAtras.setText("Volver Atras");
        bVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverAtrasActionPerformed(evt);
            }
        });
        jPanel3.add(bVolverAtras);

        bVolverMenu.setText("Volver al Menu");
        bVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverMenuActionPerformed(evt);
            }
        });
        jPanel3.add(bVolverMenu);

        add(jPanel3, java.awt.BorderLayout.SOUTH);
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

    private void bAgregarDependienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarDependienteActionPerformed
        // TODO add your handling code here:
        
        String nom=null;
        int tel=0;
        String dni=null;
                

        try {
            //si el nombre no es valido se notificará y no se podra crear el dependiente
            validarNombre(tNombre.getText());
        } catch (NombreException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
        
        try {
            //si el DNI no es valido se notificará y no se podra crear el dependiente
            validarDNI(tDNI.getText());
        } catch (DNIException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
 
        try {
            //si el telefono no es valido de notificará al usuario y no se podra crear el dependiente
            validarTelefono(tTelefono.getText());
        } catch (TelefonoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
      
        
        
        nom=tNombre.getText();
        tel= Integer.parseInt(tTelefono.getText());
        dni=tDNI.getText();

        
        String user=tUsuario.getText();
        String pass=tPassword.getText();
       
        pt.agregarDependienteATienda(t.getDependientesTienda(), nom, dni, tel, new Usuario(user,pass));
        JOptionPane.showMessageDialog(this, "Usuario agregado con exito");

        
    }//GEN-LAST:event_bAgregarDependienteActionPerformed

   
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
    private javax.swing.JButton bAgregarDependiente;
    private javax.swing.JButton bVolverAtras;
    private javax.swing.JButton bVolverMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel nombreGerente;
    private javax.swing.JTextField tDNI;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tPassword;
    private javax.swing.JTextField tTelefono;
    private javax.swing.JTextField tUsuario;
    // End of variables declaration//GEN-END:variables
}
