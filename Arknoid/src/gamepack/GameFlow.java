package gamepack;

import counterpack.Counter;
import interfacespack.Animation;

import java.util.List;

public class GameFlow {
    //fields
    private AnimationRunner runner;
    private biuoop.KeyboardSensor keyboardSensor;
    private Counter scoreCounter;
    //constructor
    /**
     * Function Name: GameFlow.
     * Function Operation: constructor
     * @param runner .
     * @param keyboardSensor .
     ***/
public GameFlow(AnimationRunner runner, biuoop.KeyboardSensor keyboardSensor){
    this.runner = runner;
    this.keyboardSensor = keyboardSensor;
    this.scoreCounter = new Counter(0);
}
    /**
     * Function Name:runLevels.
     * Function Operation:run all the Levels in levels list
     * @param levels list of levels
     ***/

    public void runLevels(List<LevelInformation> levels) {
        Boolean isWin = true;

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo,
                    this.keyboardSensor,this.runner,this.scoreCounter);

            level.initialize();

            while (!level.shouldStop()) {
                level.run();
            }

            if (level.remainingBalls() == 0) {
                Animation gameOver = new GameOver(this.keyboardSensor ,this.scoreCounter);
                KeyPressStoppableAnimation keyPressStoppableAnimation =
                        new KeyPressStoppableAnimation(this.keyboardSensor , this.keyboardSensor.SPACE_KEY.toString(),gameOver);
                this.runner.run(keyPressStoppableAnimation);
                isWin = false;
                break;
            }

        }
        if(isWin){
            Animation youWin = new YouWinScreen(this.keyboardSensor ,this.scoreCounter);
            KeyPressStoppableAnimation keyPressStoppableAnimation =
                    new KeyPressStoppableAnimation(this.keyboardSensor ,this.keyboardSensor.SPACE_KEY.toString(),youWin);
            this.runner.run(keyPressStoppableAnimation);
        }
    }
}
