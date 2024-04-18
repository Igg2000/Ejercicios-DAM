/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

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
        // TODO code application logic here
        
        Zoo z1 = new Zoo();
        datosPrueba(z1);
        
        System.out.println(""+z1.getJfs());
        
        //System.out.println(""+z1.getJfs().get(0).compareTo(z1.getJfs().get(1)));
        
        compararMayorAnimal(z1.getJfs());
       
        
    }

    private static void datosPrueba(Zoo z1) {
    
        z1.agregarJirafa("Eduardo", 45.57f);
        z1.agregarJirafa("Manuel", 15.25f);
        z1.agregarJirafa("Paco", 54.32f);
        z1.agregarJirafa("Pablo", 13.93f);
    }

    private static void compararMayorAnimal(List<Animal> a) {
        
        
        Animal Max = a.get(0);
        
        for (Animal i : a) {
            if(i.compareTo(Max)>0)
                Max=i;
        }
    
        System.out.println("La mayor Jirafa es: "+Max);
    }
    
}
