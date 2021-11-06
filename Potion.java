/**
 * @author You Peng
 * @date 11/5/2021 8:11 PM
 */

public class Potion extends RPGItem implements SingleUse {

    protected double amount;
    protected String[] attributes;

    public Potion() {
        super();
        this.amount = 0;
    }

    public Potion(String name, int minLevel, double price, double amount, String[] attributes) {
        super(name, minLevel, price);
        this.amount = amount;
        this.attributes = attributes;
    }

    public double getAmount() {
        return amount;
    }

    public String[] getAttributes() {
        return attributes;
    }

    @Override
    public void showInfo() {
        System.out.println(toString());
    }

    @Override
    public void applyTo(Hero hero) {
        hero.usePotion(this);
    }

    @Override
    public String toString() {
        return this.name
             + "\t\t "
             + this.price
             + "  "
             + this.minLevel
             + "  "
             + this.amount
             + "  "
             + String.join("/", this.attributes);
    }


}