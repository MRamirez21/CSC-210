import java.io.*;
import java.util.*;

class Creature {
    String name, classification, habitat, size, diet, action;
    
    public Creature(String name, String classification, String habitat, String size, String diet, String action) {
        this.name = name;
        this.classification = classification;
        this.habitat = habitat;
        this.size = size;
        this.diet = diet;
        this.action = action;
    }
    
    public String toString() {
        return name + " (" + classification + ") - " + size + " ft, " + diet + ", " + action;
    }
}

public class ProcessCreatureFile {
    public static void main(String[] args) {
        ArrayList<Creature> creatures = new ArrayList<>();
        
        try (Scanner file = new Scanner(new File("creature-data.csv"))) {
            file.nextLine(); 
            while (file.hasNextLine()) {
                String[] parts = file.nextLine().split(",");
                creatures.add(new Creature(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        System.out.println("Original creatures: " + creatures.size());
        
        creatures.removeIf(c -> c.name.equals("Bald Eagle"));
        
        for (Creature c : creatures) {
            if (c.name.equals("African Elephant")) {
                c.size = "12-15";
            }
        }
        
        System.out.println("Final creatures: " + creatures.size());
        for (Creature c : creatures) {
            System.out.println(c);
        }
        
        try (PrintWriter out = new PrintWriter("creature-data.csv")) {
            out.println("Name,Classification,Habitat,Size (ft),Diet,Action");
            for (Creature c : creatures) {
                out.println(c.name + "," + c.classification + "," + c.habitat + "," + c.size + "," + c.diet + "," + c.action);
            }
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
