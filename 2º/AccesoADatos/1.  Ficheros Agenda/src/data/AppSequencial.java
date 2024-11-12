/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import data.Contacto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class AppSequencial {

    public AppSequencial() {
        run();
    }
    

    private void run(){
        List<Contacto> contactos = new ArrayList();
        
        File archivo = new File(".//src//res//agendaSequencial.txt"); 

        leemeElFicheroYCreameContactos(archivo,contactos);
        
        String nombre = JOptionPane.showInputDialog("Elige el nombre del contacto");
        int numero= Integer.parseInt(JOptionPane.showInputDialog("Elige el numero de telefono"));
        
        agregarContacto(archivo,contactos,new Contacto(nombre,numero));
        
        System.out.println(contactos);

    }

    private void leemeElFicheroYCreameContactos(File archivo, List<Contacto> contactos) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Separar cada línea por el separador de campos ':'
                    String[] campos = line.split(":");

                    // Asegúrate de que hay suficientes campos
                    if (campos.length == 3) {
                        int id = Integer.parseInt(campos[0].trim());
                        String nombre = campos[1].trim();
                        int telefono = Integer.parseInt(campos[2].trim());

                        // Crea un nuevo contacto y añádelo a la lista
                        contactos.add(new Contacto(nombre, telefono));
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ha habido un error al leer el fichero");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en el formato: " + e.getMessage());
            }
    }

    public void agregarContacto(File archivo, List<Contacto> contactos, Contacto nuevoContacto) {
        //el true de fileWriter significa que va a hacer append,
        //es decir que no va a sobrescribir el archivo sino añadir al final
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            // Formatear el nuevo contacto como una cadena
            String contactoStr = nuevoContacto.getId() + ":" + nuevoContacto.getNombre() + ":" + nuevoContacto.getTelefono();
            // Escribir el contacto en el archivo
            bw.newLine();
            bw.write(contactoStr);
            contactos.add(nuevoContacto);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al agregar el contacto");
        }
    }

}
