package data;

import javax.swing.JOptionPane;

public class Humano extends Jugador {
    
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
