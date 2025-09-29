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
    
    public Creature(Creature other) {
        this.name = other.name;
        this.classification = other.classification;
        this.habitat = other.habitat;
        this.size = other.size;
        this.diet = other.diet;
        this.action = other.action;
    }
    
    public String toString() {
        return name + " (" + classification + ") - " + size + " ft, " + diet + ", " + action;
    }
}

public class CreatureRegistry {
    private ArrayList<Creature> creatures;
    private String filename;
    
    public CreatureRegistry(String filename) {
        this.filename = filename;
        this.creatures = new ArrayList<>();
        loadFromFile();
    }
    
    private void loadFromFile() {
        try (Scanner file = new Scanner(new File(filename))) {
            if (file.hasNextLine()) {
                file.nextLine(); 
            }
            while (file.hasNextLine()) {
                String[] parts = file.nextLine().split(",");
                if (parts.length == 6) {
                    creatures.add(new Creature(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public int getCount() {
        return creatures.size();
    }
    
    public Creature getCreature(int index) {
        if (index >= 0 && index < creatures.size()) {
            return new Creature(creatures.get(index)); 
        }
        return null;
    }
    
    public boolean modifyCreature(int index, String name, String classification, String habitat, String size, String diet, String action) {
        if (index >= 0 && index < creatures.size()) {
            Creature c = creatures.get(index);
            c.name = name;
            c.classification = classification;
            c.habitat = habitat;
            c.size = size;
            c.diet = diet;
            c.action = action;
            return true;
        }
        return false;
    }
    
    public boolean deleteCreature(int index) {
        if (index >= 0 && index < creatures.size()) {
            creatures.remove(index);
            return true;
        }
        return false;
    }
    
    public void addCreature(String name, String classification, String habitat, String size, String diet, String action) {
        creatures.add(new Creature(name, classification, habitat, size, diet, action));
    }
    
    public void saveToFile() {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println("Name,Classification,Habitat,Size (ft),Diet,Action");
            for (Creature c : creatures) {
                out.println(c.name + "," + c.classification + "," + c.habitat + "," + c.size + "," + c.diet + "," + c.action);
            }
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    
    public void displayAll() {
        for (int i = 0; i < creatures.size(); i++) {
            System.out.println(i + ": " + creatures.get(i));
        }
    }
}
