/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import PanelesTexto.PanelPaginaDeTexto;
import Ventana.Vppal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Representa un grafo direccional, con una Lista de nodos, los cuales tienen
 * una lista de nodos adyacentes
 * @author Nacho
 */
public class Grafo {
    List<Nodo> nodos;

    public Grafo() {
        this.nodos = new ArrayList<>();
    }

    // Añadir un nodo al grafo
    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    /**
     * Devuelve una cadena con la que mostrar el grafo
     */
    public String convierteGrafoACadena() {
        String cad="";
        for (Nodo nodo : nodos) {
            //si el nodo no está conectado
            if(nodo.getAdyacentes().isEmpty()){
                cad+=(nodo + " no está conectado \n");
                if(nodo!=nodos.getLast())
                    cad+="____________________________________\n";
                break; 
            }
            //si el nodo está conectado
            cad+=("Desde "+ nodo + " sale un camino hasta: \n");
            for (NodoAdyacente ady : nodo.getAdyacentes()) {
                cad+=("  " + ady.getNodo() + " con una distancia de " + eliminaDecimalesSiElDoubleEsEntero(ady.getDistancia()));
                cad+="\n";
            }
            //si no es el ultimo pone un separador
            if(nodo!=nodos.getLast())
                cad+="____________________________________\n";
        }
        return cad;
    }

    private String eliminaDecimalesSiElDoubleEsEntero(double distancia) {
        if(distancia%1==0)
           return ""+(int) distancia;
        else
           return ""+ distancia;
        }

    void mostrarEnConsola() {
    System.out.println(convierteGrafoACadena()); 
    }

    void MostrarEnVentana(JFrame v) {
        PanelPaginaDeTexto p = new PanelPaginaDeTexto("Representacion Grafica del Grafo",convierteGrafoACadena());
        v.setContentPane(p);
        v.revalidate();
    }

    void DibujarEnVentana(Vppal v) {
        PintarGrafo p = new PintarGrafo(nodos);
        v.setContentPane(p);
        v.revalidate();
    }
}
