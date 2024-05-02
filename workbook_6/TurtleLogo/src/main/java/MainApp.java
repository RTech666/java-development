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
        World world = new World(400, 400);
        Turtle turtle = new Turtle(world);
        turtle.setColor(Color.RED);
        turtle.setPenWidth(3);
        turtle.setDelay(0.01);
        turtle.penUp();
        turtle.goTo(-50, 180);
        turtle.penDown();
        int sides = 4;
        int length = 100;
        for (int i = 0; i < sides; i++) {
            turtle.forward(length);
            turtle.turnRight(90);
        }
    }
}