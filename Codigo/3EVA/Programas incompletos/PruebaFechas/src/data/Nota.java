/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Date;

/**
 *
 * @author Nacho
 */
public class Nota {
    
    private Date fecha=new Date();
    private String nota;
    
    
    

    public Date getFecha() {
        return fecha;
    }

    public String getNota() {
        return nota;
    }

    public Nota(String nota) {
        this.nota = nota;
    }
    
}
