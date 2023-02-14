import Console.Console;
import Console.ConsoleFunctions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * starter class
 */
public class Start {
    ConsoleFunctions input = new Console();

    /**
     * offers a choice of working with complex numbers or matrices
     */
    public void start() {
        int action = -1;
        while (action != 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("""
                    To work with complex numbers enter 1
                    To work with matrices enter 2
                    To exit enter 0
                    """);
            try {
                action = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again");
                continue;
            }
            switch (action) {
                case 0:
                    break;
                case 1:
                    input.complexInput();
                    break;
                case 2:
                    input.matrixInput();
                    break;
            }
        }
    }
}