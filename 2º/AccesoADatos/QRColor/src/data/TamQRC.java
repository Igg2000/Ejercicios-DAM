/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public enum TamQRC {
    
    Pequeño(5),Mediano(10),Grande(15);
    
    int tam;

    private TamQRC(int tam) {
        this.tam = tam;
    }

    public int getTam() {
        return tam;
    }
    
}
