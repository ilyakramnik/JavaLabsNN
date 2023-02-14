package Console;

import ComplexNums.ComplexNums;
import Matrix.Matrix;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Console implements ConsoleFunctions{
    public void complexInput() {
        ComplexNums methods = new ComplexNums();
        int action = -1;
        double real, image;
        while (action != 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("""   
                      
                    Для создания комплексного числа вида a+bi введите 1
                    Для сложения 2 созданных комплексных чисел введите 2
                    Для перемножения 2 созданных комплексных чисел введите 3
                    Для вывода созданного комплексного числа в тригонометрической форме введите 4
                    Для выхода введите 0
                    """);
            try {
                action = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова");
                continue;
            }
            switch (action) {
                case 0:
                    break;
                case 1:
                    System.out.print("Пожалуйста, введите реальную часть: ");
                    try {
                        real = in.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова");
                        continue;
                    }
                    System.out.print("Пожалуйста, введите мнимую часть: ");
                    try {
                        image = in.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова");
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
    public void matrixInput(){
        Matrix methods = new Matrix();
        int action = -1, n, m, isComplex = -1;
        while (isComplex != 0 && isComplex != 1) {
            Scanner in = new Scanner(System.in);
            System.out.print("""
                    Для работы с обычными матрицами введите 0
                    Для работы с комплексными матрицами введите 1
                    """);
            try {
                isComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова");
            }
        }
        while (action != 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("""   
                      
                    Для создания и заполнения матрицы введите 1
                    Для сложения 2 созданных матриц введите 2
                    Для умножения 2 созданных матриц введите 3
                    Для транспонирования созданной матрицы введите 4
                    Для подсчета определителя матрицы введите 5
                    Для выхода введите 0
                    """);
            try {
                action = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова");
            }
            switch (action) {
                case 0:
                    break;
                case 1:
                    System.out.print("Пожалуйста, введите количество строк в матрице: ");
                    try {
                        n = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова");
                        continue;
                    }
                    System.out.print("Пожалуйста, введите количество столбцов в матрице: ");
                    try {
                        m = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова");
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