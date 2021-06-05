package gamepack;

import java.awt.Color;
import java.util.ArrayList;

import backgroundpack.LevelName;
import ballpack.Ball;
import ballpack.BallRemover;
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import blockpack.Block;
import blockpack.BlockRemover;
import blockpack.Paddle;
import counterpack.Counter;
import counterpack.ScoreIndicator;
import counterpack.ScoreTrackingListener;
import geomatricprimitive.Point;
import geomatricprimitive.Rectangle;
import interfacespack.Animation;
import interfacespack.Collidable;
import interfacespack.HitListener;
import interfacespack.Sprite;
import interfacespack.SpriteCollection;

import java.util.List;

public class GameLevel implements Animation {
    //fields
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter counter;
    private Counter ballCounter;
    private Counter score;
    private AnimationRunner runner;
    private Boolean running;
    private LevelInformation levelInformation;
    private biuoop.KeyboardSensor keyboardSensor;

    //constructor

    /**
     * Function Name:GameLevel
     * Function Operation:construct new game
     *
     * @param levelInformation .
     * @param keyboardSensor   .
     * @param runner           .
     * @param scoreCounter     .
     ***/
    public GameLevel(LevelInformation levelInformation,
                     biuoop.KeyboardSensor keyboardSensor,
                     AnimationRunner runner,
                     Counter scoreCounter
    ) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.running = true;
        this.levelInformation = levelInformation;
        this.keyboardSensor = keyboardSensor;
        this.runner = runner;
        this.score = scoreCounter;

    }

    /**
     * Function Name:addCollidable.
     * Function Operation:
     *
     * @param c interfacespack.Collidable
     ***/
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Function Name:addSprite.
     *
     * @param s interfacespack.Sprite
     ***/
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    // Initialize a new game: create the Blocks and ballpack.Ball (and blockpack.Paddle)
    // and add them to the game.

    /**
     * Function Name:initialize
     * Function Operation:initialize the game
     * meaning that it create and objects for the game
     * add to the current list every object
     ***/
    public void initialize() {
        // add background to sprites list
        this.sprites.addSprite(this.levelInformation.getBackground());
        //creating balls
        //level 1
        if (this.levelInformation.numberOfBalls() == 1) {
            Ball ball = new Ball((new Point(400, 530)), 8
                    , Color.pink, this.environment);
            ball.setVelocity(this.levelInformation.initialBallVelocities().get(0));
            ball.addToGame(this);
        }
        // level 2
        if (this.levelInformation.numberOfBalls() == 10) {
            for (int i = 0; i < 10; i++) {
                Ball ball = new Ball((new Point(230 + i * 30, 530)), 8
                        , Color.PINK, this.environment);
                ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
                ball.addToGame(this);
            }
        }
        // level 3
        if (this.levelInformation.numberOfBalls() == 2) {
            for (int i = 0; i < 2; i++) {
                Ball ball = new Ball((new Point(360 + i * 40, 530)), 8
                        , Color.gray, this.environment);
                ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
                ball.addToGame(this);
            }

        }
        // level 4
        if (this.levelInformation.numberOfBalls() == 3) {
            for (int i = 0; i < 3; i++) {
                Ball ball = new Ball((new Point(360 + i * 40, 530)), 8
                        , Color.white, this.environment);
                ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
                ball.addToGame(this);
            }
        }
        // end of creating balls

        //set counters
        //block counter
        this.counter = new Counter(this.levelInformation.numberOfBlocksToRemove());
        //balls counter
        this.ballCounter = new Counter(this.levelInformation.numberOfBalls());

        //create blockRemover
        BlockRemover blockRemover = new BlockRemover(this, this.counter);
        //create ballRemover
        BallRemover ballRemover = new BallRemover(this, this.ballCounter);
        //create scoreTrackingListener
        ScoreTrackingListener scoreTrackingListener
                = new ScoreTrackingListener(this.score);
        // create listener lists
        List<HitListener> listenersList = new ArrayList<HitListener>();
        List<HitListener> deathListeners = new ArrayList<HitListener>();
        // add blockRemover to listenerList
        listenersList.add(blockRemover);
        // add scoreTrackingListener to  listenerList
        listenersList.add(scoreTrackingListener);
        // add ballRemover to deathList
        deathListeners.add(ballRemover);
        //create borders
        Rectangle recUppper = new Rectangle(new Point(0, 0), 800, 20);
        Rectangle recLeft = new Rectangle(new Point(0, 20), 20, 580);
        Rectangle recRight = new Rectangle(new Point(780, 20), 20, 580);
        Block blockUpper = new Block(listenersList, recUppper, Color.lightGray);
        Block blockLeft = new Block(listenersList, recLeft, Color.lightGray);
        Block blockRight = new Block(listenersList, recRight, Color.lightGray);
        //creating deathBlock
        Rectangle deathRec = new Rectangle(new Point(0, 605), 800, 20);
        Block deathBlock = new Block(deathListeners, deathRec, Color.lightGray);
        // add borders to game
        blockUpper.addToGame(this);
        blockLeft.addToGame(this);
        blockRight.addToGame(this);
        // add death block to the game
        deathBlock.addToGame(this);
        // creating blocks and add them to game
        for (Block block : this.levelInformation.blocks()) {
            block.setHitListeners(listenersList);
            block.addToGame(this);
        }

        //creating paddle
        Point point = new Point(380,555);
        //check if it is level 2
        if(this.levelInformation.paddleWidth()==650){
            point = new Point(100,555);
        }
        Rectangle paddleRec = new Rectangle(point,
                this.levelInformation.paddleWidth(), 10);
        Paddle paddle = new Paddle(paddleRec, Color.PINK, this.keyboardSensor);
        paddle.addToGame(this);
        //creating scoreIndicator
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        // add scoreIndicator to sprite list
        this.sprites.addSprite(scoreIndicator);
        // add name of level
        LevelName levelName = new LevelName(this.levelInformation.levelName());
        this.sprites.addSprite(levelName);


    }

    /**
     * Function Name:run.
     * Function Operation:draw all the sprites
     * on the surface and timed there movement
     ***/
    public void run() {
        this.runner.run(this);
    }

    /**
     * Function Name:removeCollidable.
     * Function Operation:remove collidable from list
     * calls game enviroment function
     *
     * @param c a interfacespack.Collidable to be removed
     ***/
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidableFromList(c);
    }

    /**
     * Function Name:removeSprite.
     * Function Operation:remove a giving sprite
     * calls sprite collection function
     *
     * @param s sprite
     ***/
    public void removeSprite(Sprite s) {
        this.sprites.removeSpriteFromList(s);
    }

    /**
     * Function Name:doOneFrame.
     * Function Operation:one turn of
     * the game.
     *
     * @param d surface
     ***/
    @Override
    public void doOneFrame(DrawSurface d) {
        int endGameBonus = 100;
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboardSensor.isPressed("p")) {
            Animation pauseScreen = new PauseScreen(this.keyboardSensor);
            KeyPressStoppableAnimation keyPressStoppableAnimation =
                    new KeyPressStoppableAnimation(this.keyboardSensor , this.keyboardSensor.SPACE_KEY.toString(),pauseScreen);
            this.runner.run(keyPressStoppableAnimation);
        }
        //check if there is zero blocks left
        if (this.counter.getValue() == 0) {
            this.score.increase(endGameBonus);
            this.running = false;
        }
        //check if there is zero balls left
        if (this.ballCounter.getValue() == 0) {
            this.running = false;
        }
    }

    /**
     * Function Name:shouldStop.
     * Function Operation: return a opposite boolean value
     *
     * @return blooean true/false
     ***/
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Function Name:remainingBalls.
     * Function Operation:return the number of remaining balls
     *
     * @return number of remaining balls
     ***/
    public int remainingBalls() {
        return this.ballCounter.getValue();
    }
}
