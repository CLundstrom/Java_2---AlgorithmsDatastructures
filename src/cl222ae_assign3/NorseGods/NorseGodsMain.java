package cl222ae_assign3.NorseGods;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

//import org.json.*; // external lib


/**
 * NorseGodMain.java
 *
 * @Author: Christoffer
 * @Date: 28/02/2019
 *
 * Defines UI behavior.
 */
public class NorseGodsMain extends Application {

    /* I used JSON to load the data but I didnt dare to leave it uncommented
    *  incase you had problems with the library so the gods are hardcoded instead.
    * */
    public static boolean USE_JSON = false;

    private Path path = Paths.get("src/cl222ae_assign3/NorseGods/gods.json");
    private ArrayList<NorseGod> gods = new ArrayList<>();
    private Label name;
    private Label race;
    private TextArea desc;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Norse gods"); // title
        primaryStage.setMinHeight(100);
        primaryStage.setMinWidth(700);
        populateGods();
        BorderPane border = new BorderPane(); // border pane
        HBox header = createHeader();
        ScrollPane sp = new ScrollPane();

        GridPane subHeader = new GridPane();
        subHeader.setGridLinesVisible(false);

        name = new Label("");
        race = new Label("");
        name.setFont(Font.font("Calibri", FontWeight.BOLD, 20));

        desc = new TextArea("");
        desc.setEditable(false); //not editable
        desc.setWrapText(true);
        desc.setPrefRowCount(16);

        subHeader.add(name,0,0);
        subHeader.add(race,0,1);

        AnchorPane anchor = new AnchorPane();
        anchor.setTopAnchor(subHeader, 0.0);
        anchor.setLeftAnchor(subHeader, 0.0);

        anchor.setTopAnchor(desc, 60.0);
        anchor.setLeftAnchor(desc, 25.0);
        anchor.getChildren().addAll(subHeader,desc);

        sp.setContent(anchor);

        ListView<String> names = addToListView();
        names.setPrefWidth(150);

        // Add a listener to a selection
        names.getSelectionModel().selectedIndexProperty().addListener(ov -> updateView(names));
        names.getSelectionModel().selectFirst(); //default selection

        border.setLeft(names);
        border.setTop(header);
        border.setCenter(sp);

        Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Adds the gods to ListView.
     *
     * @return Returns a ListView.
     */
    private ListView<String> addToListView() {
        ListView<String> names = new ListView();
        for (NorseGod god : gods) {
            names.getItems().add(god.getName());
        }
        return names;
    }

    private void updateView(ListView<String> list){

        NorseGod god = gods.get(list.getSelectionModel().getSelectedIndex());
        name.setText(god.getName());
        race.setText(god.getRace());
        desc.setText(god.getDesc());
    }

    /**
     * Creates the Header layout.
     *
     * @return hbox Header box.
     */
    public HBox createHeader() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 12, 0, 10));
        hbox.setSpacing(10);
        Label header = new Label("Norse Gods and other beings");
        header.setAlignment(Pos.TOP_LEFT);
        header.setFont(new Font("Calibri", 30));
        hbox.getChildren().addAll(header);
        return hbox;
    }

    /*public ArrayList<NorseGod> deserializeJson(JSONArray jsonArr) {
        ArrayList<NorseGod> list = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArr.length(); i++) {
                NorseGod god = new NorseGod();
                god.setName(jsonArr.getJSONObject(i).getString("name"));
                god.setRace(jsonArr.getJSONObject(i).getString("race"));
                god.setDesc(jsonArr.getJSONObject(i).getString("desc"));
                list.add(god);
            }
        } catch (JSONException e) {
            USE_JSON = false; // hardcode instead
            gods = null; // reset
            populateGods();
        }

        return list;
    }*/

    /**
     * I/O - Load gods to memory using JSON or hardcoded from .java file.
     */
    public void populateGods() {
        gods = HardcodeGods.getGods();

        /*if (USE_JSON) {
            String text = "";
            try {
                text = new String(Files.readAllBytes(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject obj = new JSONObject(text);
            JSONArray arr = obj.getJSONArray("Gods");
            gods = deserializeJson(arr);
        } else {
        gods = HardcodeGods.getGods();
        }*/
    }

    public static void main(String[] args) {
        launch(args);
    }

}
