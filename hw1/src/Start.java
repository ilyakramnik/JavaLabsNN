import Console.Console;
import Console.ConsoleFunctions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    ConsoleFunctions input = new Console();

    public void start() {
        int action = -1;
        while (action != 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("""
                    Для работы с комплексными числами введите 1
                    Для работы с матрицами введите 2
                    Для завершения работы введите 0
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
                    input.complexInput();
                    break;
                case 2:
                    input.matrixInput();
                    break;
            }
        }
    }
}
