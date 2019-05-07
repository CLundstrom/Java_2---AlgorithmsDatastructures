package cl222ae_assign4.time;

import java.util.Comparator;
import java.util.Random;

/**
 * ConcatMain.java
 *
 * @Author: Christoffer
 * @Date: 05/03/2019
 * Implementation of all the tests run in the exercise.<br>
 * Testing:
 * * Speed of Concatenation of strings using Stringbuilder and +-operator.
 * * Speed of Merge Sort and Insertion Sort.<br>
 *<p>
 * NOTE: THE AMOUNTS SET IN THIS FILE MAY NOT BE WORKING FOR ALL COMPUTERS RUNNING THESE TESTS.
 * JAVA HEAP SIZE AND TEST-TIME MAY DIFFER ACROSS DIFFERENT MACHINES.
 *<p>
 * USE AMOUNTS FIT FOR YOUR MACHINE
 */
public class ConcatMain {

    private static final int amount = 20000000;
    private static String longStr = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"; //80
    private static String shortStr = "x";
    private static long length = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        sb.ensureCapacity(Integer.MAX_VALUE-2);
        int[] insertSort = randIntArr(30000);
        int[] mergeSort = randIntArr(1000000);

        Comparator<String> comp = Comparator.naturalOrder();

        String[] strInsertSort = randStringArr(12000);
        String[] strMergeSort = randStringArr(2500000);

        StringBuilder warmup = new StringBuilder();

        // Turns out warmup slows down concat and append ALOT ALSO CAS
        // WARMUP ///////////////////
        /*for (int i = 0; i < 20; i++) {
            longStr = longStr + longStr;
            warmup.append(longStr);
        }*/
        /////////////////////////////

        // The different methods to be tested. Uncomment for testing one or many of them.

        //##### CONCATS AND APPENDS ######
        //measureAverageFuncTime(() -> testConcat(longStr, amount));
        //measureAverageFuncTime(() -> testConcat(shortStr, amount));
        measureAverageFuncTime(() -> testAppend(longStr, amount));
        //measureAverageFuncTime(() -> testAppend(shortStr, amount));


        //###### SORTING ALGORITHMS #######
        //measureAverageFuncTime(() -> SortingAlgorithms.insertionSort(insertSort));
        //measureAverageFuncTime(() -> SortingAlgorithms.mergeSort(mergeSort));
        //measureAverageFuncTime(()-> SortingAlgorithms.insertionSort(strInsertSort, comp));
        //measureAverageFuncTime(()-> SortingAlgorithms.mergeSort(strMergeSort, comp));

    }

    private static int[] randIntArr(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for(int i=0; i< size; i++){

            arr[i] = rand.nextInt(size*75);

        }
        return arr;
    }

    private static String[] randStringArr(int size) {
        Random rand = new Random();
        String[] arr = new String[size];
        for(int i=0; i< size; i++){
            String str = "";
            for(int j=0; j < 10; j++){
                str = str+(char)(rand.nextInt(26) + 'a'); // generate random char a-z
            }
            arr[i] = str;
        }
        return arr;
    }


    public static long measureAverageFuncTime(Runnable func){
        long tmp = 0;
        length = 0;
        Runtime r = Runtime.getRuntime();
        r.gc();
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1; i++){
            func.run();
        }
        tmp = System.currentTimeMillis()-start;
        System.out.println("Average Time: " + tmp/1 + " ms");
        return tmp;
    }


    public static void testConcat(String str, int amount){
        String con = "";
        for (int i = 0; i < amount; i++) {
            con += str;
        }
    }

    public static void testAppend(String str, int amount) {
            sb.append(str);
            for (int i = 0; i < amount; i++) {
                sb.append(longStr);
            }
            sb.toString();
    }
}

