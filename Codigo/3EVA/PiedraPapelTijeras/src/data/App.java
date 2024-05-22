package data;

import javax.swing.JOptionPane;


/**
 * Esta clase guarda los siguientes datos de la partida: <br>
 * 2 Jugadores <br>
 * numero de rondas <br>
 * puntos de cada jugador<br>
 * @author Nacho y Jesus
 */
public class App {

        private Jugador J1;
        private Jugador J2;
	private int numRondas=0;
	private int puntosJ1=0;
	private int puntosJ2=0;

        /**
         * 
         * @param J1 es el primer jugador de la partida, y es el que elige primero
         * @param J2 es el segundo jugador de la partida y por lo tanto elige despues
         * @param numRondas es el numero de rondas que va a tener la partida
         */
    public App(Jugador J1, Jugador J2, int numRondas) {
        this.J1 = J1;
        this.J2 = J2;
        this.numRondas= numRondas;
    }

        /**
       * Es el método que inicia el juego. Le pide a cada jugador elegir una opción entre:
       * <ul>
       *   <li>Piedra</li>
       *   <li>Papel</li>
       *   <li>Tijera</li>
       * </ul>
       * También comprueba quién es el ganador, lo muestra por pantalla, y repite todo esto durante<br>
       * el número de rondas que reciba la aplicación. Una vez terminado, muestra quién es el ganador<br>
       * y enseña los puntos de los jugadores.
       */
    public void iniciarJuego(){
            
        // si el tamaño del array es menor o igual al numero de rondas se crea una nueva ronda
        //despues de eso, se busca la ultima ronda añadida y se ejecuta su metodo jugar
        Mano manoJ1= null;
        Mano manoJ2= null;
        //victorias j1
        int victoriasJ1=0;
        int victoriasJ2=0;
        
        for (int i = 1; i <= numRondas; i++){
            
            JOptionPane.showMessageDialog(null, "Inicio de la ronda "+i );
            //aqui eligen la mano que van a sacar
            manoJ1 = J1.elegirMano();
            manoJ2 = J2.elegirMano();    
            
            //aqui se decide mediante un byte 1,2 o 3 quien ha ganado
            byte g=decidirGanador(manoJ1,manoJ2);
            
            String cad="";
            switch (g){
                case 1: cad= ("El ganador es "+ J1.getNombre()); victoriasJ1++; break;
                case 2: cad= ("El ganador es "+ J2.getNombre()); victoriasJ2++; break;
                case 3: cad= ("Hay empate");break;
                
            }
            
            JOptionPane.showMessageDialog(null, J1.getNombre()+" ha sacado " + manoJ1.name()
            +" y " + J2.getNombre()+ " ha sacado "+ manoJ2.name()+"\n"+cad);  
            
            }
            JOptionPane.showMessageDialog(null, "La partida ha acabado \n" + J1.getNombre() + " ha ganado "+ victoriasJ1+
            " veces \n"+ J2.getNombre() + " ha ganado "+ victoriasJ2+" veces");
        }
    
    /**
    * Decide quien es el ganador de cada ronda en base a que ha sacado cada jugador
    * @param manoJ1 Es un enumerado, que contiene la eleccion del jugador1
    * @param manoJ2 Es un enumerado, que contiene la eleccion del jugador2
    * @return Devuelve en forma de byte quien es el ganador, las posibles opciones son: 
    * <ul>
    *   <li>1 - Gana el Jugador 1</li>
    *   <li>2 - Gana el Jugador 2</li>
    *   <li>3 - Empate</li>
    * </ul>
    */
    public byte decidirGanador(Mano manoJ1, Mano manoJ2) {
    
        byte Resultado=0;
        
        /*
        *Devuelve un numero segun quien gana
        * 1 - gana jugador 1
        * 2 - gana jugador 2
        * 3 - empate
        */
        
        switch(manoJ1){
            case Piedra: 
                switch(manoJ2){
                    case Piedra: Resultado=3; break;
                    case Tijeras: Resultado=1;break;
                    case Papel: Resultado=2;break;
                }
                
                break;
            case Tijeras: 
                
                switch(manoJ2){
                    case Piedra: Resultado=2; break;
                    case Tijeras: Resultado=3; break;
                    case Papel: Resultado=1; break;
                }
                break;
            case Papel:
                
                switch(manoJ2){
                    case Piedra: Resultado=1; break;
                    case Tijeras: Resultado=2; break;
                    case Papel: Resultado=3; break;
                }
                break;
            
        }
        
        return Resultado;
    }
    
    //getters y setters
 

    public Jugador getJ1() {
        return J1;
    }

    public void setJ1(Jugador J1) {
        this.J1 = J1;
    }

    public Jugador getJ2() {
        return J2;
    }

    public void setJ2(Jugador J2) {
        this.J2 = J2;
    }

    public int getNumRondas() {
        return numRondas;
    }

    public void setNumRondas(int numRondas) {
        this.numRondas = numRondas;
    }

    public int getPuntosJ1() {
        return puntosJ1;
    }

    public void setPuntosJ1(int puntosJ1) {
        this.puntosJ1 = puntosJ1;
    }

    public int getPuntosJ2() {
        return puntosJ2;
    }

    public void setPuntosJ2(int puntosJ2) {
        this.puntosJ2 = puntosJ2;
    }

}

