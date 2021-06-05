package gamepack;

import backgroundpack.WideEasyBackground;
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

public class WideEasyLevel implements LevelInformation {
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
     * Function Name:WideEasyLevel.
     * Function Operation:constructor
     ***/
    public WideEasyLevel() {
        this.numberOfBalls = 10;
        this.initialBallVelocities = new ArrayList<Velocity>();
        this.paddleSpeed = 3;
        this.paddleWidth = 650;
        this.levelName = "Wide Easy";
        this.blocks = new ArrayList<Block>();
        this.numberOfBlocksToRemove = 15;
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
        for (int i = 0; i < 10; i++) {
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
        return new WideEasyBackground();
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
        color[0] = Color.lightGray;
        color[1] = Color.red;
        color[2] = Color.yellow;
        color[3] = Color.blue;
        color[4] = Color.pink;
        color[5] = Color.green;
        Point startingPoint = new Point(21, 200);
        int blockWidth = 50;
        int max = 5;
        int min = 0;
        Random r = new Random();

        for (int i = 0; i < 15; i++) {
            Block block = new Block(emptyListenersList,
                    new Rectangle(new Point(21 + blockWidth * i, 200), blockWidth, 20),
                    color[r.nextInt((max - min) + 1) + min]);
            this.blocks.add(block);
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
