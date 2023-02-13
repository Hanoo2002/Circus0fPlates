/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import model.FlyweightObject;
import model.Shape;
import model.Plates;
import model.Strategy.MovementStrategy.MovementBehaviour;

/**
 *
 * @author Samsung
 */
public class PlateFactory implements ShapeFactory {

    private int min = 1;
    private static int speed ;
    private static int plateColors; //num of different plate colors

    public static void setPlateSpeed(int x) {
        speed = x;
    }
    public static void setPlateColors(int x){
        plateColors = x;
    }

    /*
    Create a plate at a random position using 
    */
    @Override
    public Shape createMovableObject(MovementBehaviour mB) {
        int imgNum = (int) ((Math.random() * (plateColors - min)) + min); //num corresponding to color
        String imgPath = "plateee" + imgNum + ".png";
        int x = (int) (Math.random() * SCREEN_WIDTH);
        int y = (int) (Math.random() * SCREEN_HEIGHT/ 8);
        FlyweightObject obj = FlyweightFactoryy.getFlyweightObject(imgPath, mB);
        return new Plates(x, y, obj, speed, imgNum);
    }

}
