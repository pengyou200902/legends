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
            int i = 0;
            int prevSize = 0;
            int currSize = 0;

            while (scanner.hasNextLine()) {
                if (i > 0) {
                    List<String> config = new ArrayList<>();
                    String line = scanner.nextLine().trim();
                    if (!line.isBlank()) {
                        Collections.addAll(config, line.split("\\s+"));
                        configs.add(config);
                    }
                }
                else scanner.nextLine();
                i++;
            }

            scanner.close();
            return configs;

        } catch (FileNotFoundException e) {
            System.out.println("Can't find config for Warrior.");
            return null;
        }
    }
}
