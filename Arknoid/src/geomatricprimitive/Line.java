package geomatricprimitive;

public class Line {
    // Fields
    // x,y that indicates the starting point
    private Point start;
    // x,y that indicates the ending point
    private Point end;
    // we change the direction of line to follow axes rules
    // so we keep the original start
    private Point originalStart;
    // constructors

    /**
     * Function Name:line.
     * Function Operation: create new line by given start and end points
     *
     * @param start point
     * @param end   point
     */
    public Line(Point start, Point end) {
        Point temp;
        this.originalStart = start;
        if (end.getX() < start.getX()) {
            temp = start;
            start = end;
            end = temp;
        }
        this.start = start;
        this.end = end;

    }

    /**
     * Function Name:line.
     * Function Operation: create new line by given x,y for start point
     * and x,y for end point
     *
     * @param x1 for start point
     * @param y1 for start point
     * @param x2 for end point
     * @param y2 for end point
     */
    public Line(final double x1, final double y1,
                final double x2, final double y2) {
        Point temp;
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        this.originalStart = start;
        if (end.getX() < start.getX()) {
            temp = start;
            start = end;
            end = temp;
        }
        this.start = start;
        this.end = end;
    }

    /**
     * Function Name:length().
     * Function Operation: calculates the line's length
     *
     * @return the length of this line
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Function Name:middle().
     * Function Operation:  calculates the middle point of this line
     *
     * @return middle point
     */
    public Point middle() {
        double xMidd = (this.start.getX() + this.end.getX()) / 2;
        double yMidd = (this.start.getY() + this.end.getY()) / 2;
        Point middle = new Point(xMidd, yMidd);
        return middle;
    }

    /**
     * Function Name: getOriginalStart
     *
     * @return original starting point
     ***/

    public Point getOriginalStart() {
        return this.originalStart;
    }

    /**
     * Function Name:start().
     * Function Operation: finds the start point of the line
     *
     * @return the start point
     */
    public Point start() {
        return this.start;
    }

    /**
     * Function Name: end().
     * Function Operation: finds the end point of the line
     *
     * @return the end point
     */
    public Point end() {
        return this.end;
    }

    /**
     * Function Name: incline.
     * Function Operation: finds the incline of given line
     *
     * @return incline
     */
    public double incline() {

        return (this.end.getY() - this.start.getY())
                / (this.end.getX() - this.start.getX());
    }

    /**
     * Function Name:verticalSubLine
     * Function Operation: finds if one line is a
     * subline of the other
     *
     * @param other line
     * @return true/false
     */
    public boolean verticalSubLine(Line other) {
        if (this.start.getX() != other.start.getX()) {
            return false;
        }
        double maxYthis, minYthis, maxYother, minYother;
        maxYthis = Math.max(this.start.getY(), this.end.getY());
        minYthis = Math.min(this.start.getY(), this.end.getY());
        maxYother = Math.max(other.start.getY(), other.end.getY());
        minYother = Math.min(other.start.getY(), other.end.getY());
        if (minYthis < maxYother && minYthis >= minYother) {
            return true;
        }
        if (minYother < maxYthis && minYother >= minYthis) {
            return true;
        }

        return false;
    }


    /**
     * Function Name: b().
     * Function Operation: finds the b of the line equation
     *
     * @return incline
     */
    // y = ax+b find this b
    public double b() {
        double inc = this.incline();
        return (this.end.getY() - inc * this.end.getX());
    }

    /**
     * Function Name:potentialX.
     * Function Operation: finds potentialX for  intersection between two lines
     *
     * @param other line
     * @return potentialX
     */
    public double potentialX(final Line other) {
        return ((other.b() - this.b())) / ((this.incline() - other.incline()));
    }

    /**
     * Function Name:potentialY.
     * Function Operation: finds potentialY for  intersection between two lines
     *
     * @param other line
     * @return potentialY
     */
    public double potentialY(final Line other) {
        double potenX = this.potentialX(other);
        return (potenX * this.incline() + this.b());

    }

