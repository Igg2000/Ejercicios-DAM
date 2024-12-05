package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Nacho
 */
public class ImagenObstaculo extends Rectangle {
    private Image imagen;

    public ImagenObstaculo(int x, int y, int width, int height) {
        super(x, y, width, height);

        try {
            // Cargar la imagen desde el archivo
            imagen = ImageIO.read(new File(".//src//res//obstaculo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la imagen obstaculo.png");
        }
    }

    public void pintar(Graphics g) {
        if (imagen != null) {
            // Dibujar la imagen escalada al tamaño del rectángulo
            g.drawImage(imagen, x, y, width, height, null);
        } else {
            // Si no carga la imagen se dibuja un rectangulo rojo
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
        }
    }
}
