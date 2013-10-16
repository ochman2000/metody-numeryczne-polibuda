/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static lab01.Obliczenia.END;
import static lab01.Obliczenia.START;
import static lab01.Obliczenia.STEP;
import static lab01.Obliczenia.EPSILON;
import static lab01.Obliczenia.MAX_ITERACJE;

/**
 *
 * @author Łukasz Ochmański
 */
public class Lab01 extends Scene {
    private GridPane grid;
    private Button btn;
    private LineChart<Number,Number> lineChart;
    private Obliczenia obliczenia;
    private TextField startTextField;
    private TextField endTextField;
    private TextField epsilonTextField;
    private TextField iteracjeTextField;
    
public Lab01(GridPane parent) {
        super(parent, 1200, 675);
        this.grid = parent;       
        initGUI();
    }
    private void initGUI() {
        Label startLabel = new Label("        X od:");
        startLabel.setMinWidth(60);
        grid.add(startLabel, 0, 1);
        startTextField = new TextField();
        grid.add(startTextField, 1, 1);

        Label endLabel = new Label("       X do:");
        endLabel.setMinWidth(60);
        grid.add(endLabel, 2, 1);
        endTextField = new TextField();
        grid.add(endTextField, 3, 1);
        
        Label epsilonLabel = new Label("        Epsilon:");
        epsilonLabel.setMinWidth(70);
        grid.add(epsilonLabel, 4, 1);
        epsilonTextField = new TextField();
        grid.add(epsilonTextField, 5, 1);
        
        Label iteracjeLabel = new Label("       Maks iteracji:");
        iteracjeLabel.setMinWidth(100);
        grid.add(iteracjeLabel, 6, 1);
        iteracjeTextField = new TextField();
        grid.add(iteracjeTextField, 7, 1);
        
        btn = new Button("Odśwież");
        HBox hbBtn = new HBox(1);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 8, 1);
        
        createChart();
        createControl();
    }

    private void createControl() {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!startTextField.getText().trim().isEmpty()){
                    START = Double.parseDouble(startTextField.getText());
                }
                if (!endTextField.getText().trim().isEmpty()) {
                    END = Double.parseDouble(endTextField.getText());
                }
                if (!epsilonTextField.getText().trim().isEmpty()) {
                    EPSILON = Double.parseDouble(epsilonTextField.getText());
                }
                if (!iteracjeTextField.getText().trim().isEmpty()) {
                    MAX_ITERACJE = Integer.parseInt(iteracjeTextField.getText());
                }
                grid.getChildren().clear();
                initGUI();
            }
        });
    }
    
    private void createChart() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setPrefSize(1200, 675);
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
        
        grid.add(lineChart, 0, 2, 9, 1);
    }
}