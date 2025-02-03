package ClientSide;

import ClientSide.GUI.PizarraGUI;
import Protocol.MensajeDibujo;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * 
 */
public class Cliente implements Runnable {

    /**
     * Default constructor
     */
    public Cliente() {
    }

    /**
     * 
     */
    private Socket socket;

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
    private List<String> usuariosConectados;

    /**
     * 
     */
    private JFrame ventana;

    /**
     * 
     */
    private PizarraGUI panel;

    /**
     * @return
     */
    public void connectar() {
        // TODO implement here

    }

    /**
     * @param msg
     */
    public void enviarMensaje(MensajeDibujo msg) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void recibirMensaje() {
        // TODO implement here

    }

    @Override
    public void run() {

    }
}