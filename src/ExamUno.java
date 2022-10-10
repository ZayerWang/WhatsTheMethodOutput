public class ExamUno {
    private static final int MAX = 10;
    private static final int NUMBER_OF_ELEMENTS = 8;
    private static final int POWER_BASE = 2;

    private static final int QUARTER_WAY = 2;
    private static final int HALF_WAY = 3;
    private static final int ALL_THE_WAY = 6;

    public static void main(String[] args)
    {
        int question;
        boolean pass;
        double fear;

        question = 13;
        fear = 7.3;
        pass = ((fear + MAX) < question + MAX % question || question / MAX > 0);

        fear = ++question * fear;
        question += 13 / 4;

        System.out.println(pass + " " + fear + " " + question);

        int[] numArray = new int[NUMBER_OF_ELEMENTS];

        int i;

        for(i = 0; i < numArray.length; i++)

        {

            numArray[i] = (int) Math.pow(POWER_BASE, i);
            System.out.print(numArray[i] + " ");
        }


        int numberOfValues = 0;
        int total = 0;
        boolean madeIt;
        System.out.println();

        do{
            while (numberOfValues < HALF_WAY) {
                total += numberOfValues;
                numberOfValues++;
            }
            madeIt = (total - numberOfValues) % 2 == 0;
            numberOfValues -= QUARTER_WAY;
            System.out.println(total + " " + numberOfValues + " " + madeIt);
        }while(total < ALL_THE_WAY);

        System.out.println(intAverageOfThree(3, 5, 5));
    }

    public static int intAverageOfThree(int a, int b, int c)

    {

        double quotient;

        quotient = ((a + b + c) / 3.0);

        System.out.println(quotient);

        return (int)quotient;

    }
}
