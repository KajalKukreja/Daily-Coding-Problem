package amazon;

import java.util.Scanner;

public class MatrixInClockwiseSpiral {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int cols = scanner.nextInt();
		int[][] matrix = new int[rows][cols];
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				matrix[row][col] = scanner.nextInt();
			}
		}
		
		printSpiral(rows, cols, matrix, 0, 0);
		scanner.close();
	}
	
	private static void printSpiral(int rows, int cols, int[][] matrix, int rowCount, int colCount) {
		
		if (rowCount >= rows || colCount >= cols) {
			return;
		}
		
		//left
		for (int col = colCount; col < cols; col++) {
			System.out.println(matrix[colCount][col]);
		}
		
		//down
		for (int row = colCount+1; row < rows; row++) {
			System.out.println(matrix[row][cols-1]);
		}
		
		//right
		if (rows-1 != rowCount) {
			for (int col = cols-2; col >= colCount; col--) {
				System.out.println(matrix[rows-1][col]);
			}
		}
		
		//up
		if (cols-1 != colCount) {
			for (int row = rows-2; row > rowCount; row--) {
				System.out.println(matrix[row][colCount]);
			}
		}
		printSpiral(rows-1, cols-1, matrix, rowCount+1, colCount+1);
	}
}
