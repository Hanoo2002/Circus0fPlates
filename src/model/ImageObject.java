/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.Strategy.MovementStrategy.MovementBehaviour;

/**
 *
 * @author sophi
 */
public class ImageObject implements GameObject {

    private static final int ANIMATION_NUM = 1;

    private BufferedImage[] spriteImages;
    private int x;
    private int y;
    private boolean visible;
    private int type;
    private MovementBehaviour mB;

    public ImageObject(int x, int y, String imagePath, MovementBehaviour mB) {
        this(x, y, 0, imagePath, mB); //type 0 = Not moving object
    }

    public ImageObject(int x, int y, int type, String imageName, MovementBehaviour mB) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.spriteImages = new BufferedImage[ANIMATION_NUM];
        this.visible = true;
        this.mB = mB;

        try {
            spriteImages[0] = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
//        this.x = x;
        int z = mB.setX(x);
        if (z > 0) {
            this.x = z;
        }

    }

    @Override
    public void setY(int y) {
//        this.y = y;
        int z = mB.setY(y);
        if (z > 0) {
            this.y = z;
        }
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    public MovementBehaviour getmB() {
        return mB;
    }

    public void setmB(MovementBehaviour mB) {
        this.mB = mB;
    }
}
