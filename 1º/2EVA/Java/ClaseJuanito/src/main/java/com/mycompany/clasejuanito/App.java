/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clasejuanito;

/**
 *
 * @author Nacho
 */
public class App {
 
    public static void main(String[] args) {
        
      /*
        Compi compi1= new Compi();
        compi1.nombre = "Juan Castillo";
        compi1.equipoFavorito = "Real Madrid";
        compi1.esAmigo = true;
                
        Compi compi2= new Compi();
        compi2.nombre = "Paco Perez";
        compi2.equipoFavorito = "Betis";
        compi2.esAmigo = true;
        
        compi1.mostrar(compi1.nombre, compi1.equipoFavorito);
        compi2.mostrar(compi2.nombre, compi2.equipoFavorito);
        */
      
      String[] amigos;
      String[] noAmigos;
      
      Compi compi1= new Compi("Juan Castillo","Real Madrid",true);
      Compi compi2= new Compi("Paco Perez","Atletico de Madrid",true);
      Compi compi3= new Compi("Ana Sanchez","Betis",false);
      
      
    }
    
    
}
