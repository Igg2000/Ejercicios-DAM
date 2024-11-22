package data;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Jaula {

    
    private List<Animal> animales;
    private int id;
    //esto es un contador para establecer un id automatico
    private static int totalJaulas=0;
    
    /**
     * Default constructor
     */
    public Jaula() {
        animales = new ArrayList();
        totalJaulas++;
        id=totalJaulas;
    }

    /**
     * Agrega un animal a la Jaula
     * @param a Animal a agregar
     */
    public void agregarAnimal(Animal a) {
        animales.add(a);
    }
    /**
     * Elimina a un animal de la Jaula
     * @param a Animal a eliminar
     */
    public void eliminarAnimal(Animal a) {
        animales.remove(a);
    }
    /**
     * Vaciar la jaula de animales
     */
    public void vaciarJaula() {
        animales.removeAll(animales);
    }

    /**
     * Devuelve una lista de los animales de esta Jaula
     */
    public String getListaDeAnimalesDeLaJaula() {
        String lista="";
        for (Animal a : animales) {
            lista+=a+"\n";
        }
        return lista;
    }

    @Override
    public String toString() {
        return "Jaula "+id+"\n--------\n"+ getListaDeAnimalesDeLaJaula()+"\n\n";
    }

    
    //getters y setters abajo
    public List<Animal> getAnimales() {
        return animales;
    }

    public int getId() {
        return id;
    }
    
    

}