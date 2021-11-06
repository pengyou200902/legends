/**
 * @author You Peng
 * @date 11/3/2021 8:40 PM
 */

public class Hero extends RPGCharacter {

    protected int exp;
    protected double money;
    // mp is mana
    protected double mp;
    protected double str;
    protected double dex;
    protected double agi;
    protected Inventory inventory;
    protected Weapon weapon;
    protected Armor armor;


    public <W extends Wearable> void wear(W wearable) {
        if (wearable instanceof Weapon) {
            this.weapon = (Weapon) wearable;
        }
        else if (wearable instanceof Armor) {
            this.armor = (Armor) wearable;
        }
    }

    public void usePotion(Potion potion) {

    }

    public void castSpell(Monster target) {

    }

    /** Level up a hero */
    public void levelUp(){
        this.level += 1;
        this.hp = this.level * 100;
        this.mp *= 1.1;
    }

    @Override
    public void attack(RPGCharacter enemy) {

    }

    @Override
    protected boolean dodge() {
        return false;
    }

    @Override
    public void showInfo() {

    }
}
