import java.io.*;
import java.util.*;

public class sorting {

	public static void main(String[] args) {
		Random randy = new Random();
		
		//For Insertion Sort
		Data stats = new Data(0,0);
		List<Integer> list1 = new ArrayList<>();
		
		for(int i = 0; i <= 10; i++) {
			list1.add(randy.nextInt(100));
		}	
		
		System.out.println(" Insertion Sort: \nBefore: " + list1);
		long startTime = System.nanoTime();
		inSort(list1, stats);
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("After: " + list1);
		System.out.println("Comparisons: " + stats.comparisons);
	    System.out.println("Exchanges: " + stats.exchanges);
	    System.out.println("Time (ns): " + estimatedTime);
		
		
		//For QuickSort
	    Data data = new Data(0,0);
		List<Integer> list2 = new ArrayList<>();
		for(int i = 0; i <= 10; i++) {
			list2.add(randy.nextInt(100));
		}	
		System.out.println("\n QuickSort: \nBefore: " + list2);
		long startTime1 = System.nanoTime();
		quickSort(list2, 0, list2.size() - 1, data);
		long estimatedTime1 = System.nanoTime() - startTime1;
		System.out.println("After: " + list2);
		System.out.println("Comparisons: " + data.comparisons);
	    System.out.println("Exchanges: " + data.exchanges);
	    System.out.println("Time (ns): " + estimatedTime1);

		
		//For Shell Sort
	    Data info = new Data(0,0);
		List<Integer> list3 = new ArrayList<>();
		for(int i = 0; i <= 10; i++) {
			list3.add(randy.nextInt(100));
		}	
		System.out.println("\n Shell Sort: \nBefore: " + list3);
		long startTime2 = System.nanoTime();
	    shellSort(list3, info);
	    long estimatedTime2 = System.nanoTime() - startTime2;
	    System.out.println("After: " + list3);
	    System.out.println("Comparisons: " + info.comparisons);
	    System.out.println("Exchanges: " + info.exchanges);
	    System.out.println("Time (ns): " + estimatedTime2);

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
	
	
    
    
    
    //Shell Sort Algorithm (Modified from baeldung.com)
    public static void shellSort(List<Integer> list, Data info) {
        int n = list.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = list.get(i);
                info.exchanges++; 				//for getting key (idk if this is necessary)
                int j = i;

                while (j >= gap) {
                	info.comparisons++;			//for while condition
                	if(list.get(j - gap) > key) {
                		 list.set(j, list.get(j - gap));
                         info.exchanges++;
                         j -= gap;
                	} else {
                		break;
                	}
            
                }

                list.set(j, key);
                info.exchanges++;
            }
        }
    }
	
	
	
	
}
