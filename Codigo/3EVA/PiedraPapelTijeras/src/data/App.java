package data;

import java.util.ArrayList;
import java.util.List;

public class App {
    
        private List<Ronda> rondasApp;
        private Jugador J1;
        private Jugador J2;
	private int numRondas=0;
	private int puntosJ1=0;
	private int puntosJ2=0;

    public App(Jugador J1, Jugador J2, int numRondas) {
        this.J1 = J1;
        this.J2 = J2;
        this.numRondas= numRondas;
        rondasApp= new ArrayList(numRondas);
    }

}
