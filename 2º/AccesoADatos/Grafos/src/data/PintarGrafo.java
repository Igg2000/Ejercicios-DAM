package data;

import Pintar.BasePintar;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class PintarGrafo extends BasePintar {
    private List<Nodo> nodos;

    public PintarGrafo(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    @Override
    protected void pintar(Graphics g) {
        // Convertir Graphics a Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // Establecer la fuente en negrita
        g2d.setFont(new Font("Arial", Font.BOLD, 12)); // Cambia "Arial" por la fuente que desees

        // Dibujar las conexiones primero
        HashMap<String, String> lineasConDistancia = new HashMap<>(); // Para almacenar distancias

        for (Nodo nodo : nodos) {
            // Dibujar conexiones
            for (NodoAdyacente adyacente : nodo.getAdyacentes()) {
                Point pAdyacente = adyacente.getNodo().getCoordenadas();

                // Calcular la dirección de la línea
                Point p = nodo.getCoordenadas();
                
                // Las líneas llegan al centro del círculo
                Point finDeLinea = pAdyacente; // Punto de destino (centro del nodo adyacente)

                // Crear una clave única para la conexión
                String key = String.format("%s-%s", nodo.getNombre(), adyacente.getNodo().getNombre());

                // Almacenar las distancias en ambas direcciones
                String distancia = String.format("%.1f", adyacente.getDistancia());
                lineasConDistancia.merge(key, distancia, (oldDist, newDist) -> oldDist + ", " + distancia);

                // Dibujar la línea entre nodos
                g2d.setColor(Color.BLACK); // Color de la línea
                g2d.setStroke(new java.awt.BasicStroke(3.0f)); // Grosor de la línea
                g2d.drawLine(p.x, p.y, finDeLinea.x, finDeLinea.y); // Línea entre nodos
            }
        }

        // Luego dibujar los nodos
        for (Nodo nodo : nodos) {
            // Obtener el nombre y calcular el tamaño del texto
            String nombre = nodo.getNombre();
            FontMetrics metrics = g.getFontMetrics();
            int anchuraTexto = metrics.stringWidth(nombre);
            int alturaTexto = metrics.getHeight();

            // Establecer el tamaño del círculo basado en el ancho del texto
            int diametroCirculo = Math.max(anchuraTexto + 20, 30); // 20 de padding, mínimo 30

            // Determinar la posición del nodo
            Point posicion = nodo.getCoordenadas();

            // Dibujar círculo de borde
            g.setColor(Color.GRAY); // Color del borde
            g.fillOval(posicion.x - diametroCirculo / 2 - 5, posicion.y - diametroCirculo / 2 - 5, diametroCirculo + 10, diametroCirculo + 10);

            // Dibujar círculo para cada nodo
            g.setColor(Color.BLUE);
            g.fillOval(posicion.x - diametroCirculo / 2, posicion.y - diametroCirculo / 2, diametroCirculo, diametroCirculo);

            // Dibujar el texto del nodo
            g.setColor(Color.WHITE);
            g.drawString(nombre, posicion.x - anchuraTexto / 2, posicion.y + alturaTexto / 4); // Centrar el texto
        }

        // Dibujar las distancias en el primer tercio de la línea
        for (String key : lineasConDistancia.keySet()) {
            String[] nodosConectados = key.split("-");
            String distancia = lineasConDistancia.get(key);
            // Determinar la posición en el primer tercio de la línea
            Nodo nodoA = buscarNodoPorNombre(nodosConectados[0]);
            Nodo nodoB = buscarNodoPorNombre(nodosConectados[1]);

            Point pA = nodoA.getCoordenadas();
            Point pB = nodoB.getCoordenadas();
            int firstThirdX = (int) (pA.x + (pB.x - pA.x) / 3); // Primer tercio en X
            int firstThirdY = (int) (pA.y + (pB.y - pA.y) / 3); // Primer tercio en Y

            // Dibujar el texto de la distancia en la posición del primer tercio
            g2d.setColor(Color.RED);
            g2d.drawString(String.format("%s -> %s: %s", nodoA.getNombre(), nodoB.getNombre(), distancia), firstThirdX, firstThirdY);
        }
    }

    private Nodo buscarNodoPorNombre(String nombre) {
        for (Nodo nodo : nodos) {
            if (nodo.getNombre().equals(nombre)) {
                return nodo;
            }
        }
        return null; // Nodo no encontrado
    }
}
