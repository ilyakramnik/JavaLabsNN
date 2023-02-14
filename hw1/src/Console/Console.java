package Console;

import ComplexNums.ComplexNums;
import Matrix.Matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * console for complex nums and matrices
 */
public class Console implements ConsoleFunctions{
    /**
     * input for complex nums
     */
    public void complexInput() {
        ComplexNums methods = new ComplexNums();
        int action = -1;
        double real, image;
        while (action != 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("""   
                      
                    To create a complex number of the form a+bi, enter 1
                    To add 2 created complex numbers, enter 2
                    To multiply 2 created complex numbers, enter 3
                    To output the created complex number in trigonometric form, enter 4
                    To exit, enter 0
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
                    System.out.print("Please enter the real part of complex number: ");
                    try {
                        real = in.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect data entry. Please try again");
                        continue;
                    }
                    System.out.print("Please enter the imaginary part of complex number: ");
                    try {
                        image = in.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect data entry. Please try again");
                        continue;
                    }
                    methods.createComplexNum(real, image);
                    break;
                case 2:
                    methods.plus();
                    break;
                case 3:
                    methods.multiply();
                    break;
                case 4:
                    methods.trigonometric();
                    break;
            }
        }
    }

    /**
     * input for matrices
     */
    public void matrixInput(){
        Matrix methods = new Matrix();
        int action = -1, n, m, isComplex = -1;
        while (isComplex != 0 && isComplex != 1) {
            Scanner in = new Scanner(System.in);
            System.out.print("""
                    To work with standard matrices, enter 0
                    To work with complex matrices, enter 1
                    """);
            try {
                isComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again");
            }
        }
        while (action != 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("""   
                      
                    To create and fill a matrix, enter 1
                    To add 2 created matrices, enter 2
                    To multiply 2 created matrices, enter 3
                    To transpose a created matrix, type 4
                    To calculate the determinant of a created matrix, enter 5
                    To exit, enter 0
                    """);
            try {
                action = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again");
            }
            switch (action) {
                case 0:
                    break;
                case 1:
                    System.out.print("Please enter the number of rows in the matrix: ");
                    try {
                        n = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect data entry. Please try again");
                        continue;
                    }
                    System.out.print("Please enter the number of columns in the matrix: ");
                    try {
                        m = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect data entry. Please try again");
                        continue;
                    }
                    methods.createMatrix(n, m, isComplex);
                    break;
                case 2:
                    methods.plusMatrix(isComplex);
                    break;
                case 3:
                    methods.multiplyMatrix(isComplex);
                    break;
                case 4:
                    methods.transposeMatrix(isComplex);
                    break;
                case 5:
                    methods.determineMatrix(isComplex);
                    break;
            }
        }
    }
}