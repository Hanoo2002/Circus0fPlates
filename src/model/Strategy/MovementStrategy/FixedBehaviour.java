/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Strategy.MovementStrategy;

/**
 *
 * @author sophi
 */
/*
Fixed Behaviour for Controllable object
*/
public class FixedBehaviour implements MovementBehaviour {
    /*
    No Motion in Horizontal axis
    */
    @Override
    public int setX(int x) {
        return -1;
    }
    /*
    No Motion in vertical axis
    */
    @Override
    public int setY(int y) {
        return -1;
    }
}
