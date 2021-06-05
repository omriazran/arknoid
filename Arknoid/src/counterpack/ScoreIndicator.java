package counterpack;

import biuoop.DrawSurface;
import interfacespack.Sprite;

public class ScoreIndicator implements Sprite {
    //fields
    private Counter score;
    //constructor

    /**
     * Function Name: counterpack.ScoreIndicator.
     * Function Operation:constructor
     *
     * @param scoreCounter counterpack.Counter
     ***/
    public ScoreIndicator(Counter scoreCounter) {
        this.score = scoreCounter;
    }

    @Override
    /**
     * Function Name:drawOn.
     * Function Operation:draw the sprite to the screen
     * @param d DrawSurface
     ***/
    public void drawOn(DrawSurface d) {

        String theScore = "score: " + this.score.getValue();
        d.drawText(400, 15, theScore, 15);
    }

    @Override
    /**
     * Function Name:timePassed.
     * Function Operation:notify the sprite that time has passed
     ***/
    public void timePassed() {

    }
}
