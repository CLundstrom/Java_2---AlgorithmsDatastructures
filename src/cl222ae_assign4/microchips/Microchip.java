package cl222ae_assign4.microchips;

/**
 * Microchip.java
 *
 * @Author: Christoffer
 * @Date: 20/03/2019
 * <p>
 *
 * Representation of a Microchip object.
 * Each object has a x and y coordinate and a status which is either 0 or 1 which represents FAIL and OK.
 */
public class Microchip {

    private int status;
    private double x;
    private double y;


    public Microchip(double x, double y, int status) {

        this.x = x;
        this.y = y;
        this.status = status;
    }

    public Microchip(double x, double y) {

        this.x = x;
        this.y = y;
    }

    Double getX() {
        return this.x;
    }

    Double getY() {
        return this.y;
    }

    int getStatus() {
        return this.status;
    }

    @Override
    public String toString() {

        String fail = this.status == 0 ? "FAIL" : "OK";

        return String.format("%s [%.3f, %.3f]", fail, this.x, this.y);
    }

}
