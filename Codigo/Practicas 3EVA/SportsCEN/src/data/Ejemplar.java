package data;

import java.awt.Color;
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Ejemplar {


    private int idEjemplar;

    private Color color;

    private static int cantidad;

    private TallasZapatillas tallaZapatillas;

    private Tallas talla;
    
    private float precio;

    private Articulo articuloReferenciado;

    /**
     * Default constructor
     */
    
    public Ejemplar(Color color, Tallas talla, float precio, Articulo articuloReferenciado) {
        //constructor Ropa
        this.color = color;
        this.talla = talla;
        this.precio = precio;
        articuloReferenciado.aumentarCantidadEjemplares();
        this.articuloReferenciado = articuloReferenciado;
    }

    public Ejemplar(Color color, TallasZapatillas tallaZapatillas, float precio, Articulo articuloReferenciado) {
        //constructor Zapatillas
        this.color = color;
        this.tallaZapatillas = tallaZapatillas;
        this.precio = precio;
        articuloReferenciado.aumentarCantidadEjemplares();
        this.articuloReferenciado = articuloReferenciado;
        
    }

    @Override
    public String toString() {
        if (articuloReferenciado.getTipoPrenda()==Prendas.Zapatillas)
            return "Ejemplar{" + "idEjemplar=" + idEjemplar + ", color=" + color + ", talla=" + tallaZapatillas + ", precio=" + precio + '}';
        else
            return "Ejemplar{" + "idEjemplar=" + idEjemplar + ", color=" + color + ", talla=" + talla + ", precio=" + precio + '}';
    }
    
    
    
    //hacia abajo getters y setters

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        Ejemplar.cantidad = cantidad;
    }

    public TallasZapatillas getTallaZapatillas() {
        return tallaZapatillas;
    }

    public void setTallaZapatillas(TallasZapatillas tallaZapatillas) {
        this.tallaZapatillas = tallaZapatillas;
    }

    public Tallas getTalla() {
        return talla;
    }

    public void setTalla(Tallas talla) {
        this.talla = talla;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Articulo getArticuloReferenciado() {
        return articuloReferenciado;
    }

    public void setArticuloReferenciado(Articulo articuloReferenciado) {
        this.articuloReferenciado = articuloReferenciado;
    }



  
        




}