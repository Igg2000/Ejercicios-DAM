/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

public class Asignatura implements Comparable<Asignatura> {
    private static int contadorId = 1; // Variable estática para el contador de IDs
    private String id;
    private String nombre;

    public Asignatura(String nombre) {
        this.id = generarId();
        this.nombre = nombre;
    }

    // Método para generar el ID
    private String generarId() {
        return "ASG" + String.format("%02d",contadorId++); // ID con prefijo ASG seguido de un número único
    }
    
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }

    @Override
    public int compareTo(Asignatura otraAsignatura) {
        return this.id.compareTo(otraAsignatura.id);
    }
    

}
