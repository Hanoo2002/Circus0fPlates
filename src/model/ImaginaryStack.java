/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.Stack;
import javax.imageio.ImageIO;
import model.Strategy.MovementStrategy.MovementBehaviour;

/**
 *
 * @author sophi
 */
public class ImaginaryStack extends Stack<GameObject> implements GameObject {
    private Point position;
    private int height;
    private MovementBehaviour mB;
    private int minBorder,maxBorder;

    public ImaginaryStack(int x , int y , MovementBehaviour mB , int minBorder , int maxBorder) {
        this.position = new Point (x,y);
        height =0;
        this.mB=mB;
        this.minBorder=minBorder;
        this.maxBorder=maxBorder;
    }

    public int getMinBorder() {
        return minBorder;
    }

    public void setMinBorder(int minBorder) {
        this.minBorder = minBorder;
    }

    public int getMaxBorder() {
        return maxBorder;
    }

    public void setMaxBorder(int maxBorder) {
        this.maxBorder = maxBorder;
    }

    
    public Point getPosition() {
        return position;
    }

    public void setPosition(int x , int y) {
        position.setLocation(x, y);
    }

    @Override
    public int getHeight() {
        return height;
    }
    
    public int getImageHeight() {
       return 18;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public MovementBehaviour getmB() {
        return mB;
    }

    public void setmB(MovementBehaviour mB) {
        this.mB = mB;
    }
    
    public boolean intersect (GameObject o){
        boolean x = abs((o.getX() + o.getWidth()/2) -(position.x))<=o.getWidth();
        boolean y = abs((o.getY() + o.getHeight()/2)-(position.y-height))<=(o.getHeight());
        if(x&&y){
            this.setHeight(this.getHeight()+o.getHeight());
        }
        return x&&y;
    }
    
    @Override
    public int getX() {
        return position.x;
    }

    @Override
    public void setX(int x) {
        int z = mB.setX(x);
        if ((z > 0)&&(z>=minBorder)&&(z<maxBorder)) {
            this.setPosition(z, this.getY());
        }
    }

    @Override
    public int getY() {
        return position.y;
    }

    @Override
    public void setY(int y) {
        int z = mB.setY(y);
        if (z > 0) {
            this.setPosition(this.getX(),z);
        }
    }

    @Override
    public int getWidth() {
        return 23;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        try {
            BufferedImage[] spriteImages = {ImageIO.read(getClass().getClassLoader().getResourceAsStream("r4.png"))};
            return spriteImages;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
        }  
}
