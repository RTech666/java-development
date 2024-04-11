package workbook_1.com.pluralsight;
import java.util.Random;

public class MathApp {
    public static void main(String[] args) {
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();
        questionSix();
        questionSeven();
    }

    public static void questionOne() {
        // Question 1
        // Create the variables.
        int bobSalary = 200000;
        int garySalary = 250000;
        
        // Checks who has the higher salary.
        int highestSalary = Math.max(bobSalary, garySalary);
        
        // Print out the highest salary.
        System.out.println("The highest salary is " + highestSalary);
    }

    public static void questionTwo() {
        // Question 2
        // Create the variables and set a price.
        double carPrice = 19.99;
        double truckPrice = 29.99;
    }

    public static void questionThree() {
        // Question 3
        // Create the variables.
        // Set 7.25 as the radius.
        double radius = 7.25;

        // Calculate the area.
        double area = Math.PI * radius * radius;

        // Print out the answer.
        System.out.println("The area of a circle whose radius is 7.25 is: " + area);
    }

    public static void questionFour() {
        // Question 4
        // Create the variables.
        // Set 5 as the variable.
        double q4Variable = 5.0;

        // Calcuate the square root.
        double squareRoot = Math.sqrt(q4Variable);

        // Print out the answer.
        System.out.println("The square root of a variable after it is set to 5.0 is: " + squareRoot);
    }

    public static void questionFive() {
        // Question 5
        // Create the variables.
        // Set the x,y of the Coordinates.
        int x1 = 5, y1 = 10;
        int x2 = 85, y2 = 50;

        // Calcuate the difference in x,y points.
        int dX = x2 - x1;
        int dY = y2 - y1;

        // Square the difference.
        int dXSquared = dX * dX;
        int dYSquared = dY * dY;

        // Sum of the squares.
        int sumOfSqaures = dXSquared + dYSquared;
        
        // Calculate the distance.
        double distance = Math.sqrt(sumOfSqaures);

        // Print out the answer.
        System.out.println("The distance between the points (5,10) and (85,50) is: " + distance);
    }

    public static void questionSix() {
        // Question 6
        // Create the variables.
        // Set -3.8 as the variable.
        double q6Variable = -3.8;

        // Calculate the absolute value.
        double absoluteValue = Math.abs(q6Variable);

        // Print out the answer.
        System.out.println("The absolute (positive) value of a variable after it is set to -3.8 is: " + absoluteValue);
    }

    public static void questionSeven() {
        // Question 7
        // Create the variables.
        // Create an instance of the Random class.
        Random random = new Random();

        // Set a random number, between 0 and 1.
        double randomNumber = random.nextDouble();

        // Print out the random number.
        System.out.println("A random number between 0 and 1: " + randomNumber);
    }
}