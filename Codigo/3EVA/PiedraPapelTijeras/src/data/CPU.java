package data;

import java.util.Random;

public class CPU extends Jugador {
    
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
