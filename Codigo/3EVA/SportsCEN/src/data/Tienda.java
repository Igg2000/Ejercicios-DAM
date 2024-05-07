package data;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Tienda {

    /**
     * Default constructor
     */
    public Tienda() {
    }

    private String nombre;

    private Gerente gerenteTienda;

    private List<Dependiente> dependientesTienda = new ArrayList<>();

    private List<Ejemplar> ejemplaresTienda= new ArrayList<>();

    private List<Articulo> articulosTienda= new ArrayList<>();

    private List<Venta> ventasTienda= new ArrayList<>();

    private List<Cliente> clientesTienda= new ArrayList<>();

    
    
    // de aqui hacia abajo getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Gerente getGerenteTienda() {
        return gerenteTienda;
    }

    public void setGerenteTienda(Gerente gerenteTienda) {
        this.gerenteTienda = gerenteTienda;
    }

    public List<Dependiente> getDependientesTienda() {
        return dependientesTienda;
    }

    public void setDependientesTienda(List<Dependiente> dependientesTienda) {
        this.dependientesTienda = dependientesTienda;
    }

    public List<Ejemplar> getEjemplaresTienda() {
        return ejemplaresTienda;
    }

    public void setEjemplaresTienda(List<Ejemplar> ejemplaresTienda) {
        this.ejemplaresTienda = ejemplaresTienda;
    }

    public List<Articulo> getArticulosTienda() {
        return articulosTienda;
    }

    public void setArticulosTienda(List<Articulo> articulosTienda) {
        this.articulosTienda = articulosTienda;
    }

    public List<Venta> getVentasTienda() {
        return ventasTienda;
    }

    public void setVentasTienda(List<Venta> ventasTienda) {
        this.ventasTienda = ventasTienda;
    }

    public List<Cliente> getClientesTienda() {
        return clientesTienda;
    }

    public void setClientesTienda(List<Cliente> clientesTienda) {
        this.clientesTienda = clientesTienda;
    }

    
    
}