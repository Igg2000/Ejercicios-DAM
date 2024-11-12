package PanelesGUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nacho
 */
public class PMenuV2 extends JPanel {


    private NBoton []botones;
    private JPanel panelOpciones= new JPanel();
    private JPanel panelTitulo= new JPanel();
    private JLabel titulo = new JLabel();

    private String[] opciones;
    private String nombreTitulo;
    private Color color1;
    private Color color2;
    private Color colorFondo;

    private Color colorLetraBotones;
    private Font fuenteBotones;
    
    private Image imagen;

    /**
     * Crea un menú sin titulo con las opciones que le des 
     * y un degradado con ambos colores
     * @param opciones Opciones del Menu
     * @param color1 Color del Centro
     * @param color2 Color de los lados
     */
    public PMenuV2(String[] opciones, Color color1, Color color2){
        this.opciones=opciones;
        this.color1=color1;
        this.color2=color2;
        minitComponents();
    }
    /**
     * Crea un menu con botones blancos por cada opcion, fondo blanco
     * y sin titulo
     * @param opciones Opciones que va a tener el menu
     */
    public PMenuV2(String[] opciones){
        this.opciones=opciones;
        this.color1=Color.white;
        this.color2=Color.white;
        minitComponents();
    }
    /**
     * Crea un Menu con botones blancos por cada opcion, fondo blanco
     * y con el titulo que le des
     * @param opciones Opciones que va a tener el menu
     * @param nombreTitulo Titulo del Menú
     */
    public PMenuV2(String[] opciones, String nombreTitulo){
        this.opciones=opciones;
        this.nombreTitulo=nombreTitulo;
        this.color1=Color.white;
        this.color2=Color.white;
        minitComponents();
    }
    /**
     * Crea un Menu con botones con un degradado entre dos colores, un titulo y
     * un fondo que será un tono mas claro del boton central
     * @param opciones Opciones que va a tener el menú
     * @param nombreTitulo Titulo del Menú
     * @param color1 Color central de los botones
     * @param color2 Color de los laterales
     */
    public PMenuV2(String[] opciones, String nombreTitulo, Color color1, Color color2){
        this.opciones=opciones;
        this.nombreTitulo=nombreTitulo;
        this.color1=color1;
        this.color2=color2;
        minitComponents();
    }

    /**
     * Crea un Menu con botones con un degradado entre dos colores, un titulo 
     * y un color de fondo que tu has elegido
     * @param opciones Opciones que va a tener el menú
     * @param nombreTitulo Titulo del Menú
     * @param color1 Color central de los botones
     * @param color2 Color de los laterales
     * @param colorFondo Color del fondo
     */
    public PMenuV2(String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo){
        this.opciones=opciones;
        this.nombreTitulo=nombreTitulo;
        this.color1=color1;
        this.color2=color2;
        this.colorFondo=colorFondo;
        minitComponents();
    }
    /**
     * Crea un Menu con botones con un degradado entre dos colores, 
     * un color de fondo que tu has elegido y un titulo el cual puedes elejir
     * la fuente y el color
     * @param opciones Opciones que va a tener el menú
     * @param nombreTitulo Titulo del Menú
     * @param color1 Color central de los botones
     * @param color2 Color de los laterales
     * @param colorFondo Color del fondo
     * @param fuenteTitulo Fuente del titulo
     * @param colorLetraTitulo Color del titulo
     */
    public PMenuV2(String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo, Font fuenteTitulo, Color colorLetraTitulo){
        this.opciones=opciones;
        this.nombreTitulo=nombreTitulo;
        this.color1=color1;
        this.color2=color2;
        this.colorFondo=colorFondo;
        this.titulo.setFont(fuenteTitulo);
        this.titulo.setForeground(colorLetraTitulo);
        minitComponents();
    }

    /**
     * Crea un Menu con botones con un degradado entre dos colores, la fuente y
     * el color de texto elegidos, ademas de un color de fondo que tu has elegido
     * y un titulo el cual puedes elegir la fuente y el color
     * @param opciones Opciones que va a tener el menú
     * @param nombreTitulo Titulo del Menú
     * @param color1 Color central de los botones
     * @param color2 Color de los laterales
     * @param colorFondo Color del fondo
     * @param fuenteTitulo Fuente del titulo
     * @param colorLetraTitulo Color del titulo
     * @param fuenteBotones Fuente del texto de los botones
     * @param colorLetraBotones Color del texto de los botones
     */
    public PMenuV2(String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo, Font fuenteTitulo, Color colorLetraTitulo, Font fuenteBotones, Color colorLetraBotones){
        this.opciones=opciones;
        this.nombreTitulo=nombreTitulo;
        this.color1=color1;
        this.color2=color2;
        this.colorFondo=colorFondo;
        this.titulo.setFont(fuenteTitulo);
        this.titulo.setForeground(colorLetraTitulo);
        this.fuenteBotones=fuenteBotones;
        this.colorLetraBotones=colorLetraBotones;
        minitComponents();
    }

