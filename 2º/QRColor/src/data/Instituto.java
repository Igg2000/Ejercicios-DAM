/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class Instituto {
    
    private String nombre;
    private List<CursoColor> ciclos = new ArrayList();

    public Instituto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void addCiclos(Color c){
        //si coincide el color y no esta en la lista lo añade
        for (CursoColor ciclo : CursoColor.values()) {
            if(ciclo.color==c){
                if(ciclos.contains(ciclo)){
                    JOptionPane.showMessageDialog(null, "Error al añadir ciclo \nEl instituto " + this.nombre +" ya tiene el ciclo de "+ciclo.name());
                    return;
                }
                ciclos.add(ciclo);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Error al añadir ciclo \nEl instituto " + this.nombre +" no tiene ningun ciclo asociado a ese color ");
    }

    public List<CursoColor> getCiclos() {
        return ciclos;
    }
    
    public String getCiclosEnCadena() {
        String cad="";
        for (CursoColor ciclo : ciclos) {
            cad+=ciclo.name()+", ";
        }
        cad=cad.substring(0, cad.length()-2);
        
        return cad;
    }

    public String getCiclosEnHTML() {
        
        String cad="<p>- ";
        
        if(ciclos.isEmpty()){
            cad+=" No hay ciclos disponibles";
            return cad;
        }
        for (CursoColor ciclo : ciclos) {
            cad+=ciclo.name()+", ";
        }
        cad=cad.substring(0, cad.length()-2);
        cad+="</p>";
        return cad;
    }
    
    
    
}
