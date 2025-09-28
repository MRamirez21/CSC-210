import java.util.Scanner;

public class GoodCasino {
    
    public static double play(Customer customer, SlotMachine slotMachine, double amount) {
        
        double actualAmountSpent = customer.spend(amount);
        
        
        double winnings = slotMachine.pullLever(actualAmountSpent);
        
        return winnings;
    }
    
    public static void main(String[] args) {
        
        Customer customer = new Customer("customer.txt");
        SlotMachine slotMachine = new SlotMachine("slot-machine.txt");
        
        Scanner scanner = new Scanner(System.in);
        String input;
        
        System.out.println("Welcome to the Good Casino!");
        System.out.println("Customer wallet: $" + String.format("%.2f", customer.checkWallet()));
        System.out.println("Slot machine pot: $" + String.format("%.2f", slotMachine.getMoneyPot()));
        System.out.println();
        
        while (true) {
            System.out.print("How much money would you like to put in the machine? (or 'quit' to exit): $");
            input = scanner.nextLine().trim();
            
            
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            
            try {
                double betAmount = Double.parseDouble(input);
                
                if (betAmount <= 0) {
                    System.out.println("Please enter a positive amount.");
                    continue;
                }
                
                
                if (betAmount > customer.checkWallet()) {
                    System.out.println("You don't have enough money! You only have $" + 
                                     String.format("%.2f", customer.checkWallet()));
                    continue;
                }
                
                
                if (betAmount * 10 > slotMachine.getMoneyPot()) {
                    System.out.println("The slot machine doesn't have enough money for a potential payout!");
                    continue;
                }
                
                
                double winnings = play(customer, slotMachine, betAmount);
                
                
                System.out.println("Slot machine result: " + slotMachine.toString());
                
                if (winnings > 0) {
                    System.out.println("Congratulations! You won $" + String.format("%.2f", winnings));
                    customer.receive(winnings);
                } else {
                    System.out.println("Sorry, you didn't win anything this time.");
                }
                
                
                System.out.println("Your wallet: $" + String.format("%.2f", customer.checkWallet()));
                System.out.println("Slot machine pot: $" + String.format("%.2f", slotMachine.getMoneyPot()));
                System.out.println();
                
                
                if (customer.checkWallet() <= 0) {
                    System.out.println("You're out of money!");
                    break;
                }
                
                
                if (slotMachine.getMoneyPot() <= 0) {
                    System.out.println("The slot machine is out of money! You broke the casino!");
                    break;
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number or 'quit'.");
            }
        }
        
        
        customer.save("customer.txt");
        slotMachine.save("slot-machine.txt");
        
        System.out.println("Game ended. Final wallet: $" + String.format("%.2f", customer.checkWallet()));
        System.out.println("Final slot machine pot: $" + String.format("%.2f", slotMachine.getMoneyPot()));
        System.out.println("Data saved to files. Thanks for playing!");
        
        scanner.close();
    }
}
