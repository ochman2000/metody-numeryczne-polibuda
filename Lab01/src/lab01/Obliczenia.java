package lab01;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Obliczenia {

    public Funkcja funkcja;
    public static boolean wariant = false;
    public static int MAX_ITERACJE = 2000;
    public static double START = 0.0;
    public static double END = 2.0;
    public static double STEP = 0.1;
    public static double EPSILON = 0.000001;
    public static double DOKLADNOSC = 0.000001;

    public Obliczenia(int nrFunkcji) {
        funkcja = new Funkcja(nrFunkcji);
//        licz();
//        funkcja = new Funkcja(nrFunkcji);
    }
    public final void licz() {
        int i=1;
        while (!Double.isNaN(new Funkcja(i).getFunkcja(0.0))) {
            funkcja = new Funkcja(i);
            System.out.println("----- Równanie numer " + (i) + ": ------");
            metodaBezmyslnejIteracji(START);
            metodaBisekcji(START);
            metodaStycznych(START);
            System.out.println("------------------------------\n");        
            i++;
        }
    }

    public double wybranaFunkcja(double x) {
        return funkcja.getFunkcja(x);
    }

    public double wybranaPochodna(double x) {
        return funkcja.getPochodna(x);
    }

    public double metodaBezmyslnejIteracji(double x) {
        double y;
        int count = 0;
        do {
            y = wybranaFunkcja(x);
            x = x + 0.0001;
            count++;
        } while (Math.abs(y)<EPSILON);
        System.out.println("Metoda bezmyślnej iteracji:");
        System.out.println("X po " + count + " iteracjach wyniósł: " + x);
        return x;
    }

    public double metodaBisekcji(double x) {
        double a, b, m, y_m, y_a;
        a = START;
        b = END;
        int count = 0;
        while ((b - a) > EPSILON) {
            m = (a + b) / 2;
            y_m = wybranaFunkcja(m); // y_m = f(m)
            y_a = wybranaFunkcja(a); // y_a = f(a)

            if ((y_m > 0 && y_a < 0) || (y_m < 0 && y_a > 0)) {
                // jesli znaki są różne to szukaj po lewej
                b = m;
            } else {
                // jeśli znaki są takie same to szukaj po prawej
                a = m;
            }
            count++;
//	System.out.println(count + ". Przedział: [" + a + " .. " + b + "]");
        }
        System.out.println("Metoda bisekcji:");
        System.out.println("X po " + count + " iteracjach wyniósł: " + (a + b) / 2);
        return (a+b)/2;
    }

    public double metodaStycznych(double x) {
        double y = metodaStycznychHelper(x);
        if (START <= y && y <= END) {
            return y;
        } else {
            System.out.println("ERROR: Y poza zakresem");
            y = metodaStycznychHelper(END);
            if (START <= y && y <= END) {
                return y;
            } else {
                System.out.println("ERROR: Y poza zakresem");
                y = metodaStycznychHelper(START + (Math.abs(END - START)) / 2);
                if (START <= y && y <= END) {
                    return y;
                } else {
                    System.out.println("ERROR: Y poza zakresem");
                    System.out.println("BRAK ROZWIĄZANIA");
                    return Double.NaN;
                }
            }
        }
    }
    private double metodaStycznychHelper(double x) {
        double z=x;
        int i;
        for (i = 0; i < MAX_ITERACJE; i++) {
            double mianownik = wybranaPochodna(x);
            if (Math.abs(mianownik) < DOKLADNOSC) {
                System.out.println("UWAGA: mianownik jest zbyt mały.");
                break;
            }
            double newtonX = x - wybranaFunkcja(x) / mianownik;
            if (Math.abs(newtonX - x) < EPSILON) {
                break;
            }
            x = newtonX;
        }
        System.out.println("Metoda stycznych dla argumentu x="+z);
        System.out.println("X po " + i + " iteracjach wyniósł: " + x);
        String zero = customFormat("###.#######################", wybranaFunkcja(x));
        System.out.println("f("+x+") wynosi "+ zero);
        return x;
    }
    static public String customFormat(String pattern, double value ) {
      DecimalFormat myFormatter = new DecimalFormat(pattern);
      myFormatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
      String output = myFormatter.format(value);
      return (output);
   }
}