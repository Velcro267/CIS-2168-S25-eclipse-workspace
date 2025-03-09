import java.util.Arrays;

public class recursion {

	public static void main(String[] args) {
		
		int [][] board = new int [8][8];
		
		
		
	

	}
	
	
	
	public static void printBoard(int [][] board) {
		for (int[] row : board){
		    System.out.println(Arrays.toString(row));
		   }
		
	}
	
	
	
	
	
	public static boolean solveBoard(int [][]board, int col) {
		//Base case
		if(col >=8) {
			return true;
		}
		
		
		
		
		
		return false;			// No Valid position found in this column
	}
	
	
	
	
	
	
	public static boolean isVaild() {
		
		
		return true;
	}


}
