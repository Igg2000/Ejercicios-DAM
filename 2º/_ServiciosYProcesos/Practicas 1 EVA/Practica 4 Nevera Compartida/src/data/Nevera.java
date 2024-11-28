/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.PanelPrincipal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nacho
 */
class Nevera {
    private final List<String> latas = new ArrayList<>();
    private int hilosEsperando = 0; // Contador de hilos esperando
    private final int totalHilos; // Número total de hilos
    private final PanelPrincipal p;

    public Nevera(int totalHilos, PanelPrincipal p) {
        this.totalHilos = totalHilos;
        this.p = p;
    }

    // Método para agregar una lata a la nevera
    public synchronized void agregarLata(String tipoLata) {
        latas.add(tipoLata);
        p.agregarTexto(Thread.currentThread().getName() + " agregó una lata de " + tipoLata + " a la nevera.");
        notifyAll(); // Notificar a los que esperan para consumir
    }

    // Método para sacar una lata de la nevera
    public synchronized String sacarLata() throws InterruptedException {
        while (latas.isEmpty()) {
            hilosEsperando++; // Incrementar el número de hilos en espera
            p.agregarTexto(Thread.currentThread().getName() + " espera porque la nevera está vacía...");
            wait(); // Esperar hasta que haya latas
            hilosEsperando--; // Decrementar al salir del estado de espera
        }

        String lata = latas.remove(0); // Sacar la primera lata
        p.agregarTexto(Thread.currentThread().getName() + " sacó una lata de " + lata + " de la nevera.");
        return lata;
    }

    // Método para verificar si todos los hilos están esperando
    public synchronized void verificarBloqueo() {
        if (hilosEsperando == totalHilos) {
            p.agregarTexto("La nevera está vacía y todas las personas de la casa estan esperando");
            p.agregarTexto("Acaba de llegar nuestro colegón "+ Thread.currentThread().getName() +" con una caja de 6 cervezas");
            for (int i = 0; i < 6; i++) {
                agregarLata("Cerveza");
            }
            notifyAll(); // Notificar a todos los hilos
        }
    }

    public PanelPrincipal getP() {
        return p;
    }
    
    
}