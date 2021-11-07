import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author You Peng
 * @date 11/3/2021 8:40 PM
 */

public class Hero extends RPGCharacter {

    protected int exp;
    protected double money;
    // mp is mana
    protected double mp;
    protected double str;
    protected double dex;
    protected double agi;
    protected Inventory inventory;
    protected Weapon weapon;
    protected Armor armor;

    public Hero(){
        super();
        this.exp = 0;
        this.money = 0;
        this.mp = 0;
        this.defense = 0;
        this.str = 1;
        this.dex = 1;
        this.agi = 1;
        this.inventory = new Inventory();
    }

    public Hero(String name, int exp, double mp, double str, double dex, double agi, double money){
        super(name, 1, 0);
        this.exp = exp;
        this.money = money;
        this.mp = mp;
        this.str = str;
        this.dex = dex;
        this.agi = agi;
        this.inventory = new Inventory();
    }

    /** Take an action in battle */
    public void action(RPGCharacter enemy){
        boolean invalid;
        String choice;
        Monster monster = (Monster)enemy;
        Scanner in = new Scanner(System.in);
        System.out.println("\n\u001B[31m Turn "+this.name+" V.S "+enemy.getName()+"\u001B[0m\n");
        do {
            invalid = false;
            System.out.print("Choose action 1.Attack 2.Cast Spell 3.Drink Potion 4.Change Weapon 5.Change Armor or I/i to view info:");
            choice = in.nextLine();
            switch (choice) {
                case "Q":
                case "q":
                    System.exit(0);
                case "I":
                case "i":
                    System.out.println("\n----------------");
                    System.out.println("  Hero Info");
                    System.out.println("----------------");
                    System.out.println("Level   Name\t\t HP  Mana  Equipped Weapon\t\t Equipped Armor");
                    System.out.println("---------------------------------------------------------------------");
                    this.printStatus();
                    System.out.println("\n----------------");
                    System.out.println("  Enemy Info");
                    System.out.println("----------------");
                    System.out.println("Level   Name\t\t HP  Defense");
                    System.out.println("------------------------------------");
                    enemy.printInfo();
                    System.out.println();
                    invalid = true;
                    break;
                case "1":
                    attack(monster);
                    break;
                case "2":
                    if (this.inventory.getSpellList().size() < 1) {
                        System.out.println("No spell in inventory:");
                        invalid = true;
                    } 
                    else {
                        castSpell(monster);
                    }
                    break;
                case "3":
                    if (this.inventory.getPotionList().size() < 1) {
                        System.out.println("No potion in inventory:");
                        invalid = true;
                    } 
                    else {
                        // choose potion, including using it
                        choosePotion();
                    }
                    break;
                case "4":
                    if (this.inventory.getWeaponList().size() < 1) {
                        System.out.println("No weapon in inventory:");
                        invalid = true;
                    } 
                    else {
                        changeWeapon();
                    }
                    break;
                case "5":
                    if (this.inventory.getArmorList().size() < 1) {
                        System.out.println("No armor in inventory:");
                        invalid = true;
                    } 
                    else {
                        changeArmor();
                    }
                    break;
                default:
                    System.out.println("Invalid input, please input 1~5 or input I/i to view info:");
                    invalid = true;
                    break;
            }
        }while(invalid);
    }

    // buy sth from market
    public void buy(RPGItem product) {
        this.money -= product.getPrice();
        this.inventory.addItem(product);
    }

    public void sell() {
        this.inventory.printInfo();
        boolean invalid;
        String choice;
        Scanner in = new Scanner(System.in);
        do{
            invalid = false;
            this.chooseSellType();
            System.out.print("Enter C/c to sell another item or any other key to finish:");
            choice = in.nextLine();
            switch (choice) {
                case "Q", "q" -> System.exit(0);
                case "C", "c" -> invalid = true;
            }
        }while(invalid);
    }

    public void chooseSellType() {
        System.out.print("Enter the category of the item you want to sell 1.Weapon 2.Armor 3.Potion 4.Spell or R/r to return:");
        Scanner in = new Scanner(System.in);
        String category;
        boolean invalid;
        do {
            invalid = false;
            category = in.nextLine();
            switch (category) {
                case "Q":
                case "q":
                    System.exit(0);
                case "R":
                case "r":
                    return;
                case "1": {
                    ArrayList<Weapon> itemList = this.inventory.getWeaponList();
                    this.chooseSellItem(itemList);
                    break;
                }
                case "2": {
                    ArrayList<Armor> itemList = this.inventory.getArmorList();
                    this.chooseSellItem(itemList);
                    break;
                }
                case "3": {
                    ArrayList<Potion> itemList = this.inventory.getPotionList();
                    this.chooseSellItem(itemList);
                    break;
                }
                case "4": {
                    ArrayList<Spell> itemList = this.inventory.getSpellList();
                    this.chooseSellItem(itemList);
                    break;
                }
                default:
                    System.out.print("Invalid input, please choose from 1.Weapon 2.Armor 3.Potion 4.Spell:");
                    invalid = true;
                    break;
            }
        }while(invalid);
    }

