package gamepack;

import biuoop.DrawSurface;
import interfacespack.Animation;

public class PauseScreen implements Animation {
    //fields
    private biuoop.KeyboardSensor keyboard;
    private boolean stop;
    //constructor

    /**
     * Function Name:PauseScreen.
     * Function Operation:constructor
     *
     * @param k keyboard sensor
     ***/

    public PauseScreen(biuoop.KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
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
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);

    }

    /**
     * Function Name:shouldStop.
     * Function Operation: return a opposite boolean value
     *
     * @return blooean true/false
     ***/
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
