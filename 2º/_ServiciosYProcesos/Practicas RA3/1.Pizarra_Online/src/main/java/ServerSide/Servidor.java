package ServerSide;


import Protocol.MensajeDibujo;

import java.io.*;
import java.net.ServerSocket;
import java.util.*;

/**
 * 
 */
public class Servidor implements Runnable {

    /**
     * Default constructor
     */
    public Servidor() {
    }

    /**
     * 
     */
    private int puerto;

    /**
     * 
     */
    private ServerSocket serverSocket;

    /**
     * 
     */
    private List<GestionaCliente> clientes;

    /**
     * 
     */
    private List<MensajeDibujo> dibujos;

    /**
     * @param mensaje 
     * @return
     */
    public void broadcast(MensajeDibujo mensaje) {
        // TODO implement here
    }

    /**
     * @param cliente 
     * @return
     */
    public void quitarCliente(GestionaCliente cliente) {
        // TODO implement here
    }

    @Override
    public void run() {

    }
}