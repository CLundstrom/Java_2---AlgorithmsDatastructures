package cl222ae_assign3.TinyPainter;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.NoSuchElementException;

/**
 * TinyPainter.java
 *
 * @Author: Christoffer
 * @Date: 01/03/2019
 */
public class TinyPainter extends Application {

    private static final double MAX_SIZE = 40.0; // brush size
    private ComboBox<String> shapeBox;
    private ComboBox<String> sizeBox;
    private ColorPicker colorBox;
    private Settings settings;
    private Group canvas;
    private Object currentShape;
    private double xCoord;
    private double yCoord;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tiny Painter");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);

        BorderPane bp = new BorderPane();

        shapeBox = new ComboBox<>();
        shapeBox.getItems().addAll("Line", "Dot", "Rectangle", "Circle");
        sizeBox = setAcceptedSizes();
        shapeBox.getSelectionModel().selectFirst();
        sizeBox.getSelectionModel().selectFirst();
        colorBox = new ColorPicker();

        shapeBox.getSelectionModel().selectedIndexProperty().addListener(o -> {
            updateSettings();
        });
        HBox menu = new HBox();
        menu.setSpacing(10);
        AnchorPane mainBody = new AnchorPane();
        canvas = new Group();
        bp.setCenter(mainBody);
        bp.setTop(menu);
        Scene scene = new Scene(bp);


        bp.setOnMousePressed(o -> {
            updateSettings();
            currentShape = setShape(settings);
            getCoordsXY(o.getX(), o.getY());
        });

        bp.setOnMouseDragged(o -> {
            canvas.getChildren().remove(currentShape);
            drawShape(o.getX(), o.getY(), true);

        });


        menu.getChildren().addAll(shapeBox, sizeBox, colorBox);
        mainBody.getChildren().add(canvas);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    /**
     * @param setting Uses setting to define which object to place.
     * @return
     */
    private Object setShape(Settings setting) {
        switch (setting.getShape()) {
            case "Line":
                return new Line();
            case "Dot":
                return new Rectangle();
            case "Rectangle":
                return new Rectangle();
            case "Circle":
                return new Circle();
        }
        throw new NoSuchElementException("No element selected");
    }

    /**
     * Draws the shapes.
     *
     * @param x       Current x-coordinate.
     * @param y       Current y-coordinate.
     * @param isFinal Finalize shape: true/false
     */
    private void drawShape(double x, double y, boolean isFinal) {
        double minSize = settings.getSize();
        if (currentShape instanceof Circle) {
            ((Circle) currentShape).setCenterX(x);
            ((Circle) currentShape).setCenterY(y);
            ((Circle) currentShape).setVisible(true);
            ((Circle) currentShape).setRadius(x - xCoord);
            ((Circle) currentShape).setFill(settings.getColor());
            canvas.getChildren().add((Circle) currentShape);
        } else if (currentShape instanceof Rectangle && settings.getShape() == "Rectangle") {
            ((Rectangle) currentShape).setX(xCoord);
            ((Rectangle) currentShape).setY(yCoord);
            ((Rectangle) currentShape).setWidth(x - xCoord);
            ((Rectangle) currentShape).setHeight(y - yCoord);
            ((Rectangle) currentShape).setFill(settings.getColor());
            ((Rectangle) currentShape).setVisible(true);
            canvas.getChildren().add((Rectangle) currentShape);
        } else if (currentShape instanceof Rectangle && settings.getShape() == "Dot") {
            if (minSize < 2) minSize = 2.0;
            ((Rectangle) currentShape).setWidth(minSize);
            ((Rectangle) currentShape).setHeight(minSize);
            ((Rectangle) currentShape).setX(x);
            ((Rectangle) currentShape).setY(y);
            ((Rectangle) currentShape).setFill(settings.getColor());
            ((Rectangle) currentShape).setVisible(true);
            canvas.getChildren().add((Rectangle) currentShape);
        } else if (currentShape instanceof Line) {
            ((Line) currentShape).setStartX(xCoord);
            ((Line) currentShape).setStartY(yCoord);
            ((Line) currentShape).setEndX(x);
            ((Line) currentShape).setEndY(y);
            ((Line) currentShape).setStroke(settings.getColor());
            if (minSize < 2) minSize = 2.0;
            ((Line) currentShape).setStrokeWidth(minSize);
            ((Line) currentShape).setVisible(true);
            ((Line) currentShape).setFill(settings.getColor());
            canvas.getChildren().add((Line) currentShape);
        }

        if (!isFinal) {
            canvas.getChildren().remove(currentShape);
        }
    }

    /**
     * Saves mousepress starting coordinates.
     *
     * @param x Current x-coord.
     * @param y Current y-coord.
     */
    private void getCoordsXY(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    /**
     * Saves size, shape and color setting.
     */
    private void updateSettings() {
        settings = new Settings();
        settings.setShape(shapeBox.getSelectionModel().getSelectedItem());
        settings.setSize(sizeBox.getSelectionModel().getSelectedIndex());
        settings.setColor(colorBox.getValue());
    }

    /**
     * Fills combobox with sizes.
     *
     * @return
     */
    public ComboBox<String> setAcceptedSizes() {
        ComboBox<String> size = new ComboBox<>();
        for (double i = 0; i < MAX_SIZE; i++) {
            double d = i + 1;
            size.getItems().add(Double.toString(d));
        }
        return size;
    }
}
