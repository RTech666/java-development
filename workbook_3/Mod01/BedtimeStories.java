package workbook_3.Mod01;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BedtimeStories {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);
    static Scanner fileScanner = new Scanner(System.in);

    // Initialize the variables.
    static String fileName;
    static int lineNumber;
    static String line;
    
    public static void main(String[] args) {
        // Ask the user to enter the name of the story.
        System.out.print("Enter the name of a story: ");
        fileName = scanner.nextLine();

        // Read the entered story.
        try {
            System.out.println("Reading file: " + fileName);

            // Create the variable.
            lineNumber = 1;

            // Print the line number before the story line.
            for (String line : Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8)) {
                System.out.println(lineNumber + ". " + line);
                lineNumber++;
            }
        // If file doesn't exist, print message.
        } catch (IOException e) {
            System.out.println("File doesn't exist: " + e.getMessage());
        }
    }
}
