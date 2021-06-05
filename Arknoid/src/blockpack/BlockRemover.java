package blockpack;

import ballpack.Ball;
import counterpack.Counter;
import gamepack.GameLevel;
import geomatricprimitive.Point;
import interfacespack.HitListener;

public class BlockRemover implements HitListener {
    //fields
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    //constructor

    /**
     * Function Name:blockpack.BlockRemover.
     * Function Operation: constructor
     *
     * @param gameLevel            .
     * @param remainingBlocks .
     ***/
    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
        this.remainingBlocks = remainingBlocks;
        this.gameLevel = gameLevel;
    }

    /**
     * Function Name: hitEvent.
     * Function Operation:This method is called whenever
     * the beingHit object is hit.
     * The hitter parameter is the ballpack.Ball that's doing the hitting.
     * @param beingHit blockpack.Block
     * @param hitter   ballpack.Ball
     ***/
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (isBorder(beingHit)){
            return;
        }
        beingHit.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease(1);
    }


    /**
     * Function Name:isBorder.
     * Function Operation: checks if the block is a border
     * @param beingHit block
     * @return true for it is a border otherwise return false
     ***/

    private Boolean isBorder(Block beingHit) {
        Point upperBorder = new Point(0, 0);
        Point leftBorder = new Point(0, 20);
        Point rightBorder = new Point(780, 20);
        Point beingHitPoint = beingHit.getCollisionRectangle().getUpperLeft();
        // upperBorder check
        if (beingHitPoint.getX() == upperBorder.getX()
                && beingHitPoint.getY() == upperBorder.getY()) {
            return true;
        }
        // leftBorder check
        if (beingHitPoint.getX() == leftBorder.getX()
                && beingHitPoint.getY() == leftBorder.getY()) {
            return true;
        }
        // rightBorder check

        if (beingHitPoint.getX() == rightBorder.getX()
                && beingHitPoint.getY() == rightBorder.getY()) {
            return true;
        }
        return  false;
    }
}