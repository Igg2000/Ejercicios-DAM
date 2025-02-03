package data;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

public class GestionaServidor {
    ServerSocket servidor;
    int puerto= 50505;
    int numMaxClientes= 10;
    ObjectOutputStream out;
    ObjectInputStream in;

    public GestionaServidor() {

        crearServidor();
        aceptarCliente();

    }

    public void aceptarCliente() {
        try {
            out = new ObjectOutputStream(servidor.accept().getOutputStream());
            in = new ObjectInputStream(servidor.accept().getInputStream());
        } catch (Exception e) {
            System.out.println("Error al aceptar cliente");
        }
    }

    public void crearServidor(){
        
        try {
            servidor = new ServerSocket(puerto, numMaxClientes);
            System.out.println("Servidor iniciado");
        } catch (Exception e) {
            System.out.println("Error al iniciar el servidor");
        }
    }

}
