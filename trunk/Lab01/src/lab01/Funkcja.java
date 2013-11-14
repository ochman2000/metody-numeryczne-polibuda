package lab01;

public class Funkcja {

    private int index;

    public Funkcja(int numerWybranejFunkcji) {
        index = numerWybranejFunkcji;
    }

    public double getFunkcja(double x) {
        switch (index) {
            case 1:
                return Math.sin(x);
//            case 2:
//                return 2 * Math.exp(-x) - Math.sin(x);
//            case 3:
//                return 3 * x + Math.sin(x) - Math.exp(x);             
            default:
                return Double.NaN;
        }
    }

    public double getPochodna(double x) {
        switch (index) {
            case 1:
                return Math.cos(x);
//            case 2:
//                return (-2) * Math.exp(-x) - Math.cos(x);
//            case 3:
//                return 3 - Math.exp(x) + Math.cos(x);
            default:
                return Double.NaN;
        }
    }
}
