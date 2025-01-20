/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.util.Random;

/**
 *
 * @author Nacho
 */
public class App extends Thread{

    public static void main(String[] args) {
        App a = new App();
        a.start();
    }

    @Override
    public void run() {
        Mesa mesa = new Mesa();
        Casa casa = new Casa();
        Productor productor = new Productor(mesa, 3); // Ahora produce 3 piezas de pollo a la vez
        
        
        productor.start();

        Thread lanzadorVoluntarios = new Thread(() -> {
            Random random = new Random();
            int contador = 1;
            while (!productor.isFin()) {
                Voluntario voluntario = new Voluntario(mesa, casa, "Voluntario " + contador);
                voluntario.start();
                contador++;
                try {
                    Thread.sleep(random.nextInt(6000) + 5000); // Espera entre 5 y 10 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Lanzador de voluntarios ha finalizado.");
        });
        lanzadorVoluntarios.start();

        // Ejemplo de cómo finalizar los hilos después de un tiempo (por ejemplo, 30 segundos)
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productor.finalizarHilo();

        try {
            productor.join();
            lanzadorVoluntarios.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los hilos han finalizado.");
    }
}











