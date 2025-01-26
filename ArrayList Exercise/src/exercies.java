import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class exercies {

	public static void main(String[] args) {
		//Test Unique method
		List<Integer> x = Arrays.asList(1, 25, 2, 5, 30, 19, 57, 2, 25);
		System.out.println(unique(x));
		
		//Test All Multiples method
		System.out.println(allMultiples(x, 5));
		
		//Test All Strings of Size method
		List<String> y = Arrays.asList("I", "like", "to", "eat", "eat", "eat",""
				+ "apples", "and", "bananas");
		System.out.println(allStringsofSize(y, 3));
		
		//Test Is Permutation method
		List<Integer> perm1 = Arrays.asList(1, 2, 4);
		List<Integer> perm2 = Arrays.asList(2, 1, 4);
		System.out.println(isPermutation(perm1, perm2));
		
		//Test String to List of Words method
		String stuff = "Hello, world!";
		System.out.println(stringToListOfWords(stuff));
		
		//Test Remove All Instances method 
		List<Integer> z = Arrays.asList(1, 4, 5, 6, 5, 5, 2);
		removeAllInstances(z, 5);
		System.out.println(z);


	}

	public static <E> boolean unique(List<E> list){
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size(); j++) {
				if(i != j && list.get(i).equals(list.get(j))) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	public static List<Integer> allMultiples(List<Integer> list, int x){
		List<Integer> output = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) % x == 0) {
				output.add(list.get(i));
			}
		}
		
		return output;
	}
	
	
	
	public static List<String> allStringsofSize(List<String> list, int length){
		List<String> output = new ArrayList<>();
		for(int i = 0; i < list.size();i++) {
			if(list.get(i).length() == length) {
				output.add(list.get(i));
			}
		}
		
		return output;
	}
	
	
	
	public static <E extends Comparable<E>> boolean isPermutation(List<E> A, List<E> B) {
		List<E> sortA = new ArrayList<>();
		List<E> sortB = new ArrayList<>();
		
		sortA.addAll(A);
		sortB.addAll(B);
		
		Collections.sort(sortA);
		Collections.sort(sortB);
		
		
		
		return sortA.equals(sortB);
	}
	
	
	public static List<String> stringToListOfWords(String s){
		List<String> output = new ArrayList<>();
		String[] words = s.split("\\s+");
		
		for(int i = 0; i < words.length; i++) {
			output.add(words[i]);
		}
		
		return output;
	}
	
	
	
	public static <E> void removeAllInstances(List<E> list, E item) {
		while(list.contains(item)) {
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).equals(item)) {
					list.remove(item);
				}
			}
			
		}
		
		
	}
	
	
	
}
