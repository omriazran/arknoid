package gamepack;

import backgroundpack.Green3Background;
import ballpack.Velocity;
import blockpack.Block;
import geomatricprimitive.Point;
import geomatricprimitive.Rectangle;
import interfacespack.HitListener;
import interfacespack.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Green3Level implements LevelInformation {
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
    public Green3Level() {
        this.numberOfBalls = 2;
        this.initialBallVelocities = new ArrayList<Velocity>();
        this.paddleSpeed = 3;
        this.paddleWidth = 80;
        this.levelName = "Green 3";
        this.blocks = new ArrayList<Block>();
        this.numberOfBlocksToRemove = 40;
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
        for (int i = 0; i < 2; i++) {
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
        return new Green3Background();
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
        Color[] color = new Color[6];
        color[0] = Color.white;
        color[1] = Color.YELLOW;
        color[2] = Color.ORANGE;
        color[3] = Color.pink;
        color[4] = Color.red;
        Point startingPoint = new Point(21, 200);
        double startOfRaw = 730;
        double startOfCollum = 100;
        int blockWidth = 50;
        int blockHeight = 20;
        int limit = 10;
        Point upperLeftPoint = new Point(750, 100);
        // creating blocks and add them to game
        for (int i = 0; i < 5; i++) {
            upperLeftPoint = new Point(startOfRaw, startOfCollum + (blockHeight * i));
            for (int j = 0; j < limit; j++) {
                upperLeftPoint = new Point(startOfRaw - (blockWidth * j), upperLeftPoint.getY());
                Rectangle rectangle = new Rectangle(upperLeftPoint, blockWidth, blockHeight);
                Block block = new Block(emptyListenersList, rectangle, color[i]);
                this.blocks.add(block);
            }
            limit = limit - 1;
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