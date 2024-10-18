package Menus;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;

/**
 * Son botones personalizados que pueden ser de un solo color o degradados, para cambiar cualquiera de sus
 * atributos tiene setters que empiezan por "cambiar" y sus getters por "obtener"
 * @author Nacho
 */
public class NBoton extends JButton{

    private Color color1;
    private Color color2;
    private Font fuente;
    private Color colorTexto;
    
    /**
     * Crea un boton con el texto especificado y el fondo blanco
     * @param text Es el texto que va a tener el boton
     */
    public NBoton(String text) {
        this(text,Color.white);
    }
    /**
     * Crea un boton con el texto y color de fondo especificados
     * @param text Es el texto que va a tener el boton
     * @param color Es el color de fondo del boton
     */
    public NBoton(String text, Color color) {
        this(text,color,color);
    }
    /**
     * Se crea un boton con un degradado de color y el texto especifico
     * @param text Es el texto que va a tener el boton
     * @param color1 Es el color que va a tener en las esquinas
     * @param color2 Es el color del centro
     */
    public NBoton(String text, Color color1, Color color2) {
        this(text,color1,color2,null);
    }

    /**
     * Se crea un boton con un degradado de color y un texto del cual se elegirá su fuente
     * @param text Es el texto que va a tener el boton
     * @param color1 Es el color que va a tener en las esquinas
     * @param color2 Es el color del centro
     * @param fuente Es la fuente que va a tener el texto
     */
    public NBoton(String text, Color color1, Color color2, Font fuente) {
        this(text,color1,color2,null,Color.black);
    }
    /**
     * Se crea un boton con un degradado de color y un texto del cual se elegirá su fuente y su color
     * @param text Es el texto que va a tener el boton
     * @param color1 Es el color que va a tener en las esquinas
     * @param color2 Es el color del centro
     * @param fuente Es la fuente que va a tener el texto
     * @param colorTexto Es el color que tendrá el texto
     */
    public NBoton(String text, Color color1, Color color2, Font fuente, Color colorTexto) {
        super(text);
        this.color1 = color1;
        this.color2 = color2;
        this.fuente = fuente;
        this.colorTexto = colorTexto;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Elimina el borde del botón para personalizar completamente su apariencia
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        super.paintComponent(g);
        
        // Configuración del objeto Graphics2D
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font fuentePorDefecto= g2d.getFont();
        
        if (fuente==null)
            fuente=fuentePorDefecto;
        g2d.setFont(fuente);
        
        // Configuración de los colores
        
        Color colorDegradado1=color1;
        Color colorDegradado2=color2;
        
        
        if (getModel().isPressed()) {
            colorDegradado1=color1.darker().darker();
            colorDegradado2=color2.darker().darker();
        } else if (getModel().isRollover()) {
            colorDegradado1=color1.darker();
            colorDegradado2=color2.darker();
        }
        
        GradientPaint gradient = new GradientPaint(0, 0, colorDegradado1, getWidth()/2, getHeight()/2, colorDegradado2,true);
        g2d.setPaint(gradient);
        //Esto pinta el fondo
        
        g2d.fillRoundRect(1, 1, getWidth()-2, getHeight()-2, 20, 20);

        // Dibujar el borde del botón
        g2d.setColor(Color.BLACK);
        g2d.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

        // Configuración del texto
        FontMetrics fm = g2d.getFontMetrics();
        Rectangle rect = new Rectangle(0, 0, getWidth(), getHeight());

        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();

        int x = (rect.width - textWidth) / 2;
        int y = (rect.height - textHeight) / 2 + fm.getAscent();

        // Dibujar el texto
        g2d.setColor(colorTexto);
        g2d.drawString(getText(), x, y);

        // Liberar recursos gráficos
        g2d.dispose();
        
        repaint();
        revalidate();
    }

    public void cambiarColor1(Color color1) {
        this.color1 = color1;
    }

    public void cambiarColor2(Color color2) {
        this.color2 = color2;
    }

    public void cambiarFuente(Font fuente) {
        this.fuente = fuente;
    }

    public void cambiarColorTexto(Color colorTexto) {
        this.colorTexto = colorTexto;
    }

    public Color obtenerColor1() {
        return color1;
    }

    public Color obtenerColor2() {
        return color2;
    }

    public Font obtenerFuente() {
        return fuente;
    }

    public Color obtenerColorTexto() {
        return colorTexto;
    }
    
}
