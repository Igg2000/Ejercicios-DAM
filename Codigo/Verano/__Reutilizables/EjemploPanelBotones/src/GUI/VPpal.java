package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author javier
 */
public class VPpal extends javax.swing.JFrame {

    /**
     * Creates new form VPpal
     */
    public VPpal() {
        minitComponents();
        //setContentPane(new PBotones(new String[]{"Altas", "Bajas", "Pepe", "Salir"}));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void minitComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("TITULO");
        jLabel1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        jLabel1.setVerticalAlignment((int) CENTER_ALIGNMENT);
        
        jPanel1 = new PBotones(new String[]{"Altas", "Bajas", "Pepe", "Salir"});
        jPanel1.setBorder(new EmptyBorder(20,0,0,0));
        Component[] components = jPanel1.getComponents();
        components[0].addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                JOptionPane.showMessageDialog(null, "hola, soy la primera opcion");
            }
            
        });
        
        getContentPane().add(jLabel1, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        ((JPanel) (getContentPane())).setBorder(new EmptyBorder(30, 50, 50, 50));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.yellow.darker());
        
    }
}
