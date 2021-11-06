import java.util.ArrayList;
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
            if (choice.equals("Q") || choice.equals("q")) {
                System.exit(0);
            }
            else if (choice.equals("C") || choice.equals("c")) {
                invalid = true;
            }
        }while(invalid);
    }

    public void chooseSellType() {
        System.out.print("Enter the type of the item you want to sale 1.Weapon 2.Armor 3.Potion 4.Spell or R/r to return:");
        Scanner in = new Scanner(System.in);
        String itemType;
        boolean loop;
        do {
            loop = false;
            itemType = in.nextLine();
            switch (itemType) {
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
                    loop = true;
                    break;
            }
        }while(loop);
    }

    public <T extends Tradeable> void chooseSellItem(ArrayList<T> itemList) {
//        ArrayList<Weapon> itemList = this.inventory.getWeapons();
        Scanner in = new Scanner(System.in);
        if (itemList.size() < 1) {
            System.out.println("\u001B[31m No such item in your inventory! \u001B[0m");
        } else {
            // select item want to sell
            System.out.print("Enter the ID of the item you want to sale:");
            String itemId;
            boolean invalid = true;
            do {
                invalid = false;
                itemId = in.nextLine();
                int idNum = Integer.parseInt(itemId);
                if (idNum > 0 && idNum <= itemList.size()) {
                    T i = itemList.remove(idNum - 1);
                    // Sale with half price
                    double gained = i.returnToMarket();
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

    public void castSpell(Monster target) {

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
        this.inventory.printWeapons();
        this.inventory.printArmors();
        this.inventory.printPotions();
        this.inventory.printSpells();
    }

    @Override
    public void attack(RPGCharacter enemy) {

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
