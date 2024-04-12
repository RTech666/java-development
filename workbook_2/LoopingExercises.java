package workbook_2;

public class LoopingExercises {
    public static void main(String[] args) throws InterruptedException {
        WhileLoop.main(args);
        DoWhileLoop.main(args);
        ForLoop.main(args);
    }

    static class WhileLoop {
        public static void main(String[] args) {
            int count = 0;
            while (count < 5) {
                System.out.println("I love Java");
                count++;
            }
        }
    }

    static class DoWhileLoop {
        public static void main(String[] args) {
            int count = 0;
            do {
                System.out.println("I love Java");
                count++;
            } while (count < 5);
        }
    }

    static class ForLoop {
        public static void main(String[] args) throws InterruptedException {
            for (int i = 10; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
            System.out.println("Launch!");
        }
    }
}
