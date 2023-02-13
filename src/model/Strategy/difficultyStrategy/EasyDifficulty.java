/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Strategy.difficultyStrategy;

/**
 *
 * @author ADMIN
 */
public class EasyDifficulty implements DifficultyStrategy{

    @Override
    public int fallingSpeed(){
        return 1; 
    }
    @Override
    public int controlSpeed(){
        return 20; //speed of Clown 
    }
    @Override
    public int plateColors(){
        return 3; //to generate to plate colors
    }
    @Override
    public int bombsNum(){
        return 3;
    }
}
