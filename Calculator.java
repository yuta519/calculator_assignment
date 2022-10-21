import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        boolean isTerminated = false;

        Scanner sc = new Scanner(System.in);
        while(!isTerminated){
            calculate(sc);
            System.out.println("Do you want to use calculator again ? If you want to terminate, please input `NO`.");
            String answer = sc.next();
            if (answer.equals("NO")) {
                isTerminated = true;
            }
        }
        sc.close();
    }

    private static void calculate(Scanner sc ) {
        System.out.println("==============================");
        System.out.println("Type 1 : For Adding");
        System.out.println("Type 2 : For Subtraction");
        System.out.println("Type 3 : For Division");
        System.out.println("==============================");

        int output = 0;

        try {
            int userChoice = Calculator.validateInputInt(sc, "PLease enter a choice : ");
            while (userChoice >  3) {
                userChoice = Calculator.validateInputInt(
                    sc,
                    "A choise must be 1, 2 or 3. PLease enter a choice : "
                );
            }

            int number1 = Calculator.validateInputInt(sc, "Please enter First number : ");
            int number2 = Calculator.validateInputInt(sc, "Please enter Second number : ");

            if (userChoice == 1) {
                output = number1 + number2;
            }
            if (userChoice == 2) {
                output = number1 - number2;
            }
            if (userChoice == 3) {
                output = number1 / number2;
            }

        } catch (InputMismatchException e) {
            System.out.println("Please enter a number which is valid meaning integer");
        } catch (IllegalStateException e) {
            System.out.println("Sorry, scanner is closed now");
        } catch (ArithmeticException e) {
            System.out.println("You cannot divide a number by 0");
        } catch (Exception e) {
            System.out.println("Something Went Wrong Sorry");
        } finally {
            System.out.println("Your final output is : " + output);
        }
    }

    private static int validateInputInt(Scanner sc, String message) {
        boolean hasInt = false;
        int input = 0;
        do {
            System.out.println(message);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                hasInt = true;
            }
            sc.nextLine();
        } while(!hasInt);
        return input;
    }
}
