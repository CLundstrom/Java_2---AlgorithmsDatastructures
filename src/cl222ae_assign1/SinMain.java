package cl222ae_assign1;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;

public class SinMain {

    //y = (1 + x/pi)*cos(x)*cos(40*x) range 0 <= x <= 2*pi.

    public static void main(String[] args){

        // Create and Customize Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideS);
        chart.getStyler().setMarkerSize(4);

        // Generate data
        List xData = new ArrayList();
        List yData = new ArrayList();
        for (double i = 0; i < 2*Math.PI; i+=0.001) {
            xData.add(i);
            yData.add((1 + (i/Math.PI))*Math.cos(i)*Math.cos(40*i));
        }

        // Display scatter plot
        chart.addSeries("plot", xData, yData);
        new SwingWrapper(chart).displayChart();

    }


}
