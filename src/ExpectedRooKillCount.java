import java.util.*; //Imports the Scanner which allows for keyboard inputs
public class ExpectedRooKillCount
{
    private static Scanner keyboard = new Scanner(System.in); //Creates the scanner used to read user inputs

    private static final double ROADKILL_PROBABILITY = 1.47; //The roadkill probability constant set as a static final variable
    private static final double ROAD_WIDTH = 0.01; //The average australian road length (10m) set as a static final variable

    public static void main(String[] arg)
    {
        //Defines the input variables (square length, road length and number of roos) for data we need to gather
        double squareLength, roadLength, numRoos;

        //Defines the output variable (we are calculating the expected kangaroos car kills per year)
        double expectedKillsPerYear;

        //Prompts the users to input values for square length, road length, and number of roos
        System.out.print("Enter side of square in Km: ");
        squareLength = keyboard.nextDouble();
        System.out.println("" + (char)7);

        System.out.print("Enter roads length in Km: ");
        roadLength = keyboard.nextDouble();

        System.out.print("Enter number of 'roos: ");
        numRoos = keyboard.nextDouble();

        //Calculates the expected number of Kangaroo accident deaths per year
        //Uses methods to calculate roo density and road area
        expectedKillsPerYear = calcRoadArea(roadLength) * calcRooDensity(squareLength, numRoos) * ROADKILL_PROBABILITY;

        //Prints out the final result to the user
        System.out.println("Expected Number of kills is: " + expectedKillsPerYear);
    }

    public static double calcRooDensity(double length, double roo)
    {
        //Calculate the roo Density using square length and number of roos
        return (roo / (Math.pow(length, 2)));
    }

    public static double calcRoadArea (double length)
    {
        //Calculating the area of the road using road length and road width constant
        return (length * ROAD_WIDTH);
    }
}
