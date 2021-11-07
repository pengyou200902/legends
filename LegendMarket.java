import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author You Peng
 * @date 11/6/2021 10:17 PM
 */


public class LegendMarket extends Market {

    protected Inventory inventory;

    public LegendMarket() {
        this.inventory = new Inventory();
    }
    
    public LegendMarket(Inventory inventory) {
        this.inventory = inventory;
    }

    // print weapons in the market
    public void printWeapons(){
        inventory.printWeapons();
    }

    // print armors in the market
    public void printArmors(){
        inventory.printArmors();
    }

    // print potions in the market
    public void printPotions(){
        inventory.printPotions();
    }

    // print spells in the market
    public void printSpells(){
        inventory.printSpells();
    }

    public void sellTo(Hero hero) {
        System.out.print("Enter the category of the item you want to buy 1.Weapon 2.Armor 3.Potion 4.Spell or R/r to return:");
        Scanner in = new Scanner(System.in);
        String itemType;
        boolean invalid;
        do {
            invalid = false;
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
                    this.chooseSellItem(hero, itemList);
                    break;
                }
                case "2": {
                    ArrayList<Armor> itemList = this.inventory.getArmorList();
                    this.chooseSellItem(hero, itemList);
                    break;
                }
                case "3": {
                    ArrayList<Potion> itemList = this.inventory.getPotionList();
                    this.chooseSellItem(hero, itemList);
                    break;
                }
                case "4": {
                    ArrayList<Spell> itemList = this.inventory.getSpellList();
                    this.chooseSellItem(hero, itemList);
                    break;
                }
                default:
                    System.out.print("Invalid input, please choose from 1.Weapon 2.Armor 3.Potion 4.Spell:");
                    invalid = true;
                    break;
            }
        }while(invalid);
    }

    // choose an item to sell to a hero
    public <T extends RPGItem> void chooseSellItem(Hero hero, List<T> itemList) {
        // select item want to buy
        System.out.print("Enter the item index you want to buy or Q/q to return:");
        int itemId;
        String choice;
        Scanner in = new Scanner(System.in);
        do {
            choice = in.nextLine();
            if (choice.equals("Q") || choice.equals("q")) {
                return;
            }
            else if (choice.matches("\\d+")) {
                itemId = Integer.parseInt(choice);
                if (itemId > 0 && itemId <= itemList.size()) {
                    T product = itemList.get(itemId - 1);
                    if (product.getPrice() > hero.getMoney()) {
                        System.out.println("\n\u001B[31m Not enough money!\n");
                    }
                    else {
                        hero.buy(product);
                        System.out.println("\n\u001B[33m" + hero.getName() + " bought " + product.getName() + "\u001B[0m\n");
                    }
                }
                else {
                    System.out.print("Invalid input, input between 1 and " + itemList.size() + ":");
                }
            }
            else {
                System.out.print("Invalid input, input between 1 and " + itemList.size() + ":");
            }
        } while(true);
    }

    @Override
    public void sell(Hero hero) {
        sellTo(hero);
    }

    @Override
    public void printInfo() {
        inventory.printInfo();
    }
}
