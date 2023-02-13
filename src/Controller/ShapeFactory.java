/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.Shape;
import model.Strategy.MovementStrategy.MovementBehaviour;

/**
 *
 * @author Samsung
 */
/*
Shape Fcatory Interface 
*/
public interface ShapeFactory {

    public Shape createMovableObject(MovementBehaviour mB);

}
