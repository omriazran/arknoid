package interfacespack;

import ballpack.Ball;
import blockpack.Block;

public interface HitListener {
    /**
     * Function Name: hitEvent.
     * Function Operation:This method is called whenever
     * the beingHit object is hit.
     * The hitter parameter is the ballpack.Ball that's doing the hitting.
     * @param hitter ballpack.Ball
     * @param beingHit blockpack.Block
     ***/
    void hitEvent(Block beingHit, Ball hitter);
}
