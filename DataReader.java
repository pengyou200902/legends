import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author You Peng
 * @date 11/7/2021 8:21 PM
 */


public class DataReader {
    public static List<List<String>> getData(String filePath) {
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            List<List<String>> configs = new ArrayList<>();

            while (scanner.hasNextLine()) {
                List<String> config = new ArrayList<>();
                Collections.addAll(config, scanner.nextLine().split("\\s+"));
                configs.add(config);
            }

            scanner.close();
            return configs;

        } catch (FileNotFoundException e) {
            System.out.println("Can't find config for Warrior.");
            return null;
        }
    }
}
