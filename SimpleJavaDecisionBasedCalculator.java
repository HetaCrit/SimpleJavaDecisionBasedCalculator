//imports
import java.util.Scanner;


//class init
public class SimpleJavaDecisionBasedCalculator
{
    //can be done with multiple methods, but I just left it as one for time-sake. 
    public static void main(String[] args) 
    {
        //initalize startup variable and message
        System.out.println("----------------Welcome to the JAVA prompt Calculator----------------");
        Scanner scanner = new Scanner(System.in);
        boolean restart = true;
        double num1;
        double num2;
        double result= 0;
        while(restart)
        {
            //Start gathering info
            System.out.println("Please choose an operation (+,-,*,/, or exit)");
            String choice = scanner.next();
            //ignorecase because .equals is case sensetive

            //ensure potential loop closure.
            if(choice.equalsIgnoreCase("Exit"))
            {
                break;
            }

            //ensure operation chosen (&& statment)
            if(!choice.equalsIgnoreCase("+") && !choice.equalsIgnoreCase("-") && !choice.equalsIgnoreCase("*") && !choice.equalsIgnoreCase("/"))
            {
                System.out.println("Operation not detected, please try again");
                continue;
            }

            //get num1
            System.out.println("Type first number");
            if(!scanner.hasNextDouble())
            {
                System.out.println("Invalid number, please entire a number or decimal");
                scanner.next();
                continue;
            }
            num1 = scanner.nextDouble();
            
            //get num2
            System.out.println("Type second number");
            if(!scanner.hasNextDouble())
            {
                System.out.println("Invalid number, please entire a number or decimal");
                scanner.next();
                continue;
            }
            num2 = scanner.nextDouble();


            //check for the range  || is an or statement (optional extension?)
            //is optional extension the same as extra credit?
            if (num1 < -1000 || num1 > 1000 || num2 < -1000 || num2 > 1000) {
                System.out.println("Error: Input numbers must be between -1000 and 1000.");
                continue;
            }

            //ensure we dont divide num1/0 (num2 != 0)
            if(choice.equalsIgnoreCase("/") && num2 == 0)
            {
                System.out.println("Error: Answer is undefined (divided by zero)");
                continue;
            }

            //now for the fun part (math)
            if(choice.equalsIgnoreCase("*")){result = num1 * num2;}
            else if(choice.equalsIgnoreCase("/")){result = num1 / num2;}
            else if(choice.equalsIgnoreCase("+")){result = num1 + num2;}
            else if(choice.equalsIgnoreCase("-")){result = num1 - num2;}
            System.out.println("The result of " + num1 + " " + choice + " " + num2 + " = " + result) ;

            //ask user if they wanna keep going
            System.out.println("Would you like to do another one? (Yes/No)");
            String Answer = scanner.next();
            if(!Answer.equalsIgnoreCase("yes")){restart = false;}


        }
    //turn off scanner to stop getting error on resource leak for scanner
    scanner.close();
    System.out.println("Big W's for using this calculator. Have a splendid day!");
    }
}

