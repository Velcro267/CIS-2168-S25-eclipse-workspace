import java.util.Arrays;

public class recursion {

	public static void main(String[] args) {
		//8 Queens Problem  
		int [][] board = new int [8][8];
		
		if(solve8QBoard(board, 0)) {
			printBoard(board);
		} else {
			System.out.println("No Solution.");
		}
		
		
		//Sudoku Problem
		int[][] sudokuBoard = {
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
		
		
		
		
		
	}
	
	
	
	public static void printBoard(int [][] board) {
		for (int[] row : board){
		    System.out.println(Arrays.toString(row));
		   }
		
	}
	
	
	
	
	
	public static boolean solve8QBoard(int [][]board, int col) {
		//Base case: Off the board, or all queens placed 
		if(col >=8) {
			return true;
		}
		
		
		
		for(int row = 0; row < 8; row++) {		//Try placing queen in each row of current column
			if(is8QValid(board, row, col)) {
				board[row][col] = 1;			//Place queen
				
				
				
				if(solve8QBoard(board, col+1)) {	//Recursive Step: try placing next queen 
					return true;
				}
			}
			
			
			board[row][col] = 0;				//Backtrack: placing queen didn't work
			
			
		}
		
		
		
		
		return false;							// No Valid position found in this column
	}
	
	
	
	
	
	
	public static boolean is8QValid(int [][]board, int row, int col) {
		//Check left side of row
		for(int i = 0; i < col; i++) {		
			if(board[row][i] == 1) {
				return false;
			}
		}
		
		//Check upper left diagonal
		for(int i = row, j = col; i>= 0 && j >= 0; i--, j--) {
			if(board[i][j]== 1) {
				return false;
			}
		}
		
		//Check lower left diagonal 
		for(int i = row, j = col; i < 8 && j >= 0; i++, j--) {
			if(board[i][j]== 1) {
				return false;
			}
		}
		
		
		
		return true;			//Good to place a queen
	}


}
