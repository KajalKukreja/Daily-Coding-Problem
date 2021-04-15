package amazon;

public class MaxSumOfContiguousSubarray {

	public static void main(String[] args) {
		int[] array = {34, -50, 42, 14, -5, 86};
		System.out.println(maxSum(array));
		
		int[] array2 = {-5, -1, -8, -9};
		System.out.println(maxSum(array2));
	}

	private static int maxSum(int[] array) {
		int maxSum = 0;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			maxSum = Math.max(maxSum, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}
}
