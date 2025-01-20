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

public class Sprite {
    private SpriteSheet sheet;
    private BufferedImage image;
    private int currentFrame = 0;
    private int currentRow = 0;

    public Sprite(SpriteSheet sheet, int x, int y) {
        this.sheet = sheet;
        this.image = sheet.getSprite(x, y);
    }
    
    public Sprite(SpriteSheet sheet) {
        this.sheet = sheet;
        this.image = sheet.getSprite(0, 0);
    }

    public BufferedImage getBufferedImage() {
        return image;
    }

    public void updateFrame(int frame, int row) {
        this.currentFrame = frame;
        this.currentRow = row;
        this.image = sheet.getSprite(frame, row);
    }

    public SpriteSheet getSheet() {
        return sheet;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public BufferedImage getImage() {
        return image;
    }
    
    
}
