package data;

import Apoyo.Menu;
import Apoyo.Opcion;
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
        //@Elsa
        Opcion[] opciones={
            new Opcion('1',"Agregar articulo"),
            new Opcion('2',"Eliminar articulo"),
            new Opcion('3',"Mostrar articulo")
        };
        Menu menuarticulos= new Menu("gestion de articulos",opciones);
        menuarticulos.pintaPorConsola();
        Scanner scanner =new Scanner(System.in);
     int opcion=scanner.nextInt();
        System.out.println(""+opcion);
     switch(opcion){
         case 1:
                addArticulos(articulosTienda);
                break;
            case 2:
               eliminarArticulosModoTexto(articulosTienda);
                break;
            case 3:
                
                System.out.println(mostrarArticulos(articulosTienda));
                break;}
     
    }
    
     public  void addArticulos(List<Articulo> articulosTienda) {
         //@Elsa
         System.out.println("Introduzca el tipo de prenda");
         Scanner scanner =new Scanner(System.in);
         for(Prendas prenda : Prendas.values()){
             System.out.println(prenda.name());}
         String tipoPrenda=scanner.nextLine();
         
         System.out.println("Introduzca la marca de la prenda");
         for(Marcas marca : Marcas.values()){
             System.out.println(marca.name());}
         String nombreMarca=scanner.nextLine();
         
        Articulo articulo = new Articulo(Prendas.valueOf(tipoPrenda), Marcas.valueOf(nombreMarca));
        articulosTienda.add(articulo);
        System.out.println(mostrarArticulos(articulosTienda));
     }
     public void eliminarArticulosModoTexto(List<Articulo> articulosTienda) {
        System.out.println(mostrarArticulos(articulosTienda));
        System.out.println("Introduzca el ID del artículo que desea eliminar");
        Scanner scanner=new Scanner(System.in);
        int id_eliminar=scanner.nextInt();
        
        eliminarArticulo(articulosTienda,id_eliminar);
        System.out.println(mostrarArticulos(articulosTienda));
    }
     private void eliminarArticulo(List<Articulo> articulosTienda, int id_eliminar) {
            for (int i = 0; i < articulosTienda.size(); i++) {
                if(id_eliminar== articulosTienda.get(i).getIdArticulo()){
                articulosTienda.remove(i);
                }
            }
}

    public String mostrarArticulos(List<Articulo> a) {
        //@Elsa
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

    public void gestionarDependientes(List<Dependiente> dependientesTienda) {
        //@Elsa
        Opcion[] opcionesd={
            new Opcion('1',"Agregar dependiente"),
            new Opcion('2',"Eliminar dependiente"),
            new Opcion('3',"Mostrar dependientes")
        };
        Menu menudependientes= new Menu("Gestiona dependientes",opcionesd);
        menudependientes.pintaPorConsola();
        
     Scanner scannerb =new Scanner(System.in);
     int opciond=scannerb.nextInt();
       
     switch(opciond){
         case 1:
                addDependientesModoTexto(dependientesTienda);
                break;
        case 2:
                eliminarDependienteModoTexto(dependientesTienda);
                break;
        case 3:
                
                System.out.println(mostrarDependientes(dependientesTienda));
                break;}
    }
    
     public void addDependientesModoTexto(List dependientesTienda) {
         //@Elsa
         System.out.println("Introduzca el nombre completo del nuevo empleado");
         Scanner scanner =new Scanner(System.in);
         String NomComp_dependiente=scanner.nextLine();
         
         System.out.println("Introduzca el DNI del empleado");
         String dni_dependiente=scanner.nextLine();
         
         System.out.println("Introduzca el telefono del empleado");
         int tel_dependiente=scanner.nextInt();
         
         agregarDependienteATienda(dependientesTienda,NomComp_dependiente,dni_dependiente,tel_dependiente,null);

        System.out.println(mostrarDependientes(dependientesTienda));
         }
     
     
    public void agregarDependienteATienda(List dependientesTienda, String NomComp_dependiente, String dni_dependiente, int tel_dependiente, Usuario usuario_dependiente) {
        //@Elsa
        Dependiente dep ;
        if (usuario_dependiente==null)
            dep = new Dependiente(NomComp_dependiente,dni_dependiente,tel_dependiente);
        else
            dep = new Dependiente(NomComp_dependiente,dni_dependiente,tel_dependiente,usuario_dependiente);
        
        dependientesTienda.add(dep);
    }

     
     public void eliminarDependienteModoTexto(List<Dependiente> dependientesTienda) {
        System.out.println(mostrarDependientes(dependientesTienda));
        System.out.println("Introduzca el ID del empleado al que desee dar de baja");
        Scanner scannerd=new Scanner(System.in);
        int id_dependiente_eliminar=scannerd.nextInt();
        
        eliminarDependiente(dependientesTienda,id_dependiente_eliminar);
        System.out.println(mostrarDependientes(dependientesTienda));
    }
    public void eliminarDependiente(List<Dependiente> dependientesTienda, int id_dependiente) {
        for (int i = 0; i < dependientesTienda.size(); i++) {
                if(id_dependiente == dependientesTienda.get(i).getIdDependiente()){
                dependientesTienda.remove(i);
                }
            }
        }

    public String mostrarDependientes(List<Dependiente> a) {
         String cad="";
        for (int i = 0; i < a.size(); i++) {
            cad+=a.get(i)+" id="+ a.get(i).getIdDependiente()+ "\n";
                    
            
        }
        
        return cad;
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