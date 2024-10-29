/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

public class Alumno implements Comparable<Alumno> {
    
    private static int contadorMatricula = 1;  // Variable estática para llevar el contador de matrículas
    private String nombre;
    private String matricula;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.matricula = generarMatricula();
    }

    // Método para generar el número de matrícula automáticamente
    private String generarMatricula() {
        return "A" + String.format("%03d", contadorMatricula++);  // Formato A001, A002, etc.
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Alumno otroAlumno) {
        return this.matricula.compareTo(otroAlumno.matricula);
    }
    
    @Override
    public String toString() {
        return nombre + " (" + matricula + ")";
    }

}
