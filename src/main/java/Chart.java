import javafx.application.Application;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;

import java.util.ArrayList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {

    @Override
    public void start(Stage stage) {
        MyParser parser = new MyParser();
        ArrayList<MyLine> tableStructure = parser.getTableStructure();

        final NumberAxis xAxis = new NumberAxis(1, 12, 1);
        final NumberAxis yAxis = new NumberAxis();
        final AreaChart<Number, Number> areaChart = new AreaChart<Number, Number>(xAxis, yAxis);
        areaChart.setTitle("Revenue");
        areaChart.setLegendSide(Side.BOTTOM);

        //  2014
        XYChart.Series<Number, Number> series2014 = new XYChart.Series<Number, Number>();
        series2014.setName(Integer.toString(tableStructure.get(0).getB())); // 2014
        series2014.getData().add(new XYChart.Data<Number, Number>(1, 2000));
        for (int i = 1 ; i<tableStructure.size(); i++){
            series2014.getData().add(new XYChart.Data<Number, Number>( tableStructure.get(i).getA(), tableStructure.get(i).getB()));
        }

        //  2015
        XYChart.Series<Number, Number> series2015 = new XYChart.Series<Number, Number>();
        series2015.setName(Integer.toString(tableStructure.get(0).getC()));//2015
        series2015.getData().add(new XYChart.Data<Number, Number>(1, 2000));
        for (int i = 1 ; i<tableStructure.size(); i++){
          series2015.getData().add(new XYChart.Data<Number, Number>(  tableStructure.get(i).getA(), tableStructure.get(i).getC()));
        }

        stage.setTitle("Chart");
        Scene scene = new Scene(areaChart, 400, 300);
        areaChart.getData().addAll(series2014, series2015);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

