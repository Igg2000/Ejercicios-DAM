/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Nacho
 */
public class SpriteSheet {
    private BufferedImage spriteSheet;

    public SpriteSheet(String ruta) {
        try {
            spriteSheet = ImageIO.read(new File(ruta));
        } catch (IOException e) {
            // Maneja la excepción
        }
    }

    public Sprite getSprite(int x, int y, int width, int height) {
        BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
        return new Sprite(sprite, x, y, width, height);
    }
    
    public int getSpriteCount(int px) {
        return spriteSheet.getWidth() / px; // suponiendo que cada sprite tiene un ancho de 32 píxeles
    }
}