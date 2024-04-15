package workbook_3;
import java.util.Scanner;
import java.util.Random;

public class FamousQuotes {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Initialize the random number generator.
    static Random randomNumber = new Random();

    // Create the array.
    static String quoteList[];

    // Create the variables.
    static int userInput;
    static String anotherInput;
    static int randomArray;

    public static void main(String[] args) {
        // Call the preloadQuotes method.
        preloadQuotes();

        // Call the userChoice method.
        userChoice();
    }

    // Create the preloadQuotes method.
    public static void preloadQuotes() {
        // Set the array to hold 10 values.
        quoteList = new String[10];

        // Preload 10 quotes into the array.
        quoteList[0] = "Self-control means wanting to be effective at some random point in the infinite radiations of my spiritual existence. - Franz Kafka";
        quoteList[1] = "It is necessary to fall in love... if only to provide an alibi for all the random despair you are going to feel anyway. - Albert Camus";
        quoteList[2] = "Human well-being is not a random phenomenon. It depends on many factors - ranging from genetics and neurobiology to sociology and economics. But, clearly, there are scientific truths to be known about how we can flourish in this world. Wherever we can have an impact on the well-being of others, questions of morality apply. - Sam Harris";
        quoteList[3] = "There are good people who are dealt a bad hand by fate, and bad people who live long, comfortable, privileged lives. A small twist of fate can save or end a life; random chance is a permanent, powerful player in each of our lives, and in human history as well. - Jeff Greenfield";
        quoteList[4] = "Together we can change the world, just one random act of kindness at a time. - Ron Hall";
        quoteList[5] = "I believe life is an intelligent thing: that things aren't random. - Steve Jobs";
        quoteList[6] = "Goals transform a random walk into a chase. - Mihaly Csikszentmihalyi";
        quoteList[7] = "Everything happening around me is very random. I am enjoying the phase, as the journey is far more enjoyable than the destination. - Sushant Singh Rajput";
        quoteList[8] = "I don't believe that if you do good, good things will happen. Everything is completely accidental and random. Sometimes bad things happen to very good people and sometimes good things happen to bad people. But at least if you try to do good things, then you're spending your time doing something worthwhile. - Helen Mirren";
        quoteList[9] = "Carry out a random act of kindness, with no expectation of reward, safe in the knowledge that one day someone might do the same for you. - Princess Diana";
    }

    // Create the userChoice method.
    public static void userChoice() {
        try {
            while (true) {
                // Show the user the different options.
                System.out.println("1. Choose a quote.");
                System.out.println("2. Random quote.");
                System.out.print("Select an option: ");
                int userInput = scanner.nextInt();
                
                // Read the user input and execute the appropiate method.
                switch (userInput) {
                    case 1:
                        displayQuote();
                        break;
                    case 2:
                        randomQuote();
                        break;
                    default:
                        System.out.println("Invalid input.");
                        break;
                }
                
                // Ask the user if they want another quote.
                if (!anotherQuote())
                    break;
            }
        // Exception handling.
        } catch (Exception e) {
            // Print the invalid input.
            System.out.println("Invalid input.");

            // Clear previous input.
            scanner.next();

            // Call the userChoice method.
            userChoice();
        }
    }  
    
    public static void displayQuote() {
        try {
            // Ask the user to choose a number between 1 and 10.
            System.out.print("Please choose a number between 1 and 10: ");
            userInput = scanner.nextInt();

            // Check if the user input is betweeen 1 and 10.
            if (userInput >= 1 && userInput <= 10) {
                // Display the quote from what number was entered..
                System.out.println("\nQuote: " + quoteList[userInput - 1]);
            } else {
                // Print the invalid input.
                System.out.println("Invalid input.");
            }   
        // Exception handling.
        } catch (Exception e) {
            // Print the invalid input.
            System.out.println("Invalid input.");

            // Clear previous input.
            scanner.next();

            // Call the userChoice method.
            userChoice();
        }
    }

    // Create anotherQuote method.
    public static boolean anotherQuote() {
        try {
            // Ask them if they want another quote.
            System.out.print("\nDo you want another quote? (Yes/No): ");
            anotherInput = scanner.next();
            return anotherInput.equalsIgnoreCase("yes");
        // Exception handling.
        } catch (Exception e) {
            // Print the invalid input.
            System.out.println("Invalid input.");

            // Clear previous input.
            scanner.next();

            // Call the userChoice method.
            return anotherQuote();
        }
    }

    public static void randomQuote() {
        // Generate a random index from the array.
        randomArray = randomNumber.nextInt(quoteList.length);

        // Print the random quote.
        System.out.println("Random Quote: " + quoteList[randomArray]);
    }
}