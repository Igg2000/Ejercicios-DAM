/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;

/**
 *
 * @author grovy
 */
public class pm extends PMenuConNBotones {

    public pm(String[] opciones, String nombreTitulo, Color color1, Color color2) {
        super(opciones, nombreTitulo, color1, color2);
        init(opciones);
    }

    private void init(String[] opciones) {
        elUltimoBotonCierraLaVentana(opciones);
    }
    
}
