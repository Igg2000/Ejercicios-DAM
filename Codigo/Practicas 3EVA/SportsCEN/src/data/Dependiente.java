package data;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Dependiente extends PersonalTienda {

    
    
    private int idDependiente;

    private Tienda tiendaDependiente;
    private static int numDependientes=0; //lleva la cuenta de los dependientes para generar la id

    
    public Dependiente(String nombreCompleto, String dni, int telefono) {
        super(nombreCompleto, dni, telefono);
        
        numDependientes++;
        this.idDependiente=numDependientes;

    }

    public Dependiente(String nombreCompleto, String dni, int telefono, Usuario u) {
        super(nombreCompleto, dni, telefono, u);
    
        numDependientes++;
        this.idDependiente=numDependientes;

    }



    
    
    //de aqui hacia abajo getters y setters

    public int getIdDependiente() {
        return idDependiente;
    }

    public void setIdDependiente(int idDependiente) {
        this.idDependiente = idDependiente;
    }

    public Tienda getTiendaDependiente() {
        return tiendaDependiente;
    }

    public void setTiendaDependiente(Tienda tiendaDependiente) {
        this.tiendaDependiente = tiendaDependiente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Usuario getCredenciales() {
        return credenciales;
    }

    public void setCredenciales(Usuario credenciales) {
        this.credenciales = credenciales;
    }
    
    
    

}