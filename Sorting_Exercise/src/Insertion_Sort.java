import java.io.*;
import java.util.*;

public class Insertion_Sort {

	public static void main(String[] args) {
		Random randy = new Random();
		
		//For Insertion Sort
		//n = 64
		Data stats = new Data(0,0);
		List<Integer> list1 = new ArrayList<>();
		
		for(int i = 0; i <= 64; i++) {
			list1.add(randy.nextInt());
		}	
		
		//System.out.println(" Insertion Sort: \nBefore: " + list1);
		System.out.println("n = 64");
		long startTime = System.nanoTime();
		inSort(list1, stats);
		long estimatedTime = System.nanoTime() - startTime;
		//System.out.println("After: " + list1);
		System.out.println(stats);
	    System.out.println("Time (ns): " + estimatedTime);
	    
	    
	    
	    //n = 256
	    Data stats2 = new Data(0,0);
	    List<Integer> list2 = new ArrayList<>();
		
		for(int i = 0; i <= 256; i++) {
			list2.add(randy.nextInt());
		}	
		//System.out.println(" Insertion Sort: \nBefore: " + list2);
		System.out.println("\nn = 256");

		long startTime2 = System.nanoTime();
		inSort(list2, stats2);
		long estimatedTime2 = System.nanoTime() - startTime2;
		//System.out.println("After: " + list2);
		System.out.println(stats2);
	    System.out.println("Time (ns): " + estimatedTime2);
	    
	    
	    //n = 500
	    Data stats3 = new Data(0,0);
	    List<Integer> list3 = new ArrayList<>();
	    for(int i = 0; i <= 1000; i++) {
			list3.add(randy.nextInt());
		}	
		//System.out.println(" Insertion Sort: \nBefore: " + list3);
		System.out.println("\nn = 1000");

		long startTime3 = System.nanoTime();
		inSort(list3, stats3);
		long estimatedTime3 = System.nanoTime() - startTime3;
		//System.out.println("After: " + list3);
		System.out.println(stats3);
	    System.out.println("Time (ns): " + estimatedTime3);
	    

	}
	
	
	
	//Insertion Sort Algorithm (Modified from textbook)
		public static void inSort(List<Integer> list, Data stats) {
			for (int nextPos = 1; nextPos < list.size(); nextPos++) {
				insert(list, nextPos, stats);
			}
		}

		private static void insert(List<Integer> list, int nextPos, Data stats) {
			int nextVal = list.get(nextPos); 
			while (nextPos > 0) {
				stats.comparisons++;
				if(nextVal < list.get(nextPos - 1)) {
					list.set(nextPos, list.get(nextPos - 1)); // shift down
					stats.exchanges++;
					nextPos--; 
				}else {
					break;
				}
				
			}
			list.set(nextPos, nextVal); // insert value
			stats.exchanges++;
		}

}