    /**
     * Function Name: isIntersecting.
     * Function Operation: checks if two lines intersecting
     *
     * @param other line
     * @return true if the lines are intersecting and false if not
     */
    public boolean isIntersecting(final Line other) {
        double maxXl1, maxXl2, minXl1, minXL2, potenX = 0,
                potenY = 0, maxYl1, maxYl2, minYl1, minYL2;

        boolean xInrange = false;
        boolean yInrange = false;
        boolean isVertical = false;
        // if the lines are the same
        if (this.equals(other)) {
            return false;
        }

        // if both lines is vertical
        if (this.start.getX() == this.end.getX() &&
                other.start.getX() == other.end.getX()) {
            if ((this.start.equals(other.end) || this.end.equals(other.start)
                    || this.start.equals(other.start) || this.end.equals(other.end))
                    && !this.verticalSubLine(other)) {
                return true;
            } else {
                return false;
            }
        }
        // if this is a vertical line
        if (this.start.getX() == this.end.getX()) {
            potenX = this.start.getX();
            //linear equation
            potenY = other.incline() * potenX + other.b();
            isVertical = true;
        }
        // if other is a vertical line
        if (other.start.getX() == other.end.getX()) {
            potenX = other.start.getX();
            //linear equation
            potenY = this.incline() * potenX + this.b();
            isVertical = true;
        }


        // if inclines is equals
        if (this.incline() == other.incline()) {
            if (this.start.equals(other.end) || this.end.equals(other.start)) {
                return true;
            } else {
                return false;
            }

        }
        if ((other.start.getY() == other.end.getY()) && !isVertical) {
            potenY = other.start.getY();
            potenX = (potenY - this.b()) / (this.incline());
        }
        if ((this.start.getY() == this.end.getY()) && !isVertical) {
            potenY = this.start.getY();
            potenX = (potenY - other.b()) / (other.incline());
        }


        if (this.start.getX() != this.end.getX() &&
                other.start.getX() != other.end.getX()
                && other.start.getY() != other.end.getY()
                && this.start.getY() != this.end.getY() && !isVertical) {
            potenX = this.potentialX(other);
            potenY = this.potentialY(other);

        }


        maxXl1 = Math.max(this.start.getX(), this.end.getX());
        maxXl2 = Math.max(other.start.getX(), other.end.getX());
        maxYl1 = Math.max(this.start.getY(), this.end.getY());
        maxYl2 = Math.max(other.start.getY(), other.end.getY());
        minXl1 = Math.min(this.start.getX(), this.end.getX());
        minXL2 = Math.min(other.start.getX(), other.end.getX());
        minYl1 = Math.min(this.start.getY(), this.end.getY());
        minYL2 = Math.min(other.start.getY(), other.end.getY());

        if (potenX >= minXl1 && potenX <= maxXl1) {
            if (potenX >= minXL2 && potenX <= maxXl2) {
                xInrange = true;
            }
        }
        if (potenY >= minYl1 && potenY <= maxYl1) {
            if (potenY >= minYL2 && potenY <= maxYl2) {
                yInrange = true;
            }

        }

        if (xInrange && yInrange) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Function Name:intersectionWith.
     * Function Operation: find the intersection point between two line
     *
     * @param other line
     * @return the intersection point
     */
    public Point intersectionWith(final Line other) {
        if (!this.isIntersecting(other)) {
            return null;

        }
        double x = 0;
        double y = 0;
        boolean isVertical = false;

        if (this.start.equals(other.start)) {
            return this.start;
        }
        if (this.end.equals(other.end)) {
            return this.end;
        }
        //lines with equals inclines
        if (this.start.equals(other.end)) {
            return this.start;
        }
        //lines with equals inclines
        if (this.end.equals(other.start)) {
            return this.end;
        }
        // if this is a vertical line
        if (this.start.getX() == this.end.getX()) {
            x = this.start.getX();
            //linear equation
            y = other.incline() * x + other.b();
            isVertical = true;
        }
        // if other is a vertical line
        if (other.start.getX() == other.end.getX()) {
            x = other.start.getX();
            //linear equation
            y = this.incline() * x + this.b();
            isVertical = true;
        }
        if ((other.start.getY() == other.end.getY()) && !isVertical) {
            y = other.start.getY();
            x = (y - this.b()) / (this.incline());
        }
        if ((this.start.getY() == this.end.getY()) && !isVertical) {
            y = this.start.getY();
            x = (y - other.b()) / (other.incline());
        }


        //lines with different inclines
        if (this.start.getX() != this.end.getX() &&
                other.start.getX() != other.end.getX()
                && other.start.getY() != other.end.getY()
                && this.start.getY() != this.end.getY()
                && !isVertical) {
            x = this.potentialX(other);
            y = this.potentialY(other);
        }


        Point intersecPoint = new Point(x, y);
        return intersecPoint;

    }

    /**
     * Function Name:equals.
     * Function Operation: checks if two lines are equals
     *
     * @param other line
     * @return true if they are equals and false if they are not
     */
    public boolean equals(final Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)
                || this.start.equals(other.end) && this.end.equals(other.start)) {
            return true;
        }
        return false;
    }

    /**
     * Function Name:closestIntersectionToStartOfLine.
     * Function Operation:finds (if exists) the closet intersection
     * point of the rectangle to this line by finding each of the rectangle
     * line equations intersecting point and finds the closet one to the
     * line starting point
     *
     * @param rect
     * @return the closet intersection point if exists and if not
     * return null
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //get all  the rectangle points
        Point upperLeft = rect.getUpperLeft();
        Point upperRight = new Point(rect.getUpperLeft().getX() + rect.getWidth(),
                rect.getUpperLeft().getY());
        Point lowerLeft = new Point(rect.getUpperLeft().getX(),
                rect.getUpperLeft().getY() + rect.getHeight());
        Point lowerRight = new Point(rect.getUpperLeft().getX() +
                rect.getWidth(), rect.getUpperLeft().getY() + rect.getHeight());

        // create rectangle lines equations
        Line upperLine = new Line(upperLeft, upperRight);
        Line lowerLine = new Line(lowerLeft, lowerRight);
        Line leftLine = new Line(upperLeft, lowerLeft);
        Line rightLine = new Line(upperRight, lowerRight);
        // create an array of this lines
        Line[] linesArray = new Line[4];
        linesArray[0] = upperLine;
        linesArray[1] = lowerLine;
        linesArray[2] = leftLine;
        linesArray[3] = rightLine;
        //find if exists the  closest intersection point to the
        //  start of the line by finding each of the rectangles line
        //intersection point (if exists) with this line and finds the
        //closet one
        double minDistance = this.start.distance(this.end);
        boolean isIntersecting = false;
        Point minIntersectionPoint = null;
        for (int i = 0; i < 4; i++) {
            if (this.isIntersecting(linesArray[i])) {
                if (this.originalStart.distance(this.intersectionWith(linesArray[i])) <= minDistance) {
                    minDistance = this.originalStart.distance(this.intersectionWith(linesArray[i]));
                    isIntersecting = true;
                    minIntersectionPoint = this.intersectionWith(linesArray[i]);
                }
            }
        }
        if (isIntersecting) {
            return minIntersectionPoint;
        }
        return null;
    }

    /**
     * Function Name:isPointOnTheAlignedLine
     * Function Operation:checks if the point
     * is on the line
     *
     * @param point
     * @return true for the point is on the line
     * and false if it is not
     */
    public boolean isPointOnTheAlignedLine(Point point) {
        double maxX = Math.max(this.start.getX(), this.end.getX());
        double minX = Math.min(this.start.getX(), this.end.getX());
        double maxY = Math.max(this.start.getY(), this.end.getY());
        double minY = Math.min(this.start.getY(), this.end.getY());
        // horizontal line check
        if ((int) this.start.getY() == (int) point.getY() &&
                point.getX() >= minX && point.getX() <= maxX) {
            return true;
        }
        //vertical line check
        if ((int) this.start.getX() == (int) point.getX() &&
                point.getY() >= minY && point.getY() <= maxY) {
            return true;
        }
        return false;
    }
}
