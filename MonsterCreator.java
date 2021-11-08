import java.util.ArrayList;
import java.util.List;

/**
 * @author You Peng
 * @date 11/7/2021 8:39 PM
 */


public class MonsterCreator {

    public static List<Dragon> createDragons(List<List<String>> args) {
        // Name/level/damage/defense/dodge chance
        List<Dragon> monsters = new ArrayList<>();
        if (args == null)   return monsters;
        for (List<String> config : args) {
            monsters.add(
                    new Dragon(
                            config.get(0),
                            Integer.parseInt(config.get(1)),
                            Double.parseDouble(config.get(2)),
                            Double.parseDouble(config.get(3)),
                            Double.parseDouble(config.get(4))
                    )
            );
        }
        return monsters;
    }

    public static List<Exoskeleton> createExoskeletons(List<List<String>> args) {
        // Name/level/damage/defense/dodge chance
        List<Exoskeleton> monsters = new ArrayList<>();
        if (args == null)   return monsters;
        for (List<String> config : args) {
            monsters.add(
                    new Exoskeleton(
                            config.get(0),
                            Integer.parseInt(config.get(1)),
                            Double.parseDouble(config.get(2)),
                            Double.parseDouble(config.get(3)),
                            Double.parseDouble(config.get(4))
                    )
            );
        }
        return monsters;
    }

    public static List<Spirit> createSpirits(List<List<String>> args) {
        // Name/level/damage/defense/dodge chance
        List<Spirit> monsters = new ArrayList<>();
        if (args == null)   return monsters;
        for (List<String> config : args) {
            monsters.add(
                    new Spirit(
                            config.get(0),
                            Integer.parseInt(config.get(1)),
                            Double.parseDouble(config.get(2)),
                            Double.parseDouble(config.get(3)),
                            Double.parseDouble(config.get(4))
                    )
            );
        }
        return monsters;
    }

}
