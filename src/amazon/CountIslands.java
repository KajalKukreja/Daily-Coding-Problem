package amazon;

public class CountIslands {

	public static void main(String[] args) {
		
		int[][] matrix = { 
							{1, 0, 0, 0, 0},
							{0, 0, 1, 1, 0},
							{0, 1, 1, 0, 0},
							{0, 0, 0, 0, 0},
							{1, 1, 0, 0, 1},
							{1, 1, 0, 0, 1}	
						};
		
		System.out.println(countIslands(matrix));

		int[][] matrix2 = {
							{ 1, 1, 0, 0, 0 },
							{ 0, 1, 0, 0, 1 },
							{ 1, 0, 0, 1, 1 },
							{ 0, 0, 0, 0, 0 },
							{ 1, 0, 1, 0, 1 }
						};
		
		System.out.println(countIslands(matrix2));
	}

	private static int countIslands(int[][] matrix) {
		if (matrix.length == 0) {
			return 0;	
		}
		
		int noOfIslands = 0;
		int totalRows = matrix.length;
		int totalColumns = matrix[0].length;
		boolean[][] visited = new boolean[totalRows][totalColumns];
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == 1 && !visited[row][col]) {
					DFS(matrix, totalRows, totalColumns, row, col, visited);
					noOfIslands++;
				}
			}
		}
		return noOfIslands;
	}

	private static void DFS(int[][] matrix, int totalRows, int totalColumns, int row, int col, boolean[][] visited) {

		// It only considers the 8 neighbors as adjacent vertices
		// These arrays are used to get row and column numbers of 8 neighbors of a given cell
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		// Mark this cell as visited
		visited[row][col] = true;

		// Recur for all connected neighbours
		for (int k = 0; k < 8; k++) {
			if (isSafe(matrix, totalRows, totalColumns, row + rowNbr[k], col + colNbr[k], visited)) {
				DFS(matrix, totalRows, totalColumns, row + rowNbr[k], col + colNbr[k], visited);
			}
		}
	}
	
	private static boolean isSafe(int[][] matrix, int totalRows, int totalColumns, int row, int col, boolean[][] visited) {
		//row number is in range, column number is in range 
        //and value is 1 and not yet visited 
		return 	(row >= 0) && (row < totalRows) && 
				(col >= 0) && (col < totalColumns) && 
				(matrix[row][col] == 1) && !visited[row][col];
	}
}
