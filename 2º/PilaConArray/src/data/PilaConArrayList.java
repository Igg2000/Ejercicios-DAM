/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class PilaConArrayList implements Pila {

    List<Integer> numeros;

    public PilaConArrayList() {
        numeros = new ArrayList();
    }
    
    
    @Override
    public void apilar(int numero) {
        numeros.add(numero);
    }

    @Override
    public void desapilar() {
        numeros.removeLast();
    }

    @Override
    public void pintar() {
        for (Integer num : numeros) {
            System.out.println(num);
        }
    }
    
}
