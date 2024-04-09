package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
	
        private boolean esTurnoDeJug1;
        private List<Carta> baraja = new ArrayList<>();
        private Jugador J1 = new Jugador("J1");
        private Jugador J2 = new Jugador("J2");
        //se puede añadir que cada jugador introduzca su nombre mas adelante

    public boolean GetEsTurnoJ1() {
        return esTurnoDeJug1;
    }
    
     public Jugador getJ() {
        if (esTurnoDeJug1==true)
         return J1;
        else
         return J2;
    }
     
    public Jugador getJ1() {
        return J1;
    }

    public Jugador getJ2() {
        return J2;
    }

    public void setEsTurnoDeJug1(boolean esTurnoDeJug1) {
        this.esTurnoDeJug1 = esTurnoDeJug1;
    }

        

    public List<Carta> getBaraja() {
        return baraja;
    }
        
        //Esto baraja quien empieza y obliga a robar la primera carta
	public boolean empezarJuego() {
            Random r= new Random();
            
            boolean empiezaJ1= false;
            
            if (r.nextInt(2)==0)
                    empiezaJ1=true;
            
            
            //falta obligar a robar carta
            
            return empiezaJ1;
	}
	
	public boolean cambiarTurno(boolean turno) {
            
            turno = !turno;
            
            return turno;
	}
	
	public void decidirGanador() {
	}
        
        public void rellenarBaraja() {
        //aqui hay que hacer un for por cada valor y palo
    
        for (valor v : valor.values()) {
            
            for (palo p : palo.values()) {
                
                baraja.add(new Carta(v,p));
                
            }
        }
    
    
    }
}
