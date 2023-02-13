/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Strategy.difficultyStrategy;

/**
 *
 * @author ADMIN
 */
public class HardDifficulty implements DifficultyStrategy{
   @Override
   public int fallingSpeed(){
        return 3;
    }
   @Override
    public int controlSpeed(){
        return 5;
    }
   @Override
    public int plateColors(){
        return 6; //Generate 5 plate Colors
    }
   @Override
    public int bombsNum(){
        return 6;
    }
}
