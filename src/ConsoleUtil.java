import java.util.Scanner;

public class ConsoleUtil {
    public static int inputInt(String message, int min, int max) {
        int number = 0;
        boolean isCorrectInput;


        do {
            try {
                isCorrectInput = true;
                Scanner scanner = new Scanner(System.in);

                System.out.println(message);
                number = scanner.nextInt();

                if (number < min || number > max) {
                    throw new Exception();
                }

            } catch (Exception e) {
                isCorrectInput = false;

                System.out.println("Ошибка ввода. Вы ввелит не число или число за пределами диапазона от " + min + " до " + max);
            }

        } while (isCorrectInput == false);

        return number;
    }

    public static String inputString(String message, int minLength, int maxLength) {
        String str = "";
        boolean isCorrectInput;


        do {
            try {
                isCorrectInput = true;
                Scanner scanner = new Scanner(System.in);

                System.out.println(message);
                str = scanner.nextLine();

                if (str.length() < minLength || str.length() > maxLength) {
                    throw new Exception();
                }

            } catch (Exception e) {
                isCorrectInput = false;

                System.out.println("Ошибка ввода. Длина строки должна быть от " + minLength + " до " + maxLength);
            }

        } while (isCorrectInput == false);

        return str;
    }

    public static void printString(String message) {
        System.out.print(message);
    }

    public static void printlnString(String message) {
        System.out.println(message);
    }
}
