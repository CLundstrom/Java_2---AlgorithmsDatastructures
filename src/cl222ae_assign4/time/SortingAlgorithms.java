package cl222ae_assign4.time;

import java.util.Comparator;

/**
 * SortingAlgorithms.java
 *
 * @Author: Christoffer
 * @Date: 01/03/2019
 * <p>
 * Implementations of Merge sort and insertion sort.
 * Are used for the time measurement assignment.
 * <br>
 * Implementations include both Integer and String overloads.
 * <br>
 */
public class SortingAlgorithms {


    public static void main(String[] args) {

        Comparator<String> strNaturalOrder = Comparator.naturalOrder();
        Comparator<String> strReversed = Comparator.reverseOrder();

        String[] strTest = {"A", "g", "c", "f"};
        int[] test = {9, 8, 7, 7, 6, 5, 4, 3, 2, 1};


        printArray(mergeSort(test));
        printArray(insertionSort(test));
        printArray(insertionSort(strTest, strNaturalOrder));
        printArray(insertionSort(strTest, strReversed));
        printArray(mergeSort(strTest, strNaturalOrder));
        printArray(mergeSort(strTest, strReversed));

    }

    /**
     * Prints String and Int arrays.
     *
     * @param arr Integer[] or String[].
     */
    private static void printArray(Object arr) {
        if (arr instanceof int[]) {
            for (int i = 0; i < ((int[]) arr).length; i++) {
                System.out.print(((int[]) arr)[i] + " ");
            }
        }
        if (arr instanceof String[]) {
            for (int i = 0; i < ((String[]) arr).length; i++) {
                System.out.print(((String[]) arr)[i] + " ");
            }
        }
        System.out.println();
    }

    /**
     * Simple insertion sort.
     *
     * @param in Array to sort.
     * @return Returns sorted array.
     */
    public static int[] insertionSort(int[] in) {

        int[] sort = in.clone();

        for (int i = 0; i < sort.length - 1; i++) {
            for (int j = 0; j < sort.length - 1; j++) {
                // Right less than left? Swap places.
                if (sort[j + 1] < sort[j]) {
                    int tmp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = tmp;
                }
            }
        }
        return sort;
    }

    /**
     * Horstmann's Approach to Mergesort.
     *
     * @param in Array to sort.
     * @return Sorted Array.
     */
    public static int[] sort(int[] in) {
        if (in.length <= 1) return in;

        int[] first = new int[in.length / 2];
        int[] second = new int[in.length - first.length];


        for (int i = 0; i < first.length; i++) {
            first[i] = in[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = in[first.length + i];
        }

        // recursive division of arrays
        sort(first);
        sort(second);
        merge(first, second, in);

        return in;
    }

    public static int[] mergeSort(int[] in) {
        //separate arrays before starting recursion.
        int[] tmp = in.clone();
        sort(tmp);

        return tmp;
    }

    /**
     * Helper function for mergeSort.
     *
     * @param first    Merge origin.
     * @param second   Merge origin.
     * @param mergeArr Merge target.
     * @return Merged target.
     */
    private static int[] merge(int[] first, int[] second, int[] mergeArr) {
        int firstElement = 0; //element in first array
        int secondElement = 0; // element in second array
        int index = 0; // next position

        while (firstElement < first.length && secondElement < second.length) {

            if (first[firstElement] < second[secondElement]) {
                mergeArr[index] = first[firstElement];
                firstElement++;
            } else {
                mergeArr[index] = second[secondElement];
                secondElement++;
            }
            index++;

        }

        while (firstElement < first.length) {

            mergeArr[index] = first[firstElement];
            firstElement++;
            index++;
        }

        while (secondElement < second.length) {

            mergeArr[index] = second[secondElement];
            secondElement++;
            index++;
        }
        return mergeArr;
    }

    /**
     * Insertion sorter for String arrays.
     * <p>
     *
     * @param in String-array.
     * @param c  Comparator.
     * @return Returns sorted string-array.
     */
    public static String[] insertionSort(String[] in, Comparator<String> c) {

        String[] sort = in.clone();

        for (int i = 0; i < sort.length - 1; i++) {
            for (int j = 0; j < sort.length - 1; j++) {
                // Right less than left? Swap places.
                if (c.compare(sort[j + 1], sort[j]) <= 0) {
                    String tmp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = tmp;

                }
            }
        }
        return sort;
    }

    /**
     * Horstmanns example modified to work with Comparator.
     * <p>
     *
     * @param in Array to sort.
     * @param c  Comparator.
     * @return Returns sorted String-array.
     */
    public static String[] mergeSort(String[] in, Comparator<String> c) {
        // separate arrays before starting recursion.
        String[] tmp = in.clone();
        sort(tmp, c);

        return tmp;
    }


    /**
     * Helper-function for mergeSort.
     * <p>
     * @param in Array to sort.
     * @param c  Comparator.
     * @return Returns sorted String-array.
     */
    public static String[] sort(String[] in, Comparator<String> c) {

        if (in.length <= 1) return in;
        String[] first = new String[in.length / 2];
        String[] second = new String[in.length - first.length];


        for (int i = 0; i < first.length; i++) {
            first[i] = in[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = in[first.length + i];
        }

        // recursive division of arrays
        sort(first, c);
        sort(second, c);
        merge(first, second, in, c);
        return in;
    }


    /**
     * Helper-function for sort.
     * <p>
     * @param first    First array.
     * @param second   Second array.
     * @param mergeArr Array to merge to.
     * @param c        Comparator.
     * @return
     */
    private static String[] merge(String[] first, String[] second, String[] mergeArr, Comparator<String> c) {
        int firstElement = 0; //element in first array
        int secondElement = 0; // element in second array
        int index = 0; // next position

        while (firstElement < first.length && secondElement < second.length) {

            if (c.compare(first[firstElement], second[secondElement]) < 0) {
                mergeArr[index] = first[firstElement];
                firstElement++;
            } else {
                mergeArr[index] = second[secondElement];
                secondElement++;
            }
            index++;

        }
        while (firstElement < first.length) {

            mergeArr[index] = first[firstElement];
            firstElement++;
            index++;
        }
        while (secondElement < second.length) {

            mergeArr[index] = second[secondElement];
            secondElement++;
            index++;
        }
        return mergeArr;
    }

}
