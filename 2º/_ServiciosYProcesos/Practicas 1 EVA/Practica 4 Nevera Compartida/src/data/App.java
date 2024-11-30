/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.PanelPrincipal;
import GUI.Ventana;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class App {
    
    private Timer timer;
    private Ventana v;
    private PanelPrincipal p;
    private Nevera nevera;
    private List<Persona> personas;
    private int numeroPersonas=5;
    private VerificadorBloqueo verificadorBloqueo;

    public App() {
        
        timer = new Timer();
        
                
        // Crear la ventana y panel principal
        v = new Ventana("Nevera compartida", this);
        p = new PanelPrincipal("Nevera compartida", "");
        v.ponPanel(p);

        nevera = new Nevera(numeroPersonas, p);

        // Crear y agregar las personas
        personas = new ArrayList<>();
        personas.add(new Persona("Pablo", nevera));
        personas.add(new Persona("Nacho", nevera));
        personas.add(new Persona("Javi", nevera));
        personas.add(new Persona("Antonio", nevera));
        personas.add(new Persona("Luis", nevera));
        
        
        iniciarSimulacion();
    }



    public void iniciarSimulacion() {

        // Iniciar los hilos de las personas
        for (Persona persona : personas) {
            persona.start();
        }

        // Iniciar la animación con un tiempo límite de 60 segundos
        iniciarAnimacion(60000);

        // Crear y arrancar el hilo encargado de verificar el bloqueo
        verificadorBloqueo = new VerificadorBloqueo(nevera);
        verificadorBloqueo.start();
        
    }

    public void iniciarAnimacion(int miliSegundos) {
        // Usar un Timer para detener la simulación después de un minuto
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finalizarAnimacion();
            }
        }, miliSegundos); // Ejecutar esta tarea después de 60 segundos
    }
    
    public void finalizarAnimacion(){
        p.agregarTexto("Tiempo terminado. Deteniendo la simulación...");
        for (Persona persona : personas) {
            persona.detener(); // Detener cada persona
        }
        timer.cancel(); // Cancelar el Timer
        verificadorBloqueo.finalizar();
    }

    public class VerificadorBloqueo extends Thread {
        private final Nevera nevera;
        private boolean fin;

        private VerificadorBloqueo(Nevera nevera) {
            super("Jesús");
            this.nevera = nevera;
        }

        @Override
        public void run() {
            while (!fin) {
                try {
                    Thread.sleep(500); // Espera de medio segundo
                    nevera.verificarBloqueo(); // Verificar si todos los hilos están esperando
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        public void finalizar(){
            fin = true;
        }
        
    }
}
