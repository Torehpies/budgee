package budgee;

import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.chart.BarChart;  
import javafx.scene.chart.CategoryAxis;  
import javafx.scene.chart.NumberAxis;  
import javafx.scene.chart.XYChart;  
import javafx.stage.Stage;  

public class AccountAnalysis extends Application {  
@Override  
public void start(Stage primaryStage) throws Exception {  
    // TODO Auto-generated method stub  
    //Defining string to label XAxis   
    String Euro = "Euro";  
    String Pound = "British Pound";  
    String A_Dollar = "Austrelian Dollar";  
    String frenc= "Swis Franc";  
      
    //Configuring category and NumberAxis   
    CategoryAxis xaxis= new CategoryAxis();  
    NumberAxis yaxis = new NumberAxis(0.1,2,0.1);  
    xaxis.setLabel("Currency");  
    yaxis.setLabel("Dollar price");  
      
    //Configuring BarChart   
    BarChart<String,Float> bar = new BarChart(xaxis,yaxis);  
    bar.setTitle("Dollar Conversion chart");  
      
    //Configuring Series for XY chart   
    XYChart.Series<String,Float> series = new XYChart.Series<>();  
    series.getData().add(new XYChart.Data(Euro,0.83));  
    series.getData().add(new XYChart.Data(Pound,0.73));  
    series.getData().add(new XYChart.Data(frenc,1.00));  
    series.getData().add(new XYChart.Data(A_Dollar,1.32));  
      
    //Adding series to the barchart   
    bar.getData().add(series);  
      
    // configuring group and scene   
    Group root = new Group();  
    root.getChildren().add(bar);  
    Scene scene = new Scene(root,600,400);  
    primaryStage.setScene(scene);  
    primaryStage.setTitle("BarChart Example");  
    primaryStage.show();      
}  
public static void main(String[] args) {  
    launch(args);  
}  
}  