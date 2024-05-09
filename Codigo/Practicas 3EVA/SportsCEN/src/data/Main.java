/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.VentanaPrincipal;
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

    
    static boolean modoTexto = false;
    
    public static void main(String[] args) {
        
        Tienda t=new Tienda("Sports CEN");
        
        agregarDatosDePrueba(t);
        
        VentanaPrincipal v; 
        if(modoTexto==false)
            v= new VentanaPrincipal(t);
        
    }

    
    
    
    private static void agregarDatosDePrueba(Tienda t) {
    
        //@Nacho
        
        //gerente
        Gerente g = new Gerente("Paco","1234567H",1234567);
        g.setCredenciales(new Usuario("admin","admin"));
        addGerenteATienda(t,g);
        
        //dependientes
        addDependienteATienda(new Dependiente("Pepe","234235423H",43256634,new Usuario("Pepe","12345")),t);
        addDependienteATienda(new Dependiente("Pepa","235677853M",62253434,new Usuario("Pepa","12345")),t);
        addDependienteATienda(new Dependiente("Carlos","25678465J",90347523,new Usuario("Carlos","12345")),t);
        
        //articulos
        
        agregarArticulos(t);
       
 
        
        //ejemplares
        
        agregarEjemplares(t);
        
               
        //clientes
        
        addClientes(t);
        
        //pruebas
    /*    
        System.out.println(t.getGerenteTienda().getCredenciales());
    
        System.out.println(t.getArticulosTienda());
        System.out.println(""+t.getArticulosTienda().get(1).getEjemplaresArticulo());
    
        for (int i = 0; i < t.getArticulosTienda().size(); i++) {
            System.out.println(""+t.getArticulosTienda().get(i).getEjemplaresArticulo());
        }
         System.out.println(t.getClientesTienda());
    */
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
        float precioID5= 19.99f;
        float precioID6= 19.99f;
        float precioID7= 99.99f;
        float precioID8= 59.99f;
        float precioID9= 44.99f;
        float precioID10= 34.99f;
        float precioID11= 19.99f;
        float precioID12= 24.99f;
        float precioID13= 29.99f;
        float precioID14= 24.99f;
        float precioID15= 119.99f;
        float precioID16= 129.99f;
        float precioID17= 89.99f;
        
        //Ejemplares del articulo de ID 1 (Gorra,Pulga)
        
        crearSetDeEjemplares(t,1,Color.red,false,precioID1,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,1,Color.blue,false,precioID1,nXL,nL,nM,nS,nXS);
        
        //Ejemplares del articulo de ID 2 (Gorra,Kike)

        crearSetDeEjemplares(t,2,Color.white,false,precioID2,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,2,Color.black,false,precioID2,nXL,nL,nM,nS,nXS);
        
        //Ejemplares del articulo de ID 3 (Camiseta,Pulga)

        crearSetDeEjemplares(t,3,Color.yellow,false,precioID3,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,3,Color.blue,false,precioID3,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,3,Color.green,false,precioID3,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,3,Color.orange,false,precioID3,nXL,nL,nM,nS,nXS);
        
        //Ejemplares del articulo de ID 4 (Camiseta,Suprememe)

        crearSetDeEjemplares(t,4,Color.white,false,precioID4,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,4,Color.red,false,precioID4,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,4,Color.black,false,precioID4,nXL,nL,nM,nS,nXS);
        
        //Ejemplares del articulo de ID 5 (Camiseta,Adidos)

        crearSetDeEjemplares(t,5,Color.orange,false,precioID5,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,5,Color.blue,false,precioID5,nXL,nL,nM,nS,nXS);
        
        //Ejemplares del articulo de ID 6 (Camiseta,Kike)

        crearSetDeEjemplares(t,6,Color.gray,false,precioID6,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,6,Color.black,false,precioID6,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 7 (Chaqueta,Suprememe)

        crearSetDeEjemplares(t,7,Color.white,false,precioID7,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,7,Color.black,false,precioID7,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 8 (Chaqueta,Adidos)

        crearSetDeEjemplares(t,8,Color.white,false,precioID8,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,8,Color.black,false,precioID8,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 9 (Sudadera,Kike)

        crearSetDeEjemplares(t,9,Color.green,false,precioID9,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,9,Color.magenta,false,precioID9,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 10 (Sudadera,Pulga)

        crearSetDeEjemplares(t,10,Color.cyan,false,precioID10,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,10,Color.yellow,false,precioID10,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 11 (Pantalon,Pulga)

        crearSetDeEjemplares(t,11,Color.cyan,false,precioID11,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,11,Color.yellow,false,precioID11,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 12 (Pantalon,Kike)

        crearSetDeEjemplares(t,12,Color.red,false,precioID12,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,12,Color.black,false,precioID12,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 13 (Pantalon,Suprememe)

        crearSetDeEjemplares(t,13,Color.white,false,precioID13,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,13,Color.black,false,precioID13,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 14 (Pantalon,Adidos)

        crearSetDeEjemplares(t,14,Color.cyan,false,precioID14,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,14,Color.black,false,precioID14,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 15 (Zapatillas,Adidos)

        crearSetDeEjemplares(t,15,Color.white,true,precioID15,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,15,Color.black,true,precioID15,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,15,Color.cyan,true,precioID15,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 16 (Zapatillas,Kike)

        crearSetDeEjemplares(t,16,Color.white,true,precioID16,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,16,Color.red,true,precioID16,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,16,Color.yellow,true,precioID16,nXL,nL,nM,nS,nXS);

        //Ejemplares del articulo de ID 17 (Zapatillas,Pulga)

        crearSetDeEjemplares(t,17,Color.white,true,precioID17,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,17,Color.gray,true,precioID17,nXL,nL,nM,nS,nXS);
        crearSetDeEjemplares(t,17,Color.green,true,precioID17,nXL,nL,nM,nS,nXS);

        
    }

    private static void crearSetDeEjemplares(Tienda t,int i, Color c, Boolean sonZapatillas, float precio, int nXL, int nL, int nM, int nS, int nXS) {
      
        //@Nacho
        /*
        *Como estaba repitiendo estas 5 lineas constantemente cada vez que quería cambiar el color
        *he preferido tenerlas en un metodo aparte para ahorrar tiempo y espacio
        *
        * Este metodo crea la cantidad de ejemplares que tu le mandes de cada talla
        */
        if (sonZapatillas){
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_47,precio,1);
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_46,precio,2);
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_45,precio,3);
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_44,precio,5);
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_43,precio,4);
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_42,precio,3);
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_41,precio,2);
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_40,precio,2);   
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_39,precio,2);   
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_38,precio,1);   
            addEjemplar(t.getArticulosTienda(),i,c,null,EU_37,precio,1);   
        }else{
            addEjemplar(t.getArticulosTienda(),i,c,XL,null,precio,nXL);
            addEjemplar(t.getArticulosTienda(),i,c,L,null,precio,nL);
            addEjemplar(t.getArticulosTienda(),i,c,M,null,precio,nM);
            addEjemplar(t.getArticulosTienda(),i,c,S,null,precio,nS);
            addEjemplar(t.getArticulosTienda(),i,c,XS,null,precio,nXS); 
        }
    }
    
    private static void addClientes(Tienda t) {
    
        t.getClientesTienda().add(new Cliente("Antonio Vicente","tonivice@gmail.com"));
        t.getClientesTienda().add(new Cliente("Marta Lopez","mlope95@gmail.com"));
        t.getClientesTienda().add(new Cliente("Miguel Hernandez","miguelitohdz@gmail.com"));
    }
    
}
