/**
 * @author You Peng
 * @date 11/6/2021 3:44 PM
 */

import java.util.ArrayList;
import java.util.Scanner;

public class HeroList {

    protected ArrayList<Warrior> warriors;
    protected ArrayList<Sorcerer> sorcerers;
    protected ArrayList<Paladin> paladins;

    public HeroList() {}

    public HeroList(ArrayList<Warrior> warriors, ArrayList<Sorcerer> sorcerers, ArrayList<Paladin> paladins){
        this.warriors = warriors;
        this.sorcerers = sorcerers;
        this.paladins = paladins;
    }

    public Hero chooseHero() {
        System.out.print("Choose the category of hero 1.Warrior 2.Sorcerer 3.Paladin or Q/q to quit game:");
        Scanner in = new Scanner(System.in);
        String heroCategory;
        ArrayList<? extends Hero> heroList = warriors;
        boolean invalid;
        do {
            invalid = false;
            heroCategory = in.nextLine();
            switch (heroCategory) {
                case "Q", "q" -> System.exit(0);
                case "1" -> heroList = warriors;
                case "2" -> heroList = sorcerers;
                case "3" -> heroList = paladins;
                default -> {
                    System.out.print("Invalid input, please input 1~3:");
                    invalid = true;
                }
            }
        } while (invalid);

        // select hero id
        System.out.print("Input hero index you want or Q/q to quit game:");
        int heroId;
        String choice;
        Hero hero = heroList.get(0);
        do {
            invalid = false;
            choice = in.nextLine();
            if (choice.equals("Q") || choice.equals("q")) {
                System.exit(0);
            }
            else if (choice.matches("\\d+")) {
                heroId = Integer.parseInt(choice);
                if (heroId > 0 && heroId <= heroList.size()) {
                    hero = heroList.get(heroId - 1);
                    System.out.println("\n\u001B[35m You choose " + hero.getName() + ".\u001B[0m\n");
                }
                else {
                    System.out.print("Invalid input, please choose from 1 to " + heroList.size() + ":");
                    invalid = true;
                }
            }
            else {
                System.out.print("Invalid input, please choose from 1 to " + heroList.size() + ":");
                invalid = true;
            }
        } while (invalid);
        return hero;
    }

    // print all heroes
    public void printAllHeroes() {
        System.out.println("\n\u001B[36m-----------------------------------------\u001B[0m\n");
        System.out.println("       \u001B[36m Avaliable Heroes \u001B[0m");
        System.out.println("\n\u001B[36m-----------------------------------------\u001B[0m\n");
        System.out.println("      \u001B[36m Warriors \u001B[0m  \n");
        this.printCategory(this.warriors);
        System.out.println("\n      \u001B[36m Sorcerers \u001B[0m  \n");
        this.printCategory(this.sorcerers);
        System.out.println("\n      \u001B[36m Paladins \u001B[0m   \n");
        this.printCategory(this.paladins);
        System.out.println();
    }

    // show heroes in a category
    public void printCategory(ArrayList<? extends Hero> heroes) {
        System.out.println("ID\tName\t\t\tMana  Strength  Agility  Dexterity  Starting Money  Starting Experience");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (int i = 0; i < heroes.size(); i++) {
            System.out.print(" " + (i + 1) + "   ");
            heroes.get(i).printInfo();
        }
    }

}
