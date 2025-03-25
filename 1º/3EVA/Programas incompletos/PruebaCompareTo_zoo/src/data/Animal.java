/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public abstract class Animal implements Comparable{
    protected String nombre;
    protected Float altura;

    public Animal(String nombre, Float altura) {
        this.nombre = nombre;
        this.altura = altura;
    }

    public Float getAltura() {
        return altura;
    }
    
    @Override
    public int compareTo(Object o) {
        
        return (int) (this.altura-((Animal)o).altura);
    }

    @Override
    public String toString() {
        return "Animal{" + "nombre=" + nombre + ", altura=" + altura + '}';
    }
}
