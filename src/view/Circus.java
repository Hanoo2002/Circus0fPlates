/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import Controller.MyGameController;



/**
 *
 * @author Samsung
 */
public class Circus {
    private static Circus instance;
    private static MyGameController gameController = null ;
    
    /**
     * @param args the command line arguments
     */
    private Circus(){
        
    }
    
    public static Circus getCircus(){
        if (instance == null) {
            instance = new Circus();
        }
        return instance;
    }
    
    public void init(){

            gameController = MyGameController.getGameController();
            gameController.start();
            
        }
        
    }

    

