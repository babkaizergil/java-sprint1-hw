import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите команду:");
        Scanner scanner = new Scanner(System.in);
        printMenu();                                                            //вывели меню
        int input = scanner.nextInt();                                          //считали ввод пользователя
        StepTracker stepTracker = new StepTracker();

        while (input != 0) {
            if (input == 1) {
                System.out.println("За какой месяц вы хотите ввести данные?\n" +
                        "1-Январь, 2-Февраль, 3-Март, 4-Апрель, 5-Май, 6-Июнь, 7-Июль, " +
                        "8-Август, 9-Сентябрь, 10-Октябрь, 11-Ноябрь, 12-Декабрь?");
                int month = scanner.nextInt();
                while ((month > 12) || (month < 1)) {
                    System.out.println("Внимание: Значение должно быть в пределах от 1 до 12.\nВведите заново.");
                    month = scanner.nextInt();
                }
                System.out.println("За какой день вы хотите ввести данные?");
                int day = scanner.nextInt();
                while ((day > 30) || (day < 1)) {
                    System.out.println("Внимание: Значение должно быть в пределах от 1 до 30.\nВведите заново.");
                    day = scanner.nextInt();
                }
                System.out.println("Введите кол-во шагов");
                int steps = scanner.nextInt();
                while (steps < 0) {
                    System.out.println("Внимание: Значение должно быть не отрицательным.\nВведите заново.");
                    steps = scanner.nextInt();
                }
                stepTracker.saveDay(month, day, steps);                 //сценарий для ввода шагов за определенный день
            } else if (input == 2) {
                System.out.println("За какой месяц вы хотите вывести данные?\n" +
                        "1-Январь, 2-Февраль, 3-Март, 4-Апрель, 5-Май, 6-Июнь, 7-Июль, " +
                        "8-Август, 9-Сентябрь, 10-Октябрь, 11-Ноябрь, 12-Декабрь?");
                int month = scanner.nextInt();
                while ((month > 12) || (month < 1)) {
                    System.out.println("Внимание: Значение должно быть в пределах от 1 до 12.\nВведите заново.");
                    month = scanner.nextInt();
                }
                stepTracker.printMonth(month);                       //сценарий вывода статистики за определенный месяц
            } else if (input == 3) {
                StepTracker.changePurpose();                                                //сценарий по изменению цели
            } else if (input == 4) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Команда не известна");
            }
            printMenu();                                // печатаем меню ещё раз перед завершением предыдущего действия
            input = scanner.nextInt();                                   // повторное считывание данных от пользователя
        }
    }

    static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый день;\n" +
                "2 - Напечатать статистику за определённый месяц;\n" +
                "3 - Изменить цель по количеству шагов в день;\n" +
                "4 - Выйти из приложения");
    }
}
