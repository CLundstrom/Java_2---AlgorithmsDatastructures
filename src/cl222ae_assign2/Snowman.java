package cl222ae_assign2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * Snowman.java
 *
 * @Author: Christoffer Lundström
 * @Date: 16/02/19
 * <p>
 * Demonstration of JavaFX positioning and groups.
 */
public class Snowman extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 500);
        Rectangle bg = new Rectangle(800, 390, Color.LIGHTSKYBLUE);
        Circle sun = new Circle(700, 100, 60, Color.YELLOW);

        Circle legs = new Circle(400, 350, 60);
        legs.setStrokeWidth(1.0);
        legs.setStroke(null);
        legs.setFill(Color.WHITE);
        Circle body = new Circle(400, 270, 40);
        body.setStrokeWidth(1.0);
        body.setStroke(null);
        body.setFill(Color.WHITE);
        Circle head = new Circle(400, 210, 25);
        head.setStroke(null);
        head.setFill(Color.WHITE);

        Circle button1 = new Circle(400, 250, 4, Color.BLACK);
        Circle button2 = new Circle(400, 270, 4, Color.BLACK);
        Circle button3 = new Circle(400, 290, 4, Color.BLACK);
        Circle eye1 = new Circle(390, 205, 4, Color.BLACK);
        Circle eye2 = new Circle(410, 205, 4, Color.BLACK);
        Polygon mouth = new Polygon();
        mouth.getPoints().addAll(new Double[]{
                390.0, 215.0,
                410.0, 215.0,
                400.0, 220.0

        });
        mouth.setStroke(Color.RED);

        root.getChildren().addAll(bg, sun, legs, body, head, button1, button2, button3, eye1, eye2, mouth);
        primaryStage.setTitle("Snowman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
