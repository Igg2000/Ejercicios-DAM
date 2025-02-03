package ServerSide;


import Protocol.MensajeDibujo;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * 
 */
public class GestionaCliente implements Runnable {

    /**
     * Default constructor
     */
    public GestionaCliente() {
    }

    /**
     * 
     */
    private Socket cliente;

    /**
     * 
     */
    private ObjectInputStream input;

    /**
     * 
     */
    private ObjectOutputStream output;

    /**
     * 
     */
    private Servidor servidor;

    /**
     * @param msj
     */
    public void enviarMensaje(MensajeDibujo msj) {
        // TODO implement here
    }

    @Override
    public void run() {

    }
}