package cl222ae_assign4.microchips;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * MicrochipsMain.java
 *
 * @Author: Christoffer
 * @Date: 20/03/2019
 * <p>
 * Implementation of the K-nearest neighbour algorithm.
 * Is used to predict the quality outcome of microchips in a scatterplot.
 * <br>
 * Makes use of library xchart included in this package.
 */
public class MicrochipsMain {


    private static String path = "src/cl222ae_assign4/microchips/microchips.csv";
    private static ArrayList<Microchip> list;
    private static Map<Microchip, Double> distances;
    private static List<Map.Entry<Microchip, Double>> nearest;


    public static void main(String[] args) {

        Microchip c1 = new Microchip(-0.3, 1.0);
        Microchip c2 = new Microchip(-0.5, -0.1);
        Microchip c3 = new Microchip(0.6, 0.0);

        list = readCSV(path);
        generateGraph();

        calculateNearest(c1, 5);
        calculateNearest(c2, 5);
        calculateNearest(c3, 5);

        calculateNearest(c1, 3);
        calculateNearest(c2, 3);
        calculateNearest(c3, 3);

        calculateNearest(c1, 1);
        calculateNearest(c2, 1);
        calculateNearest(c3, 1);


    }

    /**
     * Calculates the distance to all points based on Euclidian distance formula
     * d = sqrt((x2-x1)^2+(y2-y1)^2)
     * <br>
     * Filters out the nearest k values
     * and predicts the result.
     * <p>
     * <p>
     * Example: x= -0.3 , y= 1.0 K: 5
     *
     * @param c_chip Chip to be compared for a point.
     * @param k      Amount of nearest points to be considered.
     */
    private static void calculateNearest(Microchip c_chip, int k) {
        if (k > list.size()) throw new IndexOutOfBoundsException("K value larger than amount of data.");

        distances = new HashMap<Microchip, Double>();

        for (Microchip chip : list) {
            double x = chip.getX() - c_chip.getX();
            double y = chip.getY() - c_chip.getY();
            x = Math.pow(x, 2);
            y = Math.pow(y, 2);
            double distance = Math.sqrt(x + y);
            distances.put(chip, distance);
        }

        System.out.println("\nNearest points: to [" + c_chip.getX() + ", " + c_chip.getY() + "]\n------------------");
        nearest = distances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).limit(k).collect(Collectors.toList());

        for (var entry : nearest) {

            System.out.println(entry);
        }

        if (isFailedPrediction(nearest)) {
            System.out.println("====Prediction======> FAIL");
        } else {
            System.out.println("====Prediction======> SUCCESS");
        }
    }

    /**
     * Make a prediction basedo on values of the input list.
     *
     * @param values Input map list.
     * @return
     */
    private static boolean isFailedPrediction(List<Map.Entry<Microchip, Double>> values) {

        int fail = 0;
        for (Map.Entry<Microchip, Double> e : values) {

            if (e.getKey().getStatus() == 0) fail++;

        }
        return fail > values.size() / 2;
    }

    /**
     * Generates a graph over .the csv values.
     */
    public static void generateGraph() {

        String title = "Microchip quality prediction based on two tests";
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(true);
        chart.setTitle(title);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setMarkerSize(4);
        chart.setXAxisTitle("Property 1");
        chart.setYAxisTitle("Property 2");

        List<Double> xDataFail = new ArrayList<>();
        List<Double> yDataFail = new ArrayList<>();
        List<Double> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();
        for (Microchip m : list) {
            if (m.getStatus() == 0) {
                xDataFail.add(m.getX());
                yDataFail.add(m.getY());
            } else {
                xData.add(m.getX());
                yData.add(m.getY());
            }
        }
        chart.addSeries("OK", xData, yData);
        chart.addSeries("FAIL", xDataFail, yDataFail);
        new SwingWrapper(chart).displayChart();
    }

    /**
     * Reads the values from the csv files.
     * <p>
     *
     * @param path Path to the .csv file.
     * @return A list of microchips based on the csv values.
     */
    private static ArrayList<Microchip> readCSV(String path) {
        ArrayList<Microchip> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] split = line.split(",");
                values.add(new Microchip(Double.valueOf(split[0]), Double.valueOf(split[1]), Integer.valueOf(split[2])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return values;
    }
}
