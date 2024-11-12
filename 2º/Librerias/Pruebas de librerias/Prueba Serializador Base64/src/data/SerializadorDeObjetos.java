/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Esta clase contiene metodos para serializar objetos
 * @author Nacho
 */
public class SerializadorDeObjetos {
    
    
    
     /**
      * Este metodo convierte un objeto en un array de bytes y luego lo codifica
      * en Base64 para posteriormente añadirlo al fichero que le pongas
      * @param <T> puede ser cualquier objeto
      * @param objeto el objeto que va a escribir
      * @param fichero el fichero donde lo va a escribir
      * @throws IOException 
      */
    public static <T> void escribirBase64(T objeto, File fichero) throws IOException {
        // Serializar el objeto a un arreglo de bytes
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream)) {
            oos.writeObject(objeto);
            oos.flush();  // Asegura que todos los datos se escriban
        }

        byte[] objetoBytes = byteArrayOutputStream.toByteArray(); // Obtenemos el arreglo de bytes

        // Codificar el arreglo de bytes en Base64
        String objetoBase64 = Base64.getEncoder().encodeToString(objetoBytes);

        // Escribir la cadena Base64 en un archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichero, true))) {
            writer.write(objetoBase64); // Escribe la cadena Base64 en el archivo
            writer.newLine();  // Agregar nueva línea para separar registros en el archivo
        }
    }

    /**
     * Funcion que lee objetos convertidos en Bytes y codificados en Base64 
     * y retorna un ArrayList con los objetos
     * @param <T> Puede ser cualquier tipo de Objeto
     * @param fichero el fichero que se va a leer
     * @param tipoObjeto el objeto en si
     * @return devuelve un ArrayList con los objetos
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static <T> ArrayList<T> leerBase64(File fichero, Class<T> tipoObjeto) throws IOException, ClassNotFoundException {
        ArrayList<T> objetosLeidos = new ArrayList<>();

        // Abrir el archivo para leer las cadenas Base64
        try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
            String linea;

            // Leer cada línea del archivo (cada línea contiene un objeto codificado en Base64)
            while ((linea = reader.readLine()) != null) {
                // Decodificar la cadena Base64 a un arreglo de bytes
                byte[] objetoBytes = Base64.getDecoder().decode(linea);

                // Deserializar el objeto desde los bytes
                try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(objetoBytes);
                     ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
                    T objetoLeido = (T) objectInputStream.readObject();

                    // Agregar el objeto deserializado al ArrayList
                    objetosLeidos.add(objetoLeido);
                }
            }
        }

        return objetosLeidos;  // Retorna la lista con todos los objetos leídos
    }
  /**
     * Este método escribe un objeto en un archivo binario.
     * 
     * @param <T>      puede ser cualquier objeto
     * @param objeto   el objeto que va a escribir
     * @param fichero  el fichero donde lo va a escribir
     * @throws IOException 
     */
    public static <T> void escribirBinario(T objeto, File fichero) throws IOException {

        FileOutputStream fos = new FileOutputStream(fichero, true);
        ObjectOutputStream oos;

        // Si el archivo está vacío, escribimos el encabezado
        if (fichero.exists() && fichero.length() == 0) {
            oos = new ObjectOutputStream(fos);
        } else {
            oos = new MiObjectOutputStream(fos);
        }
        oos.writeObject(objeto);

    }

    /**
     * Este método lee todos los objetos del archivo y los retorna como una lista.
     * 
     * @param <T>           el tipo de objeto a leer
     * @param fichero       el fichero desde el cual leer los objetos
     * @param tipoObjeto    el tipo de objeto (Clase) que se desea deserializar
     * @return              una lista con todos los objetos leídos desde el archivo
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> List<T> leerBinario(File fichero, Class<T> tipoObjeto) throws IOException, ClassNotFoundException {
        List<T> objetos = new ArrayList<>();

        FileInputStream fis = new FileInputStream(fichero);
        ObjectInputStream ois = new ObjectInputStream(fis);

        // Leer los objetos hasta que se llegue al final del archivo
        while (true) {
            try {
                // Leer un objeto y añadirlo a la lista
                T objeto = (T) ois.readObject();
                objetos.add(objeto);
            } catch (EOFException e) {
                // Cuando llegamos al final del archivo, salimos del bucle
                break;
            }
        }

        return objetos;  // Devuelve la lista con todos los objetos leídos
    }

    private static class MiObjectOutputStream extends ObjectOutputStream {

        public MiObjectOutputStream(FileOutputStream fos) throws IOException {
            super(fos);
        }

        @Override
        protected void writeStreamHeader() throws IOException {

        }
    }

}