    public <T extends Tradable> void chooseSellItem(List<T> itemList) {
//        ArrayList<Weapon> itemList = this.inventory.getWeapons();
        Scanner in = new Scanner(System.in);
        if (itemList.size() < 1) {
            System.out.println("\u001B[31m No such item in your inventory! \u001B[0m");
        } else {
            // select item you want to sell
            System.out.print("Enter the item index you want trade in:");
            String itemId;
            boolean invalid = true;
            do {
                invalid = false;
                itemId = in.nextLine();
                int idNum = Integer.parseInt(itemId);
                if (idNum > 0 && idNum <= itemList.size()) {
                    T i = itemList.remove(idNum - 1);
                    // Sale with half price
                    double gained = i.tradeIn();
                    RPGItem ri = (RPGItem) i;
                    this.money += gained;
                    System.out.print("\u001B[33m Sale " + ri.getName() + " with " + gained + " money.\u001B[0m");
                } else {
                    System.out.print("Invalid input, please input between 1 and " + itemList.size() + ":");
                    invalid = true;
                }
            } while (invalid);
        }
    }

    // change weapon
    public void changeWeapon() {
        // Display all weapons in inventory
        this.inventory.printWeapons();
        System.out.println("Enter weapon index you want to use:");

        boolean invalid = true;
        String itemID;
        ArrayList<Weapon> itemList = this.inventory.getWeaponList();
        Scanner in = new Scanner(System.in);
        do {
            itemID = in.nextLine();
            if (itemID.matches("\\d+")) {
                int idNum = Integer.parseInt(itemID);
                if (idNum > 0 && idNum <= itemList.size()) {
                    invalid = false;
                    this.wear(itemList.get(idNum - 1));
                    System.out.println("\u001B[33m" + this.name + " Now uses weapon " + this.weapon.getName() + "\u001B[0m");
                } else {
                    System.out.println("Please input a valid index:");
                }
            } else {
                System.out.println("Please input a valid index:");
            }
        } while (invalid);
    }

    // change armor
    public void changeArmor() {
        // Display all armors in inventory
        this.inventory.printArmors();
        System.out.println("Enter armor index you want to use:");

        boolean invalid = true;
        String itemID;
        ArrayList<Armor> itemList = this.inventory.getArmorList();
        Scanner in = new Scanner(System.in);
        do {
            itemID = in.nextLine();
            if (itemID.matches("\\d+")) {
                int idNum = Integer.parseInt(itemID);
                if (idNum > 0 && idNum <= itemList.size()) {
                    invalid = false;
                    this.wear(itemList.get(idNum - 1));
                    this.defense = this.armor.getDefense();
                    System.out.println("\u001B[33m" + this.name + " Now uses armor " + this.armor.getName() + "\u001B[0m");
                } else {
                    System.out.println("Please input a valid index:");
                }
            } else {
                System.out.println("Please input a valid index:");
            }
        } while (invalid);
    }

    // wear sth
    public <W extends Wearable> void wear(W wearable) {
        if (wearable instanceof Weapon) {
            this.weapon = (Weapon) wearable;
        }
        else if (wearable instanceof Armor) {
            this.armor = (Armor) wearable;
        }
    }

    public void usePotion(Potion potion) {
        System.out.println("\u001B[33m" + this.name + " Uses " + potion.getName() + "\u001B[0m");
        double amount = potion.getAmount();
        String[] attribs = potion.getAttributes();
        for (String attrib : attribs) {
            switch (attrib) {
                case "Health" -> this.hp += amount;
                case "Strength" -> this.str += amount;
                case "Dexterity" -> this.dex += amount;
                case "Agility" -> this.agi += amount;
                case "Defense" -> this.defense += amount;
            }
        }
    }

