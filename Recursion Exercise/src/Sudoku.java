import java.util.Arrays;

public class Sudoku {

	public static void main(String[] args) {
		int[][] board = {
				{5, 9, 0, 3, 0, 0, 8, 7, 2},
				{1, 8, 6, 4, 0, 2, 9, 5, 3},
				{7, 3, 2, 0, 0, 0, 0, 0, 1},
				{2, 1, 0, 6, 0, 7, 3, 0, 0},
				{6, 0, 0, 5, 4, 0, 1, 0, 0},
				{0, 4, 9, 2, 0, 0, 0, 6, 5},
				{3, 6, 8, 9, 0, 5, 4, 1, 0},
				{0, 5, 1, 0, 6, 4, 2, 3, 8},
				{4, 2, 0, 0, 0, 3, 5, 9, 0}, 
				
		};
		
		
		if(solveBoard(board)) {
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
	
	
	
	
	public static boolean isValid(int[][] board, int row, int col, int num ) {
		//Check row
		for(int i = 0; i < 9; i++) {
			if(board[row][i] == num){
				return false;
			}
		}
		
		//Check column 
		for(int i = 0; i < 9; i++) {
			if(board[i][col] == num) {
				return false;
			}
		}
		
		
		//Check 3x3 sub-grid
		int startRow = (row/3) * 3;
		int startCol = (col/3) * 3;
		
		// Loop through the 3x3 sub-grid
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[startRow + i][startCol + j] == num) {
					return false;
				}
			}
		}
		
		
		return true;					//Good to place number 
	}
	
	
	
	
	public static boolean solveBoard(int[][] board) {
		for(int row = 0; row < 9; row++) {
			
			for(int col = 0; col < 9; col++) {
				
				if(board[row][col] == 0) {						//Find an empty slot
					for(int num = 1; num <= 9; num++) {			//Try every number possible
						
						if(isValid(board, row, col, num)) {
							board[row][col] = num;				//Place the number if possible 
							
							if(solveBoard(board)) {				//Recursive Step: try placing next number
								return true;
							}
						}
						board[row][col] = 0;					//Backtrack: couldn't find a valid number 
					}
					return false;
				}
			}
		}
		
		return true;					//Board is completely filled	
	}

	

}
