package ballpack;

import biuoop.DrawSurface;
import gamepack.GameLevel;
import gamepack.GameEnvironment;
import geomatricprimitive.Line;
import geomatricprimitive.Point;
import interfacespack.Sprite;

public class Ball implements Sprite {
    // Fields
    private Point center;
    private int radius;
    private GameEnvironment gameEnvironment;
    // ball color
    private java.awt.Color color;
    private Velocity Velocity;


    // constructors

    /**
     * Function Name:ballpack.Ball.
     * Function Operation:generate new ball
     *
     * @param center
     * @param r               for radius
     * @param color           for the color of the ball
     * @param gameEnvironment
     */
    public Ball(Point center, int r, java.awt.Color color,
                GameEnvironment gameEnvironment) {
        this.center = center;
        this.color = color;
        this.radius = r;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Function Name:ballpack.Ball.
     * Function Operation:generate new ball
     *
     * @param x               coordinate" of the center point of the ball
     * @param y               coordinate" of the center point of the ball
     * @param r               for radius
     * @param color           for the color of the ball
     * @param gameEnvironment
     */
    public Ball(int x, int y, int r, java.awt.Color color
            , GameEnvironment gameEnvironment) {
        Point center = new Point((double) (x), (double) (y));
        this.center = center;
        this.color = color;
        this.radius = r;
        this.gameEnvironment = gameEnvironment;
    }


    /**
     * Function Name:getX().
     * Function Operation: return the x "coordinate" of
     * the center point of the ball
     *
     * @return x
     */
    public int getX() {
        return (int) (this.center.getX());
    }

    /**
     * Function Name: getGameEnvironment().
     * Function Operation:getGameEnvironment
     *
     * @return game Environment
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * Function Name: getY().
     * Function Operation:return the y "coordinate" of
     * the center point of the ball
     *
     * @return y
     */
    public int getY() {
        return (int) (this.center.getY());
    }

    /**
     * Function Name:getSize().
     * Function Operation:return radius of the ball
     *
     * @return radius
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Function Name:getColor.
     * Function Operation: return color of the ball
     *
     * @return color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Function Name: drawOn.
     * Function Operation:draw circle in given color and on given surface
     *
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    @Override
    /**
     * Function Name: timePassed().
     * Function Operation:call moveOneStep
     ***/
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Function Name:setVelocity.
     * Function Operation: set the value of velocity
     *
     * @param v wanted velocity
     */
    public void setVelocity(Velocity v) {
        this.Velocity = v;
    }

    /**
     * Function Name: setVelocity.
     * Function Operation: set velocity by dx and dy values
     *
     * @param dx x axe value
     * @param dy axe value
     */
    public void setVelocity(double dx, double dy) {
        this.Velocity = new Velocity(dx, dy);
    }

    /**
     * Function Name:getVelocity.
     * Function Operation: return this velocity
     *
     * @return velocity
     */
    public Velocity getVelocity() {
        return this.Velocity;
    }

    /**
     * Function Name:moveOneStep().
     * Function Operation:moving the ball
     * according ball velocity
     */

    public void moveOneStep() {
        Point endOfTrajectory = this.Velocity.applyToPoint(this.center);
        Line trajectory = new Line(this.center, endOfTrajectory);
        Point CollisionPoint = null;
        if (this.gameEnvironment.getClosestCollision(trajectory) == null) {
            this.center = endOfTrajectory;
        } else {
            CollisionPoint = this.gameEnvironment.getClosestCollision(trajectory)
                    .collisionPoint();
            Line upperLine = this.gameEnvironment.getClosestCollision(trajectory).
                    collisionObject().getCollisionRectangle().getUpperLine();
            Line lowerLine = this.gameEnvironment.getClosestCollision(trajectory).
                    collisionObject().getCollisionRectangle().getLowerLine();
            Line rightLine = this.gameEnvironment.getClosestCollision(trajectory).
                    collisionObject().getCollisionRectangle().getRightLine();
            Line leftLine = this.gameEnvironment.getClosestCollision(trajectory).
                    collisionObject().getCollisionRectangle().getLeftLine();
            //check if point is on upper line
            if (upperLine.isPointOnTheAlignedLine(CollisionPoint)) {
                this.center = new Point(CollisionPoint.getX(),
                        (CollisionPoint.getY() - this.radius));

            }
            // check if point is on lower line
            if (lowerLine.isPointOnTheAlignedLine(CollisionPoint)) {
                this.center = new Point(CollisionPoint.getX(),
                        (CollisionPoint.getY() + this.radius));

            }
            //check if point is on left line
            if (leftLine.isPointOnTheAlignedLine(CollisionPoint)) {
                this.center = new Point((CollisionPoint.getX() - this.radius),
                        CollisionPoint.getY());


            }
            //check if point is on right line
            if (rightLine.isPointOnTheAlignedLine(CollisionPoint)) {
                this.center = new Point((CollisionPoint.getX() + this.radius),
                        CollisionPoint.getY());

            }
            this.setVelocity(this.gameEnvironment.getClosestCollision(trajectory)
                    .collisionObject().hit(this,CollisionPoint, this.Velocity));

        }




       /* double nextStepx = this.ballpack.Velocity.getDx();
        double nextStepY = this.ballpack.Velocity.getDy();
        // checks if the ball in side x axe range int he next move
        if (this.center.getX() + nextStepx >= (maxLimit - this.radius)
                || this.center.getX() + nextStepx <= (minLimit + this.radius)) {
            //change direction in  x axe
            this.setVelocity(this.ballpack.Velocity.getDx() * -1, this.ballpack.Velocity.getDy());
        }
        // checks if the ball in side y axe range int he next move
        if (this.center.getY() + nextStepY >= (maxLimit - this.radius)
                || this.center.getY() + nextStepY <= (minLimit + this.radius)) {
            //change direction in  y axe
            this.setVelocity(this.ballpack.Velocity.getDx(), this.ballpack.Velocity.getDy() * -1);
        }


        this.center = this.getVelocity().applyToPoint(this.center); */
    }

    /**
     * Function Name:addToGame.
     * Function Operation: add the ball
     * to the sprites list
     *
     * @param gameLevel
     ***/
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
    /**
     * Function Name:removeFromGame.
     * Function Operation: remove the ball From the gamepack.Game
     * @param g game
     ***/
    public void removeFromGame(GameLevel g){
        g.removeSprite(this);
    }
}

