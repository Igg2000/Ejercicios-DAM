/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class App {

    File rutaArchivo;
    File rutaArchivoIndice;
            
    public App() {
        run();
    }

    private void run() {
        
        rutaArchivo= new File(".//src//res//agenda.txt");  
        rutaArchivoIndice= new File(".//src//res//indiceAgenda.txt");  
        
        agregarContacto();
        leerArchivo();
        
        
        
    }

    private void agregarContacto() {
        
        RandomAccessFile archivo=null;
        RandomAccessFile archivoIndice=null;
        try {
            //creo el archivo
            archivo = new RandomAccessFile(rutaArchivo,"rw");
            archivoIndice = new RandomAccessFile(rutaArchivoIndice,"rw");
            

            //le pido al usuario los datos
            String nombre = JOptionPane.showInputDialog("Elige el nombre del contacto");
            int numero= Integer.parseInt(JOptionPane.showInputDialog("Elige el numero de telefono"));

            Contacto nuevoContacto = new Contacto(nombre,numero);
        
            //me coloco al fina del archivo
            long pos = archivo.length();
            archivo.seek(pos);
            
            //escribo los datos del contacto
            archivo.writeInt(nuevoContacto.getId());
            archivo.writeUTF(nuevoContacto.getNombre());
            archivo.writeInt(nuevoContacto.getTelefono());
            
            
            //escribo los datos en el indice
            long posIndice = archivoIndice.length();
            archivoIndice.seek(posIndice);
            archivoIndice.writeInt(nuevoContacto.getId());
            archivoIndice.writeLong(pos);
            
            
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showInputDialog("No se ha podido abrir el archivo a la hora de agregar el contacto"); 
        } catch (IOException ex) {
            JOptionPane.showInputDialog("Ha ocurrido el siguiente error: "+ex.getMessage());
        } finally {
            try {
                if (archivo != null) archivo.close();
                if (archivoIndice != null) archivoIndice.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar los archivos: " + ex.getMessage());
            }
        }
        
        
        
    }
     private void leerArchivo() {
        RandomAccessFile archivo = null;
        try {
            archivo = new RandomAccessFile(rutaArchivo, "r");  // Abrir archivo en modo lectura

            System.out.println("Leyendo todos los contactos:");

            while (archivo.getFilePointer() < archivo.length()) {
                int id = archivo.readInt();      // Lee el ID
                String nombre = archivo.readUTF();  // Lee el nombre
                int telefono = archivo.readInt();  // Lee el teléfono

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Teléfono: " + telefono);
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar el archivo para leer.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + ex.getMessage());
        } finally {
            try {
                if (archivo != null) archivo.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo: " + ex.getMessage());
            }
        }
    }
    
}
