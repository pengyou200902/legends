/**
 * @author You Peng
 * @date 11/5/2021 8:11 PM
 */

public abstract class Spell extends RPGItem implements Castable, Tradable {

    protected String affectAttribute = null;

    protected double damage;
    protected double mpCost;

    public Spell() {
        super();
        this.damage = 0;
        this.mpCost = 0;
    }

    public Spell(String name, int minLevel, double price, double damage, double mpCost) {
        super(name, minLevel, price);
        this.damage = damage;
        this.mpCost = mpCost;
    }

    @Override
    public double tradeIn() {
        return this.getPrice() / 2.0;
    }

    @Override
    public void cast(Hero hero, Monster target) {
        hero.castSpell(target);
    }

    public double getDamage() {
        return damage;
    }

    public double getMpCost() {
        return mpCost;
    }

    public abstract String getAffectAttribute();

    public abstract void printInfo();


}
