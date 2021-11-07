import java.util.ArrayList;
import java.util.Random;

/**
 * @author You Peng
 * @date 11/6/2021 3:44 PM
 */


public class MonsterList {

    protected ArrayList<Dragon> dragons;
    protected ArrayList<Exoskeleton> skeletons;
    protected ArrayList<Spirit> spirits;

    public MonsterList() {}

    public MonsterList(ArrayList<Dragon> dragons, ArrayList<Exoskeleton> skeletons, ArrayList<Spirit> spirits) {
        this.dragons = dragons;
        this.skeletons = skeletons;
        this.spirits = spirits;
    }

    // create monster team
    public MonsterTeam createTeam(int num, int level) {
        ArrayList<Monster> monsterList = new ArrayList<>();

        // create candidates to form a team
        for (Dragon d : this.dragons) {
            if (d.getLevel() == level) {
                monsterList.add(d);
            }
        }
        for (Exoskeleton s : this.skeletons) {
            if (s.getLevel() == level) {
                monsterList.add(s);
            }
        }
        for (Spirit s : this.spirits) {
            if (s.getLevel() == level) {
                monsterList.add(s);
            }
        }

        // add monsters to a team randomly
        MonsterTeam team = new MonsterTeam();
        for (int i = 0; i < num; i++) {
            team.addCharacter(monsterList.get(new Random().nextInt(monsterList.size())));
        }
        return team;
    }

}
