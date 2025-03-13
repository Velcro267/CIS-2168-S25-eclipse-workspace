import java.util.Arrays;

public class Sudoku {

	public static void main(String[] args) {
		int[][] board = {
				{5, 9, 0, 3, 0, 0, 8, 0, 2},
				{1, 8, 0, 0, 0, 2, 9, 5, 3},
				{7, 0, 0, 0, 0, 0, 0, 0, 1},
				{2, 1, 0, 6, 0, 7, 3, 0, 0},
				{6, 0, 0, 5, 4, 0, 1, 0, 0},
				{0, 4, 9, 2, 0, 0, 0, 6, 5},
				{3, 0, 8, 9, 0, 5, 4, 1, 0},
				{0, 5, 1, 0, 6, 4, 2, 0, 0},
				{0, 2, 0, 0, 0, 3, 5, 9, 0}, 
				
		};
		
		if(solveBoard(board, 0, 0)) {
			printBoard(board);
		} else {
			System.out.println("No Solution.");
		}
		
		
	}
	
	
	public static void printBoard(int [][] board) {
		for (int[] row : board){
		    System.out.println(Arrays.toString(row));
		   }
		
	}
	
	
	
	
	public static boolean isValid(int[][] board, int row, int col ) {
		
		
		
		
		
		return true;					//Good to place number 
	}
	
	
	
	
	public static boolean solveBoard(int[][] board, int row, int col ) {
		
		
		
		
		
		
		return false;					//No Valid position found; Backtrack Time 	
	}

	

}
