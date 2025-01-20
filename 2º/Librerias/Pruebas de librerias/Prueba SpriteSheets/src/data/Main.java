/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
import GUI.GamePanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sprite Movement");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Cargar la imagen del spritesheet
        BufferedImage spriteSheetImage = null;
        try {
            //spriteSheetImage = ImageIO.read(new File(".//src//res//SS.jpeg"));
            //spriteSheetImage = ImageIO.read(new File(".//src//res//SS1.png"));
            spriteSheetImage = ImageIO.read(new File(".//src//res//SS2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear el spritesheet y el sprite
        //SpriteSheet spriteSheet = new SpriteSheet(spriteSheetImage,4, 6); // Asumiendo 4 filas de frames y 6 frames por fila
        //SpriteSheet spriteSheet = new SpriteSheet(spriteSheetImage,4, 9); // Asumiendo 4 filas de frames y 9 frames por fila
        SpriteSheet spriteSheet = new SpriteSheet(spriteSheetImage,4, 12); // Asumiendo 4 filas de frames y 12 frames por fila
        Sprite sprite = new Sprite(spriteSheet, 0, 0);
        Player player = new Player(sprite, 100, 100,100,200);

        GamePanel gamePanel = new GamePanel(player);
        frame.add(gamePanel);
        frame.addKeyListener(new GameKeyListener(player));

        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.update();
            }
        });
        timer.start();

        frame.setVisible(true);
    }
}
