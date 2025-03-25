package GUI;

import javax.swing.JButton;

/**
 *
 * @author javier
 */
public class PBotones extends javax.swing.JPanel {

    private javax.swing.JButton []b;        
    
    /**
     * Creates new form NewJPanel
     */
    public PBotones(String[] nombres) 
    {        
        b=new javax.swing.JButton[nombres.length];        
        minitComponents(nombres);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(4, 1, 20, 20));

        jButton1.setText("jButton1");
        add(jButton1);

        jButton2.setText("jButton2");
        add(jButton2);

        jButton3.setText("jButton3");
        add(jButton3);

        jButton4.setText("jButton4");
        add(jButton4);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables

    private void minitComponents(String[] nombres) 
    {    

        setLayout(new java.awt.GridLayout(b.length, 1, 20, 20));
        
        for (int i = 0; i < b.length; i++) {            
            b[i]=new JButton(nombres[i]);
            add(b[i]);
        }

        
    
    }
}
