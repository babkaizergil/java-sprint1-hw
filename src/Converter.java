public class Converter {
    public static double getDistance(int steps) {
        return Math.round(steps * 0.00075);  //округляю
    }

    public static double getKcal(int steps) {
        double kcal = steps * 50 / 1000.0;
        return kcal;
    }
}


