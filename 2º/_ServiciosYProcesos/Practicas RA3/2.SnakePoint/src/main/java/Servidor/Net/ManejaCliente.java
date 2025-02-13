package Servidor.Net;

import Protocolo.Protocolo;
import Protocolo.ProtocoloUtiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Clase que gestiona la conexión de un cliente individual.
 * Implementa Runnable para poder ejecutarse en un hilo independiente.
 */
public class ManejaCliente implements Runnable,Protocolo {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private GestorClientes gestor;


    private String nombre;
    private int id;
    private static int contadorID=1;
    private int avatar;

    public ManejaCliente(Socket socket, GestorClientes gestor) {
        this.socket = socket;
        this.gestor = gestor;
        this.id = contadorID++;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Error al crear los streams de comunicación con el cliente: " + e.getMessage());
        }
    }

    /**
     * Envía un mensaje al cliente.
     * @param mensaje El mensaje a enviar.
     */
    public void enviarMensaje(String mensaje) {
        out.println(mensaje);
    }

    /**
     * Obtiene el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public synchronized void run() {
        try {
            String mensaje;
            // Bucle para leer mensajes enviados por el cliente
            while ((mensaje = in.readLine()) != null) {
                procesarMensaje(mensaje);
            }
        } catch (IOException e) {
            System.out.println("Error al recibir mensajes del cliente: " + e.getMessage());
        } finally {
            // Al finalizar (o en caso de error), se remueve el cliente del gestor
            gestor.removerCliente(this);
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el socket del cliente: " + e.getMessage());
            }
        }
    }

    private synchronized void  procesarMensaje(String mensaje) {
        String[] tokens = ProtocoloUtiles.parsearMensaje(mensaje);
        if (tokens.length == 0) {
            System.out.println("Mensaje vacío o mal formado: " + mensaje);
            return;
        }

        int codigo = ProtocoloUtiles.obtenerCodigo(tokens);
        System.out.println("He recibido el siguiente mensaje: " + mensaje);

        try {
            switch (codigo) {
                case Protocolo.NUEVO_JUGADOR:
                    procesarNuevoJugador(tokens);
                    break;
                case Protocolo.JUGADOR_DESCONECTADO:
                    procesarJugadorDesconectado(tokens);
                    break;
                case Protocolo.JUGADOR_PREPARADO:
                    procesarJugadorPreparado(tokens);
                    break;
                case DAME_LISTA_DE_JUGADORES:
                    procesarDameListaDeJugadores(tokens);
                    break;
                case DAME_JUGADORES_PREPARADOS:
                    procesarDameListaDePreparados(tokens);
                    break;
                // Manejar otros casos...
                default:
                    System.out.println("Mensaje no reconocido: " + mensaje);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error parseando número en mensaje: " + mensaje + ". Detalle: " + e.getMessage());
        }
    }

    private void procesarDameListaDePreparados(String[] tokens) {
        gestor.broadcast(String.valueOf(TOMA_JUGADORES_PREPARADOS) + SEPARADOR + gestor.getUsuariosPreparados());
    }

    private void procesarDameListaDeJugadores(String[] tokens) {
        String cad="";

        for (String jugador : gestor.getUsuariosConectados()) {
            cad += ":"+ jugador ;
        }

        System.out.println("ESTOS SON LOS JUGADORES CONECTADOS:" + cad);

        gestor.broadcast(AGREGA_JUGADORES_A_LA_LISTA + cad);
    }

    private void procesarNuevoJugador(String[] tokens) {
        // Se espera: NUEVO_JUGADOR:nombre
        if (tokens.length < 2) {
            System.out.println("Mensaje NUEVO_JUGADOR mal formado.");
            return;
        }

        String nuevoNombre = tokens[1];

        this.nombre = nuevoNombre;
        System.out.println("Nuevo usuario asignado: " + id + " : " + nombre);
        //lo agrego a la lista
        gestor.getUsuariosConectados().add(nombre);

    }

    private void procesarJugadorDesconectado(String[] tokens) {
        // Se espera: JUGADOR_DESCONECTADO:id

        System.out.println("Jugador desconectado: " + id);
        // Si el mensaje indica la desconexión de este cliente, se remueve.
        gestor.removerCliente(this);
        gestor.getUsuariosConectados().remove(nombre);

    }

    private void procesarJugadorPreparado(String[] tokens) {
        // Se espera: JUGADOR_PREPARADO:avatar

        avatar = Integer.parseInt(tokens[1]);
        gestor.incrementarUsuariosPreparados();
        System.out.println("Jugador preparado: ID " + id + "Nombre " + nombre + "Avatar " + avatar);

        if (gestor.getUsuariosPreparados() == gestor.getUsuariosConectados().size()) {
            gestor.broadcast(String.valueOf(INICIO_JUEGO));
            System.out.println("Estamos listos para jugar");
        }

    }


}