    // select a potion to use
    public void choosePotion() {
        this.inventory.printPotions();
        System.out.println("Enter the index of the potion you want to use:");
        ArrayList<Potion> itemList = this.inventory.getPotionList();
        Scanner in = new Scanner(System.in);
        String itemID;
        boolean valid = false;
        do {
            itemID = in.nextLine();
            if (itemID.matches("\\d+")) {
                int id = Integer.parseInt(itemID);
                if (id > 0 && id <= itemList.size()) {
                    valid = true;
                    Potion potion = itemList.get(id - 1);
                    potion.applyTo(this);
                    this.inventory.removePotion(id - 1);
                }
                else {
                    System.out.println("Please input a valid index:");
                }
            }
            else {
                System.out.println("Please input a valid index:");
            }
        } while (!valid);
    }

    // select a spell to cast
    public void castSpell(Monster target) {
        this.inventory.printSpells();
        System.out.print("Enter spell index you want to use:");
        boolean invalid = true;
        String itemID;
        ArrayList<Spell> itemList = this.inventory.getSpellList();
        Scanner in = new Scanner(System.in);
        do {
            itemID = in.nextLine();
            if (itemID.matches("\\d+")) {
                int idNum = Integer.parseInt(itemID);
                if (idNum > 0 && idNum <= itemList.size()) {
                    invalid = false;
                    Spell spell = itemList.get(idNum - 1);
                    if (spell.getMpCost() > this.mp) {
                        System.out.println("\u001B[33m" + this.name + " cast " + spell.getName() + " on  " + target.getName() + "\u001B[0m");
                        System.out.println("\u001B[31m Not enough MP for the spell! \u001B[0m");
                    } else {
                        // Reduce mana
                        this.mp -= spell.getMpCost();
                        // Take damage
                        double damage = spell.getDamage() * (1 + this.dex / 10000);
                        String affectAttribute = spell.getAffectAttribute();
                        target.getHurt(damage);
                        target.reduceAttribute(affectAttribute);
                        // Display message
                        System.out.println("\u001B[33m" + this.name + " cast " + spell.getName() + " on  " + target.getName() + "\u001B[0m");
                        System.out.println("\u001B[33m cause" + damage + " damage, reduce " + affectAttribute + "\u001B[0m");
                    }
                } else {
                    System.out.println("Please input a valid index:");
                }
            } else {
                System.out.println("Please input a valid index:");
            }
        } while (invalid);
    }

    /** Level up a hero */
    public void levelUp(){
        this.level += 1;
        this.hp = this.level * 100;
        this.mp *= 1.1;
    }

    // regain 10% hp and mp
    public void regain() {
        this.mp *= 1.1;
        this.hp *= 1.1;
    }

    // revive
    public void revive() {
        this.hp = this.level*50;
    }

    // win a battle and get rewards
    public void winBattle(double money, int exp) {
        // Gain money and exp
        this.money += money;
        this.exp += exp;
        // level up
        if (this.exp > this.level * 10) {
            this.exp = 0;
            this.levelUp();
        }
    }

    public void printInventory(){
        this.inventory.printInfo();
    }

    @Override
    public void attack(RPGCharacter enemy) {
        Monster monster = (Monster) enemy;
        if (monster.dodge()) {
            System.out.println("\n\u001B[33m" + this.name + " attack " + monster.name);
            System.out.println("miss! \u001B[0m\n");
        }
        else {
            double damage;
            if (this.weapon == null) {
                damage = (this.str - monster.getDefense()) * 0.05;
            }
            else {
                damage = (this.str + this.weapon.getDamage() - monster.getDefense()) * 0.05;
            }
            if (damage > 0) {
                monster.getHurt(damage);
            }

            System.out.println("\n\u001B[33m" + this.name + " attack " + monster.name);
            System.out.println("cause " + damage + " damage. \u001B[0m\n");
        }
    }

    public double getMoney() {
        return money;
    }

    @Override
    protected boolean dodge() {
        return Math.random() < this.agi * 0.002;
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return name + "\t\t" + mp + "  \t" + str + "  \t" + agi + "  \t" + dex + "  \t" + money + "  \t" + exp;
    }

    // print info during battle
    public void printStatus() {
        System.out.print(this.name + "\t\t" + this.hp + "  \t" + this.mp + "  \t");
        if (this.weapon == null && this.armor == null) {
            System.out.println("Not Equipped  \tNot Equipped");
        }
        else if (this.weapon == null) {
            System.out.println("Not Equipped  \t" + this.armor.getName());
        }
        else if (this.armor == null) {
            System.out.println(this.weapon.getName() + "  \tNot Equipped");
        }
        else {
            System.out.print(this.weapon.getName() + "  \t" + this.armor.getName());
        }
    }

}
