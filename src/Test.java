public class Test {
    private static final short PLANTATION = 9;
    private static final short HIGH = 42;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

        int poppySeed = 27;
        int mountainPass;
        int steps;
        mountainPass = HIGH;

        System.out.println("The mountain pass starts at " + mountainPass);
        while (poppySeed < 4 * PLANTATION) {
            if (poppySeed < PLANTATION || poppySeed % 2 == 1) {
                mountainPass = poppySeed % 6;
                for (steps = 0; steps < mountainPass; steps++) {
                    poppySeed += steps;
                }
                poppySeed -= --mountainPass;
                System.out.println("Low price per KG is " + poppySeed);
            } else {
                do {
                    poppySeed += mountainPass;
                    mountainPass = mountainPass * mountainPass;
                } while (mountainPass <= PLANTATION);
                System.out.println("High price per KG is " + poppySeed);
                poppySeed = HIGH;
            }
        }
        System.out.println("The mountain pass ends at " + mountainPass);
        System.out.println("\\ \t tt\b \nt /");
        int height = 10;
        System.out.println("The cat " + (height > 10 ? "flew" : "sat") + " on the\b big\nmat");
        System.out.println("A is greater than 64: " + greaterLetter(64, 'A'));

        int birthday = 27;
        double catch22 = 22.22;
        long fibonacciLimit = 95;

        System.out.printf("%-8.0f %%%+d\n%5d\n",catch22,birthday,fibonacciLimit);
    }

    public static boolean greaterLetter(int num, char s)
    {
        if(s > num)
            return true;
        return false;
    }
}
