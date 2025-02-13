package servidor;

import protocolo.Protocolo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Servidor implements Runnable,Protocolo {

    private AgenciaViajes a;
    private final int PUERTO = 50001;
    private ServerSocket socket;
    private boolean fin = false;


    private List<Socket> clientes;

    public static void main(String[] args) {
        new Thread(new Servidor()).start();
    }

    @Override
    public void run() {

        a=new AgenciaViajes();

        try {
            socket = new ServerSocket(PUERTO);
            socket.setSoTimeout(4000); //tiempo que tarda en desbloquearse si no encuentra cliente
        } catch (IOException e) {
            System.out.println("No se pudo crear el servidor");
            return;
        }

        escucharClientes();


    }

    private void escucharClientes() {
        while(!fin){
            try {
                System.out.println("Escuchando clientes");
                Socket cliente= socket.accept(); //me bloqueo esperando clientes

                System.out.println("Socket aceptado: "+cliente.getInetAddress()+"/"+cliente.getPort());
                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream()); //flujo de salida
                ObjectInputStream in = new ObjectInputStream(cliente.getInputStream()); //flujo de entrada

                while(!fin) {
                    //leo la peticion del cliente
                    String cad = in.readObject().toString();
                    System.out.println("El cliente ha dicho: "+cad);
                    //creo la respuesta en base a la peticion

                    String respuesta = crearRespuesta(cad, cliente);
                    System.out.println("Se le ha respondido al cliente: "+respuesta);
                    out.writeObject(respuesta);
                    //out.writeObject(crearRespuesta(cad, cliente));
                    out.flush();
                    //si esta parte se hace muy grande, debería de crearme la clase "GestionaCliente"
                }
            } catch (IOException e) {
                System.out.println("Tiempo superado, volviendo a escuchar");
                if (fin)
                    return;
            } catch (ClassNotFoundException e) {
                System.out.println("Error al leer el objeto");
            }
        }
    }

    private String crearRespuesta(String cad, Socket cliente) {

        switch (Integer.parseInt(cad)){
            case NUEVO_USUARIO:
                return "Se ha establecido la conexion con el cliente "+cliente.getInetAddress()+"/"+cliente.getPort();
            case USUARIO_DESCONECTADO:
                try {
                    cliente.close();
                    return "Se ha cerrado la conexion con el cliente "+cliente.getInetAddress()+"/"+cliente.getPort();
                } catch (IOException e) {
                    return "No se ha podido cerrar la conexion con el cliente";
                }
        }
        return "Error";
    }
}
