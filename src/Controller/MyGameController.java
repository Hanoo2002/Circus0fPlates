/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.State.GameOverState;
import Controller.State.PausedState;
import Controller.State.PlayingState;
import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import eg.edu.alexu.csd.oop.game.GameEngine;
import view.MainMenuView;

/**
 *
 * @author ADMIN
 */
/*
Controller to pause , play , make new game and return to main menu
 */
public class MyGameController {

    private static MyGameController instance = null;
    private static GameController gameController;
    private JFrame gameFrame;

    public static void setGameController(GameController Controller) {
        gameController = Controller;
    }

    private MyGameController() {

    }

    public static MyGameController getGameController() {
        if (instance == null) {
            instance = new MyGameController();
        }
        return instance;

    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        JMenuItem MainMenuItem = new JMenuItem("Main Menu");
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menu.add(MainMenuItem);
        menuBar.add(menu);

        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.dispose();
                CircusOfPlates.setCurrentState(new GameOverState(gameController));
                start();
                CircusOfPlates.setCurrentState(new PlayingState(gameController));

            }
        });
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CircusOfPlates.setCurrentState(new PausedState(gameController));
            }
        });
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CircusOfPlates.setCurrentState(new PlayingState(gameController));
            }
        });
        MainMenuItem.addActionListener(new ActionListener() { //for testing only
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenuView.getMainMenu().setVisible(true);
                CircusOfPlates.setCurrentState(new GameOverState(gameController));
                gameFrame.dispose();
            }
        });

        return menuBar;
    }

    /*
    Launch Game and control Navigation
     */
    public void start() {
        JMenuBar menuBar = createMenuBar();
        this.gameController = GameEngine.start("Circus of Plates Game", new CircusOfPlates(SCREEN_WIDTH, SCREEN_HEIGHT), menuBar, Color.RED);
        this.gameFrame = (JFrame) menuBar.getParent().getParent().getParent();
        CircusOfPlates.setTotalPauseTime(0);
        CircusOfPlates.setPauseTime(0);
        gameFrame.setDefaultCloseOperation(gameFrame.DO_NOTHING_ON_CLOSE);
        this.gameFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(gameFrame, "Are you sure you want to close this game?",
                        "End Game?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    gameFrame.dispose();
                    MainMenuView.getMainMenu().setVisible(true);
                    CircusOfPlates.setCurrentState(new GameOverState(gameController));
                }

            }
        });
    }

    public JFrame getGameFrame() {
        return gameFrame;
    }

}
