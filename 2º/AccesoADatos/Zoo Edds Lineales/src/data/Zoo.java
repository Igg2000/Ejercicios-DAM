package data;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Zoo {

    private List<Jaula> jaulas;

    public Zoo() {
        
        jaulas = new ArrayList();
    
    }
    
    
    /**
     * Comprueba si existe una Jaula que tenga animales de la misma raza que el
     * que quieres añadir, si lo encuentra lo mete en la misma Jaula, si no crea
     * una nueva Jaula y mete al animal dentro
     * @param a Animal que quieres agregar
     */
    public void agregarAnimal(Animal a) {
        
        for (Jaula jaula : jaulas) {
            String tipoAnimal = jaula.getAnimales().getFirst().getClass().getName();
            //si hay algun animal en alguna jaula que sea de la misma raza lo mete en la misma jaula
            if(tipoAnimal.equals(a.getClass().getName())){
                jaula.agregarAnimal(a);
                return;
            }
        }
        
        //si no ha encontrado ninguna jaula con la misma raza crea una nueva jaula y lo mete
        Jaula nuevaJaula=new Jaula();
        nuevaJaula.agregarAnimal(a);
        jaulas.add(nuevaJaula);
    }

    /**
     * Busca por todas las jaulas y si encuentra al animal lo elimina
     * @param a 
     */
    public void eliminarAnimal(Animal a) {
        for (Jaula jaula : jaulas) {
            for (Animal anim : jaula.getAnimales()) {
                if(anim.equals(a))
                    jaula.eliminarAnimal(anim);
            }
        }
    }

    public String getAnimalesDelZoo() {
        String cad="";
        for (Jaula jaula : jaulas) {
            cad+=jaula.getListaDeAnimalesDeLaJaula();
        }
        return cad;
    }

    public String getJaulasComoCadena() {
        String cad="";
        for (Jaula jaula : jaulas) {
            cad+=jaula;
        }
        return cad;
    }

    //getter y setters debajo
    public List<Jaula> getJaulas() {
        return jaulas;
    }

    
}