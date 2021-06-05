package backgroundpack;

import biuoop.DrawSurface;
import geomatricprimitive.Point;
import geomatricprimitive.Rectangle;
import interfacespack.Sprite;

import java.awt.Color;

public class DirectHitBackground implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        //background
        d.setColor(Color.black);
        d.fillRectangle(21,21,758,579);
        //circles
        d.setColor(Color.blue);
        d.drawCircle(400,210,50);
        d.drawCircle(400,210,70);
        d.drawCircle(400,210,90);
        //lines
        //upper line
        d.drawLine(400,105,400,195);
        //lower line
        d.drawLine(400,225,400,315);
        // left line
        d.drawLine(385,210,295,210);
        //right line
        d.drawLine(415,210,505,210);


    }

    @Override
    public void timePassed() {

    }
}
