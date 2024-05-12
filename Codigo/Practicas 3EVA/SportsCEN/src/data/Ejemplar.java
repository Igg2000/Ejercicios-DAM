package data;

import java.awt.Color;
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Ejemplar {

    //esto es para tener otro tipo de id respecto a la tienda, y no respecto al articulo
    private int idGlobalEjemplar;
    static private int contIdGlobal=1;
    
    //este id es respecto al articulo
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
        //@Nacho

        //constructor Ropa
        this.color = color;
        this.talla = talla;
        this.precio = precio;
        articuloReferenciado.aumentarCantidadEjemplares();
        this.articuloReferenciado = articuloReferenciado;
        idEjemplar= articuloReferenciado.getCantidadEjemplares();
        
        this.idGlobalEjemplar= contIdGlobal;
        contIdGlobal++;
    }

    public Ejemplar(Color color, TallasZapatillas tallaZapatillas, float precio, Articulo articuloReferenciado) {
       //@Nacho
        
        //constructor Zapatillas
        this.color = color;
        this.tallaZapatillas = tallaZapatillas;
        this.precio = precio;
        articuloReferenciado.aumentarCantidadEjemplares();
        this.articuloReferenciado = articuloReferenciado;
        idEjemplar= articuloReferenciado.getCantidadEjemplares();
        
        
        this.idGlobalEjemplar= contIdGlobal;
        contIdGlobal++;
    }

    @Override
    public String toString() {
        //@Nacho
        
        String cadColor="";
        if (obtenerNombreColor()!=null)
            cadColor=obtenerNombreColor();
        else
            cadColor=color.toString();
        
        
        if (articuloReferenciado.getTipoPrenda()==Prendas.Zapatillas)
            return idEjemplar+". "+" Id." + idGlobalEjemplar+ " "+ articuloReferenciado.getModelo() + " color=" + cadColor + " talla=" + tallaZapatillas + ", precio=" + precio;
        else
            return idEjemplar+". "+" Id." + idGlobalEjemplar+ " "+ articuloReferenciado.getModelo() +" color=" + cadColor + " talla=" + talla + ", precio=" + precio;
    }

    private String obtenerNombreColor() {
        //@Nacho
        //es la unica forma que se me ha ocurrido de sacar el nombre del color
        //si tiene un color predefinido en la clase Color devuelve una String con su nombre en español

        if (color.equals(Color.RED)) {
            return "Rojo";
        } else if (color.equals(Color.BLUE)) {
            return "Azul";
        } else if (color.equals(Color.GREEN)) {
            return "Verde";
        } else if (color.equals(Color.WHITE)) {
            return "Blanco";
        } else if (color.equals(Color.BLACK)) {
            return "Negro";
        } else if (color.equals(Color.GRAY)) {
            return "Gris";
        } else if (color.equals(Color.ORANGE)) {
            return "Naranja";
        } else if (color.equals(Color.YELLOW)) {
            return "Amarillo";
        }else if (color.equals(Color.MAGENTA)) {
            return "Morado";
        }else if (color.equals(Color.CYAN)) {
            return "Azul Celeste";
        }else if (color.equals(Color.PINK)) {
            return "Rosa";
        }
        // En caso de no poder, devuelvo null
        else {
            return null;
        }
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

    public int getIdGlobalEjemplar() {
        return idGlobalEjemplar;
    }

    public static int getContIdGlobalEjemplares() {
        return contIdGlobal;
    }



  
        




}