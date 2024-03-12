package Music_Streaming_project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Payment_template {
     String userName;
     int amount;
     String cardType;
     long cardNumber;
     int cvc;

  
    public Payment_template(String userName, int amount, String cardType, long cardNumber, int cvc) {
        this.userName = userName;
        this.amount = amount;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
    }

   
    public void processPayment() {
   
        writeToFile();

        System.out.println("Payment of $" + amount + " for " + userName + " using " + cardType + " card was successful.");
    }

    
    public void writeToFile() {
        try (FileWriter fw = new FileWriter("payment_details.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Name: " + userName);
            pw.println("Amount: $" + amount);
            pw.println("Card Type: " + cardType);
            pw.println("Card Number: " + cardNumber);
            pw.println("CVC: " + cvc);
            pw.println("---------------------------------------");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}


public class Payment {
    public static void payment_process(int amount) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Payment amount: "+amount+"$\n");
    
        System.out.print("Enter card type (visa or master): ");
        String cardType = scanner.nextLine();

        System.out.print("Enter card number: ");
        long cardNumber = scanner.nextLong();

        System.out.print("Enter CVC: ");
        int cvc = scanner.nextInt();

        
        Payment_template payment = new Payment_template(userName, amount, cardType, cardNumber, cvc);

        
        payment.processPayment();

        scanner.close();
    }
}
