package backgroundpack;

import biuoop.DrawSurface;
import interfacespack.Sprite;

import java.awt.Color;

public class LevelName implements Sprite {
    //fields
    private String name;
    //constructor
    /**
     * Function Name:LevelName.
     * Function Operation:constructor
     * @param levelName name of level
     ***/
public LevelName(String levelName){
    this.name = levelName;
}
    @Override
    public void drawOn(DrawSurface d) {
    d.setColor(Color.red);
    d.drawText(600,15,"Level Name:"+this.name,15);
    }

    @Override
    public void timePassed() {

    }
}
