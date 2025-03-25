package GUI;

import Pintar.BasePintar;
import data.Nodo;
import data.NodoAdyacente;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;

public class PintarGrafo extends BasePintar {
    private List<Nodo> nodos;
    private boolean esBidireccional;
    private final int centerX;
    private final int centerY;
    private final int radio;
    private final Color colorCirculo =Color.decode("#6EACDA");
    private final Color colorBorde =Color.decode("#03346E");
    private final Color colorTextoCirculo =Color.white;

    public PintarGrafo(List<Nodo> nodos, boolean esBidireccional) {
        this.nodos = nodos;
        this.esBidireccional = esBidireccional;
        this.centerX = 400; // Ajusta a la posición central de la pantalla
        this.centerY = 300; // Ajusta a la posición central de la pantalla
        this.radio = 250;   // Radio del círculo
        posicionarNodosEnCirculo(); // Llama al método para posicionar los nodos
    }

    private void posicionarNodosEnCirculo() {
        int numNodos = nodos.size();
        for (int i = 0; i < numNodos; i++) {
            double angulo = 2 * Math.PI * i / numNodos; // Calcula el ángulo
            int x = (int) (centerX + radio * Math.cos(angulo)); // Coordenada X
            int y = (int) (centerY + radio * Math.sin(angulo)); // Coordenada Y
            
            // Asigna la posición calculada al nodo
            nodos.get(i).setCoordenadas(new Point(x, y));
        }
    }

    @Override
    protected void pintar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Arial", Font.BOLD, 12));

        HashMap<String, String> lineasConDistancia = new HashMap<>();

        for (Nodo nodo : nodos) {
            for (NodoAdyacente adyacente : nodo.getAdyacentes()) {
                Point pAdyacente = adyacente.getNodo().getCoordenadas();
                Point p = nodo.getCoordenadas();
                
                // Crear una clave única para la conexión
                String key = String.format("%s-%s", nodo.getNombre(), adyacente.getNodo().getNombre());
                String distancia = String.format("%.1f", adyacente.getDistancia());
                lineasConDistancia.merge(key, distancia, (oldDist, newDist) -> oldDist + ", " + distancia);

                g2d.setColor(Color.BLACK);
                g2d.setStroke(new java.awt.BasicStroke(3.0f));
                g2d.drawLine(p.x, p.y, pAdyacente.x, pAdyacente.y);
            }
        }

        for (Nodo nodo : nodos) {
            String nombre = nodo.getNombre();
            FontMetrics metrics = g.getFontMetrics();
            int anchuraTexto = metrics.stringWidth(nombre);
            int alturaTexto = metrics.getHeight();
            int diametroCirculo = Math.max(anchuraTexto + 20, 30);
            Point posicion = nodo.getCoordenadas();

            g2d.setColor(colorBorde);
            g2d.fillOval(posicion.x - diametroCirculo / 2 - 5, posicion.y - diametroCirculo / 2 - 5, diametroCirculo + 10, diametroCirculo + 10);
            g2d.setColor(colorCirculo);
            g2d.fillOval(posicion.x - diametroCirculo / 2, posicion.y - diametroCirculo / 2, diametroCirculo, diametroCirculo);
            g.setColor(colorTextoCirculo);
            g.drawString(nombre, posicion.x - anchuraTexto / 2, posicion.y + alturaTexto / 4);
        }

        for (String key : lineasConDistancia.keySet()) {
            String[] nodosConectados = key.split("-");
            String distancia = lineasConDistancia.get(key);
            Nodo nodoA = buscarNodoPorNombre(nodosConectados[0]);
            Nodo nodoB = buscarNodoPorNombre(nodosConectados[1]);

            Point pA = nodoA.getCoordenadas();
            Point pB = nodoB.getCoordenadas();

            // Calcular las posiciones para el primer tercio, medio y último tercio
            int firstThirdX = (int) (pA.x + (pB.x - pA.x) / 3);
            int firstThirdY = (int) (pA.y + (pB.y - pA.y) / 3);
            int lastThirdX = (int) (pA.x + (pB.x - pA.x) * 2 / 3);
            int lastThirdY = (int) (pA.y + (pB.y - pA.y) * 2 / 3);

            g2d.setColor(Color.RED);

            if (esBidireccional) {
                // Mostrar la distancia solo en el medio
                int midX = (pA.x + pB.x) / 2;
                int midY = (pA.y + pB.y) / 2;
                g2d.drawString(distancia, midX, midY);
            } else {
                // Mostrar en el primer y último tercio para grafo no bidireccional
                g2d.drawString(String.format("%s -> %s: %s", nodoA.getNombre(), nodoB.getNombre(), distancia), firstThirdX, firstThirdY);
                g2d.drawString(String.format("%s -> %s: %s", nodoA.getNombre(), nodoB.getNombre(), distancia), lastThirdX, lastThirdY);
            }
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
