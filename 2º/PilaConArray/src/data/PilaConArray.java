/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 * Esta clase representa el funcionamiento de una pila haciendo uso de Arrays normales
 * @author Nacho
 */
public class PilaConArray {
    int [] numeros;
    int tam=0;

    public PilaConArray() {
        this.numeros = new int[tam];
    }
    
    /**
     * Crea un array con uno mas de tamaño, copia el contenido del anterior, añade el nuevo numero
     * y sustituye el array por el nuevo
     * @param numero numero que quieres agregar a la pila
     */
    public void agregar(int numero){
        
        int [] nuevaLista = new int[tam+1];
        
        for (int i = 0; i < tam; i++) {
            nuevaLista[i]=numeros[i];
        }
        nuevaLista[tam]=numero;
        tam++;
        this.numeros = nuevaLista;
    }
    
    /**
     * Creo un array con uno menos de tamaño que el actual, y copio en el todo el contenido menos el ultimo numero
     * despues de eso sustituyo el Array viejo por el que acabo de crear
     */
    public void borrarUltimo(){
        
        tam--;
        int [] nuevaLista = new int[tam];
        
        //de esta forma copio todos menos el ultimo
        for (int i = 0; i < tam; i++) {
            nuevaLista[i]=numeros[i];
        }
        
        this.numeros = nuevaLista;
    }
    
    public void pintar(){
        System.out.println("La pila contiene los siguientes numeros:");
        for (int i = 0; i < tam; i++) {
            System.out.println(numeros[i]);
        }
    }
    
}
