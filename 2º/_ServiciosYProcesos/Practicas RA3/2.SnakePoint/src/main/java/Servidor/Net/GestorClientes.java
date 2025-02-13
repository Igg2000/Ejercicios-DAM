package Servidor.Net;

import Protocolo.Protocolo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Clase encargada de gestionar todos los clientes conectados al servidor.
 */
public class GestorClientes {
    // Se utiliza CopyOnWriteArrayList para permitir modificaciones concurrentes sin problemas en la iteración
    private List<ManejaCliente> clientes;
    private List<String> usuariosConectados = new CopyOnWriteArrayList<>(); // Lista de usuarios conectados>
    private int usuariosPreparados=0;

    public GestorClientes() {
        clientes = new CopyOnWriteArrayList<>();
    }

    /**
     * Agrega un cliente a la lista.
     * @param cliente El cliente a agregar.
     */
    public void agregarCliente(ManejaCliente cliente) {
        clientes.add(cliente);
        // Opcional: notificar a otros clientes de la conexión
        System.out.println("Cliente agregado. Total clientes: " + clientes.size());
    }

    /**
     * Remueve un cliente de la lista.
     * @param cliente El cliente a remover.
     */
    public void removerCliente(ManejaCliente cliente) {
        clientes.remove(cliente);
        // Opcional: notificar a otros clientes que uno se desconectó
        System.out.println("Cliente removido. Total clientes: " + clientes.size());
    }

    /**
     * Envía un mensaje a todos los clientes conectados.
     * @param mensaje El mensaje a enviar.
     */
    public void broadcast(String mensaje) {
        for (ManejaCliente cliente : clientes) {
            cliente.enviarMensaje(mensaje);
        }
    }

    /**
     * Devuelve la lista de clientes conectados.
     * @return Lista de ClienteHandler.
     */
    public List<ManejaCliente> obtenerClientes() {
        return clientes;
    }

    public List<ManejaCliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<ManejaCliente> clientes) {
        this.clientes = clientes;
    }

    public List<String> getUsuariosConectados() {
        return usuariosConectados;
    }

    public void setUsuariosConectados(List<String> usuariosConectados) {
        this.usuariosConectados = usuariosConectados;
    }

    public int getUsuariosPreparados() {
        return usuariosPreparados;
    }

    public void setUsuariosPreparados(int usuariosPreparados) {
        this.usuariosPreparados = usuariosPreparados;
    }

    public void incrementarUsuariosPreparados() {
        this.usuariosPreparados++;
    }

    public void reducirUsuariosPreparados() {
        this.usuariosPreparados--;
    }
}
