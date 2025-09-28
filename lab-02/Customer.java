import java.io.*;
import java.util.Scanner;

public class Customer {
    private double wallet;
    
    
    public Customer() {
        this.wallet = 500.00;
    }
    
    
    public Customer(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            if (fileScanner.hasNextDouble()) {
                this.wallet = fileScanner.nextDouble();
            } else {
                this.wallet = 500.00; 
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            this.wallet = 500.00; 
        }
    }
    
    public double spend(double amount) {
        if (amount >= wallet) {
            
            double remainingMoney = wallet;
            wallet = 0.0;
            return remainingMoney;
        } else {
            
            wallet -= amount;
            return amount;
        }
    }
    
    public void receive(double amount) {
        wallet += amount;
    }
    
    public double checkWallet() {
        return wallet;
    }
    
    public void save(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename));
            writer.println(wallet);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error saving customer data: " + e.getMessage());
      }
   }
}
