package GUI;

import PanelesGUI.NBoton;
import data.App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author grovy
 */
public class PanelPrincipal extends javax.swing.JPanel {

    private App app;

    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal(App app) {
        this.app = app;
        miInitComponent();
    }
        
    private void miInitComponent() {
        
        setLayout(new BorderLayout());
        
        // Crear componentes
        JLabel titulo = new JLabel("Animación de Particulas", JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI",1,26));
        PanelAnimacion panelAnimacion = new PanelAnimacion(app);
        JPanel panelBoton = new JPanel(new FlowLayout());
        panelBoton.setOpaque(false);
        JButton boton = new NBoton("Iniciar Animación", Color.decode("#b4b4c8"), Color.decode("#ECDFCC"));
        boton.setFont(new Font("Verdana",0,18));
        
        Color colorFondo = panelAnimacion.getColorFondo();
        setBackground(colorFondo);

        // Si pulsas el boton inicia la animacion
        boton.addActionListener(e -> {
            panelAnimacion.iniciarAnimacion();
            revalidate();
            repaint();
        });

        // Añadir los componentes al layout
        add(titulo, BorderLayout.NORTH); // Título arriba
        add(panelAnimacion, BorderLayout.CENTER); // Panel de animación en el centro
        panelBoton.add(boton);
        add(panelBoton, BorderLayout.SOUTH); // Botón abajo
        
        JFrame ventana = app.getV();
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Llamar al método finalizarAnimacion cuando se cierre la ventana
                panelAnimacion.finalizarAnimacion();
            }
        });
        
    }
}