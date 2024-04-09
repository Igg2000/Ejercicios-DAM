package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class App {
	
        private boolean esTurnoDeJug1;
        private List<Carta> baraja = new ArrayList<>();
        private Jugador j1 = new Jugador("J1");
        private Jugador j2 = new Jugador("J2");
        private final float MaximoDePuntosParaGanar= 3.5f ;
        //se puede añadir que cada jugador introduzca su nombre mas adelante

    public boolean GetEsTurnoJ1() {
        return esTurnoDeJug1;
    }
    
     public Jugador getJ() {
        if (esTurnoDeJug1==true)
         return j1;
        else
         return j2;
    }
     
    public Jugador getJ1() {
        return j1;
    }

    public Jugador getJ2() {
        return j2;
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
	
	public int decidirGanador() {
            
            // Devuelve un 1 si gana el J1, un 2 si gana el J2 y un 3 si hay empate
            
            float ptsJ1=0;
            float ptsJ2=0;
            
            int resultado=0;
            
            if(j1.sumarPuntos()*1000>MaximoDePuntosParaGanar*1000)
                ptsJ1=0;
            else
                ptsJ1=j1.sumarPuntos();
            
            if(j2.sumarPuntos()*1000>MaximoDePuntosParaGanar*1000)
                ptsJ2=0;
            else
                ptsJ2=j2.sumarPuntos();
            
                
             if (ptsJ1>ptsJ2)
                 resultado=1;
             else if (ptsJ1<ptsJ2)
                 resultado=2;
             else if (ptsJ1==ptsJ2)
                 resultado=3;
             
             /*JOptionPane.showMessageDialog(null,"el resultado es "+resultado+" los puntosfinales de j1 son "+  ptsJ1+
                                            " y los de j2 son " +ptsJ2);*/
             
             return resultado;
             
        
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
