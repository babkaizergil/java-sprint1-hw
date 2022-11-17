import java.util.Scanner;
public class StepTracker {
    static int purpose = 10000; //целевое значение по умолчанию
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void saveDay(int month, int day, int steps) {               //получила ввод пользователя аругменты
        MonthData monthData = monthToData[month-1];             //выбрала месяц из массива
        monthData.saveSteps(day, steps);                        //передала в метод объекта месяц аргументы
    }
    void printMonth(int month) {
        MonthData monthData = monthToData[month-1];
        monthData.showData();
        System.out.println();
        System.out.println("Общее количество шагов за месяц: " + monthData.sumData());
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.findMax());
        System.out.println("Среднее количество шагов: " + monthData.findAvg());
        System.out.println("Пройденная дистанция (в км): " + monthData.countDist());
        System.out.println("Количество сожжённых килокалорий: " + monthData.countKcal());
        System.out.println("Лучшая серия: " + monthData.bestSeries() + " дней подряд.");
    }

    class MonthData {
        int [] dayData = new int[30];

        void saveSteps(int day, int steps) {                        //полученные аргументы сохранила в объект
            dayData[day-1] = steps;
        }
        void showData() {
            for(int i = 0; i < dayData.length; i++){
                System.out.print((i + 1) + " день: "+ dayData[i] + ", ");
            }
        }
        int sumData() {
            int sum = 0;
            for(int i = 0; i < dayData.length; i++){
                sum += dayData[i];
            }
            return sum;
        }
        int findMax() {
            int max = 0;
            for(int i = 0; i < dayData.length; i++){
                if (dayData[i] > max) {
                    max = dayData[i];
                }
            }
            return max;
        }
        int findAvg() {
            int avg = sumData() / dayData.length;
            return avg;
        }
        double countDist() {
            double dist = Converter.getDistance(sumData());
            return dist;
        }
        double countKcal() {
            double kcal = Converter.getKcal(sumData());
            return kcal;
        }
        int bestSeries() {
            int days = 0;
            int count = 0;
            for(int i = 0; i < dayData.length; i++){
                if(dayData[i] >= purpose) {             //сравнили с целью
                    days++;                             //счет если да
                }
                else {                                  //если нет
                    if(days > count) {
                        count = days;                   //сохраняем набранные дни
                        days = 0;                      //сброс счетчика и поиск далее по массиву
                    }
                }
            }
            return count;
        }
    }
    static void changePurpose() {                                      //изменить целевое значение
        System.out.println("Введите новое целевое значение: ");
        Scanner scanner = new Scanner(System.in);
        purpose = scanner.nextInt();
        System.out.println("Новое целевое значение: " + purpose);
    }
}