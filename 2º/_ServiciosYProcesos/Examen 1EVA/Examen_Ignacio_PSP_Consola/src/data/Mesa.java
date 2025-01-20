/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 * La mesa aquí actuaría como un monitor
 * @author Nacho
 * 
 */
class Mesa {
    private int cantidadPollo = 0;
    private final int capacidad = 10;

    public synchronized void ponerPollo(int cantidad) throws InterruptedException {
        while (cantidadPollo + cantidad > capacidad) {
            wait();
        }
        cantidadPollo += cantidad;
        System.out.println("Se han puesto " + cantidad + " piezas de pollo en la mesa. Pollo actual: " + cantidadPollo);
        notifyAll();
    }

    public synchronized void tomarPollo(int cantidad, String voluntario) throws InterruptedException {
        while (cantidadPollo < cantidad) {
            System.out.println(voluntario + " está esperando a que haya pollo disponible.");
            wait();
        }
        cantidadPollo -= cantidad;
        System.out.println(voluntario + " ha tomado " + cantidad + " piezas de pollo de la mesa. Pollo actual: " + cantidadPollo);
        notifyAll();
    }
}


