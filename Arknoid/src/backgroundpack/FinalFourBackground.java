package backgroundpack;

import biuoop.DrawSurface;
import interfacespack.Sprite;

import java.awt.Color;

public class FinalFourBackground implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        //background
        d.setColor(Color.blue);
        d.fillRectangle(21,21,758,579);
        /*
        //clouds
        //cloud1
        d.setColor(Color.lightGray);
        d.fillCircle(200,400,10);
        d.fillCircle(180,420,8);
        d.fillCircle(220,450,15);
        d.fillCircle(240,380,12);
        d.fillCircle(195,390,16);
        //rain 1
        d.setColor(Color.white);
        d.drawLine(200,400,190,600);
        d.drawLine(180,420,180,600);
        d.drawLine(220,450,170,600);
        d.drawLine(240,380,160,600);
        d.drawLine(195,390,150,600);

        //cloud2
        d.setColor(Color.lightGray);
        d.fillCircle(600,500,10);
        d.fillCircle(580,520,8);
        d.fillCircle(620,550,15);
        d.fillCircle(640,480,12);
        d.fillCircle(595,530,16);
        //rain 2
        d.setColor(Color.white);
        d.drawLine(600,500,490,600);
        d.drawLine(580,520,480,600);
        d.drawLine(620,550,470,600);
        d.drawLine(640,480,460,600);
        d.drawLine(595,530,450,600);

         */
    }

    @Override
    public void timePassed() {

    }
}
