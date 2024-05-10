package data;

import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class PersonalTienda {

  

    protected String nombreCompleto;

    protected String dni;

    protected int telefono;
    
    protected Usuario credenciales;
    
    
    /**
     * Default constructor
     */
    public PersonalTienda(String nombreCompleto, String dni, int telefono) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.telefono = telefono;
    }
    
    public PersonalTienda(String nombreCompleto, String dni, int telefono, Usuario u) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.telefono = telefono;
        this.credenciales = u;
    }
    
    

    public Usuario getCredenciales() {
        return credenciales;
    }

    public void setCredenciales(Usuario credenciales) {
        this.credenciales = credenciales;
    }


    public void VerMenu(List PersonalTienda) {
        // TODO implement here
    }

    public void gestionarEjemplares(List ejemplaresTienda) {
        // TODO implement here
    }

    public void gestionarClientes(List clientesTienda) {
        // TODO implement here
    }

    @Override
    public String toString() {
        return nombreCompleto + " dni=" + dni + " telefono=" + telefono;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    
    
    
}