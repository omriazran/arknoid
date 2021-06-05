package gamepack;

import biuoop.DrawSurface;
import interfacespack.Animation;

public class KeyPressStoppableAnimation implements Animation {
    //fields
    Animation animation;
    private biuoop.KeyboardSensor keyboard;
    private boolean stop;
    private String key;
    private Boolean isAlreadyPressed;
    //constructor
    public KeyPressStoppableAnimation(biuoop.KeyboardSensor sensor, String key, Animation animation){
        this.animation =animation;
        this.key = key;
        this.keyboard =sensor;
        this.stop = false;
        this.isAlreadyPressed = true;

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
        this.animation.doOneFrame(d);
        if (this.keyboard.isPressed(key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }

        } else {
          this.isAlreadyPressed = false;
        }
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
