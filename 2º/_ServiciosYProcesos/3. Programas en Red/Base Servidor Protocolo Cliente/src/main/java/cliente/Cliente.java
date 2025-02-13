package cliente;

import protocolo.Protocolo;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente implements Runnable, Protocolo {

    private final String SERVIDOR = "localhost";
    private final int PUERTO = 50001;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket s;

    @Override
    public void run() {
        try {
            s = new Socket(SERVIDOR,PUERTO);
            out = new ObjectOutputStream(s.getOutputStream());
            in = new ObjectInputStream(s.getInputStream());

            //le digo que soy un nuevo usuario
            out.writeObject(NUEVO_USUARIO+"");
            out.flush();
            //leo la respuesta
            try {
                System.out.println("Respuesta del servidor: "+in.readObject());
            } catch (ClassNotFoundException e) {
                System.out.println("Error al leer el objeto");
            }


            //le digo que me voy
            out.writeObject(USUARIO_DESCONECTADO+"");
            out.flush();

            //leo la respuesta
            try {
                System.out.println("Respuesta del servidor: "+in.readObject());
            } catch (ClassNotFoundException e) {
                System.out.println("Error al leer el objeto");
            }


        }
        catch (EOFException e){
            System.out.println("Te has desconectado con exito");
        }
        catch (IOException e) {
            System.out.println("Error de conexion: "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Thread(new Cliente()).start();
    }
}
