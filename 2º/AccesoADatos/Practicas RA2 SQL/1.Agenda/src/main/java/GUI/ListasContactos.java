package GUI;

import Ventana.Vppal;
import data.App;
import data.Contacto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ListasContactos extends JPanel {

    private final Vppal v;
    private final MenuPrincipal panelAnterior;
    private final List<Contacto> contactos;
    
    private int anchoTarjeta=250;
    private int altoTarjeta=100;

    public ListasContactos(Vppal v, MenuPrincipal panelAnterior, List<Contacto> contactos) {
        this.v = v;
        this.panelAnterior = panelAnterior;
        this.contactos = contactos;
        minitComponents();
        
    }

    private JPanel crearTarjeta(Contacto contacto) {
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(new BorderLayout());
        tarjeta.setPreferredSize(new Dimension(anchoTarjeta, altoTarjeta)); // Tamaño fijo de la tarjeta
        tarjeta.setBorder(BorderFactory.createLineBorder(App.TEMA.getComplementario(), 1));
        tarjeta.setBackground(App.TEMA.getBoton());

        // Icono silueta
        JLabel silueta = new JLabel();
        silueta.setIcon(new ImageIcon(new ImageIcon(".//res//silueta.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        silueta.setPreferredSize(new Dimension(70, 100));
        tarjeta.add(silueta, BorderLayout.WEST);

        // Información (nombre, teléfono y dirección)
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 1));
        infoPanel.setBackground(App.TEMA.getBoton());

        JLabel nombreLabel = new JLabel(contacto.getNombre());
        nombreLabel.setFont(App.TEMA.getFuenteTexto());

        JLabel telefonoLabel = new JLabel(contacto.getTelefono());
        telefonoLabel.setFont(App.TEMA.getFuenteTexto());

        JLabel direccionLabel = new JLabel(contacto.getDireccion());
        direccionLabel.setFont(App.TEMA.getFuenteTexto());

        infoPanel.add(nombreLabel);
        infoPanel.add(telefonoLabel);
        infoPanel.add(direccionLabel);

        tarjeta.add(infoPanel, BorderLayout.CENTER);

        // Añadir funcionalidad visual y hacer que sea clickeable
        tarjeta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanel p = new EditarContacto(v,panelAnterior,ListasContactos.this,contacto);
                v.ponPanel(p);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                tarjeta.setBackground(App.TEMA.getTexto());
                tarjeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                infoPanel.setBackground(App.TEMA.getTexto());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                tarjeta.setBackground(App.TEMA.getBoton());
                tarjeta.setCursor(Cursor.getDefaultCursor());
                infoPanel.setBackground(App.TEMA.getBoton());
            }
        });

        return tarjeta;
    }

    public void minitComponents() {
        UtilTema.aplicarTema(this, App.TEMA);
        
        // Panel contenedor para centrar las tarjetas
        JPanel panelContenedor = new JPanel(new GridLayout(0,1));
        panelContenedor.setBackground(App.TEMA.getFondo());

        // Crear tarjetas para cada contacto
        for (Contacto contacto : contactos) {
            JPanel tarjeta = crearTarjeta(contacto);
            panelContenedor.add(tarjeta);
        }

        // Agregar el panel contenedor dentro de un JScrollPane
        JScrollPane scrollPane = new JScrollPane(panelContenedor);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
    
}
