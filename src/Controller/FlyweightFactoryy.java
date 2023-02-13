/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.HashMap;
import model.FlyweightObject;
import model.Strategy.MovementStrategy.MovementBehaviour;

/**
 *
 * @author Samsung
 */
public class FlyweightFactoryy {

    private static final HashMap<String, FlyweightObject> objectsMap = new HashMap();
    private static int plateSpeed;
    private static int bombSpeed;

    
    /*Returns flyweight object containing imgPath and moving Behaviour
    Creates New object if it doesn't exist
    */
    public static FlyweightObject getFlyweightObject(String imgPath, MovementBehaviour mB) {
        FlyweightObject object = null;

        if (objectsMap.containsKey(imgPath)) {
            object = objectsMap.get(imgPath);
        } else {
            if ("bomb.png".equals(imgPath)) {
                object = new FlyweightObject(imgPath, mB);
            } else { //plate
                object = new FlyweightObject(imgPath, mB);
            }

        }
        objectsMap.put(imgPath, object);
        return object;
    }

    public static void setPlateSpeed(int Speed) {
        plateSpeed = Speed;
    }

    public static void setBombSpeed(int Speed) {
        bombSpeed = Speed;
    }

    public static int getPlateSpeed() {
        return plateSpeed;
    }

    public static int getBombSpeed() {
        return bombSpeed;
    }

}
