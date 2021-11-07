/**
 * @author You Peng
 * @date 11/6/2021 8:55 PM
 */


public class Paladin extends Hero {
    public Paladin(){
        super();
    }

    public Paladin(String name, int exp, double mana, double str, double dex, double agi, double coins){
        super(name, exp, mana, str, dex, agi, coins);
    }

    // level up
    public void levelUp(){
        this.level += 1;
        this.hp = this.level * 100;
        this.mp *= 1.1;
        this.str *= 1.1;
        this.dex *= 1.1;
        this.agi *= 1.05;
    }
}
