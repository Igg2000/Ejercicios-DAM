package data;

import java.io.*;
import java.util.*;

public class Cliente {
    private int idCliente;
    static private int numClientes=0;

    private String nombreCompleto;

    private String correo;

    private List<Venta> ventasCliente;

    
    /**
     * Default constructor
     */
    
    
    public Cliente(String nombreCompleto, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        
        numClientes++;
        this.idCliente=numClientes;
    }

    public void comprar(Venta v) {
        // TODO implement here
    }

    public void disminuirStock(List ejemplaresTienda) {
        // TODO implement here
    }

    @Override
    public String toString() {
        return "\nCliente N." + idCliente + " Nombre: " + nombreCompleto + " Correo: " + correo;
    }
    
    

    //de aqui hacia abajo getters y setters
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public static int getNumClientes() {
        return numClientes;
    }

    public static void setNumClientes(int numClientes) {
        Cliente.numClientes = numClientes;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Venta> getVentasCliente() {
        return ventasCliente;
    }

    public void setVentasCliente(List<Venta> ventasCliente) {
        this.ventasCliente = ventasCliente;
    }

    
}