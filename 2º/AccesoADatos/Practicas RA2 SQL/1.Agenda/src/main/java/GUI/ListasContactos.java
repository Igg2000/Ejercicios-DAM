package GUI;

import Temas.UtilTema;
import Ventana.Vppal;
import data.App;
import data.Contacto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Esta clase contiene la lista de contactos en forma de tarjetas
 * al hacer click en una de las tarjetas podrás modificar o borrar al contacto
 * seleccionado, tambien se puede filtrar por nombre o telefono
 * @author Nacho
 */
public class ListasContactos extends JPanel {

    private final Vppal v;
    private final MenuPrincipal panelAnterior;
    private final List<Contacto> contactos;
    private JPanel panelContenedor;
    
    private int anchoTarjeta=550;
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
        nombreLabel.setForeground(App.TEMA.getTexto());

        JLabel telefonoLabel = new JLabel(contacto.getTelefono());
        telefonoLabel.setFont(App.TEMA.getFuenteTexto());
        telefonoLabel.setForeground(App.TEMA.getTexto());

        JLabel direccionLabel = new JLabel(contacto.getDireccion());
        direccionLabel.setFont(App.TEMA.getFuenteTexto());
        direccionLabel.setForeground(App.TEMA.getTexto());

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
                tarjeta.setBackground(App.TEMA.getComplementario());
                tarjeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                infoPanel.setBackground(App.TEMA.getComplementario());
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
        
        // Crear el panel de búsqueda
        JPanel barraBusqueda = new JPanel(new BorderLayout(10, 10));
        barraBusqueda.setBackground(App.TEMA.getFondo());
        barraBusqueda.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel letreroBarraBusqueda = new JLabel("Busca por nombre o telefono");
        letreroBarraBusqueda.setFont(App.TEMA.getFuenteTexto());
        letreroBarraBusqueda.setForeground(App.TEMA.getTexto());

        JTextField campoBusqueda = new JTextField();
        campoBusqueda.setFont(App.TEMA.getFuenteTexto());
        campoBusqueda.setPreferredSize(new Dimension(200, 30));
        campoBusqueda.setToolTipText("Introduce el nombre o telefono del amigo que quieres buscar");

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setFont(App.TEMA.getFuenteBoton());
        botonBuscar.setBackground(App.TEMA.getBoton());
        botonBuscar.setForeground(App.TEMA.getTexto());
        botonBuscar.addActionListener(e -> buscarContactos(campoBusqueda.getText()));

        barraBusqueda.add(letreroBarraBusqueda, BorderLayout.WEST);
        barraBusqueda.add(campoBusqueda, BorderLayout.CENTER);
        barraBusqueda.add(botonBuscar, BorderLayout.EAST);
        
        // Panel contenedor para centrar las tarjetas
        //JPanel panelContenedor = new JPanel(new GridLayout(0,1));
        panelContenedor = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelContenedor.setBackground(App.TEMA.getFondo());

        // Crear tarjetas para cada contacto
        for (Contacto contacto : contactos) {
            JPanel tarjeta = crearTarjeta(contacto);
            panelContenedor.add(tarjeta);
        }
        
        //si no hay tarjetas te sale un mensaje de que no hay amigos
        if(panelContenedor.getComponentCount()<=0){
           JLabel vacio = new JLabel("No hay amigos en la lista");
           vacio.setFont(App.TEMA.getFuenteTitulo());
           vacio.setForeground(App.TEMA.getTexto());
           panelContenedor.add(vacio);
         }
        
        // Añadir el panel contenedor a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(panelContenedor);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Ajustar tarjetas dinámicamente al redimensionar la ventana
           scrollPane.addComponentListener(new java.awt.event.ComponentAdapter() {
               @Override
               public void componentResized(java.awt.event.ComponentEvent evt) {
                   ajustarColumnas(panelContenedor, scrollPane.getViewport().getWidth());
               }
           });

           // Configurar el layout principal
           setLayout(new BorderLayout());
           add(scrollPane, BorderLayout.CENTER);
           add(barraBusqueda, BorderLayout.NORTH);

           // Realizar ajuste inicial de las columnas
           ajustarColumnas(panelContenedor, scrollPane.getViewport().getWidth());

    }

    
    //Ajusta las filas y columnas de las tarjetas en función del ancho disponible.
    private void ajustarColumnas(JPanel panelContenedor, int anchoDisponible) {
       int tarjetasPorFila = Math.max(anchoDisponible / (anchoTarjeta + 10), 1); // Calcular cuántas tarjetas caben por fila
       int anchoTotal = (anchoTarjeta + 10) * tarjetasPorFila; // Espacio necesario para las tarjetas por fila
       panelContenedor.setPreferredSize(new Dimension(anchoTotal, panelContenedor.getComponentCount() * (altoTarjeta + 10)));
       panelContenedor.revalidate();
       panelContenedor.repaint();
    }
    
    /**
    * Filtra y muestra las tarjetas que coinciden con la búsqueda.
    *
    * @param query El texto de búsqueda ingresado por el usuario.
    */
   private void buscarContactos(String query) {
       
       String busqueda = query.toLowerCase();

       // Filtrar la lista de contactos según la búsqueda
       List<Contacto> resultados = contactos.stream()
           .filter(contacto -> contacto.getNombre().toLowerCase().contains(busqueda)
                   || contacto.getTelefono().contains(busqueda))
           .toList();

       // Limpiar y volver a agregar las tarjetas filtradas al contenedor
       
       panelContenedor.removeAll();
       for (Contacto contacto : resultados) {
           JPanel tarjeta = crearTarjeta(contacto);
           panelContenedor.add(tarjeta);
       }

       //si no hay tarjetas te sale un mensaje de que no hay amigos
       if(panelContenedor.getComponentCount()<=0){
           JLabel vacio = new JLabel("No hay amigos en la lista");
           vacio.setFont(App.TEMA.getFuenteTitulo());
           vacio.setForeground(App.TEMA.getTexto());
           panelContenedor.add(vacio);
       }
           
       
       // Actualizar la vista
       panelContenedor.revalidate();
       panelContenedor.repaint();
   }

}
