package Servidor.Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TablaPuntuaciones {
    private List<Puntuacion> puntuaciones;

    public TablaPuntuaciones() {
        puntuaciones = new ArrayList<>();
    }

    public void agregarPuntuacion(String nombre, int puntos) {
        puntuaciones.add(new Puntuacion(nombre, puntos));
    }

    public List<Puntuacion> getMejores(int n) {
        Collections.sort(puntuaciones);
        return puntuaciones.subList(0, Math.min(n, puntuaciones.size()));
    }

    // Clase interna para manejar puntuaciones
    private static class Puntuacion implements Comparable<Puntuacion> {
        String nombre;
        int puntos;

        public Puntuacion(String nombre, int puntos) {
            this.nombre = nombre;
            this.puntos = puntos;
        }

        @Override
        public int compareTo(Puntuacion o) {
            return Integer.compare(o.puntos, this.puntos);
            // Orden descendente de puntos
        }
    }
}
