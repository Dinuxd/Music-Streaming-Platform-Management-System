package Music_Streaming_project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	
        System.out.println("***Welcome to the MiuHub Music Streaming Platform Management System***\n");

        System.out.println("If you are a Listener, press 1");
        System.out.println("If you are an Artist, press 2");
        System.out.println("If you are an Admin, press 3");

        int choice = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!validInput) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
            }
        }

        switch (choice) {
            case 1:
                Listener.Listenerwelcome();
                break;
            case 2:
                Artist.Artistwelcome();
                break;
            case 3:
                Admin.Adminwelcome();
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
