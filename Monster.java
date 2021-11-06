/**
 * @author You Peng
 * @date 11/5/2021 9:42 PM
 */

public abstract class Monster extends RPGCharacter {
    protected double damage;
    protected double dodgeProbability;

    Monster() {
        super();
    }

    Monster(String name, int level, double damage, double defense, double dodgeProbability) {
        super(name, level, defense);
        this.damage = damage;
        this.dodgeProbability = dodgeProbability;
    }

    /**
     * Probability to dodge = dodgeProbability * 0.01
     *
     * @return true if success, false if not
     */
    public boolean dodge() {
        return Math.random() < this.dodgeProbability * 0.01;
    }

    /**
     * Attack a hero
     */
    public void attack(RPGCharacter enemy) {
        Hero hero = (Hero) enemy;
        System.out.println("Turn \u001B[31m" + this.name + " V.S. " + enemy.getName() + "\u001B[0m");
        if (hero.dodge()) {
            System.out.println();
            System.out.println("\u001B[33m Miss! \u001B[0m");
            System.out.println();
        }
        else {
            double damage = Math.round(this.damage - hero.getDefense());
            if (damage > 0) {
                hero.getDamage(damage);
            }
            // show message
            System.out.println("\u001B[33m" + this.name + " attack " + hero.name + " with " + damage + " damage. \u001B[0m");
        }
    }

    /**
     * Reduce attribute to 90%
     */
    public void reduceAttribute(String attributebName) {
        switch (attributebName) {
            case "defense" -> this.defense *= 0.9;
            case "damage" -> this.damage *= 0.9;
            case "dodge" -> this.dodgeProbability *= 0.9;
        }
    }

    public void showInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return this.level + "  " + this.name + "\t" + this.hp + "  " + this.defense + "  " + this.damage;
    }
}
