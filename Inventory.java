/**
 * @author You Peng
 * @date 11/5/2021 8:00 PM
 */

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    protected ArrayList<Weapon> weaponList;
    protected ArrayList<Armor> armorList;
    protected ArrayList<Potion> potionList;
    protected ArrayList<Spell> spellList;

    Inventory() {
        this.weaponList = new ArrayList<>();
        this.armorList = new ArrayList<>();
        this.potionList = new ArrayList<>();
        this.spellList = new ArrayList<>();
    }

    public Inventory(ArrayList<Weapon> weaponList, ArrayList<Armor> armorList, ArrayList<Potion> potionList, ArrayList<Spell> spellList) {
        this.weaponList = weaponList;
        this.armorList = armorList;
        this.potionList = potionList;
        this.spellList = spellList;
    }

    // Add Item to inventory
    public void addItem(Item item) {
        if (item instanceof Weapon) {
            this.weaponList.add((Weapon) item);
        }
        else if (item instanceof Armor) {
            this.armorList.add((Armor) item);
        }
        else if (item instanceof Potion) {
            this.potionList.add((Potion) item);
        }
        else if (item instanceof Spell) {
            this.spellList.add((Spell) item);
        }
    }


    // getters
    public ArrayList<Weapon> getWeaponList() {
        return weaponList;
    }

    public ArrayList<Armor> getArmorList() {
        return armorList;
    }

    public ArrayList<Potion> getPotionList() {
        return potionList;
    }

    public ArrayList<Spell> getSpellList() {
        return spellList;
    }


    // Get by index
    public Weapon getWeapon(int index) {
        return this.weaponList.get(index);
    }

    public Armor getArmor(int index) {
        return this.armorList.get(index);
    }

    public Potion getPotion(int index) {
        return this.potionList.get(index);
    }

    public Spell getSpell(int index) {
        return this.spellList.get(index);
    }



    // remove by index
    public Weapon removeWeapon(int index) {
        return this.weaponList.remove(index);
    }

    public Armor removeArmor(int index) {
        return this.armorList.remove(index);
    }

    public Potion removePotion(int index) {
        return this.potionList.remove(index);
    }

    public Spell removeSpell(int index) {
        return this.spellList.remove(index);
    }


    // print the inventory
    public void printInfo() {
        System.out.println();
        this.printWeapons();
        System.out.println();
        this.printArmors();
        System.out.println();
        this.printPotions();
        System.out.println();
        this.printSpells();
    }


    // print weapons in the market
    public void printWeapons() {
        System.out.println("     \u001B[36mWeapons  List\u001B[0m  \n");
        System.out.println("ID   Name\t\t Price  Required Level  Damage  Required Hands");
        System.out.println("-------------------------------------------------------------------------------------");
        commonPrint(this.weaponList);
    }


    // print armors in the market
    public void printArmors() {
        System.out.println("     \u001B[36mArmors  List\u001B[0m  \n");
        System.out.println("ID   Name\t\t Price  Required Level  Damage Reduction");
        System.out.println("---------------------------------------------------------------------------");
        commonPrint(this.armorList);
    }


    // print potions in the market
    public void printPotions() {
        System.out.println("     \u001B[36mPotions  List\u001B[0m  \n");
        System.out.println("ID   Name\t\t Price  Required Level  Increment  Attribute Affected");
        System.out.println("------------------------------------------------------------------------------------------------------");
        commonPrint(this.potionList);
    }


    // print spells in the market
    public void printSpells() {
        System.out.println("     \u001B[36mSpells List\u001B[0m  \n");
        System.out.println("ID   Name\t\t Price  Required Level  Damage  Mana Cost  Type");
        System.out.println("------------------------------------------------------------------------------------------");
        commonPrint(this.spellList);
    }

    // common part
    public <T extends RPGItem> void commonPrint(List<T> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            System.out.print(" " + (i + 1) + "   ");
            itemList.get(i).printInfo();
        }
    }

}
