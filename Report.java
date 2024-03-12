package Music_Streaming_project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Report {
		public static void choose_report() {
			
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("If you want to view admin data press 1");	
		System.out.println("If you want to view artist data press 2");
		System.out.println("If you want to view listner data press 3");
		System.out.println("If you want to view songs press 4");
		System.out.println("If you want to view payment details press 5");
		
		int choice5 = scanner.nextInt();
        viewFileContents(choice5);
        
        scanner.close();
		}

	    public static void viewFileContents(int choice5) {
	        String fileName = "";
	        switch (choice5) {
	            case 1:
	                fileName = "admin_data.txt";
	                break;
	            case 2:
	                fileName = "artist_data.txt";
	                break;
	            case 3:
	                fileName = "listener_data.txt";
	                break;
	            case 4:
	                fileName = "song.txt";
	                break;
	            case 5:
	                fileName = "payment_details.txt";
	                break;
	            default:
	                System.out.println("Invalid choice!");
	                return;
	        }

	        try {
	            String content = Files.readString(Paths.get(fileName));
	            System.out.println("Contents of " + fileName + ":");
	            System.out.println(content);
	        } catch (IOException e) {
	            System.err.println("Error reading file: " + e.getMessage());
	        }
	    }
	}

	
