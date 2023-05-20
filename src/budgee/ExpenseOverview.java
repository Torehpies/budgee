package budgee;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ExpenseOverview extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiating PieChart class
        PieChart piechart = new PieChart();

        // Setting pieChart data
        piechart.setData(getChartData());
        piechart.setLegendSide(Side.LEFT);
        piechart.setTitle("Testtiiinhhhng");
        piechart.setClockwise(false);

        AccountAnalysis accountAnalysis = new AccountAnalysis();
        accountAnalysis.start(primaryStage);
        
        // Creating layout
        StackPane root = new StackPane();

        // Adding piechart to the layout
        root.getChildren().add(piechart);

        // Configuring Scene and stage object
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PieChart Example");

        // Set event handler for the close request
        primaryStage.setOnCloseRequest((WindowEvent event) -> {
            // Perform any cleanup or save operations here
            // Then exit the application
            Platform.exit();
        });

        primaryStage.show();
    }

    // The method sets the data to the pie-chart.
    private ObservableList<Data> getChartData() {
        ObservableList<Data> list = FXCollections.observableArrayList();
        list.addAll(
        		new PieChart.Data("JavaScript", 30.8),
                new PieChart.Data("Ruby", 11.8),
                new PieChart.Data("Java", 10.8),
                new PieChart.Data("Python", 11.6),
                new PieChart.Data("PHP", 7.2),
                new PieChart.Data("Objective-C", 10.7),
                new PieChart.Data("C", 5.2),
                new PieChart.Data("C++", 4.3),
                new PieChart.Data("Go", 3.8),
                new PieChart.Data("CSS", 3.8)
        );
        return list;
    }
    
}
