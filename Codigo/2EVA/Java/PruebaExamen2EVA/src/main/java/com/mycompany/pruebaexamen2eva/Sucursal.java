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
        this.id = numSucursales+100;
        numSucursales++;
        this.empleadosSucursales = new Empleado[3];
        this.localidad= localidad;
    }

    public void addEmpleadoASucursal(Empleado e){
    
    this.empleadosSucursales[numEmpleados]= e;
    numEmpleados++;
        
    }
    
    @Override
    public String toString() {
        
        return "Sucursal: " + "id=" + id + ", localidad=" + localidad + 
                "\n Empleado1= " + empleadosSucursales[0] + "\n Empleado2= " + empleadosSucursales[1] + "\n Empleado3= " + empleadosSucursales[2];
    }
    
    
    
}
