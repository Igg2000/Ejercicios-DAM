package GUI;

import data.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class PanelAnimacion extends JPanel {
    
    private Image img;
    private Graphics gg;
    
    private Mesa mesa;
    private Casa casa;
    private Escalera escalera;
    private List<Voluntario> voluntarios;
    private Cocinero productor;
    private Thread lanzadorVoluntarios;
    private Thread finalizador;
    private Timer timer;
    private final JFrame ventana;
    
    private BufferedImage imagenFondo;

    public PanelAnimacion(JFrame ventana) {
        this.ventana = ventana;
        this.mesa = new Mesa(100, 100, 100, 50);
        this.casa = new Casa(300, 100, 100, 100);
        this.escalera = new Escalera(450, 50, 100, 200); // Escalera más alta de lo normal
        this.voluntarios = new ArrayList<>();
        this.productor = new Cocinero(50, 50, 100, 50, mesa, 1);
        this.productor.start();
        
        try {
            imagenFondo = ImageIO.read(new File(".//src//res//bg.jpg"));
        } catch (IOException ex) {
            System.out.println("Error al cargar la foto de fondo");
        }

        // Lanzar voluntarios cada 5-10 segundos
        lanzadorVoluntarios = new Thread(() -> {
            Random random = new Random();
            int contador = 1;
            while (!productor.isFin()) {
                Voluntario voluntario = new Voluntario(50, 150 + 50 * contador, 100, 50, mesa, casa, escalera, "Voluntario " + contador);
                voluntarios.add(voluntario);
                voluntario.start();
                contador++;
                try {
                    Thread.sleep(random.nextInt(6000) + 2000); // Espera entre 2 y 7 segundos
                } catch (InterruptedException e) {
                    System.out.println("Se ha cerrado la ventana, el hilo "+super.getName()+" ha terminado");
                }
                System.out.println("Lanzado " + voluntario.nombre);
            }
            System.out.println("Lanzador de voluntarios ha finalizado.");
        });
        lanzadorVoluntarios.start();

        // Ejemplo de cómo finalizar los hilos después de un tiempo (por ejemplo, 30 segundos)
        finalizador = new Thread(() -> {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                System.out.println("Se ha cerrado la ventana, el hilo "+super.getName()+" ha terminado");
            }

            productor.finalizarHilo();

            try {
                productor.join();
                lanzadorVoluntarios.join();
            } catch (InterruptedException e) {
                System.out.println("Se ha cerrado la ventana, el hilo "+super.getName()+" ha terminado");
            }

            System.out.println("Todos los hilos han finalizado.");
        });
        finalizador.start();

        // Crear y programar la tarea de animación
        timer = new Timer();
        timer.schedule(new Animacion(this), 0, 1000 / 60); // 60 FPS

        // Añadir evento de cierre de ventana para finalizar todos los hilos
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                productor.finalizarHilo();
                timer.cancel();
                for (Voluntario voluntario : voluntarios) {
                    voluntario.interrupt();
                }
                lanzadorVoluntarios.interrupt();
                finalizador.interrupt();
                System.out.println("Ventana cerrada. Todos los hilos han sido finalizados.");
                super.windowClosing(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //doble buffer
        JFrame v= ventana;
        img=v.createImage(v.getWidth(),v.getHeight());        
        gg=img.getGraphics();  
        
        
        gg.drawImage(imagenFondo, 0, 0, v.getWidth(),v.getHeight(), this);
        
        
        mesa.pintar(gg);
        casa.pintar(gg);
        escalera.pintar(gg);
        productor.pintar(gg);
        for (Voluntario voluntario : voluntarios) {
            voluntario.pintar(gg);
        }
        
        // Escalar la imagen
        int anchoEscala = (int) (v.getWidth() * 2); // Escala el ancho a 2 veces
        int altoEscala = (int) (v.getHeight() * 2); // Escala el alto a 2 veces

        // Crea una nueva imagen escalada
        BufferedImage imgEscala = new BufferedImage(anchoEscala, altoEscala, BufferedImage.TYPE_INT_ARGB);

        // Dibuja la imagen original en la imagen escalada
        Graphics2D g2d = imgEscala.createGraphics();
        g2d.drawImage(img, 0, 0, anchoEscala, altoEscala, null);
        g2d.dispose();

        // Dibuja la imagen escalada en el panel
        g.drawImage(imgEscala, 0, 0, this);
        //g.drawImage(img, 0, 0, this);
    }

    private class Animacion extends TimerTask {
        private PanelAnimacion panelAnimacion;

        public Animacion(PanelAnimacion panelAnimacion) {
            this.panelAnimacion = panelAnimacion;
        }

        @Override
        public void run() {
            panelAnimacion.repaint();
        }
    }
}
