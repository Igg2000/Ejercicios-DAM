/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import ListaObjetos.PanelElegirObjeto;
import data.App;
import data.Nodo;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author grovy
 */
public class PanelCalcularElegirDestino extends PanelElegirObjeto {
     App a;
     Object ObjetoOrigen;
    
    public PanelCalcularElegirDestino(Object objetoOrigen, App a, List<Object> objetos, String titulo, Color colorDeFondo, Color colorDeFondoLista, Font fuenteTitulo, Font fuenteLista, Color colorTitulo, Color colorLista) {
        super(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo, fuenteLista, colorTitulo, colorLista);
        this.a = a;
        this.ObjetoOrigen = objetoOrigen; // Inicializar ObjetoOrigen
    }


    @Override
    public void accionConfirmar() {
        
        Object objetoSeleccionado=null;
        try {
            objetoSeleccionado=getObjetoSeleccionado();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(a.getV(), "Debes elegir una opcion de la lista");
        }
       
       
       List<Object> nodos = new ArrayList<>(a.getGrafo().getNodos());
       Nodo nodoDestino = (Nodo)objetoSeleccionado;
       Nodo nodoOrigen = (Nodo)ObjetoOrigen;
       
        String resultado = a.getGrafo().calcularDistancia(nodoOrigen, nodoDestino);
        JOptionPane.showMessageDialog(a.getV(), resultado);

    }

    @Override
    public void accionVolver() {
        a.getV().ponPanel(a.getMenuPrincipal());
    }
    
}
