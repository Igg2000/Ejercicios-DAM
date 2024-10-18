/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Imagenes;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Nacho
 */
public class Imagenes {
    
    /**
     * Esta funcion recibe la ruta de una imagen, la lee, y te devuelve la imagen
     * @param rutaImagen ruta que tiene la imagen
     * @return la propia imagen
     * @throws IOException Excepcion que devuelve en caso
     * de que no pueda cargar la imagen
     */
    private Image leerImagen(String rutaImagen) throws IOException {
        
        File archivoImagen = new File(rutaImagen);
        BufferedImage imagen = null;
        imagen = ImageIO.read(archivoImagen);
        return imagen;
    }
}