    private void minitComponents(){
        botones=new NBoton[opciones.length];

        //Esto pone un layout a todo el panel para poner el panel de opciones al centro y el del titulo arriba
        setLayout(new BorderLayout());

        //le ponemos layout a los botones y un borde
        panelOpciones.setLayout(new java.awt.GridLayout(botones.length, 1, 0, 180/botones.length));

        ponerBordesPanelOpciones();
        
        //Esto coloca los botones de forma automatica segun el numero de opciones
        colocarBotones(opciones,color1,color2);

        //añade el panel de opciones al centro
        add(panelOpciones,java.awt.BorderLayout.CENTER);

        panelOpciones.setOpaque(false);

        //le ponemos color al fondo
        if (colorFondo == null) {
            setBackground(color2.brighter().brighter());
        } else {
            setBackground(colorFondo);
        }

        //ponemos el titulo
        if (nombreTitulo != null) {
            ponerTitulo();
        }
        
    }

    
    


    private void ponerTitulo() {
        titulo.setText(nombreTitulo);
        panelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 10, 1));
        panelTitulo.add(titulo, new java.awt.GridBagConstraints());
        panelTitulo.setOpaque(false);
        add(panelTitulo,java.awt.BorderLayout.NORTH);
    }



    private void colocarBotones(String[] opciones, Color color1, Color color2) {
        if (fuenteBotones == null && colorLetraBotones == null) {
            for (int i = 0; i < botones.length; i++) {
                botones[i]=new NBoton(opciones[i], color1, color2);
                panelOpciones.add(botones[i]);
            }
        } else{
            for (int i = 0; i < botones.length; i++) {
                botones[i] = new NBoton(opciones[i], color1, color2, fuenteBotones, colorLetraBotones);
                panelOpciones.add(botones[i]);
            }
        }
            
    }

    public void elUltimoBotonCierraLaVentana(String[] opciones) {
        //Esto es para que el boton de salir cierre la app
        botones[opciones.length-1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(PMenuV2.this);
                ventana.dispose();
            }
        });
    }

    //de aqui hacia abajo getters y setters

    public JButton[] getBotones() {
        return botones;
    }

    public JPanel getPanelOpciones() {
        return panelOpciones;
    }

    public void setPanelOpciones(JPanel panelOpciones) {
        this.panelOpciones = panelOpciones;
    }

    public JPanel getPanelTitulo() {
        return panelTitulo;
    }

    public void setPanelTitulo(JPanel panelTitulo) {
        this.panelTitulo = panelTitulo;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public String getNombreTitulo() {
        return nombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        this.nombreTitulo = nombreTitulo;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    public Font getFuenteBotones() {
        return fuenteBotones;
    }

    public void setFuenteBotones(Font fuenteBotones) {
        this.fuenteBotones = fuenteBotones;
    }

    public Color getColorLetraBotones() {
        return colorLetraBotones;
    }

    public void setColorLetraBotones(Color colorLetraBotones) {
        this.colorLetraBotones = colorLetraBotones;
    }

    private void ponerBordesPanelOpciones() {
        // Añadimos un listener para escuchar los cambios en el tamaño del panel o ventana
        panelOpciones.addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentResized(java.awt.event.ComponentEvent evt) {
            // Recalcular el borde cuando se cambia el tamaño del panel o ventana
            actualizarBorde();
        }
            // Método que recalcula el borde dinámicamente en función del tamaño del panel
        private void actualizarBorde(){
        // Obtenemos el tamaño actual del panel
        int anchoPanel = panelOpciones.getWidth();
        int altoPanel = panelOpciones.getHeight();

        // Calculamos el ancho y la altura del borde como un porcentaje del tamaño del panel
        int anchuraBorde = (int) (anchoPanel * 0.25);  // 10% del ancho del panel
        int alturaBorde = (int) (altoPanel * 0.1);  // 10% del alto del panel

        // Si el borde es demasiado pequeño, lo ajustamos a un valor mínimo
        if (anchuraBorde < 20) {
            anchuraBorde = 20;  // Valor mínimo para el borde
        }
        if (alturaBorde < 15) {
            alturaBorde = 15;  // Valor mínimo para el borde
        }



        // Establecemos el nuevo borde calculado
        panelOpciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(alturaBorde, anchuraBorde, alturaBorde, anchuraBorde));

        
        
        // Forzamos un redibujo del panel después de ajustar el borde
        panelOpciones.revalidate();
        panelOpciones.repaint();

    }
    });

    }

    // Método para leer y redimensionar la imagen
    public void ponerImagenDeFondo(String rutaImagen) {
        try {
            Image imagenBase = Metodos.MetodosGUI.leerImagen(rutaImagen);
            if (imagenBase != null) {
                imagen = imagenBase; // Guardamos la imagen sin redimensionar por ahora
                repaint();  // Redibujamos el panel para aplicar la imagen redimensionada
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

       // Método para dibujar la imagen de fondo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (imagen != null) {
            // Redimensionamos la imagen al tamaño del panel
            Image imagenRedimensionada = imagen.getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST);
            g.drawImage(imagenRedimensionada, 0, 0, this);  // Dibujamos la imagen redimensionada
        }
    }

}
