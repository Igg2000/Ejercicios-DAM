package data;

import cliente.Cliente;
import servidor.Servidor;

public class Main {
    public static void main(String[] args) {
        new Thread(new Servidor()).start();
        new Thread(new Cliente()).start();
        new Thread(new Cliente()).start();
    }
}