package gamepack;

import biuoop.DrawSurface;
import counterpack.Counter;
import interfacespack.Animation;

public class YouWinScreen implements Animation {
    //fields
    private biuoop.KeyboardSensor keyboard;
    private boolean stop;
    private Counter scoreCounter;
    //constructor

    /**
     * Function Name:GameOver.
     * Function Operation:constructor
     *
     * @param k            keyboard sensor
     * @param scoreCounter .
     ***/

    public YouWinScreen(biuoop.KeyboardSensor k, Counter scoreCounter) {
        this.keyboard = k;
        this.stop = false;
        this.scoreCounter = scoreCounter;
    }

    /**
     * Function Name:doOneFrame.
     * Function Operation:one turn of
     * the game.
     *
     * @param d surface
     ***/
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win!.  Your score is " +
                this.scoreCounter.getValue(), 32);

    }

    /**
     * Function Name:shouldStop.
     * Function Operation: return a opposite boolean value
     *
     * @return blooean true/false
     ***/
    @Override
    public boolean shouldStop() {
        return  this.stop;
    }
}
