
public class CompareIntegersWithoutOperator {

	static boolean isEqual(int x, int y) {
		/**
		 * Write a function that determines whether two integers are equal
		 * without using any comparative operatiors.
		 */
		boolean result = true;

		// method 1: compare strings
		result = String.valueOf(x).equals(String.valueOf(y));

		// method 2: compare Integers
		result = ((Integer) x).equals((Integer) y);

		return result;
	}

	public static void main(String[] args) {
		int x = 5;
		int y = 6;
		System.out.println("5 and 6: " + isEqual(x, y));
	}

}
