package cl222ae_assign3;
/**
 * EuclidianMain.java
 *
 * @Author: Christoffer
 * @Date: 25/02/2019
 */
public class EuclidianMain {

    public static void main(String[] args) {
        System.out.println(GCD(18, 12));
        System.out.println(GCD(42, 56));
        System.out.println(GCD(9, 28));
        System.out.println(GCD(12, 18));
        System.out.println(GCD(12, 0));
    }

    public static int GCD(int m, int n) {
        // if 0 return n
        return n == 0 ? m : GCD(n, m % n);


    }

}
