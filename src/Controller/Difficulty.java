/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.Strategy.difficultyStrategy.DifficultyStrategy;
/**
 *
 * @author ADMIN
 */
public class Difficulty {
    private static DifficultyStrategy d;
    /*Set Difficulty Settings*/
    public static void setDifficulty(DifficultyStrategy diff){
        d = diff;
        CircusOfPlates.setSpeed(d.fallingSpeed()); 
        CircusOfPlates.setControlSpeed(d.controlSpeed());
        FlyweightFactoryy.setBombSpeed(d.fallingSpeed());
        FlyweightFactoryy.setPlateSpeed(d.fallingSpeed());
        PlateFactory.setPlateColors(d.plateColors());
        CircusOfPlates.setBOMBS_NUM(d.bombsNum());
        PlateFactory.setPlateSpeed(d.fallingSpeed());
        BombFactory.setBombSpeed(d.fallingSpeed() + 1);


    }
}
