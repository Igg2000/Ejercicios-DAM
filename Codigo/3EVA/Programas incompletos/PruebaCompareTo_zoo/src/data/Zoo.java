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
public class Zoo {
    List<Animal> jfs = new ArrayList<>();

    public List<Animal> getJfs() {
        return jfs;
    }
    
    public void agregarJirafa(String nombre, Float altura) {
        Jirafa j;
        if (jfs.size() < 30) {
            jfs.add(new Jirafa(nombre,altura));
        } else {
            System.out.println("No se pueden agregar más jirafas, la lista ya tiene 30 elementos");
        }
    }
    
    
}
