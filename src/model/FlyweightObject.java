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
public class FlyweightObject {
    private String imgPath;
    private MovementBehaviour mB;

    public FlyweightObject(String imgPath, MovementBehaviour mB){
    this.imgPath=imgPath;
    this.mB=mB;
    }
    
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public MovementBehaviour getmB() {
        return mB;
    }

    public void setmB(MovementBehaviour mB) {
        this.mB = mB;
    }
    
    
}
