
import java.util.*;

public class IndexNode  {

	// The word for this entry
	String word;
	// The number of occurrences for this word
	int occurrences;
	// A list of line numbers for this word.
	List<Integer> list; 
	
	
	
	IndexNode left;
	IndexNode right;
	
	
	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1
	public IndexNode(String word, int lineNum) {
		this.word= word;
		this.occurrences = 1;
		this.list = new ArrayList<>();
		list.add(lineNum);
		}
	
	
	
	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line
	
	public String toString(){
		return "Word: " + this.word + 
				" Number of occurrences: " + this.occurrences +
				" Lines it appears on: " + this.list.toString();
	}
	
	
	
}
