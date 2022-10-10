import java.util.Scanner;//import scanner to implement user inputs
public class PhoneEncoder {

    //declaring the area code as a constant
    private static final String AREA_CODE = "305";

    //Array containing the number of letters for each number
    private static final int[] LETTERS_PER_NUMBER = {1, 1, 3, 3, 3, 3, 3, 4, 3, 4};

    //the starting (lower) letter for each number
    private static final char[] LETTERS_FOR_ENCODING = {'0', '1', 'A', 'D', 'G', 'J', 'M', 'P', 'T', 'W'};

    //keyboard for user inputs
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] arg)
    {
        //declaring the variable needed
        String phoneNumber, encodedAreaCode, encodedNumber;
        int input;

        displayWelcome(); //calling a method to display a welcome and instructions for the program

        do //prompting the user for inputs until they input a 7 digit number
        {
            System.out.print("Please enter your 305 phone number: ");
            phoneNumber = keyboard.next();
            input = Integer.parseInt(phoneNumber);
        }while ((input >= 10000000) || (input <= 999999));

        encodedAreaCode = encode(AREA_CODE);//calling a method to encode the area code
        encodedNumber = encode(phoneNumber);//calling a method to encode the inputted phone number

        displayResult(phoneNumber, encodedAreaCode, encodedNumber);//calling a method to display the final results (original and coded numbers)
    }
    public static void displayWelcome() //method that displays a welcome message and instructions
    {
        System.out.println("Welcome to the phone number encoder");
        System.out.println("This program will encode your phone number according to the numbers your phone's keypad");
        System.out.println("please enter your 7 digit number (do not include your area code)\n");
    }

    public static String encode(String numbers)//method that encodes a String of numbers
    {
        //necessary variables in the recursive method
        int digit;
        char codedDigit;

        //additional variables for the non-recursive method
        int index, number;
        String encodedNumber = "";


        //Recursive method for encoding
        if(numbers.length() != 0) //check if the string is not 0 length
                digit = Integer.parseInt(numbers.substring(0, 1));//get the first digit
        else//if the digit does not exist, go back
                return "";


        //code the digit, and concat it with the rest of the numbers (recursive), then return the encoded number
        codedDigit = ((char) (LETTERS_FOR_ENCODING[digit] + Math.floor(Math.random() * LETTERS_PER_NUMBER[digit])));
        return codedDigit + encode(numbers.substring(1));


        //Non-recursive method (with for loops)
        /*number = Integer.parseInt(numbers); //turn the string number into an int
        for(index = 0; index < numbers.length(); index++)//loop for every digit
        {
            digit = number % 10; //separate the last digit

            //encode the first digit and concat it to the rest of the String
            encodedNumber = ((char) (LETTERS_FOR_ENCODING[digit] + Math.floor(Math.random() * LETTERS_PER_NUMBER[digit]))) + encodedNumber;
            number /= 10; //remove the last digit
        }
        return encodedNumber;*/ //return the encoded number

    }



    //method that displays the results including the original and encoded numbers
    public static void displayResult(String phoneNumber, String encodedAreaCode, String encodedNumber)
    {
        System.out.println("The phone number " + AREA_CODE + phoneNumber + " can be encoded as: " + encodedAreaCode + encodedNumber);
    }
}
