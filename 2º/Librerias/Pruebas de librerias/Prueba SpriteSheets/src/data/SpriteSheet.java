/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage img;
    private int frameWidth, frameHeight;
    private int rows, cols;

    public SpriteSheet(BufferedImage img, int rows, int cols) {
        this.img = img;
        this.rows = rows;
        this.cols = cols;
        this.frameWidth = img.getWidth() / cols;
        this.frameHeight = img.getHeight() / rows;
    }

    public BufferedImage getSprite(int frame, int row) {
        return img.getSubimage(frame * frameWidth, row * frameHeight, frameWidth, frameHeight);
    }

    public int getNumFramesPerRow() {
        return cols;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }
}
