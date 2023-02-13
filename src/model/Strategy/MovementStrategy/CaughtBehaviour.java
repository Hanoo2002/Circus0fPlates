/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Strategy.MovementStrategy;

import eg.edu.alexu.csd.oop.game.GameObject;
/**
 *
 * @author sophi
 */
/*
Movement Behaviour for Caught Objects
*/
public class CaughtBehaviour implements MovementBehaviour {
    private GameObject controller;
    public CaughtBehaviour(GameObject controller){
        this.controller=controller;
    }

    
    @Override
    public int setX(int x) {
        return controller.getX();
    }
    
    /*
    Doensn't move in vertical axis 
    */
    @Override
    public int setY(int y) {
        return -1;
    }   
}