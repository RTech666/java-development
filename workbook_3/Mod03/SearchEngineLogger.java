package workbook_3.Mod03;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SearchEngineLogger {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    static String searchTerm;
    static String timestamp;

    public static void main(String[] args) {
        // Write launch when program starts.
        logAction("launch");

        while (true) {
            // Ask the user to enter a search term.
            System.out.print("Enter a search term (X to exit): ");
            searchTerm = scanner.nextLine();

            // If user entered X, exit.
            if (searchTerm.equalsIgnoreCase("X")) {
                logAction("exit");
                break;
            // If user entered a search term, write it.
            } else {
                logAction("search : " + searchTerm);
            }
        }
    }

    // Create the logAction method.
    private static void logAction(String action) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true))) {
            // Set the timestamp format.
            timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            // Write the timestamp with the search term.
            writer.write(timestamp + " " + action);
            writer.newLine();
        // Print message if their was an error writing.
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}

