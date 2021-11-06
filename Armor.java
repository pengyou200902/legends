/**
 * @author You Peng
 * @date 11/5/2021 8:10 PM
 */

public class Armor extends RPGItem implements Wearable, Tradeable {

    protected double defense;

    public Armor() {
        super();
        this.defense = 0;
    }

    public Armor(String name, int minLevel, double price, double defense) {
        super(name, minLevel, price);
        this.defense = defense;
    }


    public double getDefense() {
        return defense;
    }

//    @Override
//    public void putOnto(Hero hero) {
//        hero.wear(this);
//    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return this.name + "\t\t " + this.price + "  " + this.minLevel + "  " + this.defense;
    }

    @Override
    public double returnToMarket() {
        return this.getPrice() / 2.0;
    }
}
