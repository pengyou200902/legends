/**
 * @author You Peng
 * @date 11/7/2021 9:28 PM
 */


public class LegendController {
    public static void runGame() {
        MonstersAndHeroes game = (MonstersAndHeroes) LegendCreator.createLegendGame();

        // start game
        game.welcome();
        game.play();
    }
}
