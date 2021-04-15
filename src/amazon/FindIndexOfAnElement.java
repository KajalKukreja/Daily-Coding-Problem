package amazon;

public class FindIndexOfAnElement {

	public static void main(String[] args) {
		int[] array = {13, 18, 25, 2, 8, 10};
		int n = array.length;
		System.out.println(pivotedBinarySearch(array, n, 8));
		System.out.println(pivotedBinarySearch(array, n, 3));
		System.out.println(pivotedBinarySearch(array, n, 25));
	}

	private static String pivotedBinarySearch(int[] array, int n, int elem) {

		int pivot = findPivot(array, 0, n);

		// If we didn't find a pivot, then array is not rotated at all
		if (pivot == -1)
			return binarySearch(array, 0, n - 1, elem);

		// If we found a pivot, then first compare with pivot and then
		// search in two subarrays around pivot
		if (array[pivot] == elem)
			return String.valueOf(pivot);
		
		if (array[0] <= elem)
			return binarySearch(array, 0, pivot - 1, elem);
		
		return binarySearch(array, pivot + 1, n - 1, elem);
	}

	private static int findPivot(int[] array, int low, int high) {
		if (high < low) {
			return -1;
		}
		if (high == low) {
			return low;
		}		
		int middle = (low + high) / 2;
		
		if (middle < high && array[middle] > array[middle + 1]) {
			return middle;
		}
		if (middle > low && array[middle] < array[middle - 1]) {
			return middle - 1;
		}
		if (array[low] >= array[middle]) {
			return findPivot(array, low, middle - 1);
		}
		return findPivot(array, middle + 1, high);
	}

	private static String binarySearch(int[] array, int low, int high, int elem) {
		if (high < low) {
			return null;
		}
		int middle = (low + high) / 2;
		if (elem == array[middle]) {
			return String.valueOf(middle);
		}
		if (elem < array[middle]) {
			return binarySearch(array, low, middle - 1, elem);
		}
		return binarySearch(array, middle + 1, high, elem);
	}
}
