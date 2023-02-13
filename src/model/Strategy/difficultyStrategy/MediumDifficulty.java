/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Strategy.difficultyStrategy;

/**
 *
 * @author ADMIN
 */
public class MediumDifficulty implements DifficultyStrategy{
    @Override
    public int fallingSpeed(){
        return 2;
    }
    @Override
    public int controlSpeed(){
        return 10;  //Clown Speed
    }
    @Override
    public int plateColors(){
        return 4; //Generate 3 plate Colors
    }
    @Override
    public int bombsNum(){
        return 4;
    }
}
