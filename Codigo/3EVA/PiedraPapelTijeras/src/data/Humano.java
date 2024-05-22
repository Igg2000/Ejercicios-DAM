package data;

import javax.swing.JOptionPane;
/**
 * Es una clase que hereda de Jugador, representa a un usuario que quiere jugar una partida interactuando con la aplicacion
 * @author Nacho y Jesus
 */
public class Humano extends Jugador {
    
    /**
    * Le pide al usuario mediante un JOptionPane con opciones que elija que Mano va a sacar
    * @return devuelve la mano del usuario en forma de enumerado, puede ser:
    * <ul>
    *   <li>Piedra</li>
    *   <li>Papel</li>
    *   <li>Tijera</li>
    * </ul>
    */
        @Override
	public Mano elegirMano() {
            
            String []ops={"Piedra","Papel","Tijera"};
            int op=JOptionPane.showOptionDialog(null, this.getNombre()+" Elige una opcion",
                                                "Elige una opcion", 0, 0, null, ops, this);
            
            
                        
            Mano manoEnviada = null;
            switch(op){
                case 0: manoEnviada=Mano.Papel; break;
                case 1: manoEnviada=Mano.Piedra; break;
                case 2: manoEnviada=Mano.Tijeras; break;
                case -1: elegirMano(); break; //en caso de que alguien cierre la ventana, te la vuelve a abrir
            }
            return manoEnviada;
	}

    public Humano(String nombre) {
        super.setNombre(nombre);
    }

    
}
