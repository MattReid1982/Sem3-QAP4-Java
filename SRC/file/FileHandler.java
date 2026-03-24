package SRC.file;

import java.io.*;
import SRC.Model.Drug;

public class FileHandler {
    private static final String FILE_NAME = "drugs.txt";
    
    public static void saveDrug(Drug drug) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(drug.toFileString());
            writer.newLine();
            System.out.println("Drug successfully saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    public static void readDrugs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Drug drug = Drug.fromString(line);
                System.out.println(drug);
            }
        } catch (IOException e) {
            System.out.println("Error reading file or file does not exist.");
        }
    }
}
