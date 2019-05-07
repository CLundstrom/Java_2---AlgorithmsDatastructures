package cl222ae_assign3.templeRun;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TempleRunMain extends Application {

    private ImageView imgView;
    private ImageView runner;
    private ArrayList<Image> images = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Temple Run");
        primaryStage.setResizable(false);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(800);


        renderAssets();
        AnchorPane anchor = new AnchorPane();
        anchor.getChildren().addAll(imgView, runner);

        Timeline t = new Timeline();
        t.setAutoReverse(true);

        t.setCycleCount(Timeline.INDEFINITE);

        //t.setRate(0.1); // for testing only
        t.setDelay(Duration.millis(2000)); //delay before character starts running


        // Animations
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(0),
                o -> {
                    runner.setY(315);
                    runner.setX(0);
                    runner.setImage(images.get(0));
                    runner.setScaleX(0.2); // turn around
                },
                new KeyValue(runner.translateXProperty(), 0)
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(150),
                o -> {
                    // makes sure the legs are in sync even if the animation is reversed.
                    if (runner.getScaleX() < 0)
                        runner.setImage(images.get(9));
                    else
                        runner.setImage(images.get(1));
                }
        ));

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(300),
                o -> {
                    if (runner.getScaleX() < 0)
                        runner.setImage(images.get(8));
                    else
                        runner.setImage(images.get(2));
                }
        ));

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(450),
                o -> {
                    if (runner.getScaleX() < 0)
                        runner.setImage(images.get(7));
                    else
                        runner.setImage(images.get(3));
                }
        ));

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(600),
                o -> {
                    if (runner.getScaleX() < 0)
                        runner.setImage(images.get(6));
                    else
                        runner.setImage(images.get(4));
                }
        ));

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(750),
                o -> {
                    runner.setImage(images.get(5));
                }
        ));

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(900),
                o -> {
                    if (runner.getScaleX() < 0)
                        runner.setImage(images.get(4));
                    else
                        runner.setImage(images.get(6));
                }
        ));

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(1050),
                o -> {
                    if (runner.getScaleX() < 0)
                        runner.setImage(images.get(3));
                    else
                        runner.setImage(images.get(7));
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(1200),
                o -> {
                    if (runner.getScaleX() < 0)
                        runner.setImage(images.get(2));
                    else
                        runner.setImage(images.get(8));
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(1350),
                o -> {
                    if (runner.getScaleX() < 0)
                        runner.setImage(images.get(1));
                    else
                        runner.setImage(images.get(9));
                }

        ));

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(1500),
                o -> {
                    runner.setImage(images.get(0));
                    runner.setScaleX(-0.2); // turn around
                },
                new KeyValue(runner.translateXProperty(), 500)

        ));


        t.play();
        Scene scene = new Scene(anchor);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Renders the assets and sets the coordinates to prepare the scene.
     *
     * @throws URISyntaxException
     */
    private void renderAssets() throws URISyntaxException {

        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Run__000.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Run__001.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Run__002.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Run__003.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Run__004.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Run__005.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Run__006.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Run__007.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Run__008.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Run__009.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\Idle__000.png").toUri().toString()));
        images.add(new Image(Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\background1.png").toUri().toString()));


        imgView = new ImageView();
        runner = new ImageView();
        runner.setPreserveRatio(true);
        runner.setX(20); // rescale to fit
        runner.setY(320); // rescale to fit
        runner.scaleXProperty().setValue(0.2);
        runner.scaleYProperty().setValue(0.2);
        imgView.setImage(images.get(11)); // background
        runner.setImage(images.get(10)); // idle runner

        Path mp3 = Paths.get("src\\cl222ae_assign3\\templeRun\\assets\\ff8-julia.mp3");
        Media media = new Media(mp3.toUri().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.1);
        player.play();


    }


}


