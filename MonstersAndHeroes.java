import java.util.Scanner;

/**
 * @author You Peng
 * @date 11/6/2021 3:33 PM
 */


public class MonstersAndHeroes extends RPGGame {

    protected LegendWorld world;
    protected HeroList heroList;
    protected MonsterList monsterList;
    protected HeroTeam team;
    protected LegendMarket market;

    public MonstersAndHeroes() {
        super();
        this.team = new HeroTeam();
    }

    public MonstersAndHeroes(LegendWorld world, HeroList heroList, MonsterList monsterList, LegendMarket market) {
        super(world);
        this.world = world;
        this.heroList = heroList;
        this.monsterList = monsterList;
        this.market = market;
        this.team = new HeroTeam();
    }
    
    // welcome message
    public void welcome() {
        System.out.println("\n \u001B[33m ========================================== \u001B[0m \n");
        System.out.println("       \u001B[33m Legends: Moster and Heroes \u001B[0m");
        System.out.println("\n \u001B[33m ========================================== \u001B[0m \n");
        System.out.println("  \u001B[33mWelcome to the world of adventure!\n");
        System.out.println("  Control your heroes to fight against monsters.");
        System.out.println("  You may randomly encounter fights during you adventure.");
        System.out.println("  Heroes gain money and experience by winning the fight.");
        System.out.println("  You can trade in and buy things in the markets.");
        System.out.println("  You can buy weapons, armors, potions, or spells and trade in those you no longer need.\u001B[0m");
        System.out.print("\nInput I/i to view info, Q/q to exit, or any other key to start play:");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("I") || choice.equals("i")) {
            this.printInfo();
            this.init();
        }
        else if (choice.equals("Q") || choice.equals("q")) {
            System.exit(0);
        }
        else {
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
            }
            else {
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
        // game over if all heroes die
        do {
            // print map before move
            this.printMap();
            // game starts
            this.run();
            // tile event
            this.event();
        } while (!this.team.isFaint());
    }

    // market, fight, nothing
    public void event() {
        // get team pos
        int teamX = this.team.getX();
        int teamY = this.team.getY();
        String teamTile = this.world.getTile(teamX, teamY);

        // on a Market tile then trade
        if (teamTile.equals(LegendWorld.MARKET_TILE)) {
            System.out.println("\n\u001B[32m You find a Market. \u001B[0m\n");
            this.trade();
        } else {
            // encounter a battle with 80% chance on a common tile
            if (Math.random() < 0.80) {
                System.out.println("\n\u001B[31m You encounter a fight. \u001B[0m\n");
                this.fight();
            } else {
                System.out.println("\n\u001B[33m Nothing special happened. \u001B[0m\n");
                this.nothingHappen();
            }
        }
        // update map
        this.world.setTeamLocation(this.team.getX(), this.team.getY());
    }

    // trade in market
    public void trade() {
        this.market.welcome(this.team);
    }

