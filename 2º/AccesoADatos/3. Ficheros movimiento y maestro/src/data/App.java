/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Metodos.SerializadorDeObjetos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class App implements Runnable {

    File ficheroMaestro;
    File ficheroMovimientos;
    
    public App() {
        ficheroMaestro= new File(".//src//res//Maestro.txt");
        ficheroMovimientos= new File(".//src//res//Movs.txt");
        
        crearFicheroSiNoExiste(ficheroMaestro);
        crearFicheroSiNoExiste(ficheroMovimientos);
    }

    @Override
    public void run() {
        datosDePrueba();
    }

    private void datosDePrueba() {
        //agregarDatosMovimiento('A',ficheroMovimientos,new Persona(1, "Antonio", "Perez", 20));
        //agregarDatosMovimiento('A',ficheroMovimientos,new Persona(2, "Paco", "Pepe", 25));
        //agregarDatosMovimiento('M',ficheroMovimientos,new Persona(2, "Paco", "Pepito", 25));
        //agregarDatosMovimiento('E',ficheroMovimientos,new Persona(2, "Paco", "Pepito", 25));
        
        //actualizarFicheroMaestro(ficheroMovimientos);

        
        leerFicheroMaestro();
    }

    /**
     * 
     * @param caracter El caracter debe ser 'A' 'E' o 'M'
     * A para añadir, E para eliminar, M para modificar
     * @param ficheroMovimientos
     * @param persona 
     */
    private void agregarDatosMovimiento(char caracter, File ficheroMovimientos, Persona persona) {
        
        try {
            FileWriter fw = new FileWriter(ficheroMovimientos,true);
            
            fw.write(caracter+":" + persona.getId() + ":");
            fw.write(persona.getNombre() + ":");
            fw.write(persona.getApellido() + ":");
            fw.write(persona.getEdad()+"*\n");

            fw.close();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "no se encuentra el fichero de movimientos");
        }
        
    }
    
        private void actualizarFicheroMaestro(File ficheroMovimientos) {
            
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(ficheroMovimientos));
                

            String linea;
            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Verificar que la línea no esté vacía
                if (!linea.trim().isEmpty()) {
                    // Obtener el primer carácter de la línea para hacer un switch
                    char primerCaracter = linea.charAt(0);

                    // Usar switch para actuar dependiendo del primer carácter
                    switch (primerCaracter) {
                        case 'A':
                            añadirAFicheroMaestro(linea);
                            break;
                        case 'M':
                            modificarPersonaEnFicheroMaestro(linea);
                            break;
                        case 'E':
                            eliminarPersonaDeFicheroMaestro(linea);
                            break;
                        default:
                            System.out.println("Tipo no reconocido: " + primerCaracter);
                            break;
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se puede leer el fichero de movimientos");
            return;
        }
        
        //como ya se ha actualizado el archivo maestro
        //borro el archivo y lo vuelvo a crear
        try {
            this.ficheroMovimientos.delete();
            this.ficheroMovimientos.createNewFile();
        } catch (IOException ex) {
            System.out.println("No se ha podido borrar y volver a crear el fichero de movimientos");
        }
    }

    
    private void añadirAFicheroMaestro(String linea) {
        
        // Eliminar el carácter '*' final de la línea
        linea = linea.replace("*", "");
        
        // Dividir la línea usando ":" como delimitador
        String[] partes = linea.split(":");
        
        if (partes.length == 5) {
            int id = Integer.parseInt(partes[1]); // El id está en la segunda posición
            String nombre = partes[2];            // El nombre está en la tercera
            String apellido = partes[3];          // El apellido está en la cuarta
            int edad = Integer.parseInt(partes[4]); // La edad está en la quinta

            // Crear la persona y mostrarla (o agregarla a una lista)
            Persona persona = new Persona(id, nombre, apellido, edad);
            try {
                SerializadorDeObjetos.escribirBinario(persona, ficheroMaestro);
            } catch (IOException ex) {
                System.out.println("no se ha podido serializar a binario a la persona: "+persona);
            }
        }
    }

    
    private void modificarPersonaEnFicheroMaestro(String linea) {
        // Eliminar el carácter '*' final de la línea
        linea = linea.replace("*", "");
        
        // Dividir la línea usando ":" como delimitador
        String[] partes = linea.split(":");
        
        if (partes.length == 5) {
            int id = Integer.parseInt(partes[1]); // El id está en la segunda posición
            String nombre = partes[2];            // El nombre está en la tercera
            String apellido = partes[3];          // El apellido está en la cuarta
            int edad = Integer.parseInt(partes[4]); // La edad está en la quinta

            // Crear la persona y mostrarla (o agregarla a una lista)
            Persona persona = new Persona(id, nombre, apellido, edad);
            
            try {
                List<Persona> personas = SerializadorDeObjetos.leerBinario(ficheroMaestro, Persona.class);
                modificarPersona(personas,persona);
                
                //una vez modificada la persona borro el archivo y lo vuelvo a crear
                ficheroMaestro.delete(); //por algun motivo esto no esta funcionando
                ficheroMaestro.createNewFile();
                //una vez vacio le meto todas las personas de nuevo
                //no lo hago con mi libreria porque mi libreria hace un append
                try (FileOutputStream fos = new FileOutputStream(ficheroMaestro);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    for (Persona p : personas) {
                        oos.writeObject(p);
                    }
                }
                
            } catch (ClassNotFoundException ex) {
                System.out.println("error al leer en el fichero maestro para modificar");
                
            } catch (Exception ex) {
                //la persona no está en la lista
                System.out.println(ex.getMessage());
            }
        }
    }

    private void eliminarPersonaDeFicheroMaestro(String linea) {
        // Eliminar el carácter '*' final de la línea
        linea = linea.replace("*", "");
        
        // Dividir la línea usando ":" como delimitador
        String[] partes = linea.split(":");
        
        if (partes.length == 5) {
            int id = Integer.parseInt(partes[1]); // El id está en la segunda posición
            String nombre = partes[2];            // El nombre está en la tercera
            String apellido = partes[3];          // El apellido está en la cuarta
            int edad = Integer.parseInt(partes[4]); // La edad está en la quinta

            // Crear la persona y mostrarla (o agregarla a una lista)
            Persona persona = new Persona(id, nombre, apellido, edad);
            
            try {
                List<Persona> personas = SerializadorDeObjetos.leerBinario(ficheroMaestro, Persona.class);
                eliminarPersona(personas,persona);
                
                //una vez modificada la persona borro el archivo y lo vuelvo a crear
                ficheroMaestro.delete(); //por algun motivo esto no esta funcionando
                ficheroMaestro.createNewFile();
                //una vez vacio le meto todas las personas de nuevo
                //no lo hago con mi libreria porque mi libreria hace un append
                try (FileOutputStream fos = new FileOutputStream(ficheroMaestro);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    for (Persona p : personas) {
                        oos.writeObject(p);
                    }
                }
                
            } catch (ClassNotFoundException ex) {
                System.out.println("error al leer en el fichero maestro para modificar");
                
            } catch (Exception ex) {
                //la persona no está en la lista
                System.out.println(ex.getMessage());
            }
        }
    }

    private void crearFicheroSiNoExiste(File fichero) {
        //Si el archivo no existe, se crea automáticamente
        if (!fichero.exists()) {
            try {
                fichero.createNewFile(); // Crea el archivo si no existe
            } catch (IOException ex) {
                System.out.println("No se ha podido crear el archivo"+fichero.getName());
            }
            System.out.println("El archivo "+fichero.getName()+" no existía, se ha creado.");
        } else {
            System.out.println("El archivo "+fichero.getName()+" ya existe.");
        }
    }

    private void leerFicheroMaestro() {
        try {
            List<Persona> personas = SerializadorDeObjetos.leerBinario(ficheroMaestro, Persona.class);
            System.out.println(personas);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarPersona(List<Persona> personas, Persona persona) throws Exception {
        //persona es la persona ya modificada y personas es la lista de personas que hay en el fichero
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == persona.getId()) {
                // Reemplazar directamente el objeto en la lista
                personas.set(i, persona);
                return;
            }
        }
        //si ha llegado aqui significa que no se ha encontrado a la persona
        throw new Exception("La persona que se quiere modificar no está en la lista");
    }

    private void eliminarPersona(List<Persona> personas, Persona persona) throws Exception {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == persona.getId()) {
                // Borrar el objeto en la lista
                personas.remove(i);
                return;
            }
        }
        //si ha llegado aqui significa que no se ha encontrado a la persona
        throw new Exception("La persona que se quiere eliminar no está en la lista");
    }
    
}
