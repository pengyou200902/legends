/**
 * @author You Peng
 * @date 11/5/2021 8:10 PM
 */

public class Weapon extends RPGItem implements Wearable, Tradable {

    protected double damage;
    protected int numHands;

    public Weapon() {
        super();
        this.damage = 0;
        this.numHands = 1;
    }

    public Weapon(String name, int minLevel, double price, double damage, int numHands) {
        super(name, minLevel, price);
        this.damage = damage;
        this.numHands = numHands;
    }

    public int getNumHands() {
        return numHands;
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public double tradeIn() {
        return this.getPrice() / 2.0;
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return this.name + "\t\t " + this.price + "  " + this.minLevel + "  " + this.damage + "  " + this.numHands;
    }

}
