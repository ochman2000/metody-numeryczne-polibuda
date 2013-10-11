package lab01;

public class Funkcja {
	
	private static double e = Math.E;
	private int index;
	
	public Funkcja(int numerWybranejFunkcji) {
		index=numerWybranejFunkcji;
	}
	
	public double getFunkcja(double x){
		switch (index) {
		case 1:
			return 3*x + Math.sin(x) - Math.pow(e, x);
		case 2:
			return 2*Math.pow(e, (-x)) - Math.sin(x);
		case 3:
			return Math.pow(2, x) - 3*x;
		default:
			return Double.NaN;
		}
	}
	public double getPochodna(double x){
		switch (index) {
		case 1:
			return 3-Math.pow(e, x)+Math.cos(x);
		case 2:
			return (-2)*Math.pow(e, (-x))-Math.cos(x);
		case 3:
			return Math.pow(2, x)*Math.log(2)-3;
		default:
			return Double.NaN;
		}
	}
	/**
	 * <b>Równanie: </b>3x + sin(x) - e^x = 0<br/>
	 * <b>Pierwiastki: </b>	x = 0.3604<br/><br/>
	 */
	public static double funkcjaNumer1(double x) {
		return 3*x + Math.sin(x) - Math.pow(e, x);
	}
	/**
	 * <b>Pochodna: </b> -e^x + cos(x) + 3
	 */
	public static double pochodnaNumer1(double x) {
		return 3-Math.pow(e, x)+Math.cos(x);
	}
	/**
	 * <b>Równanie: </b>2e^(-x) - sin(x) = 0<br/>
	 * <b>Pierwiastki: </b> x = 0.921028<br/><br/>
	 */
	public static double funkcjaNumer2(double x) {
		return 2*Math.pow(e, (-x)) - Math.sin(x);
	}
	/**
	 * <b>Pochodna: </b> -2 * e^(-x)- cos(x)
	 */
	public static double pochodnaNumer2(double x) {
		return (-2)*Math.pow(e, (-x))-Math.cos(x);
	}
	/**
	 * <b>Równanie: </b> 2^x - 3x = 0 <br/>
	 * <b>Pierwiastki: </b> x = 0.435<br/>x = 0.332<br/><br/>
	 */
	public static double funkcjaNumer3(double x) {
		return Math.pow(2, x) - 3*x;
	}
	/**
	 * <b>Pochodna: </b> 2^x * log(2) - 3
	 */
	public static double pochodnaNumer3(double x) {
		return Math.pow(2, x)*Math.log(2)-3;
	}
}
