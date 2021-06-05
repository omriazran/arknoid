package interfacespack;

import java.util.ArrayList;
import java.util.List;

public class SpriteCollection {

    // Fields
    private List<Sprite> sprites;
    //constructor

    /**
     * Function Name: interfacespack.SpriteCollection
     * Function Operation:constructor
     ***/
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * Function Name: addSprite.
     *
     * @param s sprite
     ***/
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    // call timePassed() on all sprites.

    /**
     * Function Name:notifyAllTimePassed
     * notify all that there time passed
     ***/

    public void notifyAllTimePassed() {
        List<Sprite> cpySpritesList = new ArrayList<Sprite>(this.sprites);
        for (Sprite s : cpySpritesList) {
            s.timePassed();
        }
    }

    // call drawOn(d) on all sprites.

    /**
     * Function Name:drawAllOn
     * Function Operation:
     *
     * @param d surface
     ***/
    public void drawAllOn(biuoop.DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }

    /**
     * Function Name:removeSpriteFromList.
     * Function Operation:remove interfacespack.Sprite From List
     *
     * @param s sprite
     ***/
    public void removeSpriteFromList(Sprite s) {
        this.sprites.remove(s);
    }
}
