package cl222ae_assign3.TinyPainter;

import javafx.scene.paint.Color;

public class Settings {
    private double size;
    private Color color;
    private String shape;

    public Settings() {
    }

    public Settings(double size, Color color, String shape){
        this.size = size;
        this.color = color;
        this.shape = shape;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }




}
