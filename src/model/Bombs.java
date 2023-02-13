/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Strategy.MovementStrategy.MovementBehaviour;



/**
 *
 * @author Samsung
 */
public class Bombs extends Shape{
    public Bombs(int x, int y, FlyweightObject o,int speed ) {
        super(x, y,o);
        setSpeed(speed);
        setType(2);
    }
}
