package data;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Articulo {


    private int idArticulo;
    private static int cont=1; //lleva la cuenta de los articulos para generar la id

    private Prendas tipoPrenda;
    
    private Marcas marca;
    
    private String modelo;
    
    private List<Ejemplar> ejemplaresArticulo= new ArrayList<>();

    private int cantidadEjemplares=0;

    /**
     * Default constructor
     */
    
    public Articulo(Prendas tipoPrenda, Marcas marca) {
        //@Nacho
        
        this.idArticulo = this.cont;
        cont++;
        this.tipoPrenda = tipoPrenda;
        this.marca = marca;
        
        //si no seleccionas un modelo, se le asignará un nombre basico
        if (tipoPrenda==Prendas.Pantalon)
            this.modelo = tipoPrenda+" basico de " + marca;
        else if (tipoPrenda==Prendas.Zapatillas)
            this.modelo = tipoPrenda+" basicas de " + marca;
        else
            this.modelo = tipoPrenda+" basica de " + marca;
    }

    public Articulo(Prendas tipoPrenda, Marcas marca, String modelo) {
        //@Nacho
        
        this.idArticulo = this.cont;
        cont++;
        this.tipoPrenda = tipoPrenda;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public void aumentarCantidadEjemplares(){
        //@Nacho
        this.cantidadEjemplares++;
    }
    
    
    public void disminuirCantidadEjemplares(){
        //@Nacho
        this.cantidadEjemplares--;
    }
    
    //toString
    @Override
    public String toString() {
        return "ID." + idArticulo +" "+ modelo + " stock:" + cantidadEjemplares;
    }

    //aqui abajo getters y setters
    
    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Articulo.cont = cont;
    }

    public Prendas getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(Prendas tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public List<Ejemplar> getEjemplaresArticulo() {
        return ejemplaresArticulo;
    }

    public void setEjemplaresArticulo(List<Ejemplar> ejemplaresArticulo) {
        this.ejemplaresArticulo = ejemplaresArticulo;
    }
    



}