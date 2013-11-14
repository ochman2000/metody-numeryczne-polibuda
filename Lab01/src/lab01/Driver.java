/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Lukasz Ochmanski
 */
public class Driver extends Application {
    GridPane grid;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metody Numeryczne 2013/2014");
        initLayout();
        Scene scene = new Lab01(grid);
        scene.getStylesheets().add("linechartsample/Chart.css"); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void initLayout() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
    }
    
    

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
