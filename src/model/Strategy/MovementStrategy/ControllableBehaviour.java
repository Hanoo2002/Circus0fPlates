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
Movment Behaviour for Controllable object
*/
public class ControllableBehaviour implements MovementBehaviour {
    @Override
    public int setX(int x) {
        return x;
    }
    /*
    No Motion in vertical axis
    */
    @Override
    public int setY(int y) {
        return -1;
    }
    
    
}
