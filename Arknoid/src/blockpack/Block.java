package blockpack;

import ballpack.Ball;
import ballpack.Velocity;
import gamepack.GameLevel;
import geomatricprimitive.Point;
import geomatricprimitive.Rectangle;
import interfacespack.Collidable;
import interfacespack.HitListener;
import interfacespack.HitNotifier;
import interfacespack.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Block implements Collidable, Sprite, HitNotifier {
    // Fields
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    // constructor

    /**
     * Function Name:blockpack.Block.
     * Function Operation:create a new block
     *
     * @param rectangle    .
     * @param color        .
     * @param hitListeners .
     ***/
    public Block(List<HitListener> hitListeners, Rectangle rectangle, Color color) {
        this.color = color;
        this.rectangle = rectangle;
        this.hitListeners = hitListeners;
    }

    @Override
/**
 * Function Name:getCollisionRectangle.
 * Function Operation:return the block as rectangle object
 * @return geomatricprimitive.Rectangle
 ***/
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    /**
     * Function Name:hit.
     * Function Operation:change the velocity of the object
     * according the current velocity and collision point
     * @param collisionPoint
     * @param currentVelocity
     * @param ballpack.Ball hitter,
     * @return new velocity
     ***/
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        boolean isOnRightLine = false;
        boolean isOnLeftLine = false;
        boolean isOnUpperLine = false;
        boolean isOnLowerLine = false;
        double changeDirection = -1;
        double newDx = currentVelocity.getDx();
        double newDy = currentVelocity.getDy();
        if (this.rectangle.getRightLine().isPointOnTheAlignedLine(collisionPoint)) {
            isOnRightLine = true;
        }
        if (this.rectangle.getLeftLine().isPointOnTheAlignedLine(collisionPoint)) {
            isOnLeftLine = true;
        }
        if (this.rectangle.getUpperLine().isPointOnTheAlignedLine(collisionPoint)) {
            isOnUpperLine = true;
        }
        if (this.rectangle.getLowerLine().isPointOnTheAlignedLine(collisionPoint)) {
            isOnLowerLine = true;
        }
        if (isOnUpperLine || isOnLowerLine) {
            newDy = currentVelocity.getDy() * changeDirection;
        }
        if (isOnLeftLine || isOnRightLine) {
            newDx = currentVelocity.getDx() * changeDirection;
        }
        Velocity newVelocity = new Velocity(newDx, newDy);
        // do not notify if a hit does not occurred
        if (newVelocity.getDx() == currentVelocity.getDx()
                && newVelocity.getDy() == currentVelocity.getDy()) {
            return newVelocity;
        }
        this.notifyHit(hitter);
        return newVelocity;
    }

    /**
     * Function Name:drawOn.
     * Function Operation: draw on surface
     *
     * @param surface
     ***/

    public void drawOn(biuoop.DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth()
                , (int) this.rectangle.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth()
                , (int) this.rectangle.getHeight());
    }

    @Override
    /**
     * Function Name: timePassed().
     * Function Operation:
     ***/
    public void timePassed() {

    }

    /**
     * Function Name:addToGame.
     * Function Operation: add the block
     * to the collidable list and the sprites list
     *
     * @param gameLevel
     ***/
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
        gameLevel.addSprite(this);
    }

    /**
     * Function Name:removeFromGame.
     * Function Operation:remove the block From the gamepack.Game
     *
     * @param gameLevel .
     ***/
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * Function Name: addHitListener.
     * Function Operation:add a interfacespack.HitListener to hit events.
     *
     * @param hl interfacespack.HitListener
     ***/
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * Function Name: removeHitListener.
     * Function Operation: Remove hl from the list of listeners to hit events.
     *
     * @param hl interfacespack.HitListener
     ***/
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * Function Name:notifyHit.
     * Function Operation:Notify all listeners about a hit event:
     *
     * @param hitter ball
     * @return
     ***/
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Function Name:setHitListeners.
     * Function Operation:set hitListener list
     * @param hitListeners hitListener list
     ***/
 public void setHitListeners(List<HitListener> hitListeners){
    this.hitListeners = hitListeners;
 }
}