    // when nothing happen on common tile
    public void nothingHappen() {
        System.out.print("Input R/r to take a rest, or any other key to continue adventure:");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("Q") || choice.equals("q")) {
            System.exit(0);
        } else if (choice.equals("R") || choice.equals("r")) {
            // print team info
            this.team.printTeam();
//            boolean invalid = true;
            do {
                System.out.print("Enter Hero ID to view a hero, or C/c to continue adventure:");
                choice = scanner.nextLine();
                if (choice.equals("Q") || choice.equals("q")) {
                    System.exit(0);
                }
                else if (choice.matches("\\d+")) {
                    int heroId = Integer.parseInt(choice);
                    if (heroId > 0 && heroId <= this.team.size()) {
                        this.actionInRest((Hero) this.team.getCharacter(heroId - 1));
                    }
                    else {
                        System.out.print("Invalid input, input hero index view a hero or C/c to continue adventure:");
                    }
                }
                else if (!choice.equals("C") && !choice.equals("c")) {
                    System.out.print("Invalid input, input hero index view a hero or C/c to continue adventure:");
                }
            } while (true);
        }
    }

    // take action during rest
    protected void actionInRest(Hero hero){
        System.out.print("Do you want to 1.Check Inventory 2.Change Weapon 3.Change Armor 4.Drink Potion 5.Return:");
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean invalid;
        do {
                invalid = false;
                choice = scanner.nextLine();
                if(choice.equals("Q")||choice.equals("q")){
                    System.exit(0);
                }
                else if(choice.equals("1")){
                    hero.printInventory();
                }
                else if(choice.equals("2")){
                    hero.changeWeapon();
                }
                else if(choice.equals("3")){
                    hero.changeArmor();
                }
                else if(choice.equals("4")){
                    hero.choosePotion();
                }
                else if(choice.equals("5")){
                    break;
                }
                else{
                    System.out.print("Invalid input, input 1~5 ");
                    invalid = true;
                }
            } while(invalid);
    }

    @Override
    public void run() {
        System.out.print("You can make a further move:");
        // get team pos
        int teamX = this.team.getX();
        int teamY = this.team.getY();

        String direction;
        Scanner scanner = new Scanner(System.in);
        boolean move = true;
        do {
            direction = scanner.nextLine();
            switch (direction) {
                case "W":
                case "w":
                    if (teamY <= 0) {
                        System.out.print("You're at top edge, try another direction:");
                    }
                    else if (this.world.isInaccessible(teamX, teamY - 1)) {
                        System.out.print("Inaccessible tile, please try a another direction:");
                    }
                    else {
                        this.team.goUp();
                        move = false;
                    }
                    break;
                case "A":
                case "a":
                    if (teamX <= 0) {
                        System.out.print("You're at left edge, try a another direction:");
                    }
                    else if (this.world.isInaccessible(teamX - 1, teamY)) {
                        System.out.print("Inaccessible tile, please try a another direction:");
                    }
                    else {
                        this.team.goLeft();
                        move = false;
                    }
                    break;
                case "S":
                case "s":
                    if (teamY >= this.world.getHeight()) {
                        System.out.print("You're at bottom edge, try a another direction:");
                    }
                    else if (this.world.isInaccessible(teamX, teamY + 1)) {
                        System.out.print("Inaccessible tile, please try a another direction:");
                    }
                    else {
                        this.team.goDown();
                        move = false;
                    }
                    break;
                case "D":
                case "d":
                    if (teamX >= this.world.getWidth()) {
                        System.out.print("Reach right edge, try a another direction:");
                    }
                    else if (this.world.isInaccessible(teamX + 1, teamY)) {
                        System.out.print("Inaccessible tile, please try a another direction:");
                    }
                    else {
                        this.team.goRight();
                        move = false;
                    }
                    break;
                case "Q":
                case "q":
                    System.exit(0);
                case "I":
                case "i":
                    this.team.printTeam();
                    System.out.print("You can make a further move:");
                    break;
                default:
                    System.out.print("Invalid input, please input W/A/S/D:");
                    break;
            }
        } while (move);
    }

    // encounter monsters
    @Override
    public void fight() {
        System.out.println("\n \u001B[31m ----------------------------------------------- \u001B[0m \n");
        System.out.println("       \u001B[31m Fight Start \u001B[0m");
        System.out.println("\n \u001B[31m ----------------------------------------------- \u001B[0m \n");

        int maxLevel = this.team.getMaxLevel();
        MonsterTeam monsters = this.monsterList.createTeam(this.team.size(), maxLevel);
        team.printTeam();
        monsters.printTeam();
        do {
            this.team.takeTurn(monsters);
            if (!monsters.isFaint()) {
                monsters.takeTurn(this.team);
            }
        } while (!this.team.isFaint() && !monsters.isFaint());
        // hero team wins else game over
        if (monsters.isFaint()) {
            System.out.println("\n Heroes won the fight! You can view info next time to check status.\n");
            this.team.win(maxLevel);
        }
        else {
            this.gameOver();
        }
    }

    // hero team loses game over
    public void gameOver() {
        System.out.println("Your have been defeated by the monsters!");
        System.out.println("\n \u001B[31m ----------------------------------------------- \u001B[0m \n");
        System.out.println("       \u001B[31m Game Over \u001B[0m");
        System.out.println("\n \u001B[31m ----------------------------------------------- \u001B[0m \n");
        System.exit(0);
    }

    // print game info
    public void printInfo() {
        System.out.println("\n       \u001B[33m Control Info \u001B[0m\n");
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
        Scanner scanner = new Scanner(System.in);
        do {
            choice = scanner.nextLine();
            switch (choice) {
                case "Q", "q" -> System.exit(0);
                case "C", "c" -> keepPlay = false;
            }
        } while (keepPlay);
    }

}
