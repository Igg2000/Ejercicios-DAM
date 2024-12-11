/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class pruebaPanel extends PanelElegirObjeto {
    
    public pruebaPanel(List<Object> objetos) {
        super(objetos);
    }

    public pruebaPanel(List<Object> objetos, String titulo) {
        super(objetos, titulo);
    }

    public pruebaPanel(List<Object> objetos, String titulo, Color colorDeFondo) {
        super(objetos, titulo, colorDeFondo);
    }

    public pruebaPanel(List<Object> objetos, String titulo, Color colorDeFondo, Color colorDeFondoLista) {
        super(objetos, titulo, colorDeFondo, colorDeFondoLista);
    }

    public pruebaPanel(List<Object> objetos, String titulo, Color colorDeFondo, Color colorDeFondoLista, Font fuenteTitulo) {
        super(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo);
    }

    public pruebaPanel(List<Object> objetos, String titulo, Color colorDeFondo, Color colorDeFondoLista, Font fuenteTitulo, Font fuenteLista, Color colorTitulo, Color colorLista) {
        super(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo, fuenteLista, colorTitulo, colorLista);
    }

    

    @Override
    public void accionConfirmar() {
        try {
            JOptionPane.showMessageDialog(this, "Has elegido: "+getObjetoSeleccionado());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @Override
    public void accionVolver() {
        JOptionPane.showMessageDialog(this, "Aqui configuraría el boton para volver");
    }
    
}
