/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Nacho
 */
public class Panel extends JPanel{

    //constructor
    public Panel() {
    
        iniciarComponentes();
    
    }

    private void iniciarComponentes() {
        
        this.setLayout(null); //quitamos layout al panel
        this.setBackground(new Color(255,204,153)); //ponemos un fondo de un color naranje suave
        
        JLabel labelTituloGrafico2D = new JLabel(); //creamos una nueva etiqueta
        labelTituloGrafico2D.setBounds(20,20,110,30); //definimos posicion y tamaño
        labelTituloGrafico2D.setForeground(Color.white); //ponemos el color de letra en blanco
        labelTituloGrafico2D.setOpaque(true); //cambiamos la opacidad del fondo para poder ponerle color
        labelTituloGrafico2D.setBackground(Color.green.darker()); //cambiamos el color del fondo
        labelTituloGrafico2D.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20)); /*ponemos la fuente que va a tener, 
        //en este caso arial, con negrita y tamaño 20*/
        labelTituloGrafico2D.setText("Grafico 2D"); //ponemos el texto que va a tener la etiqueta
        labelTituloGrafico2D.setHorizontalAlignment(SwingConstants.CENTER); 
        //de esta forma alineamos el texto en el centro de la etiqueta
        
        Tortuga labelTortuga= new Tortuga(0.27f);
        labelTortuga.setBounds(20, 60, 100, 100); //elegimos posicion y tamaño
        
        JLabel labelTituloImagen= new JLabel("Imagen",SwingConstants.CENTER); //añadimos el texto y la alineacion directamente
        labelTituloImagen.setBounds(200, 20, 110, 30);
        labelTituloImagen.setForeground(Color.magenta.darker());
        labelTituloImagen.setOpaque(true);
        labelTituloImagen.setBackground(Color.cyan);
        labelTituloImagen.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        
        //JLabel img = new JLabel(new ImageIcon("kirby1.png"));
        JLabel labelImagen = new JLabel(); //creamos una etiqueta
        ImageIcon ImagenKirby = new ImageIcon("kirby1.png"); //creamos un icono de imagen a partir de la imagen seleccionada
        labelImagen.setBounds(150,60,200,200); //ponemos la posicion y tamaño de la etiqueta
        labelImagen.setIcon(new ImageIcon(ImagenKirby.getImage().getScaledInstance
        (labelImagen.getWidth(), labelImagen.getHeight(), Image.SCALE_SMOOTH))); 
        /*esto es para escalar la imagen, se pone el new ImageIcon o un cast
        ya que getScaledInstance funciona con Image y no con ImageIcon */
        
        
        this.add(labelTituloGrafico2D); //añadimos la etiqueta al panel
        this.add(labelTortuga);
        this.add(labelTituloImagen);
        this.add(labelImagen);
    }
    
    
    
}
