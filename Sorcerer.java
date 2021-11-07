/**
 * @author You Peng
 * @date 11/6/2021 8:54 PM
 */


public class Sorcerer extends Hero {
    public Sorcerer(){
        super();
    }

    public Sorcerer(String name, int exp, double mana, double str, double dex, double agi, double coins){
        super(name, exp, mana, str, dex, agi, coins);
    }

    // level up
    public void levelUp(){
        this.level += 1;
        this.hp = this.level * 100;
        this.mp *= 1.1;
        this.str *= 1.05;
        this.dex *= 1.1;
        this.agi *= 1.1;
    }
}
