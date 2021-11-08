import java.util.ArrayList;

/**
 * @author You Peng
 * @date 11/7/2021 9:28 PM
 */


public class LegendCreator {
    public static RPGGame createLegendGame() {
        // load data
        System.out.println("\u001B[36m Loading game data \u001B[0m");

        // create items
        ArrayList<Weapon> weapons = (ArrayList<Weapon>) ItemCreator.createWeapons(DataReader.getData("data/Weaponry.txt"));
        ArrayList<Armor> armors = (ArrayList<Armor>) ItemCreator.createArmors(DataReader.getData("data/Armory.txt"));
        ArrayList<Potion> potions = (ArrayList<Potion>) ItemCreator.createPotions(DataReader.getData("data/Potions.txt"));
        ArrayList<Spell> spells = (ArrayList<Spell>) ItemCreator.createFireSpells(DataReader.getData("data/FireSpells.txt"));
        spells.addAll(ItemCreator.createIceSpells(DataReader.getData("data/IceSpells.txt")));
        spells.addAll(ItemCreator.createLightningSpells(DataReader.getData("data/LightningSpells.txt")));

        // create Heroes
        ArrayList<Warrior> warriors = (ArrayList<Warrior>) HeroCreator.createWarriors(DataReader.getData("data/Warriors.txt"));
        ArrayList<Sorcerer> sorcerers = (ArrayList<Sorcerer>) HeroCreator.createSorcerers(DataReader.getData("data/Sorcerers.txt"));
        ArrayList<Paladin> paladins = (ArrayList<Paladin>) HeroCreator.createPaladins(DataReader.getData("data/Paladins.txt"));
        // create Monsters
        ArrayList<Dragon> dragons = (ArrayList<Dragon>) MonsterCreator.createDragons(DataReader.getData("data/Dragons.txt"));
        ArrayList<Exoskeleton> exoskeletons = (ArrayList<Exoskeleton>) MonsterCreator.createExoskeletons(DataReader.getData("data/Exoskeletons.txt"));
        ArrayList<Spirit> spirits = (ArrayList<Spirit>) MonsterCreator.createSpirits(DataReader.getData("data/Spirits.txt"));

        // set up game
        System.out.println("\u001B[36m set up the game \u001B[0m");
        LegendMarket market = new LegendMarket(new Inventory(weapons, armors, potions, spells));
        HeroList HeroList = new HeroList(warriors, sorcerers, paladins);
        MonsterList MonsterList = new MonsterList(dragons, exoskeletons, spirits);
        LegendWorld world = new LegendWorld();
        MonstersAndHeroes game = new MonstersAndHeroes(world, HeroList, MonsterList, market);
        game.world.generate();
        System.out.println("Finish loading!\n");

        return game;
    }
}
