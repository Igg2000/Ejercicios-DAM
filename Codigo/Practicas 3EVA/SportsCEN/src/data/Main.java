/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import static data.Marcas.*;
import static data.Prendas.*;
import static data.Tallas.*;
import static data.TallasZapatillas.*;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class Main {
    
    public static void main(String[] args) {
        
        Tienda t=new Tienda("Sports CEN");
        
        añadirDatosDePrueba(t);
        
    }

    private static void añadirDatosDePrueba(Tienda t) {
    
        //@Nacho
        
        //gerente
        Gerente g = new Gerente("Paco","1234567H",1234567);
        addGerenteATienda(t,g);
        
        //dependientes
        addDependienteATienda(new Dependiente("Pepe","234235423H",43256634) ,t);
        addDependienteATienda(new Dependiente("Pepa","235677853M",62253434),t);
        addDependienteATienda(new Dependiente("Carlos","25678465J",90347523),t);
        
        //articulos
        t.getArticulosTienda().add(new Articulo(Gorra,Pulga));
        t.getArticulosTienda().add(new Articulo(Gorra,Kike));
        t.getArticulosTienda().add(new Articulo(Camiseta,Pulga));
        t.getArticulosTienda().add(new Articulo(Camiseta,Suprememe));
        t.getArticulosTienda().add(new Articulo(Camiseta,Adidos));
        t.getArticulosTienda().add(new Articulo(Camiseta,Pulga));
        t.getArticulosTienda().add(new Articulo(Camiseta,Kike));
        t.getArticulosTienda().add(new Articulo(Chaqueta,Suprememe));
        t.getArticulosTienda().add(new Articulo(Chaqueta,Adidos));
        t.getArticulosTienda().add(new Articulo(Sudadera,Kike));
        t.getArticulosTienda().add(new Articulo(Sudadera,Pulga));
        t.getArticulosTienda().add(new Articulo(Pantalon,Pulga));
        t.getArticulosTienda().add(new Articulo(Pantalon,Kike));
        t.getArticulosTienda().add(new Articulo(Pantalon,Suprememe));
        t.getArticulosTienda().add(new Articulo(Pantalon,Adidos));
        t.getArticulosTienda().add(new Articulo(Zapatillas,Adidos));
        t.getArticulosTienda().add(new Articulo(Zapatillas,Kike));
        t.getArticulosTienda().add(new Articulo(Zapatillas,Pulga));
       
 
        
        //ejemplares
        
        addEjemplar(t.getArticulosTienda(),1,Color.red,XL,null,15.5f,8);
        addEjemplar(t.getArticulosTienda(),1,Color.red,L,null,15.5f,7);
        addEjemplar(t.getArticulosTienda(),1,Color.red,M,null,15.5f,6);
        addEjemplar(t.getArticulosTienda(),1,Color.red,S,null,15.5f,3);
        addEjemplar(t.getArticulosTienda(),1,Color.red,XS,null,15.5f,1);
        
               
        
        //prueba
        System.out.println(t.getArticulosTienda());
    
    }

    private static void addGerenteATienda(Tienda t, Gerente g) {
       //@Nacho
        t.setGerenteTienda(g);
        g.setTiendaGerente(t);
    }

    private static void addDependienteATienda(Dependiente d, Tienda t) {
       //@Nacho
        t.getDependientesTienda().add(d);
        d.setTiendaDependiente(t);   
    }

    private static void addEjemplar(List<Articulo> articulosTienda, int idArticulo, Color color, Tallas talla, TallasZapatillas tallaZapas, float precio) {
       //@Nacho
       
       /*este metodo busca el articulo dentro de la lista segun la id y le agrega un ejemplar
       segun los parametros introducidos, si el articulo son zapatillas hay que poner null en talla,
       si no son zapatillas en tallazapatilla hay que pasarle un null*/
       
        for (Articulo a : articulosTienda) {
            if (a.getIdArticulo()==idArticulo)
                if (talla!=null) //esto significaria que son zapatillas
                    a.getEjemplaresArticulo().add(new Ejemplar(color,talla,precio,a));
                else
                    a.getEjemplaresArticulo().add(new Ejemplar(color,tallaZapas,precio,a));
        }
    }

    private static void addEjemplar(List<Articulo> articulosTienda, int idArticulo, Color color, Tallas talla, TallasZapatillas tallaZapas, float precio, int cantidad) {
        //@Nacho
        //este metodo es para poder crear varios ejemplares iguales
        
        for (int i = 0; i < cantidad; i++) {
             addEjemplar(articulosTienda, idArticulo, color, talla, tallaZapas, precio);
        }
        
    }
    
}
