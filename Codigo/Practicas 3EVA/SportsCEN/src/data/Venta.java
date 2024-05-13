package data;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Venta {
    
    private int idVenta;
    private static int contVentas=0;
    private List<Ejemplar> ejemplares;
    private Cliente clienteVenta;
     
    public Venta(List<Ejemplar> ejemplares, Cliente clienteVenta) {
        contVentas++;
        this.idVenta=contVentas;
        this.ejemplares = ejemplares;
        this.clienteVenta = clienteVenta;
    }

    @Override
    public String toString() {
        return  idVenta +". "+ " Ejemplares:" + ejemplares;
    }
    
    

}