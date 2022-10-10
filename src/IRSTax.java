import java.util.*;//import package for keyboard scanner
public class IRSTax {
    private static final Scanner keyboard = new Scanner(System.in); //initialize keyboard scanner

    //Initialize the tax rates (constant) for each income level
    private static final double RICH_TAX = .25;
    private static final double MIDDLE_TAX = .1;
    private static final double LOW_TAX = .03;
    private static final int S_RICH_LEVEL = 500000;
    private static final int Q_RICH_LEVEL = 200000;
    private static final int M_RICH_LEVEL = 100000;
    private static final int A_RICH_LEVEL = 50000;
    private static final int R_RICH_LEVEL = 20000;

    public static void main(String[] arg)
    {
        //declare the variables necessary for calculations and results
        int income = 0, deduction = 0, input;
        double taxable, tax;
        char taxGroup;

        //call the opening message method
        displayWelcome();

        //This sections loops until a 0 is inputted
        do{
            //prompt the user for next value and stores the input
            System.out.print("Enter next amount: ");
            input = keyboard.nextInt();

            //adds to income or deduction based on sign of input
            if(input > 0)
            {
                income += input;
            }
            else if(input < 0) {
                deduction += (input * -1);
            }

        } while(input != 0);

        //call the calculation methods for taxable income, tax group, and tax owed
        taxable = computeTaxable(income, deduction);
        taxGroup = computeTaxGroup(taxable);
        tax = computeTax(taxable, taxGroup);

        //call the method to display the final results
        displayResults(income, deduction, taxable, taxGroup, tax);
    }

    public static void displayWelcome() //method for opening introduction and instructions
    {
        System.out.println("Welcome to the IRS tax calculation program! \n" +
                "Please input any income (positive number) or deductables (negative number)\n" +
                "Once you are finished, type 0 to perform calculations.\n");
    }

    public static double computeTaxable(double income, double deduction)//method that calculated taxable income
    {
        if(income >= deduction)
        {
            return income - deduction;
        }

        else
            return 0.0;
    }

    public static char computeTaxGroup(double taxable)//method that calculates tax group based on taxable income
    {
        if(taxable >= S_RICH_LEVEL)
            return 'S';
        else if(taxable >= Q_RICH_LEVEL)
            return 'Q';
        else if(taxable >= M_RICH_LEVEL)
            return 'M';
        else if(taxable >= A_RICH_LEVEL)
            return 'A';
        else if(taxable >= R_RICH_LEVEL)
            return 'R';
        else
            return 'P';
    }

    public static double computeTax(double taxable, char taxGroup) //method that calculates the tax owed
    {
        switch (taxGroup) {
            case 'S', 'Q':
                return taxable * RICH_TAX;

            case 'M':
                return taxable * MIDDLE_TAX;

            case 'A', 'R':
                return taxable * LOW_TAX;

            case 'P':
                return 0.0;

            default:
                return -1;
        }

    }

    //method that displays the total income, deductions, and all calculations
    public static void displayResults(double income, double deduction, double taxable, char taxGroup, double tax)
    {
        if(tax == -1)
        {
            System.out.println("ERROR, PLEASE RETRY");
        }

        else
        {
            System.out.println("");
            System.out.println("Income\t\t\t = $" + income);
            System.out.println("Deductions\t\t = $" + deduction);
            System.out.println("Taxable income \t = $" + taxable);
            System.out.println("Tax group \t\t = $" + taxGroup);
            System.out.println("Tax owed \t\t = $" + tax);
        }
    }

}
