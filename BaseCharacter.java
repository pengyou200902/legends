/**
 * @author You Peng
 * @date 11/3/2021 8:04 PM
 */

public abstract class BaseCharacter {

    protected String name;

    BaseCharacter () {
        this.name = "undefined";
    }

    BaseCharacter (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }


    // Display information
    public abstract void showInfo();
}
