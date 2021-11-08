import java.util.ArrayList;
import java.util.List;

/**
 * @author You Peng
 * @date 11/7/2021 8:37 PM
 */


public class HeroCreator {
    public static List<Warrior> createWarriors(List<List<String>> args) {
        if (args == null)   return null;
        // Name/mana/strength/agility/dexterity/starting money/starting experience
        List<Warrior> warriors = new ArrayList<>();
        for (List<String> config : args) {
            warriors.add(
                    new Warrior(
                            config.get(0),
                            Integer.parseInt(config.get(6)),
                            Double.parseDouble(config.get(1)),
                            Double.parseDouble(config.get(2)),
                            Double.parseDouble(config.get(3)),
                            Double.parseDouble(config.get(4)),
                            Double.parseDouble(config.get(5))
                    )
            );
        }
        return warriors;
    }

    public static List<Sorcerer> createSorcerers(List<List<String>> args) {
        if (args == null)   return null;
        // Name/mana/strength/agility/dexterity/starting money/starting experience
        List<Sorcerer> sorcerers = new ArrayList<>();
        for (List<String> config : args) {
            sorcerers.add(
                    new Sorcerer(
                            config.get(0),
                            Integer.parseInt(config.get(6)),
                            Double.parseDouble(config.get(1)),
                            Double.parseDouble(config.get(2)),
                            Double.parseDouble(config.get(3)),
                            Double.parseDouble(config.get(4)),
                            Double.parseDouble(config.get(5))
                    )
            );
        }
        return sorcerers;
    }

    public static List<Paladin> createPaladins(List<List<String>> args) {
        if (args == null)   return null;
        // Name/mana/strength/agility/dexterity/starting money/starting experience
        List<Paladin> paladins = new ArrayList<>();
        for (List<String> config : args) {
            paladins.add(
                    new Paladin(
                            config.get(0),
                            Integer.parseInt(config.get(6)),
                            Double.parseDouble(config.get(1)),
                            Double.parseDouble(config.get(2)),
                            Double.parseDouble(config.get(3)),
                            Double.parseDouble(config.get(4)),
                            Double.parseDouble(config.get(5))
                    )
            );
        }
        return paladins;
    }
}
