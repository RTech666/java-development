package workbook_2;
import java.util.Arrays;

public class TestStatistics {
    // Create the array and put 10 test scores in it.
    static int[] testScores = {100, 95, 80, 72, 66, 98, 76, 99, 44, 60};

    // Create the variables.
    static double average;
    static int highScore;
    static int lowScore;
    static double median;
    static double difference;

    public static void main(String[] args) {
        // Call the average method.
        average();
        
        // Call the highScore method.
        highScore();

        // Call the lowScore method.
        lowScore();

        // Call the median method.
        median();

        // Call the difference method.
        difference();
    }

    // Method to calculate the average from the array.
    public static double calculateAverage(int[] array) {
        // Create the variable.
        int sum = 0;

        // Add all the scores in the array.
        for (int num : array) {
            sum += num;
        }

        // Divide the sum by the amount of scores in the array, then print.
        return (double) sum / array.length;
    }

    // Method to get the average from the array, then print the average.
    public static void average() {
        average = calculateAverage(testScores);
        System.out.println("Average: " + average);
    }

    // Method to find the high score in the array.
    public static int findHighScore(int[] array) {
        // Create the variable.
        int max = array[0];

        // Look for the highest number in the array.
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // Print the highest number.
        return max;
    }

    // Method to get the high score from the array, then print the high score.
    public static void highScore() {
        int highScore = findHighScore(testScores);
        System.out.println("High Score: " + highScore);
    }

    // Method to find the lowest score in the array.
    public static int findLowScore(int[] array) {
        // Create the variable.
        int min = array[0];

        // Look for the lowest number in the array.
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        // Print the lowest number.
        return min;
    }

    // Method to get the low score from the array, then print the low score.
    public static void lowScore() {
        int lowScore = findLowScore(testScores);
        System.out.println("Low Score: " + lowScore);
    }

    // Method to calculate the median in the array.
    public static double calculateMedian(int[] array) {
        // Sort the array from greatest to least.
        Arrays.sort(array);

        // Find the median of the array if more than 2 numbers.
        if (array.length % 2 == 0) {
            int middle1 = array[array.length / 2 - 1];
            int middle2 = array[array.length / 2];
            
            // Add the middle numbers and divide by 2.
            return (double) (middle1 + middle2) / 2;
        } else
        // Find the median of the array if 2 or less numbers.
        return array[array.length / 2];
    }

    // Method to get the median from the array, then print the median.
    public static void median() {
        double median = calculateMedian(testScores);
        System.out.println("Median: " + median);
    }

    // Method to get the difference by taking the average and subtracting the median, then print the difference.
    public static void difference() {
        double difference = Math.abs(average - median);
        System.out.println("Difference: " + difference);
    }
}
