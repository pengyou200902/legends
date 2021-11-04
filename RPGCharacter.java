/**
 * @author You Peng
 * @date 11/3/2021 8:00 PM
 */

public abstract class RPGCharacter extends BaseCharacter {

    protected int level;
    protected double hp;
    protected double defense;

    public RPGCharacter() {
        super();
        level = 1;
        hp = level * 100;
        defense = 0;
    }

    public RPGCharacter(String name, int level, double defense) {
        super(name);
        this.level = level;
        this.hp = level * 100;
        this.defense = defense;
    }

    public abstract void attack(RPGCharacter enemy);

    protected abstract boolean dodge();

    protected void getDamage(double damage) {
        hp -= damage;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getLevel() {
        return level;
    }

    public double getHp() {
        return hp;
    }

    public double getDefense() {
        return defense;
    }
}
