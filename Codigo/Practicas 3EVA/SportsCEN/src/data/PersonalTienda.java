package data;

import Apoyo.Menu;
import Apoyo.Opcion;
import java.awt.Color;

import java.util.*;

/**
 * 
 */
public abstract class PersonalTienda {

  

    protected String nombreCompleto;

    protected String dni;

    protected int telefono;
    
    protected Usuario credenciales;
    
    
    /**
     * Default constructor
     */
    public PersonalTienda(String nombreCompleto, String dni, int telefono) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.telefono = telefono;
    }
    
    public PersonalTienda(String nombreCompleto, String dni, int telefono, Usuario u) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.telefono = telefono;
        this.credenciales = u;
    }
    
    

    public Usuario getCredenciales() {
        return credenciales;
    }

    public void setCredenciales(Usuario credenciales) {
        this.credenciales = credenciales;
    }


    public void VerMenu(List PersonalTienda) {
        // TODO implement here
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
    
    public void gestionarEjemplares(List<Ejemplar> ejemplaresArticulo,List <Articulo> articulosTienda) {
        //@Elsa
        Opcion[] opcionese={
            new Opcion('1',"Agregar ejemplar"),
            new Opcion('2',"Eliminar ejemplar"),
            new Opcion('3',"Mostrar ejemplares de un articulo")
        };
        Menu menuejemplares= new Menu("Gestiona ejemplares de un artículo",opcionese);
        menuejemplares.pintaPorConsola();
        
     Scanner scannerb =new Scanner(System.in);
     int opcione=scannerb.nextInt();
       
     switch(opcione){
         case 1:
                addEjemplarModoTexto(ejemplaresArticulo, articulosTienda);
                break;
        case 2:
                eliminarEjemplarModoTexto(articulosTienda);
                break;
        case 3:
                
                mostrarEjemplarArt(articulosTienda);
                break;}
    }
    
    public void addEjemplarModoTexto(List<Ejemplar> ejemplaresArticulo,List<Articulo> articulosTienda) {
        //@Elsa
        System.out.println("Introduce el ID del articulo al que le quieres añadir un ejemplar");
        System.out.println(mostrarArticulos(articulosTienda));
        Scanner scanner= new Scanner(System.in);
        int id_articulo=scanner.nextInt();
        /*tenía un problema ya que colocaba un nextInt seguido de un NextLine y el NextLine
        me leía el salto de línea que quedaba después de introducir el entero previamente. Para
        solucionarlo uso otro nextLine adicional después de nexInt
        */
        scanner.nextLine(); 
            for (int i = 0; i < articulosTienda.size(); i++) {
           if(id_articulo==articulosTienda.get(i).getIdArticulo()){
               if(articulosTienda.get(i).getTipoPrenda()==Prendas.Zapatillas){
                   System.out.println("Introduce el color del ejemplar de zapatillas");
                   String color=scanner.nextLine();
                   Color colorZap=validarColor(color);
                   System.out.println("Introduce la talla del ejemplar");
                   for (TallasZapatillas talla : TallasZapatillas.values()) {
                       System.out.println(talla);
                   }
                   String talla= scanner.nextLine();
                   TallasZapatillas tallaZap= TallasZapatillas.valueOf(talla);
                   System.out.println("Introduce el precio");
                   float precioZap=scanner.nextFloat();
                   addEjemplarZap(articulosTienda, colorZap,tallaZap, precioZap,articulosTienda.get(i));
               }else{
                   System.out.println("Introduce el color del ejemplar ");
                   String color=scanner.nextLine();
                   Color colorRopa=validarColor(color);
                   System.out.println("Introduce la talla del ejemplar");
                   for (Tallas talla : Tallas.values()) {
                       System.out.println(talla);
                   }
                   String talla= scanner.nextLine();
                   Tallas tallaRopa= Tallas.valueOf(talla);
                   System.out.println("Introduce el precio");
                   float precioRopa=scanner.nextFloat();
                   addEjemplarRopa(articulosTienda, colorRopa,tallaRopa, precioRopa,articulosTienda.get(i));
                   
                   
               }    
               
           }
        }
            
        
       }
     private void addEjemplarRopa(List<Articulo> articulosTienda, Color colorRopa, Tallas tallaRopa, float precioRopa, Articulo a) {
         //@Elsa
         Ejemplar newEjemRopa= new Ejemplar(colorRopa, tallaRopa,precioRopa,a);
                a.getEjemplaresArticulo().add(newEjemRopa);
                a.aumentarCantidadEjemplares();
               
      }

      public void addEjemplarZap(List<Articulo> articulosTienda,Color colorZap, TallasZapatillas tallaZap, float precioZap, Articulo a) {
          //@Elsa
          Ejemplar newEjemZap= new Ejemplar(colorZap, tallaZap,precioZap,a);
               a.getEjemplaresArticulo().add(newEjemZap);
               a.aumentarCantidadEjemplares();
               
      }
      
      public Color validarColor(String color) {
        //@Elsa  
      Map<String, Color> colorMap = new HashMap<>();
        colorMap.put("blanco", Color.WHITE);
        colorMap.put("negro", Color.BLACK);
        colorMap.put("rojo", Color.RED);
        colorMap.put("verde", Color.GREEN);
        colorMap.put("azul", Color.BLUE);
        colorMap.put("amarillo", Color.YELLOW);
        colorMap.put("naranja", Color.ORANGE);
        colorMap.put("rosa", Color.PINK);
        colorMap.put("gris", Color.GRAY);
        colorMap.put("magenta", Color.MAGENTA);
        colorMap.put("cian", Color.CYAN);
      
      Color colorzap=colorMap.get(color);
      /*  if (colorzap != null) {
            System.out.println("El color elegido es: " + color);
        } else {
            System.out.println("El color especificado no está en la lista de colores");
           }
      */
        return colorzap;   
      }
      
 public void eliminarEjemplarModoTexto( List<Articulo> articulosTienda) {
        //@Elsa
        System.out.println(mostrarArticulos(articulosTienda));
        System.out.println("Introduzca el id del articulo del cual desea eliminar algún ejemplar");
        Scanner scanner= new Scanner(System.in);
        int id_articulo=scanner.nextInt();
        for (int i = 0; i < articulosTienda.size(); i++) {
            if (id_articulo==articulosTienda.get(i).getIdArticulo()) {
                System.out.println(mostrarEjemPorArticulo(articulosTienda.get(i).getIdArticulo(), articulosTienda));
                System.out.println("Introduzca el id del ejemplar que desea eliminar");
                scanner.nextLine(); 
                int id_ejemplar=scanner.nextInt();
                eliminarEjemplar(articulosTienda, articulosTienda.get(i), id_ejemplar);
                }
                }
        }
        
        
      
    public void eliminarEjemplar(List<Articulo> articulosTienda, Articulo a, int id_ejemplar) {
        //@Elsa
        for (int i = 0; i < a.getEjemplaresArticulo().size(); i++) {
               if (id_ejemplar==a.getEjemplaresArticulo().get(i).getIdEjemplar())
                   a.getEjemplaresArticulo().remove(i);
        }
    }
    public void mostrarEjemplarArt(List<Articulo> articulosTienda) {
        //@Elsa
        Opcion[] opcionese={
            new Opcion('1',"Marca"),
            new Opcion('2',"Prenda"),
            new Opcion('3',"Todo")
        };
        Menu menuejemplares= new Menu("Mostrar ejemplares por:",opcionese);
        menuejemplares.pintaPorConsola();
        
        
        Scanner scanner=new Scanner(System.in);
        int ope=scanner.nextInt();
        
        switch (ope) {
         case 1:
                mostrarEjemMarcaModoTexto( articulosTienda);
                break;
         case 2:
                mostrarEjemPrendaModoTexto(articulosTienda);
                break;
         case 3:
                mostrarEjemPorArticuloModoTexto(articulosTienda);
                break;
        }   
  }

    private void mostrarEjemMarcaModoTexto( List<Articulo> articulosTienda) {
        //@Elsa
        Scanner scanner= new Scanner(System.in);
        System.out.println("Marcas disponibles");
       
        for (Marcas marca : Marcas.values()) {
            System.out.println(marca);
        }
        System.out.println("Introduzca la marca");
        String marcaElegida= scanner.nextLine();
        /*Con el método valueof , se intenta convertir la cadena introducida
        "marcaElegida" en una constante del enumerado. Si la cadena proporcionada 
        no coincide con nigún valor del enumerado, se lanzará una excepción
        */
        Marcas marcaDeseada= Marcas.valueOf(marcaElegida);
        System.out.println(mostrarEjemMarca(marcaDeseada, articulosTienda));
        
        
        
       }
    public String mostrarEjemMarca(Marcas marcaDeseada, List<Articulo> articulosTienda){
        //@Elsa
        String cad="";
        for (int i = 0; i <articulosTienda.size() ; i++) {
            if(marcaDeseada == articulosTienda.get(i).getMarca()){
                for (int j = 0; j < articulosTienda.get(i).getEjemplaresArticulo().size(); j++) {
                    cad+=articulosTienda.get(i).getEjemplaresArticulo().get(j)+"\n";
                }
            }
        }
        return cad;
    }

    private void mostrarEjemPrendaModoTexto(List<Articulo> articulosTienda) {
        //@Elsa
        Scanner scanner= new Scanner(System.in);
        System.out.println("Tipo de prendas disponibles");
       
        for (Prendas prenda : Prendas.values()) {
            System.out.println(prenda);
        }
        System.out.println("Introduzca el tipo de prenda");
        String prendaElegida= scanner.nextLine();
        /*Con el método valueof , se intenta convertir la cadena introducida
        "prendaElegida" en una constante del enumerado. Si la cadena proporcionada 
        no coincide con nigún valor del enumerado, se lanzará una excepción
        */
        Prendas prendaDeseada=Prendas.valueOf(prendaElegida);
        System.out.println(mostrarEjemPrenda(prendaDeseada, articulosTienda));
       }
    
    public String mostrarEjemPrenda(Prendas prendaDeseada, List <Articulo> articulosTienda){
        //@Elsa
        String cad="";
        for (int i = 0; i <articulosTienda.size(); i++) {
            if(prendaDeseada == articulosTienda.get(i).getTipoPrenda()){
                for (int j = 0; j <articulosTienda.get(i).getEjemplaresArticulo().size() ; j++) {
                    cad+=articulosTienda.get(i).getEjemplaresArticulo().get(j)+"\n";
                }
            }
        }
        return cad;
    }

    public void mostrarEjemPorArticuloModoTexto(List<Articulo> articulosTienda) {
        //@Elsa
        Scanner scanner= new Scanner(System.in);
          
          
          System.out.println(mostrarArticulos(articulosTienda)
           );
          int id_articulo=scanner.nextInt();
          
          System.out.println(mostrarEjemPorArticulo(id_articulo, articulosTienda));
   
        }
    public String mostrarEjemPorArticulo(int id_articulo, List <Articulo> articulosTienda){
        //@Elsa  
        String cad="";
          for (int i = 0; i < articulosTienda.size() ; i++) {
          if(id_articulo == articulosTienda.get(i).getIdArticulo()){
              for (int j = 0; j < articulosTienda.get(i).getEjemplaresArticulo().size(); j++) {
                 cad+=articulosTienda.get(i).getEjemplaresArticulo().get(j)+"\n"; 
              }
         
          }
         
        }
        return cad;
    } 
    
    public String mostrarEjemplaresTodos( List <Articulo> articulosTienda){
        //@Nacho  
        String cad="";
          for (int i = 0; i < articulosTienda.size(); i++) {
            cad+=mostrarEjemPorArticulo(articulosTienda.get(i).getIdArticulo(), articulosTienda)+"\n";
        }
        return cad;
    } 
    
    public void gestionarClientes(List<Cliente> clientesTienda,Tienda b) {
                Opcion[] opcionesc={
            new Opcion('1',"Agregar cliente"),
            new Opcion('2',"Eliminar cliente"),
            new Opcion('3',"Mostrar clientes")
        };
        Menu menuclientes= new Menu("Gestiona clientes",opcionesc);
        menuclientes.pintaPorConsola();
        
     Scanner scanner =new Scanner(System.in);
     int opcionc=scanner.nextInt();
       
     switch(opcionc){
         case 1:
                addClienteModoTexto(clientesTienda, b);
                break;
        case 2:
                eliminarClienteModoTexto(clientesTienda);
                break;
        case 3:
                
                System.out.println(mostrarClientes(clientesTienda));
                break;}
    }

    public void eliminarClienteModoTexto(List<Cliente> clientesTienda) {
        System.out.println(mostrarClientes(clientesTienda));
        System.out.println("Introduca el ID del cliente que desea eliminar");
        Scanner scanner= new Scanner(System.in);
        int id_cliente=scanner.nextInt();
       eliminarCliente(clientesTienda,id_cliente);
         }
   public void eliminarCliente(List<Cliente> clientesTienda, int id_cliente) {
        for (int i = 0; i < clientesTienda.size(); i++) {
            if (id_cliente==clientesTienda.get(i).getIdCliente()) {
                clientesTienda.remove(i);
            }
        }
         
   }
    public void addClienteModoTexto(List<Cliente> clientesTienda, Tienda b) {
        System.out.println("Introduzca el nombre completo del cliente que desea añadir");
        Scanner scanner= new Scanner(System.in);
        String nombre= scanner.nextLine();
        System.out.println("Introduzca el correo del nuevo cliente");
        String correo=scanner.nextLine();
                addCliente(nombre, correo,b);
                
          }
     public void addCliente(String nombre, String correo, Tienda b) {
         Cliente a= new Cliente(nombre,correo);
         b.getClientesTienda().add(a);
        }
     
    public String mostrarClientes(List<Cliente> clientesTienda) {
        String cad="";
        for (int i = 0; i < clientesTienda.size(); i++) {
            cad+="id:"+ clientesTienda.get(i).getIdCliente()+" "+clientesTienda.get(i)+"\n";
        }
        return cad;
    }
    
    public String visHistorialVentas( Cliente clienteVenta) {
        String cad="";
        for (int i = 0; i <clienteVenta.getVentasCliente().size(); i++) {
                 cad+=clienteVenta.getVentasCliente().get(i)+"\n";
                }
        
         return cad;
    }

    

    @Override
    public String toString() {
        return  nombreCompleto + " dni=" + dni + " telefono=" + telefono;
    }

    //de aqui hacia abajo getters y setters
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