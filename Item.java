/**
 * @author You Peng
 * @date 11/5/2021 8:04 PM
 */

public abstract class Item {
    protected String name;

    public Item() {
        this.name = "undefined";
    }

    public Item(String name) {
        this.name = name;
    }

    public abstract void printInfo();

    public String getName() {
        return name;
    }
}
