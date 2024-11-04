/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.MetodosGUI;
import PanelesTexto.PanelPaginaDeTexto;
import Ventana.Vppal;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Representa un grafo, con una lista de nodos, los cuales tienen
 * una lista de nodos adyacentes.
 * Puede ser direccional o bidireccional según lo indique el constructor.
 * @author Nacho
 */
public class Grafo {
    private List<Nodo> nodos;
    private boolean esBidireccional;

    public Grafo(boolean esBidireccional) {
        this.nodos = new ArrayList<>();
        this.esBidireccional = esBidireccional;
    }

    // Añadir un nodo al grafo
    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo);
    }
    
    // Conectar dos nodos con una distancia, y de forma bidireccional si es necesario
    public void conectarNodos(Nodo origen, Nodo destino, double distancia) {
        
        // Verifica si destino ya es adyacente de origen y en caso contrario lo agrega
        if (!origen.yaEsAdyacente(destino)) {
            origen.agregarNodoAdyacente(destino, distancia);
        }

        // Si es bidireccional, agrega también la conexión inversa si no existe
        if (esBidireccional && !destino.yaEsAdyacente(origen)) {
            destino.agregarNodoAdyacente(origen, distancia);
        }
    }

     public String calcularDistancia(Nodo origen, Nodo destino) {
        // Mapa para almacenar las distancias más cortas desde el nodo de origen
        HashMap<Nodo, Double> distancias = new HashMap<>();
        // Mapa para rastrear los nodos anteriores en la ruta más corta
        HashMap<Nodo, Nodo> rutaPrevia = new HashMap<>();
        // Cola de prioridad para los nodos a explorar
        PriorityQueue<Nodo> cola = new PriorityQueue<>((n1, n2) -> Double.compare(distancias.get(n1), distancias.get(n2)));

        // Inicializa las distancias a infinito
        for (Nodo nodo : nodos) {
            distancias.put(nodo, Double.MAX_VALUE);
        }
        // La distancia al nodo de origen es 0
        distancias.put(origen, 0.0);
        cola.add(origen);
        rutaPrevia.put(origen, null); // No hay nodo previo para el origen

        while (!cola.isEmpty()) {
            Nodo nodoActual = cola.poll();

            // Si hemos llegado al nodo destino, construimos la ruta
            if (nodoActual.equals(destino)) {
                StringBuilder ruta = new StringBuilder();
                double distanciaTotal = distancias.get(nodoActual);

                // Reconstruir la ruta desde el destino hasta el origen
                List<Nodo> nodosRuta = new ArrayList<>();
                for (Nodo nodo = destino; nodo != null; nodo = rutaPrevia.get(nodo)) {
                    nodosRuta.add(nodo);
                }
                // Invertir la lista para que la ruta esté en el orden correcto
                Collections.reverse(nodosRuta);

                // Construir la cadena de la ruta
                for (Nodo nodo : nodosRuta) {
                    ruta.append(nodo.toString()).append(" -> ");
                }
                // Eliminar la última flecha y agregar la distancia total
                ruta.setLength(ruta.length() - 4); // Eliminar " -> "
                return ruta.append(" | Distancia total: ").append(distanciaTotal).toString();
            }

            // Recorre los nodos adyacentes
            for (NodoAdyacente adyacente : nodoActual.getAdyacentes()) {
                Nodo nodoAdyacente = adyacente.getNodo();
                double nuevaDistancia = distancias.get(nodoActual) + adyacente.getDistancia();

                // Si encontramos una distancia más corta, actualiza la distancia y agrega el nodo a la cola
                if (nuevaDistancia < distancias.get(nodoAdyacente)) {
                    distancias.put(nodoAdyacente, nuevaDistancia);
                    cola.add(nodoAdyacente);
                    rutaPrevia.put(nodoAdyacente, nodoActual); // Actualiza la ruta previa
                }
            }
        }

        // Si no se encontró una ruta, retorna un mensaje apropiado
        return "No se encontró una ruta entre " + origen + " y " + destino + ".";
    }


    /**
     * Devuelve una cadena con la que mostrar el grafo
     */
    public String convierteGrafoACadena() {
        String cad = "";
        for (Nodo nodo : nodos) {
            // Si el nodo no está conectado
            if (nodo.getAdyacentes().isEmpty()) {
                cad += (nodo + " no está conectado \n");
                if (nodo != nodos.get(nodos.size() - 1))
                    cad += "____________________________________\n";
                continue; 
            }
            // Si el nodo está conectado
            cad += ("Desde " + nodo + " sale un camino hasta: \n");
            for (NodoAdyacente ady : nodo.getAdyacentes()) {
                cad += ("  " + ady.getNodo() + " con una distancia de " + eliminaDecimalesSiElDoubleEsEntero(ady.getDistancia()));
                cad += "\n";
            }
            // Si no es el último nodo, añade un separador
            if (nodo != nodos.get(nodos.size() - 1))
                cad += "____________________________________\n";
        }
        return cad;
    }

    private String eliminaDecimalesSiElDoubleEsEntero(double distancia) {
        if (distancia % 1 == 0)
            return "" + (int) distancia;
        else
            return "" + distancia;
    }

    // Método para mostrar el grafo en consola
    void mostrarEnConsola() {
        System.out.println(convierteGrafoACadena()); 
    }

    // Método para mostrar el grafo en una ventana de texto
    void MostrarEnVentana(JFrame v, JPanel panelAnterior) {
        PanelPaginaDeTexto p = new PanelPaginaDeTexto("Representación Gráfica del Grafo", convierteGrafoACadena());
        v.setContentPane(p);
        v.revalidate();
        MetodosGUI.agregarBotonDeVolverAUnPanel(v, p, panelAnterior);
    }

    // Método para dibujar el grafo en una ventana
    void DibujarEnVentana(Vppal v, JPanel panelAnterior) {
        PintarGrafo p = new PintarGrafo(nodos, esBidireccional);
        p.setLayout(new BorderLayout());
        v.setContentPane(p);
        v.revalidate();
        MetodosGUI.agregarBotonDeVolverAUnPanel(v, p, panelAnterior);
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public boolean isEsBidireccional() {
        return esBidireccional;
    }
    
    
}
