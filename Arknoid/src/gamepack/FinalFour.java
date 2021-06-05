package gamepack;

import backgroundpack.FinalFourBackground;
import ballpack.Velocity;
import blockpack.Block;
import geomatricprimitive.Point;
import geomatricprimitive.Rectangle;
import interfacespack.HitListener;
import interfacespack.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FinalFour implements LevelInformation {
    //fields
    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;
    //constructor

    /**
     * Function Name:Green3Level.
     * Function Operation:constructor
     ***/
    public FinalFour() {
        this.numberOfBalls = 3;
        this.initialBallVelocities = new ArrayList<Velocity>();
        this.paddleSpeed = 3;
        this.paddleWidth = 80;
        this.levelName = "Final four";
        this.blocks = new ArrayList<Block>();
        this.numberOfBlocksToRemove = 105;
    }

    /**
     * Function Name:numberOfBalls.
     * Function Operation: return the number Of Balls
     *
     * @return number of balls
     ***/
    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    /**
     * Function Name:initialBallVelocities.
     * Function Operation:return The initial velocity of each ball
     *
     * @return list of balls velocities
     ***/
    @Override
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < 3; i++) {
            this.initialBallVelocities.add(new Velocity(0, -3));
        }
        return this.initialBallVelocities;
    }

    /**
     * Function Name:paddleSpeed.
     * Function Operation:return the paddle Speed
     *
     * @return paddle Speed
     ***/
    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    /**
     * Function Name:paddleWidth.
     * Function Operation:return the paddle Width
     *
     * @return Width
     ***/
    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    /**
     * Function Name:levelName.
     * Function Operation:the level name will be displayed at the top of the screen.
     ***/
    @Override
    public String levelName() {
        return this.levelName;
    }

    /**
     * Function Name:getBackground.
     * Function Operation:return the background
     *
     * @return background
     ***/
    @Override
    public Sprite getBackground() {
        return new FinalFourBackground();
    }

    /**
     * Function Name:blocks.
     * Function Operation: The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return list of blocks
     ***/
    @Override
    public List<Block> blocks() {
        List<HitListener> emptyListenersList = new ArrayList<HitListener>();
        Color[] color = new Color[7];
        color[0] = Color.white;
        color[1] = Color.pink;
        color[2] = Color.cyan;
        color[3] = Color.green;
        color[4] = Color.yellow;
        color[5] = Color.orange;
        color[6] = Color.red;
        Point startingPoint = new Point(21, 200);
        int blockWidth = 50;
        double startOfRaw = 20;
        double startOfCollum = 100;
        int blockHeight = 20;
        // creating blocks and add them to game
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                Block block = new Block(emptyListenersList,
                        new Rectangle(new Point(25 + blockWidth * j,
                                startOfCollum + blockHeight * i),
                                blockWidth, 20), color[i]);
                this.blocks.add(block);
            }

        }
        return this.blocks;
    }

    /**
     * Function Name:numberOfBlocksToRemove.
     * Function Operation: Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return number of blocks to removed
     ***/
    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}
