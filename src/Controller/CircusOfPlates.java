/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.State.PausedState;
import Controller.State.State;
import model.Strategy.MovementStrategy.ControllableBehaviour;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import model.ImageObject;
import model.ImaginaryStack;
import model.Shape;
import model.Plates;
import model.Strategy.MovementStrategy.FixedBehaviour;
import model.Strategy.MovementStrategy.MovementBehaviour;
import model.Strategy.MovementStrategy.MovingBehaviour;
import model.Strategy.MovementStrategy.CaughtBehaviour;

/**
 *
 * @author Samsung
 */
/* Game World*/
public class CircusOfPlates implements World {

    private static final int MAX_TIME = 10 * 60 * 100; // 1 minute (Game Timer)
    private static int DEFAULT_SPEED = 10;
    private static int DEFAULT_CONTROL_SPEED = 20;
    private static final int NUM_OF_MOVING_OBJ = 5;
    private static int BOMBS_NUM;
    private static long pauseTime = 0;
    private static long totalPauseTime = 0;
    private final long startTime;
    private int score;

    private final int width;
    private final int height;

    private List<GameObject> constant;
    private List<GameObject> moving;
    private List<GameObject> control;
    private static State currentState;

    ShapeFactory mof = new PlateFactory();
    ShapeFactory bof = new BombFactory();
    MovementBehaviour mB = new MovingBehaviour();
    MovementBehaviour fB = new FixedBehaviour();
    MovementBehaviour cB = new ControllableBehaviour();

    public static long getPauseTime() {
        return pauseTime;
    }

    public static void setTotalPauseTime(long totalPauseTime) {
        CircusOfPlates.totalPauseTime = totalPauseTime;
    }

    public static void incTotalPauseTime(long totalPauseTime) {
        CircusOfPlates.totalPauseTime += totalPauseTime;
    }

    public static void setPauseTime(long pause) {
        pauseTime = pause;
    }

    public static void setBOMBS_NUM(int BOMBS_NUM) {
        CircusOfPlates.BOMBS_NUM = BOMBS_NUM;
    }

    public CircusOfPlates(int width, int height) {
        this.width = width;
        this.height = height;

        this.startTime = System.currentTimeMillis();
        this.score = 0;

        this.constant = new LinkedList<>();
        this.moving = new LinkedList<>();
        this.control = new LinkedList<>();

        createGameObject();
    }

    private void createGameObject() {
        //Add backgroud

        constant.add(new ImageObject(score, score, "circus2.jpg", fB));
        //Add control objects (Clown and stacks)
        ImageObject clown = new ImageObject(width / 3, (int) (height * 0.65), "clownwithsticks2.png", cB);
        control.add(clown);
        GameObject rStack = new ImaginaryStack(0, 0, cB, 0, 0);
        GameObject lStack = new ImaginaryStack(0, 0, cB, 0, 0);
        ((ImaginaryStack) rStack).setPosition(clown.getX() + (clown.getWidth()) - 27, clown.getY() + 8);
        ((ImaginaryStack) lStack).setPosition(clown.getX() + 1, clown.getY() + 2);

        ((ImaginaryStack) lStack).setMinBorder(7);
        ((ImaginaryStack) lStack).setMaxBorder(width - (clown.getWidth() - 13));
        ((ImaginaryStack) rStack).setMinBorder((clown.getWidth()) - 15 - 7);
        ((ImaginaryStack) rStack).setMaxBorder(width - 26);
        control.add(lStack);
        control.add(rStack);
        //Add moving Objects(Plates and Bombs)
        for (int i = 0; i < NUM_OF_MOVING_OBJ; i++) {
            generatePlate(mB);
        }
        for (int i = 0; i < BOMBS_NUM; i++) {
            generateBomb(mB);
        }

    }

