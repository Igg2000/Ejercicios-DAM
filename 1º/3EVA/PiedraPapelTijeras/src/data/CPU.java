package data;

import java.util.Random;
/**
 * Es una clase que hereda de Jugador y representa un jugador controlado por la aplicacion
 * @author Nacho y Jesus
 */
public class CPU extends Jugador {
    
    /**
    * Genera de forma aleatoria un numero del 1 al 3 y segun la opcion elegida selecciona una de las posibles jugadas
    * @return devuelve la mano del usuario en forma de enumerado, puede ser:
    * <ul>
    *   <li>Piedra</li>
    *   <li>Papel</li>
    *   <li>Tijera</li>
    * </ul>
    */
        @Override
	public Mano elegirMano() {
	    
            /*genero un numero del 1 al 3, en funcion del numero envio un mano distina
            * 1- papel
            * 2- piedra
            * 3- tijeras
            */
            
            Random r = new Random();
            int rand=r.nextInt(1, 4);
            
            Mano manoEnviada = null;
            switch(rand){
                case 1: manoEnviada=Mano.Papel; break;
                case 2: manoEnviada=Mano.Piedra; break;
                case 3: manoEnviada=Mano.Tijeras; break;
            }
            
            return manoEnviada;
	}

    public CPU(String nombre) {
        super.setNombre(nombre);
    }
        
        
}
