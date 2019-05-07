package cl222ae_assign1;

/**
 * PascalMain.java
 * 
 * Zero-index based Pascal triangle calculator.
 * 
 * @author Christoffer Lundström
 * @date: 29 Jan 2019
 */
public class PascalMain {

	public static void main(String[] args) {
		// print 11 rows
		pascalRow(10);

	}

	public static void printRow(int[] row) {
		for (int i : row) {
			System.out.print(i + " ");
		}
	}
	/**
	 * Takes last row of Pascal and returns next row.
	 *  @param lastRow Last row of Pascal.
	 * */
	public static int[] nextRow(int[] lastRow) {
		// new array
		int[] arr = new int[lastRow.length + 1];

		// first element always 1
		arr[0] = lastRow[0];

		// between first and last element
		for (int i = 0; i < lastRow.length - 1; i++) {

			arr[i + 1] = lastRow[i] + lastRow[i + 1];
		}

		// last number always 1;
		arr[arr.length - 1] = lastRow[lastRow.length - 1];
		printRow(arr);
		System.out.println();
		return arr;
	}
/**
 * @param n Calculate n row of Pascal's Triangle
 * @throws IllegalArgumentException */
	public static int[] pascalRow(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Cannot calculate negative numbers.");
		
		int[] arr = { 1 };

		if (n == 0) {
			printRow(arr);
			System.out.println();
			return arr; // base case
		} else {
			// recursive call
			return nextRow(pascalRow(n - 1));
		}
	}
}
