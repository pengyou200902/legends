/**
 * @author You Peng
 * @date 11/7/2021 4:23 PM
 */


public abstract class RPGGame extends Game {

    protected World world;

    /* Default constructor */
    public RPGGame() {
    }

    /* User defined constructor */
    public RPGGame(World world) {
        this.world = world;
    }

    // fights may happen
    public abstract void fight();

    // Trade
    public abstract void trade();

    // print map
    public void printMap() {
        this.world.printMap();
    }
}
