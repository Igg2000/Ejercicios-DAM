/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Temas;

import java.awt.Color;
import java.awt.Font;
/**
 * Enumerado con diferentes temas posibles para la aplicacion
 * @author Nacho
 */
public enum Temas {
    CLARO(
        new Color(240, 240, 240), // Fondo
        new Color(50, 50, 50),   // Texto
        new Color(100, 150, 200), // Botones
        new Color(150, 150, 150), // Complementario
        new Font("Segoe UI", Font.BOLD, 26),  // Fuente título
        new Font("Segoe UI", Font.PLAIN, 14), // Fuente texto
        new Font("Segoe UI", Font.BOLD, 16)   // Fuente botón
    ),
    OSCURO(
        new Color(45, 45, 45),    // Fondo
        new Color(200, 200, 200), // Texto
        new Color(70, 120, 170),  // Botones
        new Color(90, 90, 90),    // Complementario
        new Font("Segoe UI", Font.BOLD, 26),  // Fuente título
        new Font("Segoe UI", Font.PLAIN, 14), // Fuente texto
        new Font("Segoe UI", Font.BOLD, 16)   // Fuente botón
    ),
    OSCURO_CYAN(
        new Color(34, 40, 49),    // Fondo (#222831)
        new Color(238, 238, 238), // Texto (#EEEEEE)
        new Color(0, 173, 181),   // Botones (#00ADB5)
        new Color(57, 62, 70),    // Complementario (#393E46)
        new Font("Segoe UI", Font.BOLD, 26),  // Fuente título
        new Font("Segoe UI", Font.PLAIN, 14), // Fuente texto
        new Font("Segoe UI", Font.BOLD, 16)   // Fuente botón
    ),
    MENTA(
        new Color(211, 255, 223), // Fondo
        new Color(25, 85, 45),    // Texto
        new Color(51, 204, 102),  // Botones
        new Color(102, 153, 102), // Complementario
        new Font("Segoe UI", Font.BOLD, 26),  // Fuente título
        new Font("Segoe UI", Font.PLAIN, 14), // Fuente texto
        new Font("Segoe UI", Font.BOLD, 16)   // Fuente botón
    ),
    AMANECER(
        new Color(255, 244, 230), // Fondo
        new Color(102, 51, 0),    // Texto
        new Color(255, 153, 51),  // Botones
        new Color(204, 102, 0),   // Complementario
        new Font("Segoe UI", Font.BOLD, 26),  // Fuente título
        new Font("Segoe UI", Font.PLAIN, 14), // Fuente texto
        new Font("Segoe UI", Font.BOLD, 16)   // Fuente botón
    );



    // Propiedades del tema
    private final Color fondo;
    private final Color texto;
    private final Color boton;
    private final Color complementario;
    private final Font fuenteTitulo;
    private final Font fuenteTexto;
    private final Font fuenteBoton;

    Temas(Color fondo, Color texto, Color boton, Color complementario, Font fuenteTitulo, Font fuenteTexto, Font fuenteBoton) {
        this.fondo = fondo;
        this.texto = texto;
        this.boton = boton;
        this.complementario = complementario;
        this.fuenteTitulo = fuenteTitulo;
        this.fuenteTexto = fuenteTexto;
        this.fuenteBoton = fuenteBoton;
    }

    // Getters
    public Color getFondo() { return fondo; }
    public Color getTexto() { return texto; }
    public Color getBoton() { return boton; }
    public Color getComplementario() { return complementario; }
    public Font getFuenteTitulo() { return fuenteTitulo; }
    public Font getFuenteTexto() { return fuenteTexto; }
    public Font getFuenteBoton() { return fuenteBoton; }
}
