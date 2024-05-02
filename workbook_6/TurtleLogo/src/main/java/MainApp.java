import java.awt.*;

public class MainApp
{
    public static void main(String[] args)
    {
        // This starter code to get you familiar with how
        // the TurtleLogo application works

        // The world is your canvas
        // World world = new World(200, 200);
        // Turtle turtle = new Turtle(world,-100, -100);
        
        // int width = 200;
        // int height = 200;

        // calculate the hypotenuse (diagonal)
        // a2 + b2 = c2
        // double widthSquared = Math.pow(width, 2);
        // double heightSquared = Math.pow(height, 2);
        // double hypotenuse = Math.sqrt(widthSquared + heightSquared);


        // turtle.setPenWidth(3);
        // turtle.setColor(Color.GREEN);

        // turtle.turnRight(45);
        // turtle.forward(hypotenuse);

        // turtle.penUp();
        // turtle.goTo(100, 100);
        // turtle.turnRight(90);

        // turtle.penDown();
        // turtle.forward(hypotenuse);

        // Draw a circle.
        // World world = new World(400, 400);
        // Turtle turtle = new Turtle(world);
        // turtle.setColor(Color.RED);
        // turtle.setPenWidth(3);
        // turtle.setDelay(0.01);
        // turtle.penUp();
        // turtle.goTo(0, 180);
        // turtle.penDown();
        // int sides = 360;
        // int length = 2;
        // for (int i = 0; i < sides; i++) {
            // turtle.forward(length);
            // turtle.turnRight(1);
        // }

        // Draw a square.
        // World world = new World(400, 400);
        // Turtle turtle = new Turtle(world);
        // turtle.setColor(Color.RED);
        // turtle.setPenWidth(3);
        // turtle.setDelay(0.01);
        // turtle.penUp();
        // turtle.goTo(-50, 180);
        // turtle.penDown();
        // int sides = 4;
        // int length = 100;
        // for (int i = 0; i < sides; i++) {
            // turtle.forward(length);
            // turtle.turnRight(90);
        // }

        // The world is your canvas
        World world = new World(300, 300); // Adjusted the size of the world for the Tic-Tac-Toe grid
        Turtle turtle = new Turtle(world);

        // Set the speed of the turtle
        turtle.setDelay(0.01); // Set a very small delay to make it faster

        // Draw Tic-Tac-Toe grid
        drawGrid(turtle);

        // Draw X and O markers
        drawX(turtle, -100, 100); // Draw X marker in the top-left cell
        drawO(turtle, 0, 100);  // Draw O marker in the top-middle cell
        drawX(turtle, 100, 100); // Draw X marker in the top-right cell
        drawO(turtle, -100, 0); // Draw O marker in the middle-left cell
        drawX(turtle, 0, 0); // Draw X marker in the middle-middle cell
        drawO(turtle, 100, 0); // Draw O marker in the middle-right cell
        drawX(turtle, -100, -100); // Draw X marker in the bottom-left cell
        drawO(turtle, 0, -100); // Draw O marker in the bottom-middle cell
        drawX(turtle, 100, -100); // Draw X marker in the bottom-right cell
    }

    // Helper method to draw Tic-Tac-Toe grid
    private static void drawGrid(Turtle turtle) {
        // Draw vertical lines
        turtle.penUp();
        turtle.goTo(-100, 100);
        turtle.penDown();
        turtle.goTo(-100, -100);
        turtle.penUp();
        turtle.goTo(0, 100);
        turtle.penDown();
        turtle.goTo(0, -100);
        turtle.penUp();
        turtle.goTo(100, 100);
        turtle.penDown();
        turtle.goTo(100, -100);

        // Draw horizontal lines
        turtle.penUp();
        turtle.goTo(-100, 100);
        turtle.penDown();
        turtle.goTo(100, 100);
        turtle.penUp();
        turtle.goTo(-100, 0);
        turtle.penDown();
        turtle.goTo(100, 0);
        turtle.penUp();
        turtle.goTo(-100, -100);
        turtle.penDown();
        turtle.goTo(100, -100);
    }

    // Helper method to draw X marker
    private static void drawX(Turtle turtle, int x, int y) {
        turtle.penUp();
        turtle.goTo(x - 40, y + 40);
        turtle.penDown();
        turtle.setColor(Color.RED); // Set color to red for X marker
        turtle.turnRight(45);
        turtle.forward(80);
        turtle.turnLeft(90);
        turtle.forward(80);
        turtle.turnRight(45);
    }

    // Helper method to draw O marker
    private static void drawO(Turtle turtle, int x, int y) {
        turtle.penUp();
        turtle.goTo(x, y - 40);
        turtle.penDown();
        turtle.setColor(Color.BLUE); // Set color to blue for O marker
        turtle.turnRight(90);
        for (int i = 0; i < 36; i++) { // Draw a polygon with 36 sides to approximate a circle
            turtle.forward(8);
            turtle.turnRight(10);
        }
    }
}