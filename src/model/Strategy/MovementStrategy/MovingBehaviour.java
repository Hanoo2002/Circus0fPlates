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
Movement of object that is not controlled
*/
public class MovingBehaviour implements MovementBehaviour {
    @Override
    public int setX(int x) {
        return x;
    }

    @Override
    public int setY(int y) {
        return y;
    }
}