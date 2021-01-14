import java.util.Random;
import java.util.Scanner;

public class Randomizer {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String userCommand;

    public void hello() {
        System.out.println("Приветствую, друг!\n" +
                "Я знаю 3 команды.\n" +
                "1 - |Помощь|, можешь с нее начать, я расскажу подробнее, что умею.\n" +
                "2 - Сгенерировать число.(Можешь мне писать |Дай| и я покажу тебе число).\n" +
                "3 - |Выход|.\n");
        userCommand = scanner.nextLine();
        if (userCommand.equalsIgnoreCase("Помощь")) {
            help();
        }
        if (userCommand.equalsIgnoreCase("Дай")) {
            start();
        }
        if (userCommand.equalsIgnoreCase("Выход")) {
            exit();
        }
    }

    public void start() {
        System.out.println("Введите минимальное значение:");
        int min = scanner.nextInt();
        System.out.println("Введите максимальное значение:");
        int max = scanner.nextInt();
        int[] array = new int[max - min + 1];
        int count = 0;

        while (true) {
            userCommand = scanner.nextLine();
            if (userCommand.equalsIgnoreCase("Помощь")) {
                help();
            }
            if (userCommand.equalsIgnoreCase("Выход")) {
                System.out.println("До свидания!");
                System.exit(0);
            }
            if (userCommand.equalsIgnoreCase("Дай")) {
                if (array.length == count) {
                    System.out.println("У меня больше ничего для Вас нет :(");
                    System.exit(0);
                }
                while (true) {
                    int randomValue = random.nextInt((max - min) + 1) + min;
                    if (array[randomValue - min] == 0) {
                        array[randomValue - min] = randomValue;
                        System.out.println(randomValue);
                        count++;
                        break;
                    }
                }
            }
        }
    }

    public void help() {
        if (userCommand.equalsIgnoreCase("Помощь")) {
            System.out.println("При команде |Дай| - я тебе покажу уникальное число в рамках диапазона, который ты указал.\n" +
                    "Если я тебе больше не нужен, введи команду |Выход|. Надеюсь я тебе в этом помог.\n");
            userCommand = scanner.nextLine();
        }
    }

    public void exit() {
        if (userCommand.equalsIgnoreCase("Выход")) {
            System.out.println("До свидания!");
            System.exit(0);
        }
    }
}
