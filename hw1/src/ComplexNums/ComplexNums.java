package ComplexNums;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * main class of complex nums
 */
public class ComplexNums {
    ArrayList<Double> listOfReal = new ArrayList<>();
    ArrayList<Double> listOfImage = new ArrayList<>();

    /**
     * creates complex num
     * @param newReal real part of the num
     * @param newImage imaginary part of the num
     */

    public void createComplexNum(double newReal, double newImage) {
        listOfReal.add(newReal);
        listOfImage.add(newImage);
        seeListOfComplex(listOfReal, listOfImage);
    }

    /**
     * adds two complex nums
     */
    public void plus() {
        if (isCorrectInput() != 1) {
            return;
        }
        int firstComplex, secondComplex;
        while (true) {
            seeListOfComplex(listOfReal, listOfImage);
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter the position of the first complex number: ");
            try {
                firstComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            System.out.print("Please enter the number of the second complex number: ");
            try {
                secondComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstComplex, secondComplex) == 1) {
            double finalReal = listOfReal.get(firstComplex) + listOfReal.get(secondComplex);
            double finalImage = listOfImage.get(firstComplex) + listOfImage.get(secondComplex);
            System.out.printf("\nResult of the sum: %.2f + %.2fi \n", finalReal, finalImage);
        }
    }

    /**
     * multiply two complex nums
     */
    public void multiply() {
        if (isCorrectInput() == 0) {
            return;
        }
        int firstComplex, secondComplex;
        while (true) {
            seeListOfComplex(listOfReal, listOfImage);
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter the position of the first complex number: ");
            try {
                firstComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            System.out.print("Please enter the number of the second complex number: ");
            try {
                secondComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstComplex, secondComplex) == 1) {
            double finalReal = listOfReal.get(firstComplex) * listOfReal.get(secondComplex) -
                    listOfImage.get(firstComplex) * listOfImage.get(secondComplex);
            double finalImage = listOfReal.get(firstComplex) * listOfImage.get(secondComplex) +
                    listOfImage.get(firstComplex) * listOfReal.get(secondComplex);
            System.out.printf("\nResult of the multiply: %.2f + %.2fi \n", finalReal, finalImage);
        }
    }

    /**
     * gives a trigonometric form of the complex num
     */
    public void trigonometric() {
        if (isCorrectInput() == 0) {
            return;
        }
        int firstComplex;
        while (true) {
            seeListOfComplex(listOfReal, listOfImage);
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter the position of the first complex number: ");
            try {
                firstComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstComplex, 0) == 1) {
            double r = Math.sqrt(Math.pow(listOfReal.get(firstComplex), 2) + Math.pow(listOfImage.get(firstComplex), 2));
            double cos = listOfReal.get(firstComplex) / r;
            double sin = listOfImage.get(firstComplex) / r;
            System.out.printf("\nz = %.2f * (cos(a) + i*sin(a)), where cos(a) = %.2f, sin(a) = %.2f\n", r, cos, sin);
        }
    }

    /**
     * outputs all list of created complex nums
     * @param real real part of the complex num
     * @param image imaginary part of the complex num
     */
    private void seeListOfComplex(ArrayList<Double> real, ArrayList<Double> image) {
        System.out.println("\nAll created complex numbers (position: number):");
        for (int i = 0; i < real.size(); ++i) {
            System.out.printf("%d: %.2f + %.2fi \n", i, real.get(i), image.get(i));
        }
    }

    /**
     * checks on correct input of positions
     * @param firstComplex position of first complex num
     * @param secondComplex position of second complex num
     * @return input is okay or not
     */
    private int isCorrectInput(int firstComplex, int secondComplex) {
        if (firstComplex < 0 || secondComplex < 0 ||
                firstComplex >= listOfReal.size() || secondComplex >= listOfReal.size()) {
            System.out.println("\nThe position you entered is incorrect. Please try again");
            return 0;
        }
        return 1;
    }

    /**
     * checks if it is not enough complex nums created
     * @return is okay or not
     */

    private int isCorrectInput() {
        if (listOfReal.size() == 0) {
            System.out.println("\nFirst create at least 1 complex number");
            return 0;
        }
        return 1;
    }
}