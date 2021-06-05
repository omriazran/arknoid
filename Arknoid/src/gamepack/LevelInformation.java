package gamepack;

import ballpack.Velocity;
import blockpack.Block;
import interfacespack.Sprite;

import java.util.List;

public interface LevelInformation {
    /**
     * Function Name:numberOfBalls.
     * Function Operation: return the number Of Balls
     * @return number of balls
     ***/

    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    /**
     * Function Name:initialBallVelocities.
     * Function Operation:return The initial velocity of each ball
     * @return list of balls velocities
     ***/

    List<Velocity> initialBallVelocities();
    /**
     * Function Name:paddleSpeed.
     * Function Operation:return the paddle Speed
     * @return paddle Speed
     ***/
    int paddleSpeed();
    /**
     * Function Name:paddleWidth.
     * Function Operation:return the paddle Width
     * @return Width
     ***/
    int paddleWidth();
    /**
     * Function Name:levelName.
     * Function Operation:the level name will be displayed at the top of the screen.
     ***/
    String levelName();
    /**
     * Function Name:getBackground.
     * Function Operation:return the background
     * @return background
     ***/
    Sprite getBackground();
    /**
     * Function Name:blocks.
     * Function Operation: The Blocks that make up this level, each block contains
     * its size, color and location.
     * @return list of blocks
     ***/
    List<Block> blocks();

    /**
     * Function Name:numberOfBlocksToRemove.
     * Function Operation: Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return number of blocks to removed
     ***/

    int numberOfBlocksToRemove();
}
