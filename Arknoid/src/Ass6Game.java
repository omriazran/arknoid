import biuoop.GUI;
import gamepack.AnimationRunner;
import gamepack.DirectHitLevel;
import gamepack.FinalFour;
import gamepack.GameFlow;
import gamepack.GameLevel;
import gamepack.Green3Level;
import gamepack.LevelInformation;
import gamepack.WideEasyLevel;

import java.util.ArrayList;
import java.util.List;

/**********
 * omri azran
 * 316098979
 * 01
 * ass6
 ***********/
public class Ass6Game {
    /**
     * Function Name:main
     * Function Operation:runs a game levels according to user input.
     * @param args the order of the levels the user wants to play
     ***/
    public static void main(String[] args) {

        if(args.length == 0){
          defaultRun();
        }
        else{
            List<LevelInformation> levels = new ArrayList<LevelInformation>();
            for(int i=0 ; i<args.length;i++)
            {
                //level 1 directHit
                if(args[i].equals("1")){
                    DirectHitLevel directHitLevel = new DirectHitLevel();
                    levels.add(directHitLevel);
                }
                //level 2 wideEasyLevel
                if(args[i].equals("2")){
                    WideEasyLevel wideEasyLevel = new WideEasyLevel();
                    levels.add(wideEasyLevel);
                }
                //level 3 green3Level
                if(args[i].equals("3")){
                    Green3Level green3Level = new Green3Level();;
                    levels.add( green3Level);
                }
                //level 4 finalFour
                if(args[i].equals("4")){
                    FinalFour finalFour = new FinalFour();
                    levels.add(finalFour);
                }


            }
            if(!levels.isEmpty()){
                //creating gui
                biuoop.GUI gui = new GUI("Arkanoid",800,600);
                // creating animationRunner
                AnimationRunner animationRunner = new AnimationRunner(gui);

                GameFlow gameFlow = new GameFlow(animationRunner,gui.getKeyboardSensor());
                gameFlow.runLevels(levels);
                gui.close();
            }
            else {
                defaultRun();
            }
        }

    }
    /**
     * Function Name:defaultRun.
     * Function Operation: runs all four levels from 1 to 4
     ***/
    public static void defaultRun(){
        //creating gui
        biuoop.GUI gui = new GUI("Arkanoid",800,600);
        // creating animationRunner
        AnimationRunner animationRunner = new AnimationRunner(gui);
        //creating level information
        DirectHitLevel directHitLevel = new DirectHitLevel();
        WideEasyLevel wideEasyLevel = new WideEasyLevel();
        Green3Level green3Level = new Green3Level();
        FinalFour finalFour = new FinalFour();
        //creating level list
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        //add them to the list
        levels.add(directHitLevel);
        levels.add(wideEasyLevel);
        levels.add(green3Level);
        levels.add(finalFour);
        GameFlow gameFlow = new GameFlow(animationRunner,gui.getKeyboardSensor());
        gameFlow.runLevels(levels);
        gui.close();

    }
}
