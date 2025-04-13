import java.io.*;
import java.util.*;

public class sorting {

	public static void main(String[] args) {
		Random randy = new Random();
		
		//For Insertion Sort
		List<Integer> list1 = new ArrayList<>();
		
		for(int i = 0; i <= 10; i++) {
			list1.add(randy.nextInt(100));
		}	
		System.out.println(" Insertion Sort: \nBefore: " + list1);
		inSort(list1);
		System.out.println("After: " + list1);
		
		
		//For QuickSort
		List<Integer> list2 = new ArrayList<>();
		for(int i = 0; i <= 10; i++) {
			list2.add(randy.nextInt(100));
		}	
		System.out.println("\n QuickSort: \nBefore: " + list2);
		quickSort(list2, 0, list2.size() - 1);
		System.out.println("After: " + list2);

		
		//For Shell Sort
		List<Integer> list3 = new ArrayList<>();
		for(int i = 0; i <= 10; i++) {
			list3.add(randy.nextInt(100));
		}	
		System.out.println("\n Shell Sort: \nBefore: " + list3);
	    shellSort(list3);
	    System.out.println("After: " + list3);

	}
	
	
	
	
	
	//Insertion Sort Algorithm (Modified from textbook)
	public static void inSort(List<Integer> list) {
		for (int nextPos = 1; nextPos < list.size(); nextPos++) {
			insert(list, nextPos);
		}
	}

	private static void insert(List<Integer> list, int nextPos) {
		int nextVal = list.get(nextPos); 
		while (nextPos > 0 && nextVal < list.get(nextPos - 1)) {
			list.set(nextPos, list.get(nextPos - 1)); // shift down
			nextPos--;
		}
		list.set(nextPos, nextVal); // insert value
	}
	
	
	
	
	
	
	//QuickSort Algorithm (Modified from textbook)
	public static void quickSort(List<Integer> list, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(list, begin, end);
            quickSort(list, begin, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, end);
        }
    }

    private static int partition(List<Integer> list, int begin, int end) {
        int pivot = list.get(end);
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (list.get(j) <= pivot) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, end);
        return i + 1;
    }

    private static void swap(List<Integer> list, int i, int j) {
        if (i == j) return;
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
	
	
    
    
    
    //Shell Sort Algorithm (Modified from baeldung.com)
    public static void shellSort(List<Integer> list) {
        int n = list.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = list.get(i);
                int j = i;

                while (j >= gap && list.get(j - gap) > key) {
                    list.set(j, list.get(j - gap));
                    j -= gap;
                }

                list.set(j, key);
            }
        }
    }
	
	
	
	
}
