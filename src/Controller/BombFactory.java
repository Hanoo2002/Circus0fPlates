/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import model.Bombs;
import model.FlyweightObject;
import model.Shape;
import model.Strategy.MovementStrategy.MovementBehaviour;

/**
 *
 * @author Samsung
 */
public class BombFactory implements ShapeFactory {

    private static int speed;

    
    /*Creates Bombs*/
    @Override
    public Shape createMovableObject(MovementBehaviour mB) {
        String imgPath = "bomb.png";
        int x = (int) (Math.random() * SCREEN_WIDTH);
        int y = (int) (Math.random() * SCREEN_HEIGHT / 8);
        //Gets Flyweight object of Bombs
        FlyweightObject obj = FlyweightFactoryy.getFlyweightObject(imgPath, mB);
        return new Bombs(x, y, obj, speed);
    }

    public static void setBombSpeed(int bombSpeed) {
        speed = bombSpeed;
    }
}
