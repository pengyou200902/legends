/**
 * @author You Peng
 * @date 11/5/2021 9:21 PM
 */

public class IceSpell extends Spell {


    public IceSpell() {
        super();
        this.affectAttribute = "damage";
    }

    @Override
    public String getAffectAttribute() {
        return affectAttribute;
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return name + "\t\t" + price + "  " + minLevel + "  " + damage + "  " + mpCost + "  Ice";
    }
}
