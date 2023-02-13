/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.State;
import Controller.CircusOfPlates;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import Controller.MyGameController;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class GameOverState extends State{
    public GameOverState(GameController controller)
    {
        super(controller);
    }
    public void run(){
       
        wasPaused = false;
        CircusOfPlates.setTotalPauseTime(0);
        CircusOfPlates.setPauseTime(0);

        //play music here
    }
}