    @Override
    public List<GameObject> getConstantObjects() {
        return this.constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return this.moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return this.control;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    /*Check intersection of falling objects with Comtrable objects*/
    public void intersected(GameObject o, ImaginaryStack s, Iterator itr) {
        switch (((ImageObject) o).getType()) {
            case 1:
                int color = ((Plates) o).getColor();
                if (!s.isEmpty()) {
                    if (((Plates) s.peek()).getColor() == color) {
                        ImageObject temp1 = (ImageObject) s.pop();
                        //check if there are 3 plates in same color and removes them
                        if (!s.isEmpty()) {
                            if (((Plates) s.peek()).getColor() == color) {
                                ImageObject temp2 = (ImageObject) s.pop();
                                control.remove(temp1);
                                control.remove(temp2);
                                control.remove(o);
                                ((ImageObject) o).setVisible(false);
                                s.setHeight(s.getHeight() - 3 * o.getHeight());
                                score = score + 3;
                                break;
                            } else {
                                s.push(temp1);
                            }
                        } else {
                            s.push(temp1);
                        }

                    }
                }
                o.setX(s.getX() + s.getWidth() / 2 - o.getWidth() / 2);
                o.setY(s.getY() - s.getHeight());
                //changes object from falling object to controlable object
                ((ImageObject) o).setmB(new CaughtBehaviour(s));
                s.push(o);
                control.add(o);
                itr.remove();
                break;
            case 2:
                //It object is bomb plates disappear and bomb is generated elswhere
                ((Shape) o).reset();
                Iterator i1 = s.iterator();
                while (i1.hasNext()) {
                    ImageObject obj = (ImageObject) s.pop();
                    obj.setVisible(false);
                }
                if (score > 0) {
                    score--;
                }
                s.setHeight(0);

                break;
        }
    }

    @Override
    public boolean refresh() {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME; // time end and game over
        for (GameObject o : moving) {
            Shape obj = (Shape) o;
            obj.move();
        }
        Iterator itr = moving.iterator();
        ImaginaryStack s1 = (ImaginaryStack) control.get(1);
        ImaginaryStack s2 = (ImaginaryStack) control.get(2);
        int caughtOrBombed = 0;
        while (itr.hasNext()) {
            GameObject o = (GameObject) itr.next();
            if (!timeout && o.isVisible()) {
                if (s1.intersect(o)) {
                    intersected(o, s1, itr);
                    caughtOrBombed++;
                } else if (s2.intersect(o)) {
                    intersected(o, s2, itr);
                    caughtOrBombed++;

                } else if (o.getY() > height) {
                    // reuse the plate in another position
                     ((Shape)o).reset();
                     ((ImageObject) o).setVisible(true);
                }
            }
        }
        //Generate new Bombs and plates as the game is working
        for (int i = 0; i < caughtOrBombed; i++) {
            generatePlate(mB);
        }
        for (int i = 0; i < caughtOrBombed / 5; i++) {
            generateBomb(mB);
        }
        return !timeout;
    }

    @Override
    public String getStatus() {
        if (currentState instanceof PausedState) {
            return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (pauseTime - startTime)) / 1000);
        }
        return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime - totalPauseTime)) / 1000);
        // update status
    }

    public static void setSpeed(int DEFAULT_SPEED) {
        CircusOfPlates.DEFAULT_SPEED = DEFAULT_SPEED;
    }

    public static void setControlSpeed(int DEFAULT_CONTROL_SPEED) {
        CircusOfPlates.DEFAULT_CONTROL_SPEED = DEFAULT_CONTROL_SPEED;
    }

    @Override
    public int getSpeed() {
        return DEFAULT_SPEED;
    }

    @Override
    public int getControlSpeed() {
        return DEFAULT_CONTROL_SPEED;
    }

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State state) {
        currentState = state;
        currentState.run();
    }

    private void generatePlate(MovementBehaviour mB) {
        moving.add(mof.createMovableObject(mB));
    }

    private void generateBomb(MovementBehaviour mB) {
        moving.add(bof.createMovableObject(mB));
    }

}
