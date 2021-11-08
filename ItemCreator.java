import java.util.ArrayList;
import java.util.List;

/**
 * @author You Peng
 * @date 11/7/2021 9:45 PM
 */


public class ItemCreator {

    public static List<Weapon> createWeapons(List<List<String>> args) {
        if (args == null)   return new ArrayList<>();

        List<Weapon> weapons = new ArrayList<>();
        for (List<String> config : args) {
            weapons.add(
                    new Weapon(
                            config.get(0),
                            Integer.parseInt(config.get(1)),
                            Double.parseDouble(config.get(2)),
                            Double.parseDouble(config.get(3)),
                            Integer.parseInt(config.get(4))
                    )
            );
        }
        return weapons;
    }

    public static List<Armor> createArmors(List<List<String>> args) {
        if (args == null)   return new ArrayList<>();

        List<Armor> armors = new ArrayList<>();
        for (List<String> config : args) {
            armors.add(
                    new Armor(
                            config.get(0),
                            Integer.parseInt(config.get(1)),
                            Double.parseDouble(config.get(2)),
                            Double.parseDouble(config.get(3))
                    )
            );
        }
        return armors;
    }

    public static List<Potion> createPotions(List<List<String>> args) {
        if (args == null)   return new ArrayList<>();

        // Name/level/damage/defense/dodge chance
        List<Potion> potions = new ArrayList<>();
        for (List<String> config : args) {
            potions.add(
                    new Potion(
                            config.get(0),
                            Integer.parseInt(config.get(2)),
                            Double.parseDouble(config.get(1)),
                            config.get(4).split("/ "),
                            Double.parseDouble(config.get(3))
                    )
            );
        }
        return potions;
    }

    public static List<Spell> createFireSpells(List<List<String>> args) {
        if (args == null)   return new ArrayList<>();

        // Name/cost/required level/damage/mana cost
        List<Spell> spells = new ArrayList<>();
        for (List<String> config : args) {
            spells.add(new FireSpell(
                    config.get(0),
                    Integer.parseInt(config.get(1)),
                    Double.parseDouble(config.get(2)),
                    Double.parseDouble(config.get(3)),
                    Double.parseDouble(config.get(4)))
            );
        }
        return spells;
    }

    public static List<Spell> createIceSpells(List<List<String>> args) {
        if (args == null)   return new ArrayList<>();

        // Name/cost/required level/damage/mana cost
        List<Spell> spells = new ArrayList<>();
        for (List<String> config : args) {
            spells.add(new IceSpell(
                    config.get(0),
                    Integer.parseInt(config.get(1)),
                    Double.parseDouble(config.get(2)),
                    Double.parseDouble(config.get(3)),
                    Double.parseDouble(config.get(4)))
            );
        }
        return spells;
    }

    public static List<Spell> createLightningSpells(List<List<String>> args) {
        if (args == null)   return new ArrayList<>();

        // Name/cost/required level/damage/mana cost
        List<Spell> spells = new ArrayList<>();
        for (List<String> config : args) {
            spells.add(new LightningSpell(
                    config.get(0),
                    Integer.parseInt(config.get(1)),
                    Double.parseDouble(config.get(2)),
                    Double.parseDouble(config.get(3)),
                    Double.parseDouble(config.get(4)))
            );
        }
        return spells;
    }

}
