package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author javier
 */
public class V2 extends JFrame{

    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1, jPanelBoton,jPanelLabelUp;
    JButton b;
    
    public V2(VPpal v, String cad) 
    {
        super("");
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1.setText(cad);
        jLabel2.setText("    ");
        
        b=new JButton("OK");
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });

        
        
        jPanel1 = new javax.swing.JPanel();
        
        
        jPanelLabelUp= new javax.swing.JPanel();        
        jPanelLabelUp.add(jLabel1);
        jPanelLabelUp.add(new JLabel("       "));
        
        
        jPanelBoton= new javax.swing.JPanel();        
        jPanelBoton.add(new JLabel("       "));
        jPanelBoton.add(b);
        
        
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));        
        jPanel1.add(jPanelLabelUp);
        jPanel1.add(jLabel2);
        jPanel1.add(jPanelBoton);        
        
        this.setLayout(new java.awt.GridBagLayout());        
        this.add(jPanel1, new java.awt.GridBagConstraints());
        
        
        
        this.setSize(260,140);        
        this.setLocationRelativeTo(v);        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setUndecorated(true);
    }

    
    /*
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody            
        g.setColor(Color.red);
        g.fill3DRect(10,10,300,300,true);
    }*/

    
}
