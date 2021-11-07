/**
 * @author You Peng
 * @date 11/6/2021 8:57 PM
 */


public class MonsterTeam extends Team {

    public MonsterTeam(){
        super();
    }
    
    public void takeTurn(HeroTeam heroes) {
        for (int i = 0; i < characters.size(); i++) {
            // all monsters faint, end battle
            if (heroes.isFaint()) {
                break;
            }
            Monster m = (Monster) this.characters.get(i);
            Hero h = (Hero) heroes.getCharacter(i);
            // If both hero and monster is alive, fight
            if (h.isAlive() && m.isAlive()) {
                m.attack(h);
            }
            else if (m.isAlive()) {
                // if that hero die, attack the first alive hero
                for (int j = 0; j < heroes.size(); j++) {
                    Hero otherH = (Hero) heroes.getCharacter(j);
                    if (otherH.isAlive()) {
                        m.attack(otherH);
                        break;
                    }
                }
            }
        }
    }

    // check if whole team faints
    public boolean isFaint(){
        for(BaseCharacter c : this.characters) {
            Monster m = (Monster) c;
            if (m.isAlive()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printTeam() {
        System.out.println("-----------------------------------------");
        System.out.println("       \u001B[35m Monster Team \u001B[0m");
        System.out.println("-----------------------------------------");
        System.out.println("ID   Level   Name                    HP      Defense       Damage");
        System.out.println("------------------------------------------------------------------------------");
        for (int i = 0; i < this.characters.size(); i++) {
            Monster m = (Monster) this.characters.get(i);
            System.out.print((i + 1) + "     ");
            m.printInfo();
        }
    }
}
