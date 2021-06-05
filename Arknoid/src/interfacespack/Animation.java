/**********
 * omri azran
 * 316098979
 * 01
 * ass6
 ***********/

package interfacespack;

public interface Animation {
    /**
     * Function Name:doOneFrame.
     * Function Operation:one turn of
     * the game.
     *
     * @param d surface
     ***/
    void doOneFrame(biuoop.DrawSurface d);

    /**
     * Function Name:shouldStop.
     * Function Operation: return a opposite boolean value
     *
     * @return blooean true/false
     ***/
    boolean shouldStop();


}
