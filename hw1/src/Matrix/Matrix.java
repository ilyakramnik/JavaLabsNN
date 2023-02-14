package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {
    ArrayList<double[][]> listOfMatrix = new ArrayList<>();
    ArrayList<ComplexMatrix[][]> listOfComplexMatrix = new ArrayList<>();

    public void createMatrix(int n, int m, int isComplex) {
        double[][] matrix = new double[n][m];
        ComplexMatrix[][] complexMatrix = new ComplexMatrix[n][m];
        System.out.println("Пожалуйста, введите значения для матрицы:");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (isComplex == 0) {
                    while (true) {
                        Scanner in = new Scanner(System.in);
                        try {
                            matrix[i][j] = in.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                            continue;
                        }
                        break;
                    }
                } else {
                    ComplexMatrix complexNum = new ComplexMatrix();
                    while (true) {
                        Scanner in = new Scanner(System.in);
                        System.out.printf("Введите реальную часть комплексного числа с адресом %d %d: ", i, j);
                        try {
                            complexNum.real = in.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                            continue;
                        }
                        System.out.printf("Введите мнимую часть комплексного числа с адресом %d %d: ", i, j);
                        try {
                            complexNum.image = in.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
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

    public void plusMatrix(int isComplex) {
        if (isCorrectInput(isComplex) != 1) {
            return;
        }
        int firstMatrix, secondMatrix;
        while (true) {
            seeMatrix(isComplex);
            Scanner in = new Scanner(System.in);
            System.out.print("Пожалуйста, введите номер первой матрицы: ");
            try {
                firstMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                continue;
            }
            System.out.print("Пожалуйста, введите номер второй матрицы: ");
            try {
                secondMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
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
                System.out.println("Итоговая матрица:");
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
                System.out.println("Итоговая матрица:");
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

    public void multiplyMatrix(int isComplex) {
        if (isCorrectInput(isComplex) != 1) {
            return;
        }
        int firstMatrix, secondMatrix;
        while (true) {
            seeMatrix(isComplex);
            Scanner in = new Scanner(System.in);
            System.out.print("Пожалуйста, введите номер первой матрицы: ");
            try {
                firstMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                continue;
            }
            System.out.print("Пожалуйста, введите номер второй матрицы: ");
            try {
                secondMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstMatrix, secondMatrix, isComplex) == 1 && isMultiply(firstMatrix, secondMatrix, isComplex) == 1) {
            if (isComplex == 0) {
                double[][] newMatrix = new double[listOfMatrix.get(firstMatrix).length][listOfMatrix.get(secondMatrix)[0].length];
                System.out.println("Итоговая матрица:");
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
                System.out.println("Итоговая матрица:");
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

    public void transposeMatrix(int isComplex) {
        if (isCorrectInput(isComplex) != 1) {
            return;
        }
        int firstMatrix;
        while (true) {
            seeMatrix(isComplex);
            Scanner in = new Scanner(System.in);
            System.out.print("Пожалуйста, введите номер матрицы: ");
            try {
                firstMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstMatrix, 0, isComplex) == 1) {
            if (isComplex == 0) {
                double[][] newMatrix = new double[listOfMatrix.get(firstMatrix)[0].length][listOfMatrix.get(firstMatrix).length];
                System.out.println("Итоговая матрица:");
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
                System.out.println("Итоговая матрица:");
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

    public void determineMatrix(int isComplex) {
        if (isCorrectInput(isComplex) != 1) {
            return;
        }
        int firstMatrix;
        while (true) {
            seeMatrix(isComplex);
            Scanner in = new Scanner(System.in);
            System.out.print("Пожалуйста, введите номер матрицы: ");
            try {
                firstMatrix = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstMatrix, 0, isComplex) == 1) {
            if (isComplex == 0) {
                if (listOfMatrix.get(firstMatrix).length == listOfMatrix.get(firstMatrix)[0].length) {
                    System.out.printf("\nДетерминант равен = %f\n", det(listOfMatrix.get(firstMatrix)));
                } else {
                    System.out.println("Невозможно посчитать детерминант не для квадратной матрицы");
                }
            } else {
                if (listOfComplexMatrix.get(firstMatrix).length == listOfComplexMatrix.get(firstMatrix)[0].length) {
                    System.out.printf("\nДетерминант равен = %2f + %2fi\n", detComplex(listOfComplexMatrix.get(firstMatrix)).real,
                            detComplex(listOfComplexMatrix.get(firstMatrix)).image);
                } else {
                    System.out.println("Невозможно посчитать детерминант не для квадратной матрицы");
                }
            }
        }
    }

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


    public void seeMatrix(int isComplex) {
        if (isComplex == 0) {
            for (int i = 0; i < listOfMatrix.size(); ++i) {
                System.out.printf("\nМатрица %d\n", i);
                for (int j = 0; j < listOfMatrix.get(i).length; ++j) {
                    for (int t = 0; t < listOfMatrix.get(i)[j].length; ++t) {
                        System.out.print(listOfMatrix.get(i)[j][t] + "\t");
                    }
                    System.out.println();
                }
            }
        } else {
            for (int i = 0; i < listOfComplexMatrix.size(); ++i) {
                System.out.printf("\nМатрица № %d\n", i);
                for (int j = 0; j < listOfComplexMatrix.get(i).length; ++j) {
                    for (int t = 0; t < listOfComplexMatrix.get(i)[j].length; ++t) {
                        System.out.printf("%.2f + %.2fi \t", listOfComplexMatrix.get(i)[j][t].real, listOfComplexMatrix.get(i)[j][t].image);
                    }
                    System.out.println();
                }
            }
        }
    }

    private int isMultiply(int firstMatrix, int secondMatrix, int isComplex) {
        if (isComplex == 0) {
            if (listOfMatrix.get(firstMatrix)[0].length != listOfMatrix.get(secondMatrix).length) {
                System.out.println("\nНевозможно выполнить произведение с матрицами данных размеров");
                return 0;
            }
        } else {
            if (listOfComplexMatrix.get(firstMatrix)[0].length != listOfComplexMatrix.get(secondMatrix).length) {
                System.out.println("\nНевозможно выполнить произведение с матрицами данных размеров");
                return 0;
            }
        }
        return 1;
    }

    private int isPlus(int firstMatrix, int secondMatrix, int isComplex) {
        if (isComplex == 0) {
            if (listOfMatrix.get(firstMatrix).length != listOfMatrix.get(secondMatrix).length ||
                    listOfMatrix.get(firstMatrix)[0].length != listOfMatrix.get(secondMatrix)[0].length) {
                System.out.println("\nНевозможно произвести данную операцию с матрицами разных размеров");
                return 0;
            }
        } else {
            if (listOfComplexMatrix.get(firstMatrix).length != listOfComplexMatrix.get(secondMatrix).length ||
                    listOfComplexMatrix.get(firstMatrix)[0].length != listOfComplexMatrix.get(secondMatrix)[0].length) {
                System.out.println("\nНевозможно произвести данную операцию с матрицами разных размеров");
                return 0;
            }
        }
        return 1;
    }

    private int isCorrectInput(int firstMatrix, int secondMatrix, int isComplex) {
        int listSize;
        if (isComplex == 0) {
            listSize = listOfMatrix.size();
        } else {
            listSize = listOfComplexMatrix.size();
        }
        if (firstMatrix < 0 || secondMatrix < 0 ||
                firstMatrix >= listSize || secondMatrix >= listSize) {
            System.out.println("\nВведен некорректный номер. Попробуйте еще раз");
            return 0;
        }
        return 1;
    }

    private int isCorrectInput(int isComplex) {
        if (isComplex == 0) {
            if (listOfMatrix.size() == 0) {
                System.out.println("\nСначала создайте хотя бы 1 матрицу");
                return 0;
            }
        } else {
            if (listOfComplexMatrix.size() == 0) {
                System.out.println("\nСначала создайте хотя бы 1 матрицу");
                return 0;
            }
        }
        return 1;
    }
}