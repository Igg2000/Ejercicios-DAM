/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaexamen2eva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class APP {
    
    final static int MaxEmpleadosXSucursal= 3;

    public static void main(String[] args) {
        
        
        
       List<Sucursal> sucursales = new ArrayList<>();
       List<Empleado> empleados = new ArrayList<>();
        
       
       datosPruebaConListas(sucursales,empleados);
       
       String []opcionesMenuPPal={
            "Menu Gestion",
            "Salir",
        };
        int op;
        
        
        Scanner scanner = new Scanner(System.in);
        
        do{
             VisualizarMenu("Menu Principal", opcionesMenuPPal );
            do{
                System.out.print("Elige una opcion: ");
                op = scanner.nextInt();
            }while(op<0 || op>opcionesMenuPPal.length);
            
           
        
            switch(op){
                case 1:
                    menuGestion(sucursales,empleados);
                    break;
                case 2:
                    break;

            }
        }while (op!=opcionesMenuPPal.length);
        
        
       //scanner.close();
    }
    
    
    public static void VisualizarMenu(String titulo, String []opciones){
       
        int cont=0;
        
        
          
        System.out.println("____________________");
        System.out.println(""+titulo);
        System.out.println("____________________");
        
        for (String i : opciones) {
            cont++;
            System.out.println(cont+". "+i);
        }    
    }
    
    private static void asignarEmpleadosASucursales(Empleado e, Sucursal s){
        if (s.getNumEmpleados()<MaxEmpleadosXSucursal && e.getSucursal()==0){
            
            s.addEmpleadoASucursal(e);
            e.asignarSucursal(s);}
        
        else if (s.getNumEmpleados()==MaxEmpleadosXSucursal){
            JOptionPane.showMessageDialog(null,"la sucursal "+ s.getId() +" está llena");
            }
        else if (e.getSucursal() !=0) {
            JOptionPane.showMessageDialog(null,"El empleado "+ e.getNombre() +" está en otra sucursal");
        }    
    }
    
    
    private static void menuAsignarEmpleadosASucursales(List<Empleado> empleados, List<Sucursal> sucursales){
        
        int cont=0;
        
        Scanner scanner = new Scanner(System.in);
        
        
        
        for (Object e : empleados) {
            cont++;
            System.out.println( cont+". "+ e);
        }
        System.out.println("________________________________________________");
        System.out.println("Elige que empleado quieres añadir a una sucursal");
        int opEmp = scanner.nextInt();
        
        
        
        
       // System.out.println(" PRUEBA: EL EMPLEADO ELEGIDO ES : "+ empleados.get(opEmp-1));
        System.out.println("________________________________________________");
       cont=0;
         for (Object s : sucursales) {
            cont++;
            System.out.println( cont+". "+ s);
        }
        System.out.println("________________________________________________");
        System.out.println("Elige a que sucursal lo quieres añadir");
        int opSuc = scanner.nextInt();
        
       // System.out.println(" PRUEBA: LA SUCURSAL ELEGIDA ES : "+ sucursales.get(opSuc-1));
       
        
        asignarEmpleadosASucursales(empleados.get(opEmp-1),sucursales.get(opSuc-1));
        
    }
    
    private static void datosPrueba(){
            Persona c1 = new Cliente("1231241M","Pepe",21,TipoVehiculo.Coche);
       // System.out.println(""+c1);
        
        Empleado e1 = new Empleado("1234567H","Paco",17);
        Empleado e2 = new Empleado("1234567M","Victor",32);
        Empleado e3 = new Empleado("1234567J","Nacho",24);
        Empleado e4 = new Empleado("1234567S","Jose",28);
        
        //System.out.println(""+e1);
        
      /*  Persona p1 = new Persona(1231241,"Pepe",14);
        System.out.println(""+p1); */
      
      
      
      Sucursal s1= new Sucursal("Madrid");
      Sucursal s2= new Sucursal("Murcia");
      
      
      asignarEmpleadosASucursales(e1,s1);
      asignarEmpleadosASucursales(e2,s1);
      s1.eliminarEmpleadoDeSucursal(e2);
      asignarEmpleadosASucursales(e3,s1);
       asignarEmpleadosASucursales(e4,s2);
      //asignarEmpleadosASucursales(e1,s2);
      
      //s1.addEmpleadoASucursal(e1);
      //s1.addEmpleadoASucursal(e2);
      //s1.addEmpleadoASucursal(e3);
      
       // System.out.println(""+s1+"\n"+s2);
        
    }
        
    private static void agregarSucursales(List<Sucursal> sucursales){
        
        Scanner scanner = new Scanner(System.in);
                    
        System.out.println("Introduce la localidad de la nueva sucursal");
        String localidad= scanner.nextLine();
                    
        //String nombreSucursal= ("s"+Sucursal.getNumSucursales()+1);
                  
        sucursales.add(new Sucursal(localidad));
        
        //scanner.close();
                    
        //Sucursal nombreSucursal = new Sucursal(localidad);

        //Sucursal s1= new Sucursal("Madrid");
     }
    
    
    private static void eliminarSucursales(List<Sucursal> sucursales){
        
        int cont=0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("________________________________________________");
         
        System.out.println("Sucursales: ");
        
        for (Object e : sucursales) {
            cont++;
            System.out.println( cont+". "+ e);
        }
        System.out.println("________________________________________________");
        System.out.println("Elige que sucursal quieres eliminar");
        int opSuc = scanner.nextInt();
        
        sucursales.remove(opSuc-1);
        
        
    }

    private static void visEmpleadosDeUnaSucursal(List<Sucursal> sucursales){

        int cont=0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("________________________________________________");

        System.out.println("Sucursales: ");

        for (Object e : sucursales) {
            cont++;
            System.out.println( cont+". "+ e);
        }
        System.out.println("________________________________________________");
        System.out.println("Elige que sucursal quieres visualizar");
        int opSuc = scanner.nextInt();
        
        System.out.println(""+sucursales.get(opSuc-1).toString(1));
    }
    private static void mostrarListas(List lista){
            
        for (Object l : lista) {
            System.out.println(""+l);
        }
        
    }
    
    private static void agregarEmpleados(List empleados){
        
    Scanner scanner = new Scanner(System.in);
                    
    System.out.println("Introduce el DNI del empleado");
    String dni= scanner.nextLine();
    System.out.println("Introduce el nombre del empleado");
    String nombre= scanner.nextLine();
    System.out.println("Introduce la edad del empleado");
    int edad= scanner.nextInt();
                    
    //String nombreSucursal= ("s"+Sucursal.getNumSucursales()+1);
                  
    empleados.add(new Empleado(dni,nombre,edad));
                    
    //scanner.close();
    
     }
    
    private static void eliminarEmpleados(List empleados){
        
        int cont=0;
        
         Scanner scanner = new Scanner(System.in);
        System.out.println("________________________________________________");
         
        System.out.println("Empleados: ");
        
        for (Object e : empleados) {
            cont++;
            System.out.println( cont+". "+ e);
        }
        System.out.println("________________________________________________");
        System.out.println("Elige que empleado quieres eliminar");
        int opEmp = scanner.nextInt();
        
        empleados.remove(opEmp-1);
    }

    private static void datosPruebaConListas(List<Sucursal> sucursales, List<Empleado> empleados) {
    
        empleados.add(new Empleado("1234567H","Paco",17));
        empleados.add(new Empleado("1234567M","Victor",32));
        empleados.add(new Empleado("1234567J","Nacho",24));
        empleados.add(new Empleado("1234567S","Jose",28));
        
        sucursales.add(new Sucursal("Madrid"));
        sucursales.add(new Sucursal("Murcia"));
        sucursales.add(new Sucursal("Valencia"));
    }

    private static void menuGestion(List<Sucursal> sucursales, List<Empleado> empleados) {
    
        String []opcionesMenuPPal={
            "Agregar Sucursales",
            "Mostrar Sucursales",
            "Eliminar Sucursales",
            "Agregar Empleados",
            "Mostrar Empleados",
            "Eliminar Empleados",
            "Asignar un Empleado a una Sucursal",
            "Mostrar Empleados de una Sucursal",
            "Salir",
        };
        int op;
        
        
        Scanner scanner = new Scanner(System.in);
        
        do{
             VisualizarMenu("Menu Gestion", opcionesMenuPPal );
            do{
                System.out.print("Elige una opcion: ");
                op = scanner.nextInt();
            }while(op<0 || op>opcionesMenuPPal.length);
            
           
        
            switch(op){
                case 1:
                    agregarSucursales(sucursales);
                    break;
                case 2:
                    mostrarListas(sucursales);
                    break;
                case 3:
                    eliminarSucursales(sucursales);
                    break;
                case 4:
                    agregarEmpleados(empleados);
                    break;
                case 5:
                    mostrarListas(empleados);
                    break;
                case 6:
                    eliminarEmpleados(empleados);
                    break;
                case 7:
                    menuAsignarEmpleadosASucursales(empleados,sucursales);
                    break;
                case 8:
                    visEmpleadosDeUnaSucursal(sucursales);
                    break;
                case 9:
                    break;
            }
        }while (op!=opcionesMenuPPal.length);
            
    }
}
