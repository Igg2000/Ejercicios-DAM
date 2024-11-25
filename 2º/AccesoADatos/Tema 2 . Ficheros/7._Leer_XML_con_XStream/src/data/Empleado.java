/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
import java.util.List;

public class Empleado {
    private String id;
    private String firstName;
    private String lastName;
    private String location;

    // Constructor
    public Empleado(String id, String firstName, String lastName, String location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("Empleado [ID: %s, Nombre: %s %s, Ubicación: %s]", id, firstName, lastName, location);
    }


    
}
