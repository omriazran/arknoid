package blockpack;

import ballpack.Ball;
import ballpack.Velocity;
import biuoop.KeyboardSensor;
import gamepack.GameLevel;
import geomatricprimitive.Line;
import geomatricprimitive.Point;
import geomatricprimitive.Rectangle;
import interfacespack.Collidable;
import interfacespack.Sprite;

import java.awt.Color;

public class Paddle implements Sprite, Collidable {
    //fields
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private java.awt.Color color;
    //constructor

    /**
     * Function Name: paddle.
     * Function Operation:constructor
     *
     * @param rectangle
     * @param color
     ***/
    public Paddle(Rectangle rectangle, java.awt.Color color, KeyboardSensor keyboardSensor) {
        this.rectangle = rectangle;
        this.color = color;
        this.keyboard =keyboardSensor;
    }

    /**
     * Function Name:moveLeft.
     * Function Operation: move the paddle to the left
     ***/
    public void moveLeft() {
        double movementValue = -3;
        double leftBorder = 20; //width of the left block(border)
        if (this.rectangle.getUpperLeft().getX() + movementValue > leftBorder) {
            this.rectangle.setUpperLeftPoint(this.rectangle.getUpperLeft().getX()
                    + movementValue, this.rectangle.getUpperLeft().getY());
        }
    }

    /**
     * Function Name:moveRight.
     * Function Operation:move the paddle to the right
     ***/
    public void moveRight() {
        double movementValue = 3;
        double rightBorder = 780 - this.rectangle.getWidth();
        if (this.rectangle.getUpperLeft().getX() + movementValue < rightBorder) {
            this.rectangle.setUpperLeftPoint(this.rectangle.getUpperLeft().getX()
                    + movementValue, this.rectangle.getUpperLeft().getY());
        }
    }

    /**
     * Function Name:timePassed.
     * Function Operation: calls to move left
     * or move right according user key presses
     ***/
    // interfacespack.Sprite
    public void timePassed() {
        if (this.keyboard.isPressed(biuoop.KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * Function Name:drawOn.
     * Function Operation:draw the paddle on the surface
     *
     * @param d surface
     ***/
    public void drawOn(biuoop.DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());

    }

    /**
     * Function Name:getCollisionRectangle.
     * Function Operation:return the rectangle
     * field from the paddle
     *
     * @return rectangle
     ***/
    // interfacespack.Collidable
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Function Name:hit.
     * Function Operation: checks if a hit accord and is so
     * it is change the direction
     *
     * @param collisionPoint .
     * @param currentVelocity .
     * @param hitter ball
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
        Velocity newVelocity = null;
        double speed = Math.sqrt((Math.pow
                (currentVelocity.getDx(), 2)) + Math.pow(currentVelocity.getDy(), 2));

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
        //there is no hit
        if (!isOnUpperLine && !isOnLowerLine && !isOnRightLine && !isOnLeftLine) {
            return currentVelocity;
        }

        if (isOnUpperLine) {
            Line[] linesOfPaddle = new Line[5];
            double xStartValue = this.rectangle.getUpperLeft().getX();
            for (int i = 0; i < 5; i++) {
                Point leftPoint = new Point(xStartValue
                        , this.rectangle.getUpperLeft().getY());
                Point rightPoint = new Point(xStartValue + (this.rectangle.getWidth() / 5)
                        , this.rectangle.getUpperLeft().getY());
                linesOfPaddle[i] = new Line(leftPoint, rightPoint);
                xStartValue = xStartValue + (this.rectangle.getWidth() / 5);
            }
            //part 1 of paddle
            if (linesOfPaddle[0].isPointOnTheAlignedLine(collisionPoint)) {
                newVelocity = Velocity.fromAngleAndSpeed(210, speed);

            }
            //part 2 of paddle
            if (linesOfPaddle[1].isPointOnTheAlignedLine(collisionPoint)) {
                newVelocity = Velocity.fromAngleAndSpeed(240, speed);

            }
            //part 3 of paddle
            if (linesOfPaddle[2].isPointOnTheAlignedLine(collisionPoint)) {
                newVelocity = new Velocity(currentVelocity.getDx()
                        , currentVelocity.getDy() * changeDirection);

            }
            //part 4 of paddle
            if (linesOfPaddle[3].isPointOnTheAlignedLine(collisionPoint)) {
                newVelocity = Velocity.fromAngleAndSpeed(120, speed);

            }
            //part 5 of paddle
            if (linesOfPaddle[4].isPointOnTheAlignedLine(collisionPoint)) {
                newVelocity = Velocity.fromAngleAndSpeed(150, speed);
            }
            return newVelocity;
        }
        if (isOnLeftLine || isOnRightLine) {
            newVelocity = new Velocity(currentVelocity.getDx() * changeDirection
                    , currentVelocity.getDy());
        }
        if (isOnLowerLine) {
            newVelocity = new Velocity(newVelocity.getDx()
                    , newVelocity.getDy() * changeDirection);
        }
        return newVelocity;
    }


    /**
     * Function Name:addToGame.
     * Function Operation:Add this paddle to the game
     *
     * @param g game
     ***/
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}
