package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class to work with matrices
 */
public class Matrix {
    ArrayList<double[][]> listOfMatrix = new ArrayList<>();
    ArrayList<ComplexMatrix[][]> listOfComplexMatrix = new ArrayList<>();

    /**
     * creates a matrix
     * @param n num of rows
     * @param m num of columns
     * @param isComplex is matrix with complex nums or not
     */
    public void createMatrix(int n, int m, int isComplex) {
        double[][] matrix = new double[n][m];
        ComplexMatrix[][] complexMatrix = new ComplexMatrix[n][m];
        System.out.println("Please enter the values for the matrix:");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (isComplex == 0) {
                    while (true) {
                        Scanner in = new Scanner(System.in);
                        try {
                            matrix[i][j] = in.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect data entry. Please try again\n");
                            continue;
                        }
                        break;
                    }
                } else {
                    ComplexMatrix complexNum = new ComplexMatrix();
                    while (true) {
                        Scanner in = new Scanner(System.in);
                        System.out.printf("Enter the real part of the complex number with the address %d %d: ", i, j);
                        try {
                            complexNum.real = in.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect data entry. Please try again\n");
                            continue;
                        }
                        System.out.printf("Enter the imaginary part of the complex number with the address %d %d: ", i, j);
                        try {
                            complexNum.image = in.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect data entry. Please try again\n");
                            continue;
                        }
                        break;
                    }
                    complexMatrix[i][j] = complexNum;
                }
            }
        }
        if (isComplex == 0) {
            listOfMatrix.add(matrix);
            seeMatrix(0);
        } else {
            listOfComplexMatrix.add(complexMatrix);
            seeMatrix(1);
        }
    }

    /**
     * adds two matrices
     * @param isComplex is matrix with complex nums or not
     */
    public void plusMatrix(int isComplex) {
        if (isCorrectInput(isComplex) != 1) {
            return;
        }
        int firstMatrix, secondMatrix;
        while (true) {
            seeMatrix(isComplex);
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter the position of the first matrix: ");
            try {
                firstMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            System.out.print("Please enter the position of the second matrix: ");
            try {
                secondMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstMatrix, secondMatrix, isComplex) == 1 && isPlus(firstMatrix, secondMatrix, isComplex) == 1) {
            if (isComplex == 0) {
                double[][] newMatrix = new double[listOfMatrix.get(firstMatrix).length][listOfMatrix.get(firstMatrix)[0].length];
                for (int i = 0; i < listOfMatrix.get(firstMatrix).length; ++i) {
                    for (int j = 0; j < listOfMatrix.get(firstMatrix)[i].length; ++j) {
                        newMatrix[i][j] = listOfMatrix.get(firstMatrix)[i][j];
                    }
                }
                System.out.println("Total matrix:");
                for (int i = 0; i < listOfMatrix.get(secondMatrix).length; ++i) {
                    for (int j = 0; j < listOfMatrix.get(secondMatrix)[i].length; ++j) {
                        System.out.print(listOfMatrix.get(secondMatrix)[i][j] + newMatrix[i][j] + "\t");
                    }
                    System.out.println();
                }
            } else {
                ComplexMatrix[][] newMatrix = new ComplexMatrix[listOfComplexMatrix.get(firstMatrix).length][listOfComplexMatrix.get(firstMatrix)[0].length];
                for (int i = 0; i < listOfComplexMatrix.get(firstMatrix).length; ++i) {
                    for (int j = 0; j < listOfComplexMatrix.get(firstMatrix)[i].length; ++j) {
                        newMatrix[i][j] = listOfComplexMatrix.get(firstMatrix)[i][j];
                    }
                }
                System.out.println("Total matrix:");
                for (int i = 0; i < listOfComplexMatrix.get(secondMatrix).length; ++i) {
                    for (int j = 0; j < listOfComplexMatrix.get(secondMatrix)[i].length; ++j) {
                        System.out.printf("%f+%fi \t", listOfComplexMatrix.get(secondMatrix)[i][j].real + newMatrix[i][j].real,
                                listOfComplexMatrix.get(secondMatrix)[i][j].image + newMatrix[i][j].image);
                    }
                    System.out.println();
                }
            }
        }
    }

    /**
     * multiplies two matrices
     * @param isComplex is matrix with complex nums or not
     */
    public void multiplyMatrix(int isComplex) {
        if (isCorrectInput(isComplex) != 1) {
            return;
        }
        int firstMatrix, secondMatrix;
        while (true) {
            seeMatrix(isComplex);
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter the position of the first matrix: ");
            try {
                firstMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            System.out.print("Please enter the position of the second matrix: ");
            try {
                secondMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstMatrix, secondMatrix, isComplex) == 1 && isMultiply(firstMatrix, secondMatrix, isComplex) == 1) {
            if (isComplex == 0) {
                double[][] newMatrix = new double[listOfMatrix.get(firstMatrix).length][listOfMatrix.get(secondMatrix)[0].length];
                System.out.println("Total matrix:");
                for (double[] matrix : newMatrix) {
                    Arrays.fill(matrix, 0);
                }
                for (int i = 0; i < listOfMatrix.get(firstMatrix).length; ++i) {
                    for (int j = 0; j < listOfMatrix.get(secondMatrix)[0].length; ++j) {
                        for (int k = 0; k < listOfMatrix.get(secondMatrix).length; ++k) {
                            newMatrix[i][j] += listOfMatrix.get(firstMatrix)[i][k] * listOfMatrix.get(secondMatrix)[k][j];
                        }
                    }
                }
                for (double[] matrix : newMatrix) {
                    for (int j = 0; j < newMatrix[0].length; ++j) {
                        System.out.format("%2f \t", matrix[j]);
                    }
                    System.out.println();
                }
            } else {
                ComplexMatrix[][] newMatrix = new ComplexMatrix[listOfComplexMatrix.get(firstMatrix).length][listOfComplexMatrix.get(secondMatrix)[0].length];
                System.out.println("Total matrix:");
                for (int i = 0; i < newMatrix.length; ++i) {
                    for (int j = 0; j < newMatrix[0].length; ++j) {
                        ComplexMatrix complexNum = new ComplexMatrix();
                        complexNum.real = 0;
                        complexNum.image = 0;
                        newMatrix[i][j] = complexNum;
                    }
                }
                for (int i = 0; i < listOfComplexMatrix.get(firstMatrix).length; ++i) {
                    for (int j = 0; j < listOfComplexMatrix.get(secondMatrix)[0].length; ++j) {
                        for (int k = 0; k < listOfComplexMatrix.get(secondMatrix).length; ++k) {
                            newMatrix[i][j].real += (listOfComplexMatrix.get(firstMatrix)[i][k].real *
                                    listOfComplexMatrix.get(secondMatrix)[k][j].real -
                                    listOfComplexMatrix.get(firstMatrix)[i][k].image * listOfComplexMatrix.get(secondMatrix)[k][j].image);
                            newMatrix[i][j].image += (listOfComplexMatrix.get(firstMatrix)[i][k].real *
                                    listOfComplexMatrix.get(secondMatrix)[k][j].image +
                                    listOfComplexMatrix.get(firstMatrix)[i][k].image * listOfComplexMatrix.get(secondMatrix)[k][j].real);
                        }
                    }
                }
                for (ComplexMatrix[] matrix : newMatrix) {
                    for (int j = 0; j < newMatrix[0].length; ++j) {
                        System.out.printf("%2f + %2fi \t", matrix[j].real, matrix[j].image);
                    }
                    System.out.println();
                }
            }
        }
    }

    /**
     * transposes matrix
     * @param isComplex is matrix with complex nums or not
     */
    public void transposeMatrix(int isComplex) {
        if (isCorrectInput(isComplex) != 1) {
            return;
        }
        int firstMatrix;
        while (true) {
            seeMatrix(isComplex);
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter the matrix position: ");
            try {
                firstMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstMatrix, 0, isComplex) == 1) {
            if (isComplex == 0) {
                double[][] newMatrix = new double[listOfMatrix.get(firstMatrix)[0].length][listOfMatrix.get(firstMatrix).length];
                System.out.println("Total matrix:");
                for (int i = 0; i < newMatrix.length; ++i) {
                    for (int j = 0; j < newMatrix[0].length; ++j) {
                        newMatrix[i][j] = listOfMatrix.get(firstMatrix)[j][i];
                    }
                }
                for (double[] matrix : newMatrix) {
                    for (int j = 0; j < newMatrix[0].length; ++j) {
                        System.out.format("%2f \t", matrix[j]);
                    }
                    System.out.println();
                }
            } else {
                ComplexMatrix[][] newMatrix = new ComplexMatrix[listOfComplexMatrix.get(firstMatrix)[0].length][listOfComplexMatrix.get(firstMatrix).length];
                System.out.println("Total matrix:");
                for (int i = 0; i < newMatrix.length; ++i) {
                    for (int j = 0; j < newMatrix[0].length; ++j) {
                        newMatrix[i][j] = listOfComplexMatrix.get(firstMatrix)[j][i];
                    }
                }
                for (ComplexMatrix[] matrix : newMatrix) {
                    for (int j = 0; j < newMatrix[0].length; ++j) {
                        System.out.format("%2f + %2fi \t", matrix[j].real, matrix[j].image);
                    }
                    System.out.println();
                }
            }
        }
    }

    /**
     * finds a determinant of matrix
     * @param isComplex is matrix with complex nums or not
     */
    public void determineMatrix(int isComplex) {
        if (isCorrectInput(isComplex) != 1) {
            return;
        }
        int firstMatrix;
        while (true) {
            seeMatrix(isComplex);
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter the matrix position: ");
            try {
                firstMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entry. Please try again\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstMatrix, 0, isComplex) == 1) {
            if (isComplex == 0) {
                if (listOfMatrix.get(firstMatrix).length == listOfMatrix.get(firstMatrix)[0].length) {
                    System.out.printf("\nThe determinant = %f\n", det(listOfMatrix.get(firstMatrix)));
                } else {
                    System.out.println("It is impossible to calculate the determinant for a non-squared matrix");
                }
            } else {
                if (listOfComplexMatrix.get(firstMatrix).length == listOfComplexMatrix.get(firstMatrix)[0].length) {
                    System.out.printf("\nThe determinant = %2f + %2fi\n", detComplex(listOfComplexMatrix.get(firstMatrix)).real,
                            detComplex(listOfComplexMatrix.get(firstMatrix)).image);
                } else {
                    System.out.println("It is impossible to calculate the determinant for a non-squared matrix");
                }
            }
        }
    }

    /**
     * recursive function to find determinant of standard matrix
     * @param A matrix
     * @return determinant
     */
    static double det(double[][] A) {
        int n = A.length;
        if (n == 1) {
            return A[0][0];
        }
        double ans = 0;
        double[][] B = new double[n - 1][n - 1];
        int l = 1;
        for (int i = 0; i < n; ++i) {
            int x = 0, y = 0;
            for (int j = 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (i == k) {
                        continue;
                    }
                    B[x][y] = A[j][k];
                    ++y;
                    if (y == n - 1) {
                        y = 0;
                        ++x;
                    }
                }
            }
            ans += l * A[0][i] * det(B);
            l *= (-1);
        }
        return ans;
    }

    /**
     * recursive function to find determinant of complex matrix
     * @param A matrix
     * @return determinant
     */
    static ComplexMatrix detComplex(ComplexMatrix[][] A) {
        int n = A.length;
        if (n == 1) {
            return A[0][0];
        }
        ComplexMatrix ans = new ComplexMatrix();
        ComplexMatrix[][] B = new ComplexMatrix[n - 1][n - 1];
        int l = 1;
        for (int i = 0; i < n; ++i) {
            int x = 0, y = 0;
            for (int j = 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (i == k) {
                        continue;
                    }
                    B[x][y] = A[j][k];
                    ++y;
                    if (y == n - 1) {
                        y = 0;
                        ++x;
                    }
                }
            }
            ans.real += l * (A[0][i].real * detComplex(B).real - A[0][i].image * detComplex(B).image);
            ans.image += l * (A[0][i].real * detComplex(B).image + A[0][i].image * detComplex(B).real);
            l *= (-1);
        }
        return ans;
    }

    /**
     * outputs all list of created matrices
     * @param isComplex is matrix with complex nums or not
     */
    public void seeMatrix(int isComplex) {
        if (isComplex == 0) {
            for (int i = 0; i < listOfMatrix.size(); ++i) {
                System.out.printf("\nMatrix № %d\n", i);
                for (int j = 0; j < listOfMatrix.get(i).length; ++j) {
                    for (int t = 0; t < listOfMatrix.get(i)[j].length; ++t) {
                        System.out.print(listOfMatrix.get(i)[j][t] + "\t");
                    }
                    System.out.println();
                }
            }
        } else {
            for (int i = 0; i < listOfComplexMatrix.size(); ++i) {
                System.out.printf("\nMatrix № %d\n", i);
                for (int j = 0; j < listOfComplexMatrix.get(i).length; ++j) {
                    for (int t = 0; t < listOfComplexMatrix.get(i)[j].length; ++t) {
                        System.out.printf("%.2f + %.2fi \t", listOfComplexMatrix.get(i)[j][t].real, listOfComplexMatrix.get(i)[j][t].image);
                    }
                    System.out.println();
                }
            }
        }
    }

    /**
     * checks can we multiply two matrices
     * @param firstMatrix position of the first matrix
     * @param secondMatrix position of the second matrix
     * @param isComplex is matrix with complex nums or not
     * @return can we multiply or not
     */
    private int isMultiply(int firstMatrix, int secondMatrix, int isComplex) {
        if (isComplex == 0) {
            if (listOfMatrix.get(firstMatrix)[0].length != listOfMatrix.get(secondMatrix).length) {
                System.out.println("\nIt is impossible to multiply matrices of these sizes");
                return 0;
            }
        } else {
            if (listOfComplexMatrix.get(firstMatrix)[0].length != listOfComplexMatrix.get(secondMatrix).length) {
                System.out.println("\nIt is impossible to multiply matrices of these sizes");
                return 0;
            }
        }
        return 1;
    }

    /**
     * checks can we add two matrices
     * @param firstMatrix position of the first matrix
     * @param secondMatrix position of the second matrix
     * @param isComplex is matrix with complex nums or not
     * @return can we add or not
     */
    private int isPlus(int firstMatrix, int secondMatrix, int isComplex) {
        if (isComplex == 0) {
            if (listOfMatrix.get(firstMatrix).length != listOfMatrix.get(secondMatrix).length ||
                    listOfMatrix.get(firstMatrix)[0].length != listOfMatrix.get(secondMatrix)[0].length) {
                System.out.println("\nIt is impossible to perform this operation with matrices of different sizes");
                return 0;
            }
        } else {
            if (listOfComplexMatrix.get(firstMatrix).length != listOfComplexMatrix.get(secondMatrix).length ||
                    listOfComplexMatrix.get(firstMatrix)[0].length != listOfComplexMatrix.get(secondMatrix)[0].length) {
                System.out.println("\nIt is impossible to perform this operation with matrices of different sizes");
                return 0;
            }
        }
        return 1;
    }

    /**
     * checks on correct input of positions
     * @param firstMatrix position of the first matrix
     * @param secondMatrix position of the second matrix
     * @param isComplex is matrix with complex nums or not
     * @return input is okay or not
     */
    private int isCorrectInput(int firstMatrix, int secondMatrix, int isComplex) {
        int listSize;
        if (isComplex == 0) {
            listSize = listOfMatrix.size();
        } else {
            listSize = listOfComplexMatrix.size();
        }
        if (firstMatrix < 0 || secondMatrix < 0 ||
                firstMatrix >= listSize || secondMatrix >= listSize) {
            System.out.println("\nThe number you entered is incorrect. Please try again");
            return 0;
        }
        return 1;
    }

    /**
     * checks if it is not enough matrices created
     * @param isComplex is matrix with complex nums or not
     * @return is okay or not
     */
    private int isCorrectInput(int isComplex) {
        if (isComplex == 0) {
            if (listOfMatrix.size() == 0) {
                System.out.println("\nFirst, create at least 1 matrix");
                return 0;
            }
        } else {
            if (listOfComplexMatrix.size() == 0) {
                System.out.println("\nFirst, create at least 1 matrix");
                return 0;
            }
        }
        return 1;
    }
}