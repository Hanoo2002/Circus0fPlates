/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.State;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
/**
 *
 * @author ADMIN
 */
public abstract class State {
    protected GameController controller;
    static boolean wasPaused = false;
    protected static State currentState;
    
    public State(GameController controller){
        this.controller = controller;
    }
    
    public State getCurrentState(){
        return currentState;
    }
    public void setCurrentState(State state){
        this.currentState = state;
    }
    
    public abstract void run();
}
