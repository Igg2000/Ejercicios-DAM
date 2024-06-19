package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vpp extends JFrame {
    private JButton soyUnBotonButton;
    private JPanel panel1;
    private JTextArea textArea1;

    public Vpp() {
        this.setVisible(true);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        this.setContentPane(panel1);
        this.revalidate();

        soyUnBotonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cad = textArea1.getText();
                JOptionPane.showMessageDialog(null,cad);
            }
        });
    }

/*
    private void createUIComponents() {
        // TODO: place custom component creation code here
        Border b1 = new EmptyBorder(50,50,50,50);
        Border b2 = new LineBorder(Color.GREEN);
        Border b3 = new LineBorder(Color.red);

        Border b = BorderFactory.createCompoundBorder(b2,b3);
        panel1.setBorder(b);

    } */
}
