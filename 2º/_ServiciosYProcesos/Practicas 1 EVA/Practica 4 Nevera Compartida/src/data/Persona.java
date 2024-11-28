/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
class Persona extends Thread {
    private final Nevera nevera;
    private volatile boolean activo = true; // Controlar si el hilo debe seguir activo

    public Persona(String nombre, Nevera nevera) {
        super(nombre);
        this.nevera = nevera;
    }

    public void detener() {
        activo = false; // Detener el bucle
    }

    @Override
    public void run() {
        try {
            while (activo) {
                // Decidir aleatoriamente si agregar o consumir
                if (Math.random() > 0.5) {
                    String tipoLata = Math.random() > 0.5 ? "Cerveza" : "CocaCola";
                    nevera.agregarLata(tipoLata);
                } else {
                    nevera.sacarLata();
                }

                // Pausa entre acciones
                Thread.sleep((long) (Math.random() * 5000));
            }
            nevera.getP().agregarTexto(getName() + " ha terminado.");
        } catch (InterruptedException e) {
            nevera.getP().agregarTexto(getName() + " ha sido interrumpido.");
        }
    }
}