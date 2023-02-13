/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.State;
import Controller.CircusOfPlates;
import Controller.MyGameController;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
/**
 *
 * @author ADMIN
 */
public class PausedState extends State{
    //GameEngine.GameController controller = Controller.GameController.get
    public PausedState(GameController controller){
        super(controller);
    }
    
    public void run(){
        //MyGameController.getGameController().pause();
        wasPaused = true;
        currentState = this;
        //System.out.println(wasPaused);
        controller.pause();
        CircusOfPlates.setPauseTime(System.currentTimeMillis());
        
        //play music here
    }
    
}
