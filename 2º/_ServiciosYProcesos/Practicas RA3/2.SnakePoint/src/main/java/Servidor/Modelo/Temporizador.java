package Servidor.Modelo;

public class Temporizador implements Runnable {
    private int segundos;
    private boolean corriendo;

    public Temporizador(int segundos) {
        this.segundos = segundos;
        this.corriendo = false;
    }

    public void iniciar() {
        corriendo = true;
        new Thread(this).start();
    }

    public void detener() {
        corriendo = false;
    }

    @Override
    public void run() {
        while (corriendo && segundos > 0) {
            try {
                Thread.sleep(1000);
                segundos--;
                System.out.println("Tiempo restante: " + segundos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        corriendo = false;
        System.out.println("Temporizador finalizado.");
    }
}
