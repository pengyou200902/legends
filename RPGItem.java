/**
 * @author You Peng
 * @date 11/5/2021 8:04 PM
 */

public abstract class RPGItem extends Item {

    protected int minLevel;
    protected double price;

    public RPGItem() {
        super();
        minLevel = 0;
        price = 0;
    }

    public RPGItem(String name, int minLevel, double price) {
        super(name);
        this.minLevel = minLevel;
        this.price = price;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public double getPrice() {
        return price;
    }
}
