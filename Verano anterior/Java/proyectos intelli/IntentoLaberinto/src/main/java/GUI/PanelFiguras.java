package GUI;

import data.Figura;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelFiguras extends JPanel {

    List<Figura> figuras= new ArrayList<>();
    int separacion = 10;

    public PanelFiguras() {
        crearFiguras();
    }


    private void crearFiguras() {
        JLabel tituloFiguras = new JLabel("Figuras");
        tituloFiguras.setBorder(new EmptyBorder(0,0,50,0));
        add(tituloFiguras);
        setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(20,20,20,20), BorderFactory.createLineBorder(Color.BLACK, 1)));

        pintarFiguras();
    }

    private void pintarFiguras() {

        figuras.add(new Figura(0,30,10,10,Color.BLACK));
        figuras.add(new Figura(0,30,10,10,Color.BLUE));
        figuras.add(new Figura(0,30,10,10,Color.RED));
        figuras.add(new Figura(0,30,10,10,Color.GREEN));
        figuras.add(new Figura(0,30,10,10,Color.MAGENTA));


        this.figuras = figuras;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Figura f : figuras) {
            f.setX(separacion);
            separacion += f.getAncho() + separacion;
            f.pintar(g);
        }
    }
}
