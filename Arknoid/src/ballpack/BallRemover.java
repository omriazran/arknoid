package ballpack;

import blockpack.Block;
import counterpack.Counter;
import gamepack.GameLevel;
import geomatricprimitive.Point;
import interfacespack.HitListener;

public class BallRemover implements HitListener {
    //fields
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Function Name:ballpack.BallRemover.
     * Function Operation: constructor
     *
     * @param gameLevel           .
     * @param remainingBalls .
     ***/
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.remainingBalls = remainingBalls;
        this.gameLevel = gameLevel;
    }

    /**
     * Function Name: hitEvent.
     * Function Operation:This method is called whenever
     * the beingHit object is hit.
     * The hitter parameter is the ballpack.Ball that's doing the hitting.
     *
     * @param beingHit blockpack.Block
     * @param hitter   ballpack.Ball
     ***/
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //remove one ball if it is death ball
        if (isDeathBlock(beingHit)) {
            hitter.removeFromGame(this.gameLevel);
            this.remainingBalls.decrease(1);
        }
        return;
    }

    /**
     * Function Name:isDeathBlock.
     * Function Operation:check if the block is death block
     *
     * @param beingHit block
     * @return true for death block otherwise return false
     ***/

    public Boolean isDeathBlock(Block beingHit) {
        Point deathPoint = new Point(0, 605);
        if (beingHit.getCollisionRectangle().getUpperLeft().getX()
                == deathPoint.getX()
                && beingHit.getCollisionRectangle().getUpperLeft().getY()
                == deathPoint.getY()) {
            return true;
        }
        return false;
    }
}
