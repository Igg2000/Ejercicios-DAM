/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package data;

import java.awt.Color;

/**
 *
 * @author Nacho
 */
public enum CursoColor {
    
    Dam(Color.red),Daw(Color.blue),Asir(Color.green),Comercio(Color.yellow);
    
    public Color color;

    private CursoColor(Color color) {
        this.color = color;
    }    
    
    
}
