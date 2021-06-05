package backgroundpack;

import biuoop.DrawSurface;
import interfacespack.Sprite;

import java.awt.Color;
import java.util.Random;

public class WideEasyBackground implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Color[] color = new Color[6];
        color[0] = Color.green;
        color[1] = Color.blue;
        color[2] = Color.yellow;
        color[3] = Color.blue;
        color[4] = Color.pink;
        color[5] = Color.green;
        int max = 1;
        int min = 0;
        Random r = new Random();
        for(int i=0 ; i<20;i++){
            d.setColor(color[r.nextInt((max - min) + 1) + min]);
            d.fillCircle(50+i*40,80,20);
        }
        for(int i=0 ; i<20;i++){
            d.setColor(color[r.nextInt((max - min) + 1) + min]);
            d.fillCircle(50+i*40,130,20);
        }
        for(int i=0 ; i<20;i++){
            d.setColor(color[r.nextInt((max - min) + 1) + min]);
            d.fillCircle(50+i*40,180,20);
        }
     /*   for(int i=0 ; i<20;i++){
            d.setColor(color[r.nextInt((max - min) + 1) + min]);
            d.fillCircle(50+i*40,250,20);
        }
        for(int i=0 ; i<20;i++){
            d.setColor(color[r.nextInt((max - min) + 1) + min]);
            d.fillCircle(50+i*40,300,20);
        }
        for(int i=0 ; i<20;i++){
            d.setColor(color[r.nextInt((max - min) + 1) + min]);
            d.fillCircle(50+i*40,350,20);
        }
        for(int i=0 ; i<20;i++){
            d.setColor(color[r.nextInt((max - min) + 1) + min]);
            d.fillCircle(50+i*40,400,20);
        }
        for(int i=0 ; i<20;i++){
            d.setColor(color[r.nextInt((max - min) + 1) + min]);
            d.fillCircle(50+i*40,450,20);
        }

*/
    }

    @Override
    public void timePassed() {

    }
}
