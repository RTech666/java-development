package workbook_2;

public class LoopingExercises {
    public static void main(String[] args) throws InterruptedException {
        // Call the WhileLoop class.
        WhileLoop.main(args);

        // Call the DoWhileLoop class.
        DoWhileLoop.main(args);

        // Call the ForLoop class.
        ForLoop.main(args);
    }

    // WhileLoop class.
    static class WhileLoop {
        public static void main(String[] args) {
            // Create the variable.
            int count = 0;

            // Print "I love Java" five times.
            while (count < 5) {
                System.out.println("I love Java");
                count++;
            }
        }
    }

    // DoWhileLoop class.
    static class DoWhileLoop {
        public static void main(String[] args) {
            // Create the variable.
            int count = 0;

            // Print "I love Java" five times.
            do {
                System.out.println("I love Java");
                count++;
            } while (count < 5);
        }
    }

    // ForLoop class.
    static class ForLoop {
        public static void main(String[] args) throws InterruptedException {
            // Count down from 10, once it hits 0, it prints "Launch!".
            for (int i = 10; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
            System.out.println("Launch!");
        }
    }
}
