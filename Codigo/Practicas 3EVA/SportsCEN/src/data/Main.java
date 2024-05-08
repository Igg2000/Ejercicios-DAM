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
        
        agregarDatosDePrueba(t);
        
    }

    
    
    
    private static void agregarDatosDePrueba(Tienda t) {
    
        //@Nacho
        
        //gerente
        Gerente g = new Gerente("Paco","1234567H",1234567);
        addGerenteATienda(t,g);
        
        //dependientes
        addDependienteATienda(new Dependiente("Pepe","234235423H",43256634) ,t);
        addDependienteATienda(new Dependiente("Pepa","235677853M",62253434),t);
        addDependienteATienda(new Dependiente("Carlos","25678465J",90347523),t);
        
        //articulos
        
        agregarArticulos(t);
       
 
        
        //ejemplares
        
        agregarEjemplares(t);
        
               
        
        //pruebas
        
        //System.out.println(t.getArticulosTienda());
        //System.out.println(""+t.getArticulosTienda().get(1).getEjemplaresArticulo());
    
        for (int i = 0; i < t.getArticulosTienda().size(); i++) {
            System.out.println(""+t.getArticulosTienda().get(i).getEjemplaresArticulo());
        }
        
        
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
            if (a.getIdArticulo()==idArticulo){
                if (talla!=null) //esto significaria que son zapatillas
                    a.getEjemplaresArticulo().add(new Ejemplar(color,talla,precio,a));
                else
                    a.getEjemplaresArticulo().add(new Ejemplar(color,tallaZapas,precio,a));
            }
        }
     }

    private static void addEjemplar(List<Articulo> articulosTienda, int idArticulo, Color color, Tallas talla, TallasZapatillas tallaZapas, float precio, int cantidad) {
        //@Nacho
        //este metodo es para poder crear varios ejemplares iguales
        
        for (int i = 0; i < cantidad; i++) {
             addEjemplar(articulosTienda, idArticulo, color, talla, tallaZapas, precio);
        }
        
    }

    private static void agregarArticulos(Tienda t) {
        
        //@Nacho
        
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
       
    }

    private static void agregarEjemplares(Tienda t) {

        //@Nacho
        
        //Esto es para añadir un numeros fijos de articulos o precio de cada prenda para hacer pruebas
        int nXL=5;
        int nL=4;
        int nM=5;
        int nS=3;
        int nXS=2;
        float precioID1= 17.99f;
        float precioID2= 20.99f;
        float precioID3= 14.99f;
        float precioID4= 24.99f;
        
        //Ejemplares del articulo de ID 1
        
        crearSetDeEjemplares(t,1,Color.red,XL,null,precioID1,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,1,Color.blue,XL,null,precioID1,nXL,nL,nM,nS,nXS);
        
        //Ejemplares del articulo de ID 2

        crearSetDeEjemplares(t,2,Color.white,XL,null,precioID2,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,2,Color.black,XL,null,precioID2,nXL,nL,nM,nS,nXS);
        
        //Ejemplares del articulo de ID 3

        crearSetDeEjemplares(t,3,Color.yellow,XL,null,precioID3,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,3,Color.blue,XL,null,precioID3,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,3,Color.green,XL,null,precioID3,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,3,Color.orange,XL,null,precioID3,nXL,nL,nM,nS,nXS);
        
        //Ejemplares del articulo de ID 4

        crearSetDeEjemplares(t,4,Color.white,XL,null,precioID4,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,4,Color.black,XL,null,precioID4,nXL,nL,nM,nS,nXS);

        
    }

    private static void crearSetDeEjemplares(Tienda t,int i, Color red, Tallas tallas, Object object, float precio, int nXL, int nL, int nM, int nS, int nXS) {
      
        //@Nacho
        /*
        *Como estaba repitiendo estas 5 lineas constantemente cada vez que quería cambiar el color
        *he preferido tenerlas en un metodo aparte para ahorrar tiempo y espacio
        *
        * Este metodo crea la cantidad de ejemplares que tu le mandes de cada talla
        */
        
        addEjemplar(t.getArticulosTienda(),i,Color.red,XL,null,precio,nXL);
        addEjemplar(t.getArticulosTienda(),i,Color.red,L,null,precio,nL);
        addEjemplar(t.getArticulosTienda(),i,Color.red,M,null,precio,nM);
        addEjemplar(t.getArticulosTienda(),i,Color.red,S,null,precio,nS);
        addEjemplar(t.getArticulosTienda(),i,Color.red,XS,null,precio,nXS);   
    
    }
    
}
