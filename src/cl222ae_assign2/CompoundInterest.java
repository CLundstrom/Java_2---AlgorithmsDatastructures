package cl222ae_assign2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * CompoundInterest.java
 *
 * @Author: Christoffer Lundström
 * @Date: 12/02/19
 * <p>
 * Calculates Compound interest over x years.
 */
public class CompoundInterest extends Application {

    private double interest = 0;
    private double amount = 0;
    private double years = 0;
    private Label result;

    /**
     * @param primaryStage Sets the first Scene of the application.
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Compound Interest"); // title
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);
        BorderPane border = new BorderPane(); // Set top element
        HBox intro = createHeader(); // header box
        GridPane pane = createBody(); // body

        border.setTop(intro);
        border.setCenter(pane);


        Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param amount   Amount to calculate.
     * @param interest Interest rate in % (ex 3.42%)
     * @param years    Amount of years to calculate.
     */
    public void calculateInterest(double amount, double interest, double years) {
        if (amount <= 0 || interest <= 0 || years <= 0)
            result.setText("Fields must contain positive numbers.");

        else {

            double calc = Math.pow(1 + (interest / 100), years);
            calc = amount * calc;
            result.setText(String.format("Result: %.2f", calc));
        }
    }

    /**
     * @return Returns the header box.
     */
    public HBox createHeader() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 12, 10, 10));
        hbox.setSpacing(10);
        Label header = new Label("Compound interest");
        header.setAlignment(Pos.CENTER);
        header.setFont(new Font("Calibri", 30));
        hbox.getChildren().addAll(header);
        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }

    /**
     * @return Returns the body of the application.
     */
    public GridPane createBody() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        pane.add(new Label("Start amount:"), 0, 1);
        final TextField amount = new TextField();
        pane.add(amount, 1, 1);

        pane.add(new Label("Interest: (%)"), 0, 2);
        final TextField interest = new TextField();
        pane.add(interest, 1, 2);

        pane.add(new Label("Number of years:"), 0, 3);
        final TextField years = new TextField();
        pane.add(years, 1, 3);

        result = new Label();
        pane.add(result, 0, 5);

        Button calc = new Button("Calculate");
        pane.add(calc, 0, 4);
        GridPane.setHalignment(calc, HPos.LEFT);

        calc.setOnAction(e -> {

            this.amount = tryParseDouble(amount.getText());
            this.interest = tryParseDouble(interest.getText());
            this.years = tryParseDouble(years.getText());
            calculateInterest(this.amount, this.interest, this.years);
        });

        return pane;

    }

    private double tryParseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            System.err.println(e.toString());
            return 0;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
