package cl222ae_assign1.intCollection;

/**
 * @author Christoffer Lundström 
 * Date: 22/01-2019
 * 
 */

public class CollectionMain {

	public static void main(String[] args) {

		ArrayIntList arr = new ArrayIntList();
		ArrayIntStack stack = new ArrayIntStack();
		System.out.println("ArrayList\n");
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		arr.add(8);
		arr.add(9);
		System.out.println("Index of 5: " + arr.indexOf(5));

		arr.addAt(7, 5);

		arr.remove(7);

		System.out.println(arr.toString());
		System.out.println("\nStack\n");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);

		System.out.println("Top element: " + stack.peek());
		stack.pop();

		System.out.println("Top element: " + stack.peek());
		System.out.println(stack.toString());

	}

}
