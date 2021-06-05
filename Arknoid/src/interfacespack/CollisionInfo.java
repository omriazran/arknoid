package interfacespack;

import geomatricprimitive.Point;

public class CollisionInfo {
    // Fields
    private Point collisionPoint;
    private Collidable objectType;

    // constructor

    /**
     * Function Name:interfacespack.CollisionInfo.
     * Function Operation:constructor
     *
     * @param collisionPoint
     * @param objectType
     ***/
    public CollisionInfo(Point collisionPoint, Collidable objectType) {
        this.collisionPoint = collisionPoint;
        this.objectType = objectType;
    }

    /**
     * Function Name:collisionPoint.
     * Function Operation:return collision point
     *
     * @return collision point
     ***/
    public Point collisionPoint() {
        return this.collisionPoint;

    }

    /**
     * Function Name:collisionObject.
     * Function Operation:return collision object
     *
     * @return collision object
     ***/
    public Collidable collisionObject() {
        return this.objectType;
    }
}
