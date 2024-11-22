/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Nacho
 */
public class Empleado implements Serializable {
    // Atributos de la clase
    private String dni;
    private String nombre;
    private int edad;
    private double sueldo;
    private Calendar fechaAlta;

    // Constructor de la clase
    public Empleado(String dni, String nombre, int edad, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
        this.fechaAlta = GregorianCalendar.getInstance();
    }

    // Métodos getter y setter para los atributos (opcional)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Calendar getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    // Método toString para representar al empleado como un String
    @Override
    public String toString() {
        return "Empleado: " + nombre + "\n" +
               "DNI: " + dni + "\n" +
               "Edad: " + edad + " años\n" +
               "Sueldo: " + sueldo + "€\n" +
               "Fecha de alta: " + fechaAlta.getTime();
    }

    // Método para calcular la antigüedad del empleado en la empresa (en años)
    public int antiguedad() {
        Calendar hoy = Calendar.getInstance();
        int añosAntiguedad = hoy.get(Calendar.YEAR) - fechaAlta.get(Calendar.YEAR);

        // Ajustar si la fecha de alta aún no ha ocurrido este año
        if (hoy.get(Calendar.MONTH) < fechaAlta.get(Calendar.MONTH) || 
            (hoy.get(Calendar.MONTH) == fechaAlta.get(Calendar.MONTH) && hoy.get(Calendar.DAY_OF_MONTH) < fechaAlta.get(Calendar.DAY_OF_MONTH))) {
            añosAntiguedad--;
        }

        return añosAntiguedad;
    }
}