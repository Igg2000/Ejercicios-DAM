/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaexamen2eva;

/**
 *
 * @author Nacho
 */
public class APP {

    public static void main(String[] args) {
        
       
        Persona c1 = new Cliente("1231241M","Pepe",21,TipoVehiculo.Coche);
        System.out.println(""+c1);
        
        Empleado e1 = new Empleado("1234567H","Paco",17);
        Empleado e2 = new Empleado("1234567M","Victor",32);
        Empleado e3 = new Empleado("1234567J","Nacho",24);
        System.out.println(""+e1);
        
      /*  Persona p1 = new Persona(1231241,"Pepe",14);
        System.out.println(""+p1); */
      
      
      
      Sucursal s1= new Sucursal("Madrid");
      Sucursal s2= new Sucursal("Murcia");
      
      s1.addEmpleadoASucursal(e1);
      s1.addEmpleadoASucursal(e2);
      s1.addEmpleadoASucursal(e3);
      
        System.out.println(""+s1+"\n"+s2);
        
       
    }
}
