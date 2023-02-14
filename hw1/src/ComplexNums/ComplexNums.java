package ComplexNums;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ComplexNums {
    ArrayList<Double> listOfReal = new ArrayList<>();
    ArrayList<Double> listOfImage = new ArrayList<>();
    public void createComplexNum(double newReal, double newImage) {
        listOfReal.add(newReal);
        listOfImage.add(newImage);
        seeListOfComplex(listOfReal, listOfImage);
    }
    public void plus() {
        if (isCorrectInput() != 1){
            return;
        }
        int firstComplex, secondComplex;
        while (true) {
            seeListOfComplex(listOfReal, listOfImage);
            Scanner in = new Scanner(System.in);
            System.out.print("Пожалуйста, введите номер первого комплексного числа: ");
            try {
                firstComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                continue;
            }
            System.out.print("Пожалуйста, введите номер второго комплексного числа: ");
            try {
                secondComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstComplex, secondComplex) == 1) {
            double finalReal = listOfReal.get(firstComplex) + listOfReal.get(secondComplex);
            double finalImage = listOfImage.get(firstComplex) + listOfImage.get(secondComplex);
            System.out.printf("\nРезультат суммы: %.2f + %.2fi \n", finalReal, finalImage);
        }
    }
    public void multiply() {
        if (isCorrectInput() == 0){
            return;
        }
        int firstComplex, secondComplex;
        while (true) {
            seeListOfComplex(listOfReal, listOfImage);
            Scanner in = new Scanner(System.in);
            System.out.print("Пожалуйста, введите номер первого комплексного числа: ");
            try {
                firstComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                continue;
            }
            System.out.print("Пожалуйста, введите номер второго комплексного числа: ");
            try {
                secondComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstComplex, secondComplex) == 1) {
            double finalReal = listOfReal.get(firstComplex) * listOfReal.get(secondComplex) -
                    listOfImage.get(firstComplex) * listOfImage.get(secondComplex);
            double finalImage = listOfReal.get(firstComplex) * listOfImage.get(secondComplex) +
                    listOfImage.get(firstComplex) * listOfReal.get(secondComplex);
            System.out.printf("\nРезультат произведения: %.2f + %.2fi \n", finalReal, finalImage);
        }
    }
    public void trigonometric() {
        if (isCorrectInput() == 0){
            return;
        }
        int firstComplex;
        while (true) {
            seeListOfComplex(listOfReal, listOfImage);
            Scanner in = new Scanner(System.in);
            System.out.print("Пожалуйста, введите номер первого комплексного числа: ");
            try {
                firstComplex = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод данных. Пожалуйста, попробуйте снова\n");
                continue;
            }
            break;
        }
        if (isCorrectInput(firstComplex, 0) == 1) {
            double r = Math.sqrt(Math.pow(listOfReal.get(firstComplex), 2) + Math.pow(listOfImage.get(firstComplex), 2));
            double cos = listOfReal.get(firstComplex) / r;
            double sin = listOfImage.get(firstComplex) / r;
            System.out.printf("\nz = %.2f * (cos(a) + i*sin(a)), где cos(a) = %.2f, sin(a) = %.2f\n", r, cos, sin);
        }
    }
    private void seeListOfComplex(ArrayList<Double> real, ArrayList<Double> image) {
        System.out.println("\nВсе созданные комплексные числа (номер: число):");
        for (int i = 0; i < real.size(); ++i) {
            System.out.printf("%d: %.2f + %.2fi \n", i, real.get(i), image.get(i));
        }
    }
    private int isCorrectInput(int firstComplex, int secondComplex) {
        if (firstComplex < 0 || secondComplex < 0 ||
                firstComplex >= listOfReal.size() || secondComplex >= listOfReal.size()) {
            System.out.println("\nВведен некорректный номер. Попробуйте еще раз");
            return 0;
        }
        return 1;
    }
    private int isCorrectInput(){
        if (listOfReal.size() == 0) {
            System.out.println("\nСначала создайте хотя бы 1 комплексное число");
            return 0;
        }
        return 1;
    }
}