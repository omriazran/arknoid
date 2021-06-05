package interfacespack;

import ballpack.Ball;
import ballpack.Velocity;
import geomatricprimitive.Point;
import geomatricprimitive.Rectangle;

public interface Collidable {
    /**
     * Function Name:getCollisionRectangle.
     * Function Operation:  Return the "collision shape" of the object.
     * @return rectangle
     ***/
    Rectangle getCollisionRectangle();


    /**
     * Function Name: hit.
     * Function Operation:
     *  Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     *  The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     * @param hitter ballpack.Ball
     * @param collisionPoint geomatricprimitive.Point
     * @param currentVelocity ballpack.Velocity
     * @return
     ***/
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

}
