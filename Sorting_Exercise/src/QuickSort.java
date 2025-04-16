import java.io.*;
import java.util.*;

public class QuickSort {

	public static void main(String[] args) {
		Random randy = new Random();
		
		//For QuickSort
		//n = 64
	    Data data = new Data(0,0);
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i <= 64; i++) {
			list.add(randy.nextInt());
		}	
		//System.out.println("\n QuickSort: \nBefore: " + list);
		System.out.println("n = 64");

		long startTime = System.nanoTime();
		quickSort(list, 0, list.size() - 1, data);
		long estimatedTime = System.nanoTime() - startTime;
		//System.out.println("After: " + list);
		System.out.println(data);
	    System.out.println("Time (ns): " + estimatedTime);
	    
	    //n = 256
	    Data data2 = new Data(0,0);
		List<Integer> list2 = new ArrayList<>();
		for(int i = 0; i <= 256; i++) {
			list2.add(randy.nextInt());
		}	
		//System.out.println("\n QuickSort: \nBefore: " + list);
		System.out.println("\nn = 256");

		long startTime2 = System.nanoTime();
		quickSort(list2, 0, list2.size() - 1, data2);
		long estimatedTime2 = System.nanoTime() - startTime2;
		//System.out.println("After: " + list);
		System.out.println(data2);
	    System.out.println("Time (ns): " + estimatedTime2);
	    
	    
	    //n = 500
	    Data data3 = new Data(0,0);
		List<Integer> list3 = new ArrayList<>();
		for(int i = 0; i <= 1000; i++) {
			list3.add(randy.nextInt());
		}	
		//System.out.println("\n QuickSort: \nBefore: " + list);
		System.out.println("\nn = 1000");

		long startTime3 = System.nanoTime();
		quickSort(list3, 0, list3.size() - 1, data3);
		long estimatedTime3 = System.nanoTime() - startTime3;
		//System.out.println("After: " + list);
		System.out.println(data3);
	    System.out.println("Time (ns): " + estimatedTime3);

	}
	
	
	//QuickSort Algorithm (Modified from textbook)
		public static void quickSort(List<Integer> list, int begin, int end, Data data) {
			data.comparisons++;
	        if (begin < end) {
	            int partitionIndex = partition(list, begin, end, data);
	            quickSort(list, begin, partitionIndex - 1, data);
	            quickSort(list, partitionIndex + 1, end, data);
	        }
	    }

	    private static int partition(List<Integer> list, int begin, int end, Data data) {
	        int pivot = list.get(end);
	        data.exchanges++; 				//for copying pivot
	        int i = begin - 1;

	        for (int j = begin; j < end; j++) {
	        	data.comparisons++; 		//for the following if statement 
	            if (list.get(j) <= pivot) {
	                i++;
	                swap(list, i, j, data);
	            }
	        }

	        swap(list, i + 1, end, data);
	        return i + 1;
	    }

	    private static void swap(List<Integer> list, int i, int j, Data data) {
	        if (i == j) return;
	        int temp = list.get(i);
	        list.set(i, list.get(j));
	        list.set(j, temp);
	        data.exchanges+= 3; 			//for 3 swaps 
	    }

}
