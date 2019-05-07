package cl222ae_assign1;

/**
 * PrintRecursive.java
 * 
 * @author Christoffer Lundström
 * @date: 28 Jan 2019
 */
public class PrintRecursive {

	public static void main(String[] args) {

		String str = "Hello Everyone!";

		print(str, 0);
		System.out.println();
		printReverse(str, 0);

	}

	/**
	 *@param text String to print.
	 *@param n Index to print from. */
	public static int print(String text, int n) {

		if (n < 0 || n > text.length()) {
			throw new IllegalArgumentException("Index out of bounds.");
		} else {
			System.out.print(text.charAt(n));

			if (n + 1 == text.length()) // base case
				return 0; // exit recursion

			return print(text, n + 1);
		}
	}

	/**
	 *@param text String to print.
	 *@param n Index to print from. */
	public static int printReverse(String text, int n) {

		if (n < 0 || n > text.length()) {
			throw new IllegalArgumentException("Index out of bounds.");
		} else {
			System.out.print(text.charAt(text.length() - 1 - n));
			if (n + 1 == text.length()) // base case
				return 0; // exit recursion

			return printReverse(text, n + 1);
		}
	}

}
