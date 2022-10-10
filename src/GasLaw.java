import java.util.Scanner; //Imports the scanners and allows the use of the keyboard (User can input values)
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    //----The gas constant in Joules/mole/K set as a static variable (a constant value)
    private static final double GAS_CONSTANT = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

        //----defines the input variables (Volume, Moles, and Temp) and the output variable we want (pressure)
        double volume, moles, temp;
        double pressure;

        //prompts the user to input values for Volume, moles, and Temp
        System.out.print("Enter volume, moles, temperature : ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temp = keyboard.nextDouble();

        //Giving value to the variable pressure, by using the pressure formula and variable that were just input
        pressure = moles * GAS_CONSTANT * temp / volume;

        //To print out our resulting pressure for a final result
        System.out.println("Pressure is " + pressure);

    }
}
