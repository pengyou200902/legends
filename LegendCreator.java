import java.util.ArrayList;

/**
 * @author You Peng
 * @date 11/7/2021 9:28 PM
 */


public class LegendCreator {
    public static RPGGame createLegendGame() {
        // load data
        System.out.println("\u001B[36m Loading game data \u001B[0m");
        
        String folder = "./ConfigFiles/";

        // create items
        ArrayList<Weapon> weapons = (ArrayList<Weapon>) ItemCreator.createWeapons(DataReader.getData(folder + "/Weaponry.txt", 1));
        ArrayList<Armor> armors = (ArrayList<Armor>) ItemCreator.createArmors(DataReader.getData(folder + "/Armory.txt", 1));
        ArrayList<Potion> potions = (ArrayList<Potion>) ItemCreator.createPotions(DataReader.getData(folder + "/Potions.txt", 1));
        ArrayList<Spell> spells = (ArrayList<Spell>) ItemCreator.createFireSpells(DataReader.getData(folder + "/FireSpells.txt", 1));
        spells.addAll(ItemCreator.createIceSpells(DataReader.getData(folder + "/IceSpells.txt", 1)));
        spells.addAll(ItemCreator.createLightningSpells(DataReader.getData(folder + "/LightningSpells.txt", 1)));

        // create Heroes
        ArrayList<Warrior> warriors = (ArrayList<Warrior>) HeroCreator.createWarriors(DataReader.getData(folder + "/Warriors.txt", 1));
        ArrayList<Sorcerer> sorcerers = (ArrayList<Sorcerer>) HeroCreator.createSorcerers(DataReader.getData(folder + "/Sorcerers.txt", 1));
        ArrayList<Paladin> paladins = (ArrayList<Paladin>) HeroCreator.createPaladins(DataReader.getData(folder + "/Paladins.txt", 1));
        // create Monsters
        ArrayList<Dragon> dragons = (ArrayList<Dragon>) MonsterCreator.createDragons(DataReader.getData(folder + "/Dragons.txt", 1));
        ArrayList<Exoskeleton> exoskeletons = (ArrayList<Exoskeleton>) MonsterCreator.createExoskeletons(DataReader.getData(folder + "/Exoskeletons.txt", 1));
        ArrayList<Spirit> spirits = (ArrayList<Spirit>) MonsterCreator.createSpirits(DataReader.getData(folder + "/Spirits.txt", 1));

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
