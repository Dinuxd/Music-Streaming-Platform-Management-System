package Music_Streaming_project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Song {
	
	public static void enter_song(String artistName) {
	Scanner scanner = new Scanner(System.in);
	
	 System.out.println("Enter song name:");
     String songName = scanner.nextLine();
     System.out.println("Enter song genre:");
     String songGenre = scanner.nextLine();
     writeToFile(songName, artistName, songGenre);
     
     scanner.close();
}

	public static void delete_song(String songName) {
		
		  File inputFile = new File("songs.txt");
	        File tempFile = new File("temp_songs.txt");

	        try (Scanner scanner = new Scanner(inputFile);
	             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

	            boolean userFound = false;
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                if (line.contains("Song Name: " + songName)) {
	                    userFound = true;
	                    
	                    for (int i = 0; i < 3; i++) {
	                        if (scanner.hasNextLine()) {
	                            scanner.nextLine();
	                        }
	                    }
	                } else {
	                    writer.println(line);
	                }
	            }

	            if (!userFound) {
	                System.out.println("Song not found.");
	                return;
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while deleting Song data: " + e.getMessage());
	            return;
	        }

	        
	        if (!inputFile.delete()) {
	            System.out.println("Error deleting the original file.");
	            return;
	        }

	        if (!tempFile.renameTo(inputFile)) {
	            System.out.println("Error renaming the temporary file.");
	        } else {
	            System.out.println("Song successfully deleted.");
	        }
		
	}
	
	public static void writeToFile(String songName, String artistName, String songGenre) {
        File file = new File("songs.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            
            	writer.println("Song Name: " + songName);
            	writer.println("Artist Name: " + artistName);
                writer.println("Song Genre: " + songGenre);
                writer.println(); 
                System.out.println("Operation successful.");
          
        }catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }
	
}