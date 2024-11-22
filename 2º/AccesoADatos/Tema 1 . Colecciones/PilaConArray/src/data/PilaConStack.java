/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Nacho
 */
public class PilaConStack extends Stack implements Pila {

    @Override
    public void apilar(int numero) {
        push(new Integer(numero));
    }

    @Override
    public void desapilar() {
        pop();
    }

    @Override
    public void pintar() {
        for (int j = 0; j < elementCount; j++) {
            System.out.println(elementData[j]);    
        }
    }
    
}
