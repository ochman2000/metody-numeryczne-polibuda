package linechartsample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import lab01.Funkcja;
import lab01.Obliczenia;


public class Wykres extends Application {

    public static final double START = -0.0;
    public static final double END = 2.0;
    public static final double STEP = 0.1;
    private Obliczenia obliczenia;
    
    @Override public void start(Stage stage) {
        stage.setTitle("Metody numeryczne");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number,Number> lineChart;
        lineChart = new LineChart<>(xAxis,yAxis);                
        lineChart.setTitle("Wykresy funkcji dla zadania nr 1");      
        lineChart.setCreateSymbols(true);     
        lineChart.setAlternativeRowFillVisible(true);
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Funkcja nr 1");
        Funkcja funkcja = new Funkcja(1);
        for (double x=START; x<END; x=x+STEP) {
            double y = funkcja.getFunkcja(x);
            series1.getData().add(new XYChart.Data(x, y));
        }
        lineChart.getData().add(series1);
        XYChart.Series punkt1 = new XYChart.Series();
        punkt1.setName("Pierw. nr 1");
        obliczenia = new Obliczenia(1);
        double pierwiastek1 = obliczenia.metodaStycznych(START);
        punkt1.getData().add(new XYChart.Data(pierwiastek1, 0.0));
        lineChart.getData().add(punkt1);

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Funkcja nr 2");
        funkcja = new Funkcja(2);
        for (double x=START; x<END; x=x+STEP) {
            double y = funkcja.getFunkcja(x);
            series2.getData().add(new XYChart.Data(x, y));
        }
        lineChart.getData().add(series2);
        XYChart.Series punkt2 = new XYChart.Series();
        punkt2.setName("Pierw. nr 2");
        obliczenia = new Obliczenia(2);
        double pierwiastek2 = obliczenia.metodaStycznych(START);
        punkt2.getData().add(new XYChart.Data(pierwiastek2, 0.0));
        lineChart.getData().add(punkt2);
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Funkcja nr 3");
        funkcja = new Funkcja(3);
        for (double x=START; x<END; x=x+STEP) {
            double y = funkcja.getFunkcja(x);
            series3.getData().add(new XYChart.Data(x, y));
        }
        lineChart.getData().add(series3);
        XYChart.Series punkt3 = new XYChart.Series();
        punkt3.setName("Pierw. nr 3");
        obliczenia = new Obliczenia(3);
        double pierwiastek3 = obliczenia.metodaStycznych(START);
        punkt3.getData().add(new XYChart.Data(pierwiastek3, 0.0));
        lineChart.getData().add(punkt3);
        
        
        Scene scene  = new Scene(lineChart, 800, 450);   
        scene.getStylesheets().add("linechartsample/Chart.css");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}