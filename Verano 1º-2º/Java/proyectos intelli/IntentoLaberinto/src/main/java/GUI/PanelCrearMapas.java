package GUI;


import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class PanelCrearMapas extends JPanel {

    JPanel panelEditor = new JPanel();
    PanelFiguras panelFiguras = new PanelFiguras();

    //constructor
    public PanelCrearMapas() {
        inicializar();
    }


    public void inicializar() {
        this.setLayout(new BorderLayout());

        crearEditor();

        this.add(panelEditor, BorderLayout.CENTER);
        this.add(panelFiguras, BorderLayout.NORTH);


    }


    private void crearEditor() {
        panelEditor.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(20,20,20,20), BorderFactory.createLineBorder(Color.red, 5)));
    }
}
