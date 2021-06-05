package ballpack;

import geomatricprimitive.Point;

// ballpack.Velocity specifies the change in position on the `x` and the `y` axes
public class Velocity {
    //// Fields
    private double dx;
    private double dy;

    // constructor

    /**
     * Function Name:ballpack.Velocity.
     * Function Operation: create a velocity value
     *
     * @param dx value to add to current x axe value
     * @param dy value to add to current t axe value
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Function Name: getDx().
     * Function Operation: return dx value
     *
     * @return dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Function Name: getDy().
     * Function Operation:return value dy value
     *
     * @return dy
     */
    public double getDy() {
        return this.dy;
    }

    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)

    /**
     * Function Name:applyToPoint.
     * Function Operation:create a new point with  position (x+dx, y+dy)
     *
     * @param p current point (x,y)
     * @return newPoint (x+dx, y+dy)
     */

    public Point applyToPoint(Point p) {
        Point newPoint = new Point(this.dx + p.getX(), this.dy + p.getY());
        return newPoint;
    }

    /**
     * Function Name:fromAngleAndSpeed.
     * Function Operation: create velocity from angle and speed
     *
     * @param angle
     * @param speed
     * @return velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = Math.toRadians(angle);
        double dx = speed * Math.sin(angle);
        double dy = speed * Math.cos(angle);
        return new Velocity(dx, dy);
    }

}
