/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pintar;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author grovy
 */
public abstract class BasePintar extends JPanel {

    // Constructor
    public BasePintar() {
    }

    // Método que heredarán las clases para pintar
    protected abstract void pintar(Graphics g);

    // Sobrescribir el método paintComponent de JPanel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llamar a la superclase para pintar correctamente
        pintar(g);  // Llamar al método abstracto que las subclases implementarán
    }
}