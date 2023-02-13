/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.State;
import Controller.CircusOfPlates;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
/**
 *
 * @author ADMIN
 */
public class PlayingState extends State{
    
    public PlayingState(GameController controller){
        super(controller);
    }
    
    public void run(){
        
        currentState = this;
        //System.out.println("running");
        if(wasPaused == true){
            controller.resume(); 
            wasPaused = false;
            CircusOfPlates.incTotalPauseTime(System.currentTimeMillis() - CircusOfPlates.getPauseTime());
        }
        //play music
        
    }
     
}
