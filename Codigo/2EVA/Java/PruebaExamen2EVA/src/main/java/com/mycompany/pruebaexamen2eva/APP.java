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

    public static void main(String[] args) {
        
        datosPrueba();
        
       List<Sucursal> sucursales = new ArrayList<>();
       List<Empleado> empleados = new ArrayList<>();
        
        String []opcionesMenuPPal={
            "Agregar Sucursales",
            "Mostrar Sucursales",
            "Agregar Empleados",
            "Mostrar Empleados",
            "Asignar un Empleado a una Sucursal",
            "Eliminar un Empleado de una Sucursal",
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
                    agregarSucursales(sucursales);
                    break;
                case 2:
                    mostrarListas(sucursales);
                    break;
                case 3:
                    agregarEmpleados(empleados);
                    break;
                case 4:
                    mostrarListas(empleados);
                    break;
                case 5:
                    menuAsignarEmpleadosASucursales(empleados,sucursales);
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }while (op!=7);
        
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
        if (s.getNumEmpleados()<3 && e.getSucursal()==0){
            
            s.addEmpleadoASucursal(e);
            e.asignarSucursal(s);}
        
        else if (s.getNumEmpleados()==3){
            JOptionPane.showMessageDialog(null,"la sucursal "+ s.getId() +" está llena");
            }
        else if (e.getSucursal() !=0) {
            JOptionPane.showMessageDialog(null,"El empleado "+ e.getNombre() +" está en otra sucursal");
        }    
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
      
        System.out.println(""+s1+"\n"+s2);
        
    }
        
    private static void agregarSucursales(List sucursales){
        
        Scanner scanner = new Scanner(System.in);
                    
        System.out.println("Introduce la localidad de la nueva sucursal");
        String localidad= scanner.nextLine();
                    
        String nombreSucursal= ("s"+Sucursal.getNumSucursales()+1);
                  
        sucursales.add(new Sucursal(localidad));
        
        //scanner.close();
                    
        //Sucursal nombreSucursal = new Sucursal(localidad);

        //Sucursal s1= new Sucursal("Madrid");
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
                    
    String nombreSucursal= ("s"+Sucursal.getNumSucursales()+1);
                  
    empleados.add(new Empleado(dni,nombre,edad));
                    
    //scanner.close();
    
     }
    
    private static void menuAsignarEmpleadosASucursales(List empleados, List sucursales){
        
        int cont=0;
        
        Scanner scanner = new Scanner(System.in);
        
        
        
        for (Object e : empleados) {
            cont++;
            System.out.println( cont+". "+ e);
        }
        System.out.println("________________________________________________");
        System.out.println("Elige que empleado quieres añadir a una sucursal");
        int opEmp = scanner.nextInt();
        
        
        
        
        System.out.println(" PRUEBA: EL EMPLEADO ELEGIDO ES : "+ empleados.get(opEmp-1));
        
        
    }
}
