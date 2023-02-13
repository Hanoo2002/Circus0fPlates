/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Scanner;
import model.Strategy.MovementStrategy.MovementBehaviour;

/**
 *
 * @author Samsung
 */
public class Plates extends Shape {
    private int color; //color == imgNum
    public Plates(int x, int y, FlyweightObject o,int speed,int color) {
        super(x, y,o);
        //this.color = new Scanner(imagePath).useDelimiter("\\D+").nextInt(); 
        this.color = color;
        setSpeed(speed);
        setType(1);
    }
    
    public int getColor(){
        return color;
    }

}
