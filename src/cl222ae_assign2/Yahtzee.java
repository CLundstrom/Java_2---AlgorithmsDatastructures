package cl222ae_assign2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Yahtzee.java
 *
 * @Author: Christoffer Lundström
 * @Date: 15/02/19
 * <p>
 * A simple Yatzy implementation using 5 dices and three rolls.
 */
public class Yahtzee extends Application {

    private HashMap<Integer, Integer> duplicates = new HashMap<>();
    private final int MAX_ROLLS = 3;
    private int nrOfRolls = 0;
    private final int nrOfDices = 5;
    private Group images;
    private Label result;
    private List<Dice> dices = new ArrayList<Dice>();
    private List<ImageView> views = new ArrayList<>();
    private List<CheckBox> boxes = new ArrayList<>();


    /**
     * @param primaryStage Stage object used for setting the first Scene.
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Yahtzee"); // title
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(400);
        BorderPane border = new BorderPane(); // Use border layout
        HBox intro = createHeader(); // header box
        HBox pane = createCheckBoxes(); // checkboxes
        images = createImageGroup(); // group of images
        result = new Label("You have 3 rolls left."); // result box

        Button toss = new Button("Toss dices");


        GridPane body = new GridPane();
        body.setVgap(20);

        body.add(images, 0, 0);
        body.add(pane, 0, 1);
        body.add(toss, 0, 2);
        body.add(result, 0, 3);


        border.setTop(intro);
        border.setCenter(body);

        Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.show();

        toss.setOnAction(e -> {
            nrOfRolls++;

            for (CheckBox b : boxes) {
                b.setDisable(false);
            }

            // don't roll if max exceeded
            if (nrOfRolls <= MAX_ROLLS) {
                rollDices();

                //determine textbox
                if (nrOfRolls == MAX_ROLLS) {
                    result.setText("Result: " + results());
                } else {
                    result.setText("You have " + (MAX_ROLLS - nrOfRolls) + " rolls left.");
                }

            }
        });


    }

    /**
     * @return prints the final results.
     */
    private String results() {
        return calculateScore();
    }


    /**
     * @return String of final results.
     */
    public String calculateScore() {

        String score = "";

        // Value, duplicates 1-6
        for (int i = 1; i <= 6; i++) {
            duplicates.put(i, 0);
        }

        // Gets the values of the dices
        for (int i = 0; i < dices.size(); i++) {

            // DiceNR -> Key -> Add +1 to Value
            int value = duplicates.get(dices.get(i).diceNr);
            value++;

            duplicates.put(dices.get(i).diceNr, value);
        }
        if (duplicates.containsValue(5)) score = "Yahtzee!";
        else if (duplicates.containsValue(4)) score = "Four of a kind!";
        else if (duplicates.containsValue(3)) {
            if (duplicates.containsValue(2)) {
                score = "Full house!";
            } else {
                score = "Three of a kind!";
            }
        } else if (duplicates.get(2).equals(1)
                && duplicates.get(3).equals(1)
                && duplicates.get(4).equals(1)
                && duplicates.get(5).equals(1)
                && duplicates.get(6).equals(1)) {
            score = "Large straight"; // 2 3 4 5 6

        } else if (duplicates.get(1).equals(1)
                && duplicates.get(2).equals(1)
                && duplicates.get(3).equals(1)
                && duplicates.get(4).equals(1)
                && duplicates.get(5).equals(1)) {

            score = "Small straight"; // 1 2 3 4 5
        } else if (duplicates.containsValue(2)) score = "Pair";

        return score;
    }


    /**
     * Sets up the group wherein dices will be shown.
     */
    public Group createImageGroup() {
        createDices();
        rollDices();

        Group group = new Group();

        for (ImageView v : views) {
            group.getChildren().add(v);
        }
        return group;
    }


    /**
     * Sets up ImageViews and adds the tosses the first round of Dices.
     */
    private void createDices() {
        //Add ImageViews
        for (int i = 0; i < nrOfDices; i++) {
            views.add(new ImageView());
        }

        // Add dices to Views
        for (ImageView v : views) {
            Dice d = new Dice();
            Image img = new Image(d.getRandomDice());
            dices.add(d);
            v.setImage(img);
        }
    }

    /**
     * Rolls dices and refreshes those which aren't saved.
     */
    private void rollDices() {
        checkBoxStatus();

        for (int i = 0; i < views.size(); i++) {
            if (dices.get(i).isSaved()) continue;

            Dice d = new Dice();
            dices.set(i, d); //replace object in list
            Image img = new Image(d.getRandomDice());
            views.get(i).setImage(img);
            views.get(i).setX(i * 100);
        }
    }

    /**
     * Gets and sets the status of each Dice.
     */
    private void checkBoxStatus() {
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).isSelected()) {
                dices.get(i).setSaved(true);
            } else {
                dices.get(i).setSaved(false);
            }
        }
    }

    /**
     * Creates the Header layout.
     */
    public HBox createHeader() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 12, 0, 10));
        hbox.setSpacing(10);
        Label header = new Label("Yahtzee");
        header.setAlignment(Pos.CENTER);
        header.setFont(new Font("Calibri", 30));
        hbox.getChildren().addAll(header);
        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }

    /**
     * Creates Checkboxes for every image and returns them in HBox.
     *
     * @return HBox
     */
    public HBox createCheckBoxes() {
        HBox box = new HBox();
        box.setSpacing(80);
        box.setAlignment(Pos.CENTER);

        // Add a checkbox for every image
        for (int i = 0; i < nrOfDices; i++) {
            boxes.add(new CheckBox());
        }

        for (CheckBox b : boxes) {
            b.setDisable(true);
            box.getChildren().add(b);
        }

        return box;
    }

    public static void main(String[] args) {
        launch(args);
    }
}