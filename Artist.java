package Music_Streaming_project;


import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;

class Artist {

    public static void Artistwelcome() {
    	
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n***Welcome to Artist management system***\n");
        System.out.println("If you have an account press 1 to login");
        System.out.println("If you are new to MiuHub press 2 to Signup");
        
      
                int choice = scanner.nextInt();
                scanner.nextLine(); 
         
        
        switch (choice) {
            case 1:
            	
            	loginArtist();
                break;
           
            case 2:
                
            	signupArtist();
                break;
                
            default:
                System.out.println("Invalid choice");
        }
       
        }
        
    
    public static void writeToFile(String[][] data) {
        File file = new File("artist_data.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            for (String[] artist : data) {
            	writer.println("Username: " + artist[0]);
            	writer.println("First Name: " + artist[1]);
                writer.println("Last Name: " + artist[2]);
                writer.println("Email: " + artist[3]);
                writer.println("Password: " + artist[4]);
                writer.println(); 
            }
          
        }catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }
    
    
    public static void signupArtist() {
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	  System.out.println("Enter your User name: ");
          String username = scanner.nextLine();
    	
    	System.out.println("Enter your First name: ");
         String firstName = scanner.nextLine();
         
         System.out.println("Enter your Last name: ");
         String lastName = scanner.nextLine();
         
         
         System.out.println("Enter your Email: ");
         String email = scanner.nextLine();
         
         System.out.println("Enter your password: ");
         String password = scanner.nextLine();
        
         
         String[][] artistData = {{username, firstName, lastName, email, password} };
         
         System.out.println("\nYou have successfully signed up!");
         
         System.out.println("\nStored Artist Data:");
         for (String[] artist : artistData) {
        	 System.out.println("Username: " + artist[0]);
        	 System.out.println("First Name: " + artist[1]);
             System.out.println("Last Name: " + artist[2]);
             System.out.println("Email: " + artist[3]);
             System.out.println("Password: " + artist[4]);
         }
            
         writeToFile(artistData);
         scanner.close();
    	
    }
    
    public static void loginArtist() {
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your User name");
        String username = scanner.nextLine();
        
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        
       
        if (checkCredentials(username, password)) {
            System.out.println("Login successful!");
            
            Artistcontent(username);
            
        } else {
            System.out.println("Invalid username or password.");
            Artistwelcome();
        }
        
        scanner.close();
    }
    
    public static boolean checkCredentials(String username, String password) {
        File file = new File("artist_data.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Username: " + username)) {
                    while (scanner.hasNextLine()) {
                        String nextLine = scanner.nextLine();
                        if (nextLine.contains("Password: ")) {
                            String storedPassword = nextLine.replace("Password: ", "");
                            return storedPassword.equals(password);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: artist_data.txt not found.");
        }
        return false;
    }


    
    public static void Artistcontent(String username) {
    	
    	
        System.out.println("If you want to delete the account press 1");
        System.out.println("If you want to add a song press 2");
        Scanner scanner = new Scanner(System.in);
        int choice2 = scanner.nextInt();
        scanner.nextLine();

        switch (choice2) {
            case 1:
                delete_record(username);
                
                break;
            case 2:
            	Song.enter_song(username);
            	
            	break;
            default:
                System.out.println("Invalid choice\n");
               
        }
       
        scanner.close();
    }
    
    public static void delete_record(String usernameToDelete) {
        File inputFile = new File("artist_data.txt");
        File tempFile = new File("temp_artist_data.txt");

        try (Scanner scanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

            boolean userFound = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Username: " + usernameToDelete)) {
                    userFound = true;
                    
                    for (int i = 0; i < 5; i++) {
                        if (scanner.hasNextLine()) {
                            scanner.nextLine();
                        }
                    }
                } else {
                    writer.println(line);
                }
            }

            if (!userFound) {
                System.out.println("User not found.");
                return;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while deleting user data: " + e.getMessage());
            return;
        }

        
        if (!inputFile.delete()) {
            System.out.println("Error deleting the original file.");
            return;
        }

        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Error renaming the temporary file.");
        } else {
            System.out.println("Account successfully deleted.");
        }




    }
}   
