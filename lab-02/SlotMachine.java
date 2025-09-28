import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    private char slot1;
    private char slot2;
    private char slot3;
    private double moneyPot;
    
    
    private static final char SMILEY = '\u263A';     
     private static final char HEART = '\u2764';   
    private static final char SEVEN = '7';       
    private static final char[] SYMBOLS = {SMILEY, HEART, SEVEN};
    
    private Random random = new Random();
    
    
    public SlotMachine() {
        this.moneyPot = 1000000.00;
        initializeSlots();
    }
    
    
    public SlotMachine(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            if (fileScanner.hasNextDouble()) {
                this.moneyPot = fileScanner.nextDouble();
            } else {
                this.moneyPot = 1000000.00; 
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            this.moneyPot = 1000000.00; 
        }
        initializeSlots();
    }
    
    private void initializeSlots() {
        slot1 = SYMBOLS[random.nextInt(3)];
        slot2 = SYMBOLS[random.nextInt(3)];
        slot3 = SYMBOLS[random.nextInt(3)];
    }
    
    public double pullLever(double amountBet) {
        
        slot1 = SYMBOLS[random.nextInt(3)];
        slot2 = SYMBOLS[random.nextInt(3)];
        slot3 = SYMBOLS[random.nextInt(3)];
        
        
        if (slot1 == slot2 && slot2 == slot3) {
            double payout = amountBet * 10;
            moneyPot -= payout;
            return payout;
        }
        
        
        moneyPot += amountBet;
        return 0.0;
    }
    
    @Override
    public String toString() {
        return "" + slot1 + " " + slot2 + " " + slot3;
    }
    
    public double getMoneyPot() {
        return moneyPot;
    }
    
    public void save(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename));
            writer.println(moneyPot);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error saving slot machine data: " + e.getMessage());
        }
    }
}
