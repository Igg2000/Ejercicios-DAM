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

    public Gerente(String nombreCompleto, String dni, int telefono, Usuario u) {
        super(nombreCompleto, dni, telefono, u);
    }

  


    private int idGerente;

    private Tienda tiendaGerente;

    public void verMenu(Gerente g) {
        // TODO implement here
    }


    public void gestionarArticulos(List<Articulo> articulosTienda) {
     
        /*
        *aqui iría el menu de gestionarArticulos
        *a la hora de elegir la opcion en un switch 
        *puedes pintar la funcion en el case
        *
        *           Mucho animo
        */
        System.out.println(mostrarArticulos(articulosTienda));
        
 
    }
    
    
    private String mostrarArticulos(List<Articulo> a) {
        /*
        *Añade todos los articulos a una cadena, añadiendo un salto de linea entre ellos
        *una vez estan todos los articulos devuelve la cadena
        */
        
        String cad="";
        for (int i = 0; i < a.size(); i++) {
            cad+=a.get(i)+"\n";
        }
        
        return cad;
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