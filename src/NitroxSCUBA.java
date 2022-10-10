import java.util.*; //importing the package for scanner
public class NitroxSCUBA
{
    private static final Scanner keyboard = new Scanner(System.in); //initializing the keyboard to input depth and oxygen pressure

    private static final int FEET_PER_ATMOSPHERE_CONSTANT = 33; //initializing the fpa constant

    public static void main(String[] arg)
    {
        //declaring all the variable (those that need to be calculated like partial pressure
        // and those that need to be inputted like depth)
        double ambientPressure, oxygenPressure;
        char oxygenGroup;
        int depth, oxygen;

        //Prompting the user to input values for depth and oxygen pressure
        System.out.print("Enter depth and percentage of O2: ");
        depth = keyboard.nextInt();
        oxygen = keyboard.nextInt();

        //calculating ambient pressure and oxygen partial pressure
        ambientPressure = calcAmbientPressure(depth);
        oxygenPressure = calcOxygenPressure(oxygen, ambientPressure);

        //determining the oxygen group based on the calculated partial pressure
        oxygenGroup = findOxygenGroup(oxygenPressure);

        //displaying the results of the calculations
        System.out.println("Ambient Pressure: " + ambientPressure);
        System.out.println("O2 Pressure: " + oxygenPressure);
        System.out.println("O2 Group: " + oxygenGroup);

        //Checking if the partial pressure exceeds the maximum or contingency values
        if(oxygenPressure > 1.4)
            System.out.println("Exceeds maximal O2 pressure : true");
        else
            System.out.println("Exceeds maximal O2 pressure : false");
        if(oxygenPressure > 1.6)
            System.out.println("Exceeds contingency O2 pressure: true");
        else
            System.out.println("Exceeds maximal O2 pressure : false");
    }

    public static double calcAmbientPressure(int depth) //method for calculating ambient pressure
    {
        double ambientPressure;

        ambientPressure = ((double) depth/ (double) FEET_PER_ATMOSPHERE_CONSTANT) + 1;

        return ambientPressure;
    }

    public static double calcOxygenPressure(int oxygen, double pressure) //method for calculating oxygen partial pressure
    {
        double oxygenPressure;

        oxygenPressure = ((double) oxygen / 100) * pressure;

        return oxygenPressure;
    }

    public static char findOxygenGroup(double oxygenPressure) //method for finding the oxygen pressure group
    {
        char oxygenGroup;
        int letter = (int)((oxygenPressure * 10)) + 65;//65 is equivalent to A
        oxygenGroup = (char) letter;

        return oxygenGroup;
    }
}
