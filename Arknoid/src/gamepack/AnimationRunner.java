package gamepack;

import interfacespack.Animation;

public class AnimationRunner {
    //fields
    private biuoop.GUI gui;
    private int framesPerSecond;
    //constructor

    /**
     * Function Name:AnimationRunner.
     * Function Operation:constructor
     *
     * @param gui Gui
     ***/

    public AnimationRunner(biuoop.GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
    }

    public void run(Animation animation) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            biuoop.DrawSurface d = this.gui.getDrawSurface();

            animation.doOneFrame(d);

            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
