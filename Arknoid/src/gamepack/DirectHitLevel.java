package gamepack;

import backgroundpack.DirectHitBackground;
import ballpack.Velocity;
import blockpack.Block;
import geomatricprimitive.Point;
import geomatricprimitive.Rectangle;
import interfacespack.HitListener;
import interfacespack.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class DirectHitLevel implements LevelInformation {
    //fields
   private int numberOfBalls ;
   private List<Velocity> initialBallVelocities;
   private int paddleSpeed ;
   private int  paddleWidth ;
   private String levelName;
   private List<Block> blocks;
   private int numberOfBlocksToRemove;
   //constructor
    /**
     * Function Name:DirectHitLevel.
     * Function Operation:constructor
     ***/
    public DirectHitLevel(){
        this.numberOfBalls= 1;
        this.initialBallVelocities = new ArrayList<Velocity>();
        this.paddleSpeed = 3;
        this.paddleWidth = 80;
        this.levelName = "Direct Hit";
        this.blocks = new ArrayList<Block>();
        this.numberOfBlocksToRemove = 1;
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
        this.initialBallVelocities.add(new Velocity(0,-3));
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
     * @return background
     ***/
    @Override
    public Sprite getBackground() {
       return new DirectHitBackground();
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
        Block block = new Block(emptyListenersList,new
                Rectangle(new Point(390,200),20,20), Color.red);
        this.blocks.add(block);
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
