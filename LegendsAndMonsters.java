import java.util.Scanner;

/**
 * @author You Peng
 * @date 11/6/2021 3:33 PM
 */


public class LegendsAndMonsters extends RPGGame {

    protected HeroList heroList;
    protected MonsterList monsterList;
    protected HeroTeam team;
    protected LegendMarket market;

    public LegendsAndMonsters() {
        super();
        this.team = new HeroTeam();
    }

    public LegendsAndMonsters(LegendWorld world, HeroList heroList, MonsterList monsterList, LegendMarket market) {
        super(world);
        this.heroList = heroList;
        this.monsterList = monsterList;
        this.market = market;
        this.team = new HeroTeam();
    }
    
    // welcome message
    public void welcome() {
        System.out.println("\n \u001B[35m ========================================== \u001B[0m \n");
        System.out.println("       \u001B[35m LEGENDS: MOSTER AND HEROES \u001B[0m");
        System.out.println("\n \u001B[35m ========================================== \u001B[0m \n");
        System.out.println("  \u001B[35mWelcome to the world of adventure!\n");
        System.out.println("  Control your heroes to fight against monsters.");
        System.out.println("  You may randomly encounter fights during you adventure.");
        System.out.println("  Heroes gain money and experience by winning the fight.");
        System.out.println("  Markets are the place where you can sell and buy things.");
        System.out.println("  You can buy weapons, armors, potions, or spells and trade in those you no longer need.\u001B[0m");
        System.out.print("\nInput I/i to view info, Q/q to exit, or any other key to start play:");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("I") || choice.equals("i")) {
            this.info();
            this.init();
        } else if (choice.equals("Q") || choice.equals("q")) {
            System.exit(0);
        } else {
            this.init();
        }
    }

    // create teams
    public void init() {
        System.out.println("\n     You can create your team!\n");
        System.out.println("       You can choose 3 types of heroes: Warriors, Sorcerers and Paladins.");
        System.out.println("       Note: you can choose up to 3 heroes to form a team.\n");
        
        // add characters
        boolean invalid = true;
        do {
            // print heroes info
            this.heroList.printAllHeroes();
            // create team
            this.team.addCharacter(this.heroList.chooseHero());
            if (this.team.size() == 3) {
                invalid = false;
            } else {
                System.out.print("Do you want to select another hero? (Y/y for yes, N/n for no or Q/q to quit game):");
                boolean anotherHero;
                String choice;
                Scanner scanner = new Scanner(System.in);
                do {
                    choice = scanner.nextLine();
                    anotherHero = false;
                    switch (choice) {
                        case "Y":
                        case "y":
                            continue;
                        case "N":
                        case "n":
                            invalid = false;
                            break;
                        case "Q":
                        case "q":
                            System.exit(0);
                        default:
                            System.out.print("Invalid input, please input Y/y for yes, N/n for no:");
                            anotherHero = true;
                            break;
                    }
                } while (anotherHero);
            }
        } while (invalid);
    }

    // play game
    public void play() {
        // End the game if all heroes die
        do {
            // Show world map before move
            this.world.printMap();
            // Move team to new tile pos
            this.move();
            // Launch event on that tile
            this.event();
        } while (!this.team.isFaint());
    }

    public void event() {
        // get team pos
        int teamX = this.team.getX();
        int teamY = this.team.getY();
        String teamTile = this.world.getTile(teamX, teamY);
        
        // on a Market tile then trade
        if (teamTile.equals(LegendWorld.MARKET_TILE)) {
            System.out.println();
            System.out.println("\u001B[32m You Found a Market. \u001B[0m");
            System.out.println();
            this.trade();
        } else {
            // encounter a battle with 80% chance on a common tile
            if (Math.random() < 0.80) {
                System.out.println("\n\u001B[31m You get a fight. \u001B[0m\n");
                this.fight();
            } else {
                System.out.println("\n\u001B[35m Nothing special happened. \u001B[0m\n");
                this.common();
            }
        }
        // Update change to the world
        this.world.updateTeamPos(this.team.getXPos(), this.team.getYPos());
    }

    // print game info
    public void info() {
        System.out.println("\n       \u001B[33m CONTROL INFO \u001B[0m\n");
        System.out.println("        W/w - go up");
        System.out.println("        A/a - go left");
        System.out.println("        S/s - go down");
        System.out.println("        D/d - go right");
        System.out.println("        Q/q - quit game");
        System.out.println("        I/i - print information");
        System.out.println("\n       \u001B[33m Map Info \u001B[0m\n");
        System.out.println("       \u001B[31m X means\u001B[0m - team");
        System.out.println("       \u001B[34m M means\u001B[0m - market");
        System.out.println("        O means - inaccessible tile\n");
        // exit menu
        System.out.print("Input C/c to continue play or Q/q to exit game:");
        String choice;
        boolean keepPlay = true;
        Scanner in = new Scanner(System.in);
        do {
            choice = in.nextLine();
            switch (choice) {
                case "Q", "q" -> System.exit(0);
                case "C", "c" -> keepPlay = false;
            }
        } while (keepPlay);
    }

}
