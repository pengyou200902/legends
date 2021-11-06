/**
 * @author You Peng
 * @date 11/5/2021 8:10 PM
 */

public class Weapon extends RPGItem implements Wearable {

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

//    @Override
//    public void putOnto(Hero hero) {
//        hero.wear(this);
//    }

    @Override
    public void showInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return this.name + "\t\t " + this.price + "  " + this.minLevel + "  " + this.damage + "  " + this.numHands;
    }

}
