package geomatricprimitive;

import geomatricprimitive.Line;
import geomatricprimitive.Point;

import java.util.ArrayList;
import java.util.List;

/**********
 * omri azran
 * 316098979
 * 01
 * ass03
 ***********/

public class Rectangle {
    // Fields
    private Point upperLeft;
    private double width;
    private double height;

    // constructors

    /**
     * Function Name:geomatricprimitive.Rectangle.
     * Function Operation: create new geomatricprimitive.Rectangle by given
     * upperLeft point width and height
     *
     * @param upperLeft point
     * @param width     of the geomatricprimitive.Rectangle
     * @param height    of the geomatricprimitive.Rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.height = height;
        this.upperLeft = upperLeft;
        this.width = width;
    }

    /**
     * Function Name:getWidth().
     * Function Operation:return the  width of the rectangle
     *
     * @return width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Function Name:getHeight().
     * Function Operation:return the  Height of the rectangle
     *
     * @return height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Function Name: getUpperLeft.
     * Function Operation:return the   getUpperLeft point
     * of the rectangle
     *
     * @return upperLeft
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Function Name:  getUpperRightPoint.
     *
     * @return upper Right point
     */
    public Point getUpperRightPoint() {
        return new Point(this.getUpperLeft().getX() + this.getWidth(),
                this.getUpperLeft().getY());
    }

    /**
     * Function Name: getLowerLeftPoint
     *
     * @return lower left point
     */
    public Point getLowerLeftPoint() {
        return new Point(this.getUpperLeft().getX(),
                this.getUpperLeft().getY() + this.getHeight());
    }

    /**
     * Function Name: getLowerRightPoint
     *
     * @return lower right point
     */
    public Point getLowerRightPoint() {
        return new Point(this.getUpperLeft().getX() +
                this.getWidth(), this.getUpperLeft().getY() + this.getHeight());
    }

    /**
     * Function Name: getUpperLine
     *
     * @return upper  line of the rectangle
     */
    public Line getUpperLine() {
        return new Line(this.getUpperLeft(), this.getUpperRightPoint());
    }

    /**
     * Function Name: getLowerLine
     *
     * @return lower  line of the rectangle
     */
    public Line getLowerLine() {
        return new Line(this.getLowerLeftPoint(), this.getLowerRightPoint());
    }

    /**
     * Function Name:getLeftLine
     *
     * @return left  line of the rectangle
     */
    public Line getLeftLine() {
        return new Line(this.getUpperLeft(), this.getLowerLeftPoint());
    }

    /**
     * Function Name:getRightLine
     *
     * @return right  line of the rectangle
     */
    public Line getRightLine() {
        return new Line(this.getUpperRightPoint(), this.getLowerRightPoint());
    }

    /**
     * Function Name: intersectionPoints
     * Function Operation: finds all possible intersection points with
     * a line and list them
     *
     * @param line
     * @return list of intersection points
     ***/
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<Point>();
        // upper line of rectangle check
        if (this.getUpperLine().isIntersecting(line)) {
            intersectionPoints.add(this.getUpperLine().intersectionWith(line));
        }
        // lower line of rectangle check
        if (this.getLowerLine().isIntersecting(line)) {
            intersectionPoints.add(this.getLowerLine().intersectionWith(line));
        }
        // right line of rectangle check
        if (this.getRightLine().isIntersecting(line)) {
            intersectionPoints.add(this.getRightLine().intersectionWith(line));
        }
        //left line of rectangle check
        if (this.getLeftLine().isIntersecting(line)) {
            intersectionPoints.add(this.getLeftLine().intersectionWith(line));
        }
        return intersectionPoints;
    }

    /**
     * Function Name:setUpperLeftPoint.
     * Function Operation:set new value to the
     * upper left point
     *
     * @param x value
     * @param y value
     * @return
     ***/

    public void setUpperLeftPoint(double x, double y) {
        this.upperLeft = new Point(x, y);
    }
}
