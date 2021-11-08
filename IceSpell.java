/**
 * @author You Peng
 * @date 11/5/2021 9:21 PM
 */

public class IceSpell extends Spell {


    public IceSpell() {
        super();
        this.affectAttribute = "damage";
    }

    public IceSpell(String name, int minLevel, double price, double damage, double mpCost) {
        super(name, minLevel, price, damage, mpCost);
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
        return name + "\t\t" + price + "  " + minLevel + "  " + damage + "  " + mpCost + "  Ice";
    }
}
