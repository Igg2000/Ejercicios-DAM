package data;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class Jugador {
        
         private String nombre;
         private boolean plantado;
         private List<Carta> manoJugador = new LinkedList<>();

    public boolean isPlantado() {
        return plantado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPlantado(boolean seHaPlantado) {
        this.plantado = seHaPlantado;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        plantado=false;
    }

    public float sumarPuntos(){
        
        float pts=0;
        
        for (Carta c : manoJugador) {
            pts += c.getValor().getPuntos();
        }
        
        
        return pts;
    }

        
	/*public boolean quiereRobarCarta() {
            
            Object[] opciones = {"Sí", "No"};
            
            int op= JOptionPane.showOptionDialog(null, this + " Quieres robar otra carta?", "Turno de "+ this, 
               JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);
            
            if(op == JOptionPane.YES_OPTION)
                return true;
            else if (op == JOptionPane.NO_OPTION)
                return false;
            
            
            return false; //esto es una prueba, va a devolver si has querido robar carta o no
	}
        */
        

    @Override
    public String toString() {
        return "Jugador "+ nombre;
    }

    public List<Carta> getManoJugador() {
        return manoJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String verMano() {
        
        String cad="";
        
        
        for (Carta c : manoJugador) {
            cad+="\n"+c;
        }
        
        return cad;
    }

    public void robarCarta(List<Carta> baraja) {
        
        Random r = new Random();
        
        int rand = r.nextInt(baraja.size());
        
        manoJugador.add(baraja.get(rand));
        baraja.remove(rand);
        
    }
}
