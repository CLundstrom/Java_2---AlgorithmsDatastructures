package cl222ae_assign1.intCollection;

/**
 * @author Christoffer Lundström 
 * Date: 20/01-2019
 *         Defines functionality for a List of type Integer.
 * 
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {

	/** 
	 * Allocates double the size of array elements in the array if needed.
	 * 
	 * @param n Adding n to the end of the list. */
	@Override
	public void add(int n) {

		
		if (super.size() == super.values.length) {
			super.resize();
		}
		super.values[super.size] = n;
		super.size++;
	}

	/**
	 * Values to the right of index will be reindexed.
	 * 
	 * @param n     Adding integer to list.
	 * @param index Index where n is added.
	 */
	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		System.out.println("Adding value " + n + " to index " + index);
		int amount = 0;
		for (int i = index; i < super.size(); i++) {
			amount++;
		}

		// Allocate temporary array.
		int[] placeHolder = new int[amount];

		// Add elements right of index to placeholder
		for (int i = 0; i < amount; i++) {
			placeHolder[i] = super.values[index + i];
		}

		super.values[index] = n;

		// Merge placeHolder with array.
		for (int i = 0; i < placeHolder.length; i++) {

			super.values[index + 1 + i] = placeHolder[i];
		}
		super.size++;
	}

	/**
	 * Removes value and resizes array if need be.
	 * 
	 * @param index Remove value at index.
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		System.out.println("Removing index " + index + " which contains value: " + super.values[index]);

		int[] placeHolder = new int[super.size - 1];

		int offset = 0;

		for (int i = 0; i < placeHolder.length; i++) {

			if (index == i) {
				placeHolder[i] = super.values[i + 1];
				offset++;
			}

			else {
				placeHolder[i] = super.values[i + offset];
			}
		}
		super.values = placeHolder;
		super.size--;
	}

	/** @return Returns value at index. */
	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		return super.values[index];
	}

	/** @param n Finds the index of integer n.
	 *  @return Default return -1 if no match. */
	@Override
	public int indexOf(int n) {

		for (int i = 0; i < super.size(); i++) {

			if (super.values[i] == n) {

				return i;
			}
		}

		return -1;
	}

}
