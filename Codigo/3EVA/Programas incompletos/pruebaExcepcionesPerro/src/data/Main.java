/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.util.ArrayList;
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
        
        List<Perro> perros = new ArrayList<>();
        
        try{
        crearPerro(perros, 9);
        }catch (EdadPerroException e){
            System.out.println(""+e.getMessage());
        }
        
    }

    private static void crearPerro(List<Perro> perros, int edad) throws EdadPerroException {
        
        
        if (edad>90)
            throw new EdadPerroException("El perro tiene mas de 90 años");
        perros.add(new Perro(edad));
        
        String cad=perros.getLast().toString();
        
        System.out.println("Se ha creado el perro: "+cad);
        
        
    }
    
    
}
