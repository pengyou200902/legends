/**
 * @author You Peng
 * @date 11/5/2021 9:21 PM
 */

public class FireSpell extends Spell {

    public FireSpell() {
        super();
        this.affectAttribute = "defense";
    }

    public FireSpell(String name, int minLevel, double price, double damage, double hpCost) {
        super(name, minLevel, price, damage, hpCost);
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
        return name + "\t\t" + price + "  " + minLevel + "  " + damage + "  " + mpCost + "  Fire";
    }



}
