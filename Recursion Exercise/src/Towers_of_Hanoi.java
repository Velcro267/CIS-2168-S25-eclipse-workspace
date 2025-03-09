import java.util.Stack;

public class Towers_of_Hanoi {


	static Stack<Integer> A = new Stack<>();
	static Stack<Integer> B = new Stack<>();
	static Stack<Integer> C = new Stack<>();


	public static void main(String[] args) {
		//Stack<Integer> A = new Stack<>();
		//Stack<Integer> B = new Stack<>();
		//Stack<Integer> C = new Stack<>();
		A.push(3);
		A.push(2);
		A.push(1);
		printStatus();
		move(3, A, C, B);
		
			
	}
	
	public static void move( int n, Stack<Integer> source, Stack<Integer> dest, Stack<Integer> temp) {
		if(n > 0) {
			move(n-1, source, temp, dest);
			dest.push(source.pop());
			printStatus();
			move(n-1, temp, dest, source);
		}
		
		
	}
	
	
	public static void printStatus() {
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
		System.out.println("________");
		
	}
	
}
