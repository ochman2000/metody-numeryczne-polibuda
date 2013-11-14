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
                System.out.println("     ===================");
                System.out.println("     ------ODŚWIEŻ------");
                System.out.println("     ===================");
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
                createChart();
            }
        });
    }
    
    private void createChart() {
        NumberAxis xAxis;
        xAxis = new NumberAxis(START, END, STEP);
        NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setPrefSize(1200, 675);
        lineChart.setTitle("Wykresy funkcji dla zadania nr 1");      
        lineChart.setCreateSymbols(true);     
        lineChart.setAlternativeRowFillVisible(true);

        int m=1;
        while (!Double.isNaN(new Funkcja(m).getFunkcja(0.0))) {
            createSeries(m);
            m++;
        }
        grid.add(lineChart, 0, 2, 9, 1);
    }
    
    private void createSeries(int i) {
        XYChart.Series series = new XYChart.Series();
        series.setName("Funkcja nr "+i);
        Funkcja funkcja = new Funkcja(i);
        for (double x=START; x<END; x=x+STEP) {
            double y = funkcja.getFunkcja(x);
            series.getData().add(new XYChart.Data(x, y));
        }
        lineChart.getData().add(series);
        Obliczenia obliczenia = new Obliczenia(i);
        System.out.println("----- Równanie numer " + (i) + ": ------");
        obliczenia.metodaBezmyslnejIteracji(START);
        obliczenia.metodaBisekcji(START);
        double pierwiastek = obliczenia.metodaStycznych(START);
        System.out.println("------------------------------\n");
        XYChart.Series punkt = new XYChart.Series();
        if (!Double.isNaN(pierwiastek)) {
            punkt.setName("Pierw. nr "+i+" ="+pierwiastek);
            punkt.getData().add(new XYChart.Data(pierwiastek, 0.0));
        }
        else {
            punkt.setName("Brak pierw. nr "+i);
        }
        lineChart.getData().add(punkt);
    }
}