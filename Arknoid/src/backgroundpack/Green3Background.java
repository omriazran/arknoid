package backgroundpack;

import biuoop.DrawSurface;
import interfacespack.Sprite;

import java.awt.Color;

public class Green3Background implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        //background
        d.setColor(Color.green);
        d.fillRectangle(21,21,758,579);
    }

    @Override
    public void timePassed() {

    }
}
