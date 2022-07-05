package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Brain {
  Scanner scanner = new Scanner(System.in);
  String mathType;
  double numOne;
  double numTwo;

  // This is the constructor for the class. It is called when the class is instantiated.
  public Brain() {
    //Get First Number
    System.out.println("Hello, welcome to the calculator.\n\n Please input your first number...");
    numOne = getNum();

    //Get Math Function
    System.out.println("\nGreat! Now please enter what you'd like to do with it.\n '+' = Addition\n '-' = Subtraction\n '*' = Multiplication\n '/' = Division.");
    mathType = getMathType();
    
    //Get Second Number
    System.out.println("\nAmazing job! Please input the second didgit for the calculator.");
    numTwo = getNum();

    double result = makeCalculation(numOne, numTwo, mathType);
    System.out.println("\n" + numOne + " " + mathType.charAt(0) + " " + numTwo + " = " + result);

    System.out.println("\n Continue with calculations? [y/n]\n");
    checkContinue();
  }

  /**
   * It will keep asking the user for a number until the user enters a valid number
   * 
   * @return A double value.
   */
  private double getNum() {
    Double inputNum;
    while(true) {
      try {
        inputNum = scanner.nextDouble();
        scanner.nextLine();
        break;
      } catch (InputMismatchException e) {
        System.out.println("Incorrect input! Please enter a valid number ^_^");
        scanner = new Scanner(System.in);
      }
    }
    return inputNum;
  }

  /**
   * It takes in a string from the user, and if the string is not a valid function, it will ask the
   * user to enter a valid function
   * 
   * @return The inputString is being returned.
   */
  public String getMathType() {
    String inputString;
    while(true) {
      try {
        inputString = scanner.nextLine();
        break;
      } catch (InputMismatchException e) {
        System.out.println("Incorrect input! Please enter a valid function ^_^");
        scanner = new Scanner(System.in);
      }
    }
    return inputString;
  }

  /**
   * It takes in two numbers and a string, and returns the result of the operation specified by the
   * string
   * 
   * @param first The first number in the calculation
   * @param second The second number in the calculation
   * @param function The function to be performed.
   * @return The result of the calculation.
   */
  private double makeCalculation(double first, double second, String function) {
    double result;
    switch(function.charAt(0)) {
      case '+':
        result = first + second;
        break;
      case '-':
        result = first - second;
        break;
      case '/':
        result = first / second;
        break;
      case '*':
        result = first * second;
        break;
      default:
        System.out.println("Unrecognised Math Function. Aborting now.");
        result = 0;
        break;
    }
    return result;
  }

  /**
   * If the user enters 'y' then the program will start over, if the user enters 'n' then the program
   * will end
   */
  private void checkContinue() {
    String input = scanner.nextLine();
    if(input.charAt(0) == 'y' && input.length() == 1) {
      new Brain();
    } else if(input.charAt(0) == 'n') {
      return;
    }
  }
}
