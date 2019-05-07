package cl222ae_assign2;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Dice.java
 * <p>
 * Provides Toss, saved status and number.
 */
public class Dice {

    private boolean isSaved = false;
    private String diceAddress;

    int diceNr = 0;
    String[] diceNumberArr = {
            "src/cl222ae_assign2/1.png",
            "src/cl222ae_assign2/2.png",
            "src/cl222ae_assign2/3.png",
            "src/cl222ae_assign2/4.png",
            "src/cl222ae_assign2/5.png",
            "src/cl222ae_assign2/6.png"};

    public Dice() {
        getRandomDice();
    }

    /**
     * Tosses a dice.
     *
     * @return Returns a URL to the images to be shown.
     */
    public String getRandomDice() {

        int rand = new Random().nextInt(6);
        this.diceNr = rand + 1;
        this.diceAddress = new File(diceNumberArr[rand]).toURI().toString();

        return this.diceAddress;
    }

    /**
     * @param state Save the dice for next roll.
     */
    public void setSaved(boolean state) {

        this.isSaved = state;
    }

    public boolean isSaved() {
        return this.isSaved;
    }

}
