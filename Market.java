import java.util.Scanner;

/**
 * @author You Peng
 * @date 11/6/2021 9:40 PM
 */


public abstract class Market {
    public Market() {}

    public void welcome(HeroTeam team) {
        System.out.println("\n\u001B[32m-----------------------------------------\n");
        System.out.println("        Welcome to Market! ");
        System.out.println("\n-----------------------------------------\u001B[0m\n");

        Scanner in = new Scanner(System.in);
        if (team.size() == 1) {
            this.chooseAction((Hero) team.getCharacter(0));
        }
        else {
            team.printTeam();
            System.out.print("Select a hero or R/r to leave market:");
            int choice;
            boolean invalid = true;
            String key;
            do {
                key = in.nextLine();
                if (key.equals("Q") || key.equals("q")) {
                    System.exit(0);
                }
                if (key.equals("R") || key.equals("r")) {
                    invalid = false;
                }
                else if (key.matches("\\d+")) {
                    choice = Integer.parseInt(key);
                    if (choice > 0 && choice <= team.size()) {
                        this.chooseAction((Hero) team.getCharacter(choice - 1));
                    }
                    System.out.print("Select a hero or R/r to leave market:");
                }
                else {
                    System.out.print("Select a hero or R/r to leave market:");
                }
            } while (invalid);
        }
    }
    
    // choose to buy or sell
    public void chooseAction(Hero hero) {
        boolean invalid;
        String choice;
        Scanner in = new Scanner(System.in);
        System.out.print("Do you want to 1.Buy 2.Trade in or R/r to return:");
        do {
            invalid = false;
            choice = in.nextLine();
            switch (choice) {
                case "Q":
                case "q":
                    System.exit(0);
                case "R":
                case "r":
                    return;
                // hero buys
                case "1":
                    this.sell(hero);
                    break;
                // hero sells
                case "2":
                    hero.sell();
                    break;
                default:
                    System.out.print("Invalid input, please input 1~2 or R/r to return:");
                    invalid = true;
                    break;
            }
        } while (invalid);
    }


    // sell sth in the market to the hero
    public abstract void sell(Hero hero);


    // print items in market
    public abstract void printInfo();

}
