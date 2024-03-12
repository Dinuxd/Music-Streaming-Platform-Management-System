package Music_Streaming_project;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Admin {
    
    public static void Adminwelcome() {
        
        System.out.println("\n***Welcome to Admin management system***\n");
     
        loginAdmin();
    }
 
 public static void loginAdmin() {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your User name");
        String username = scanner.nextLine();
        
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        
       
        if (checkCredentials(username, password)) {
            System.out.println("Login successful!");
            
            Admincontent();
            
        } else {
            System.out.println("Invalid username or password.");
        }
        
        scanner.close();
    }
 
 public static boolean checkCredentials(String username, String password) {
     File file = new File("Admin_data.txt");
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
         System.out.println("Error: listener_data.txt not found.");
     }
     return false;
 }
 
 public static void Admincontent() {
	
	 Scanner scanner = new Scanner(System.in);
	 
	 System.out.println("If you want to view a Listner account press 1");
     System.out.println("If you want to delete a Listner account press 2");
     System.out.println("If you want to view a Artist account press 3");
     System.out.println("If you want to delete a Artist account press 4");
     System.out.println("If you want to delete a Song press 5");
     System.out.println("If you want to view a report press 6");
     int choice3 = scanner.nextInt();
     scanner.nextLine();
     
     switch (choice3) {
         case 1:
        	 System.out.println("Enter the username to view");
        	 String lisenerusername = scanner.nextLine();
        	 viewListenerData(lisenerusername);
             break;
        
         case 2:
        	 
        	 System.out.println("Enter the username to delete");
        	 String lisenerusername2 = scanner.nextLine();
        	 Listener.delete_record(lisenerusername2);
             break;
             
         case 3:
        	 
        	 System.out.println("Enter the username to view");
        	 String artistusername = scanner.nextLine();
        	 viewArtistData(artistusername);
        	 break;
        	 
         case 4:
        	 
        	 System.out.println("Enter the username to delete");
        	 String artistusername2 = scanner.nextLine();
        	 Artist.delete_record(artistusername2);
             break;
             
          case 5:
        	 
        	 System.out.println("Enter the song Name to delete");
        	 String songName = scanner.nextLine();
        	 Song.delete_song(songName);
             break;    
             
          case 6:
         	  Report.choose_report();
         
              break;       
         default:
             System.out.println("Invalid choice");
     }
     }
	 
 
 public static void viewArtistData(String usernameToView) {
	    File inputFile = new File("artist_data.txt");

	    try (Scanner scanner = new Scanner(inputFile)) {
	        boolean userFound = false;

	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            if (line.contains("Username: " + usernameToView)) {
	                userFound = true;
	                System.out.println("Artist Data:");
	                for (int i = 0; i < 5; i++) {
	                    System.out.println(scanner.nextLine());
	                }
	                break;
	            }
	        }

	        if (!userFound) {
	            System.out.println("User not found.");
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Error: artist_data.txt not found.");
	    }
	}
 public static void viewListenerData(String usernameToView) {
	    File inputFile = new File("listener_data.txt");

	    try (Scanner scanner = new Scanner(inputFile)) {
	        boolean userFound = false;

	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            if (line.contains("Username: " + usernameToView)) {
	                userFound = true;
	                System.out.println("Listener Data:");
	                for (int i = 0; i < 5; i++) {
	                    System.out.println(scanner.nextLine());
	                }
	                break;
	            }
	        }

	        if (!userFound) {
	            System.out.println("User not found.");
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Error: listener_data.txt not found.");
	    }
	}
 
}

