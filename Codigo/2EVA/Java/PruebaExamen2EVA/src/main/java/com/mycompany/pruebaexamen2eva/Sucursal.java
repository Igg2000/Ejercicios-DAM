/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaexamen2eva;

/**
 *
 * @author Nacho
 */
public class Sucursal {
    
    private  int id;
    Empleado [] empleadosSucursales;
    private String localidad;
    private static int numSucursales;
    private int numEmpleados;
    
    public Sucursal(String localidad) {
        this.id = numSucursales+1;
        numSucursales++;
        this.empleadosSucursales = new Empleado[3];
        this.localidad= localidad;
    }

    public void addEmpleadoASucursal(Empleado e){
    
        int posicion;
        
    posicion=buscarPrimerHueco(empleadosSucursales);
    
        //System.out.println("la posicion es"+posicion);
       
        if (posicion>=0 && posicion<=2){
            this.empleadosSucursales[posicion]= e;
            numEmpleados++; 
        }
    }

    
    public int buscarPrimerHueco(Empleado [] empleadosSucursales){
        
        int posicion=-1,i=0;
        
        do{
            if (this.empleadosSucursales[i]==null){
                posicion=i;
            }
            i++;
        }while(this.empleadosSucursales[i-1]!=null);
        
        return posicion;
    }
    

       public void eliminarEmpleadoDeSucursal(Empleado e){
    
        int posicion=-1;
        
           for (int i = 0; i < empleadosSucursales.length; i++) {
              if (this.empleadosSucursales[i]!=null){
                if (e.getDni().equals(this.empleadosSucursales[i].getDni()))
                    posicion = i;
                 }
                }
           
            this.empleadosSucursales[posicion]= null;
            numEmpleados--; 
        
    }
    
    public int getId() {
        return id;
    }

    public Empleado[] getEmpleadosSucursales() {
        return empleadosSucursales;
    }

    public String getLocalidad() {
        return localidad;
    }

    public static int getNumSucursales() {
        return numSucursales;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }
    
    
    @Override
    public String toString() {
        
        return "Sucursal: " + "id=" + id + ", localidad=" + localidad + " Numero de empleados = "+ numEmpleados + "/3";
    }
    
     public String toString(int a) {
        if (a==1);
        return "Sucursal: " + "id=" + id + ", localidad=" + localidad + " Numero de empleados = "+ numEmpleados + "/3"+
                "\n Empleado1= " + empleadosSucursales[0] + "\n Empleado2= " + empleadosSucursales[1] + "\n Empleado3= " + empleadosSucursales[2];
    }

}
