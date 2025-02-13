package Servidor.Modelo;

import Cliente.Modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores; // Ejemplo de clase Jugador en el servidor
    private boolean enEjecucion;

    public Juego() {
        jugadores = new ArrayList<>();
        enEjecucion = false;
    }

    public void iniciarJuego() {
        enEjecucion = true;
        // Lógica para iniciar la partida
    }

    public void finalizarJuego() {
        enEjecucion = false;
        // Lógica para finalizar la partida
    }

    // Otros métodos para gestionar comida, colisiones, puntuaciones...
}
