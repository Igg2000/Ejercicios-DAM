/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.VentanaJuego;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //al acabar hacer replace de "a" por TRESYMEDIA
        App a = new App();

        //rellenarBaraja(a.getBaraja());
        
        
        crearVentanaDeJuego(a);
        
        
        
        //Esto indica las cartas que tiene la baraja
        //System.out.println(""+a.getBaraja());
        
        
        //esto es para comprobar que funcione el barajar turno
        //System.out.println("es turno del j1? "+a.GetEsTurnoJ1());
        
        //System.out.println(""+a.getJ1().quiereRobarCarta());
        /*
        for (int i = 0; i <10; i++) {
        
            
            
        if (a.getJ().quiereRobarCarta()==true){
            a.getJ().robarCarta(a.getBaraja());
            a.setEsTurnoDeJug1(! a.GetEsTurnoJ1());
            
            //System.out.println("Las cartas que hay en la mano del jugador son: \n" + a.getJ().verMano());
            }

        }
*/        
        //Esto es para comprobar que al robar carta se elimina de una baraja y se añade a la mano del jugador
        //System.out.println("Las cartas que quedan en la baraja son: \n --------------\n"+ a.getBaraja());
        //System.out.println("Las cartas que hay en la mano del jugador son: \n" + a.getJ().verMano());
        
        
        
        
        
        
    }
/*
    private static void rellenarBaraja(List<Carta> baraja) {
    //aqui hay que hacer un for por cada valor y palo
    
        for (valor v : valor.values()) {
            
            for (palo p : palo.values()) {
                
                baraja.add(new Carta(v,p));
                
            }
        }
    
    
    }
*/

    private static void crearVentanaDeJuego(App a) {
        VentanaJuego v = new VentanaJuego(a);
        v.setVisible(true);
        v.setResizable(false);
        v.setLocationRelativeTo(null);
        v.setSize(850, 550);    
    }
}
