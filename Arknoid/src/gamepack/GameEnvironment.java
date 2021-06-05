package gamepack;

import geomatricprimitive.Line;
import geomatricprimitive.Point;
import interfacespack.Collidable;
import interfacespack.CollisionInfo;

import java.util.ArrayList;
import java.util.List;

public class GameEnvironment {
    // Fields
    private List<Collidable> collidables;

    // constructor

    /**
     * Function Name:gamepack.GameEnvironment.
     * Function Operation:constructor
     ***/
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * Function Name: addCollidable.
     *
     * @param c collidable
     ***/
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Function Name: getClosestCollision.
     * Function Operation:finds if in its trajectory
     * an object collide with on of the collidable;
     *
     * @param trajectory line
     * @return
     ***/
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closestCollisionPoint = null;
        Collidable closetColliadleType = null;
        double minDistance = trajectory.length() + 1;//+1 to initiate the value to
        // non possible collision value
        for (Collidable c : collidables) {
            if (null != trajectory.closestIntersectionToStartOfLine
                    (c.getCollisionRectangle())) {
                double distance = trajectory.getOriginalStart().
                        distance(trajectory.closestIntersectionToStartOfLine
                                (c.getCollisionRectangle()));
                if (distance < minDistance) {
                    closestCollisionPoint = trajectory.closestIntersectionToStartOfLine
                            (c.getCollisionRectangle());
                    closetColliadleType = c;
                    minDistance = distance;
                }
            }
        }
        if (closestCollisionPoint == null) {
            return null;
        }
        return new CollisionInfo(closestCollisionPoint, closetColliadleType);
    }


    /**
     * Function Name: getCollidablesList
     * Function Operation:return all collidables
     * in the game environment
     *
     * @return collidables
     ***/

    public List<Collidable> getCollidablesList() {
        return this.collidables;
    }
    /**
     * Function Name:removeCollidableFromList.
     * Function Operation:remove a collidable from the list
     * inside the game environment
     * @param c a interfacespack.Collidable to be removed
     * @return
     ***/
    public void removeCollidableFromList(Collidable c){
        this.collidables.remove(c);
    }
}
