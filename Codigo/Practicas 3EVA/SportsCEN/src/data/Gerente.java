package data;

import java.io.*;
import java.util.*;

public class Gerente extends PersonalTienda {

    /**
     * Default constructor
     */
    public Gerente(String nombreCompleto, String dni, int telefono) {
        super(nombreCompleto, dni, telefono);
    }

  


    private int idGerente;

    private Tienda tiendaGerente;

    public void verMenu(Gerente g) {
        // TODO implement here
    }


    public void gestionarArticulos(List articulosTienda) {
 
    }

    public void gestionarDependientes(List dependientesTienda) {
       
    }

    //de aqui hacia abajo getters y setters 
    
    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public Tienda getTiendaGerente() {
        return tiendaGerente;
    }

    public void setTiendaGerente(Tienda tiendaGerente) {
        this.tiendaGerente = tiendaGerente;
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

    
    
}