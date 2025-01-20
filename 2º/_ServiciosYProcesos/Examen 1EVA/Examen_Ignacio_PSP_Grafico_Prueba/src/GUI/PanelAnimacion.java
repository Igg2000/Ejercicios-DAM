package GUI;

import data.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class PanelAnimacion extends JPanel {
    private Mesa mesa;
    private Casa casa;
    private Escalera escalera;
    private List<Voluntario> voluntarios;
    private Productor productor;

    public PanelAnimacion() {
        this.mesa = new Mesa(100, 100, 100, 50);
        this.casa = new Casa(300, 100, 100, 50);
        this.escalera = new Escalera(450, 50, 100, 200); // Escalera más alta de lo normal
        this.voluntarios = new ArrayList<>();
        this.productor = new Productor(50, 50, 100, 50, mesa, 3);
        this.productor.start();

        // Lanzar voluntarios cada 5-10 segundos
        Thread lanzadorVoluntarios = new Thread(() -> {
            Random random = new Random();
            int contador = 1;
            while (!productor.isFin()) {
                Voluntario voluntario = new Voluntario(50, 150 + 50 * contador, 100, 50, mesa, casa, escalera, "Voluntario " + contador);
                voluntarios.add(voluntario);
                voluntario.start();
                contador++;
                try {
                    Thread.sleep(random.nextInt(6000) + 1000); // Espera entre 1 y 6 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Lanzado " + voluntario.nombre);
            }
            System.out.println("Lanzador de voluntarios ha finalizado.");
        });
        lanzadorVoluntarios.start();

        // Ejemplo de cómo finalizar los hilos después de un tiempo (por ejemplo, 30 segundos)
        Thread finalizador = new Thread(() -> {
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
        });
        finalizador.start();

        // Crear y programar la tarea de animación
        Timer timer = new Timer();
        timer.schedule(new Animacion(this), 0, 1000 / 60); // 60 FPS
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        mesa.pintar(g);
        casa.pintar(g);
        escalera.pintar(g);
        productor.pintar(g);
        for (Voluntario voluntario : voluntarios) {
            voluntario.pintar(g);
        }
    }

    
}
