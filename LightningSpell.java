/**
 * @author You Peng
 * @date 11/5/2021 9:21 PM
 */

public class LightningSpell extends Spell {


    public LightningSpell() {
        super();
        this.affectAttribute = "dodge";
    }

    public LightningSpell(String name, int minLevel, double price, double damage, double manaCost) {
        super(name, minLevel, price, damage, manaCost);
    }

    @Override
    public String getAffectAttribute() {
        return affectAttribute;
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return name + "\t\t" + price + "  " + minLevel + "  " + damage + "  " + mpCost + "  Lightning";
    }
}
