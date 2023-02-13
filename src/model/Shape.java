/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import model.Strategy.MovementStrategy.MovementBehaviour;

/**
 *
 * @author Samsung
 */
public abstract class Shape extends ImageObject {
    
    private int speed;

    public Shape(int x, int y, FlyweightObject o) {
        super(x, y, o.getImgPath(),o.getmB());
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {
        setY((getY() + getSpeed()));//move Down
        if (getY() == SCREEN_HEIGHT) {
            setY(-1 * (int) (Math.random() * SCREEN_HEIGHT /2));
            setX((int) (Math.random() * SCREEN_WIDTH-10));

        }
    }
    
    public void reset(){
         setY((int) (Math.random() * SCREEN_HEIGHT / 8));
         setX((int) (Math.random() * SCREEN_WIDTH-10));
    }
}
