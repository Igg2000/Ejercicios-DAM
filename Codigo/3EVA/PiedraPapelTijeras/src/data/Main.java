
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;


/**
 * Esta es la clase principal del programa
 * @author Nacho y Jesus
 */
public class Main {

    /**
     * Este es el metodo que se ejecuta al inicio de la aplicacion,
     * se encarga de iniciar una partida a 3 rondas de un Humano llamado Javi
     * contra una CPU llamado Bot
     * @param args Son los argumentos que recibe el Main
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        App a = new App(new Humano("Javi"),new CPU("Bot"),3);
 
        
        a.iniciarJuego();
        
    }
    
}
