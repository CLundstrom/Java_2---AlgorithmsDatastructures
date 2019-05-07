package cl222ae_assign1.intCollection;

/**
 * @author Christoffer Lundström 
 * Date: 20/01-2019
 *         Defines functionality for a Stack of type Integer.
 * 
 */

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	private int arrSizeMultiplier = 1;

	/** @param n Adding integer n to top of stack. */
	@Override
	public void push(int n) {
		// Allocate double the size of array elements in the array if needed.
		if (super.size() == super.values.length) {
			arrSizeMultiplier++;
			super.resize();
		}
		values[super.size()] = n;
		super.size++;

	}

	/**
	 * @param n Removing top element of stack.
	 * @return Returns top element.
	 */
	@Override
	public int pop() throws IndexOutOfBoundsException {

		int val = values[super.size() - 1];
		values[super.size() - 1] = 0;
		System.out.println("Removing " + val + " from the stack.");
		super.size--;

		// Reducing array size if need be.
		if (super.size() <= 8 * (arrSizeMultiplier - 1)) {
			int[] tmp = new int[8 * (arrSizeMultiplier - 1)];

			for (int i = 0; i < super.size(); i++) {
				tmp[i] = values[i];
			}
			values = tmp;
		}
		return val;
	}

	/** View top element of stack. */
	@Override
	public int peek() throws IndexOutOfBoundsException {
		return values[super.size() - 1];
	}

}
