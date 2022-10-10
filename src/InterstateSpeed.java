import java.util.*; //importing the package for scanner
import java.text.*; //Decimal formatting
public class InterstateSpeed
{
    private static final Scanner keyboard = new Scanner(System.in); //initializing the scanner so inputs can be used

    private static final int SPEED_LIMIT = 65;// initializing the seed limit which is a constant

    public static void main(String[] arg)
    {
        //Declaring the necessary variables like
        // input variables: distance to travel and time available
        // And what is being calculated: travel speed and whether the speed limit is exceeded
        double travelDistance, timeAvailable, travelSpeed;

        //calling method to display welcome and instructions
        displayStart();

        //calling method to prompt user for values
        travelDistance = inputDistance();
        timeAvailable = inputTime();

        //calling the method to calculate the necessary travel speed
        travelSpeed = calculateTime(travelDistance, timeAvailable);

        //calling the method to display and print out the results
        displayResults(travelSpeed);

    }

    private static double calculateTime(double distance, double time) //method for calculating speed
    {
        //declaring necessary variables: number of breaks and time available for travel
        double numBreaks, travelTime;
        DecimalFormat df = new DecimalFormat("0.00");

        //calculating the number of breaks given a certain distance
        numBreaks = (int) (distance / 100);
        if((distance % 100) > 0)
        {
            numBreaks += 1;
        }

        //calculating the time available for traveling (breaks not included)
        travelTime = time - ((numBreaks * 5) / 60);

        //calculating and returning the travel speed based on distance and time available for traveling
        return Double.parseDouble(df.format(distance/travelTime));
        //return distance/travelTime;
    }

    public static void displayStart()
    {
        //printing the decided prompt format, introduction and instructions about our system
        System.out.println("Welcome to the I95 Speed Machine \n " +
                "\n " +
                "You will have to supply: \n" +
                "+ The distance you want to travel, in miles \n" +
                "+The time you have available, in hours \n");
    }

    public static double inputDistance()
    {
        //Prompting the user to input values for travel distance
        System.out.print("Enter distance to travel: ");
        return keyboard.nextDouble();

    }

    public static double inputTime()
    {
        //Prompting the user to input a value for the time available
        System.out.print("Enter time available: ");
        double timeAvailable = keyboard.nextDouble();
        System.out.println();
        return timeAvailable;
    }

    public static void displayResults(double travelSpeed)
    {
        //displaying and printing out the results
        System.out.println("You will have to travel at\t: " + travelSpeed + "mph");
        System.out.println("Over the speed limit\t: " + (travelSpeed > SPEED_LIMIT));
    }
}
