import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Friende.Peng_You
 * @Date 2021-11-07 19:57
 */

public class HeroReader {
    public static <T extends RPGCharacter> ArrayList<T> load(String filePath){
        File file = new File(filePath);
        try{
            Scanner scanner = new Scanner(file);
            String line;
            String[] config;
            ArrayList<T> heroes = new ArrayList<>();
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                config = line.split("\\s+");
                // Name/mana/strength/agility/dexterity/starting money/starting experience
                heroes.add( new T(config[0],Integer.parseInt(config[6]),Double.parseDouble(config[1]),Double.parseDouble(config[2]),Double.parseDouble(config[3]),Double.parseDouble(config[4]),Double.parseDouble(config[5])));
            }
            scanner.close();
            return heroes;
        }catch (FileNotFoundException e) {
            System.out.println("Can't find config for Warrior.");
            return null;
        }
    }
}
