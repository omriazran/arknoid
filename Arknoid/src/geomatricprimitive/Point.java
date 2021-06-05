package geomatricprimitive;

/**
 * @author omri azran
 * id:316098979
 * omriazran10@gmail.com*
 * @version 1.6
 * @since 2020-03-26
 */


public class Point {
    // Fields
    // x value of a point
    private double x;
    // y value of a point
    private double y;
    //constructor

    /**
     * Function Name:point.
     * Output:-
     * Function Operation: create a new point by given inputs values
     *
     * @param x value for the new point
     * @param y value for the new point
     */
    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * .
     * Function Name:distance.
     * Function Operation:calculates the distance between
     * given point and this point
     *
     * @param other that is given by the user
     * @return distance between the two points
     */
    public double distance(final Point other) {
        double distance;
        double xDiff = this.x - other.getX();
        double yDiff = this.y - other.getY();
        distance = Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
        return distance;
    }


    /**
     * Function Name:equals.
     * Function Operation:checks if two given points are equals
     *
     * @param other point
     * @return true if the points are equals and false if they are not
     */
    public boolean equals(final Point other) {
        boolean isEqual = false;
        if (this.x == other.getX() && this.y == other.getY()) {
            isEqual = true;
        }
        return isEqual;
    }

    /**
     * Function Name:getX().
     * Function Operation: return this point x value
     *
     * @return x value
     */
    public double getX() {
        return this.x;
    }

    /**
     * Function Name:getY().
     * Function Operation: return this point y value
     *
     * @return y value
     */
    public double getY() {
        return this.y;
    }


}

