/**
 * @author You Peng
 * @date 11/5/2021 9:21 PM
 */

public class LightningSpell extends Spell {


    public LightningSpell() {
        super();
        this.affectAttribute = "dodge";
    }

    @Override
    public String getAffectAttribute() {
        return affectAttribute;
    }

    @Override
    public void showInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return name + "\t\t" + price + "  " + minLevel + "  " + damage + "  " + mpCost + "  Lightning";
    }
}