import java.io.*;
import java.util.*;

public class ShellSort {

	public static void main(String[] args) {
		Random randy = new Random();
		
		//For Shell Sort
	//n = 64
	    Data info = new Data(0,0);
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i <= 64; i++) {
			list.add(randy.nextInt());
		}	
		//System.out.println("\n Shell Sort: \nBefore: " + list);
		System.out.println("n = 64");
		long startTime = System.nanoTime();
	    shellSort(list, info);
	    long estimatedTime = System.nanoTime() - startTime;
	    //System.out.println("After: " + list);
	    System.out.println(info);
	    System.out.println("Time (ns): " + estimatedTime);
	    
	  //n = 256
	    Data info2 = new Data(0,0);
		List<Integer> list2 = new ArrayList<>();
		for(int i = 0; i <= 256; i++) {
			list2.add(randy.nextInt());
		}	
		//System.out.println("\n Shell Sort: \nBefore: " + list);
		System.out.println("\nn = 256");
		long startTime2 = System.nanoTime();
	    shellSort(list2, info2);
	    long estimatedTime2 = System.nanoTime() - startTime2;
	    //System.out.println("After: " + list);
	    System.out.println(info2);
	    System.out.println("Time (ns): " + estimatedTime2);
	    
	    
	  //n = 500
	    Data info3 = new Data(0,0);
		List<Integer> list3 = new ArrayList<>();
		for(int i = 0; i <= 1000; i++) {
			list3.add(randy.nextInt());
		}	
		//System.out.println("\n Shell Sort: \nBefore: " + list);
		System.out.println("\nn = 1000");
		long startTime3 = System.nanoTime();
	    shellSort(list3, info3);
	    long estimatedTime3 = System.nanoTime() - startTime3;
	    //System.out.println("After: " + list);
	    System.out.println(info3);
	    System.out.println("Time (ns): " + estimatedTime3);
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
