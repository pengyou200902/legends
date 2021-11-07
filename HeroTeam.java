/**
 * @author You Peng
 * @date 11/6/2021 3:53 PM
 */


public class HeroTeam extends Team {
    protected int x;
    protected int y;

    public HeroTeam() {
        super();
        this.x = 0;
        this.y = 0;
    }

    public HeroTeam(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    // moves
    public void goUp() {
        this.y -= 1;
    }

    public void goDown() {
        this.y += 1;
    }

    public void goLeft() {
        this.x -= 1;
    }

    public void goRight() {
        this.x += 1;
    }

    // getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void takeTurn(MonsterTeam monsters) {
        for (int i = 0; i < characters.size(); i++) {
            // If all monsters faint, end the battle
            if (monsters.isFaint()) {
                break;
            }
            Hero h = (Hero) this.characters.get(i);
            Monster m = (Monster) monsters.getCharacter(i);
            // fight if both hero and monster are alive
            if (h.isAlive() && m.isAlive()) {
                h.action(m);
            } else if (h.isAlive()) {
                // if that monster die, attack the first monster that's still alive
                for (int j = 0; j < monsters.size(); j++) {
                    Monster otherM = (Monster) monsters.getCharacter(j);
                    if (otherM.isAlive()) {
                        h.action(otherM);
                        break;
                    }
                }
            }
        }
    }

    // get max level of the team
    public int getMaxLevel(){
        int max = -1;
        for (BaseCharacter c : this.characters) {
            Hero h = (Hero) c;
            int level = h.getLevel();
            if (level > max) {
                max = level;
            }
        }
        return max;
    }

    // check if whole team faints
    public boolean isFaint() {
        for (BaseCharacter c : this.characters) {
            Hero h = (Hero) c;
            if (h.isAlive()) {
                return false;
            }
        }
        return true;
    }


    // When win a battle, get rewards, faint hero revived by the other
    public void win(int monsterLevel) {
        for (BaseCharacter c : this.characters) {
            Hero h = (Hero) c;
            if (h.isAlive()) {
                h.winBattle(100 * monsterLevel, 2);
            } else {
                h.revive();
            }
        }
    }
    
    // display whole team info
    @Override
    public void printTeam() {
        System.out.println("------------------------");
        System.out.println("\t\tHero Team ");
        System.out.println("------------------------\n");
        System.out.println("ID   Level     Class    Name\t\t Mana  Strength  Agility  Dexterity  Money  Exp");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (int i = 0; i < this.characters.size(); i++) {
            Hero hero = (Hero) this.characters.get(i);
            System.out.print((i + 1) + "      " + hero.getLevel());
            if (hero instanceof Warrior) {
                System.out.print("  Warrior     ");
            }
            else if (hero instanceof Sorcerer) {
                System.out.print("  Sorcerer    ");
            }
            else if (hero instanceof Paladin) {
                System.out.print("  Paladin     ");
            }
            hero.printInfo();
        }
    }


}
