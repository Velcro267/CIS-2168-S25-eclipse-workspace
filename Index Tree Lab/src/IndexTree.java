// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IndexTree {

	// This is your root 
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;
	
	// Make your constructor
	// It doesn't need to do anything
	public IndexTree() {
		this.root = null;
	}
	
	// complete the methods below
	
	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method		
	public void add(String word, int lineNumber){
		this.root = add(this.root, word, lineNumber);
		
	}
	
	
	
	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if(root == null) {									//If word not in the tree, then add it
			return new IndexNode(word, lineNumber);
		}
		
		int comparison = word.compareTo(root.word);
		
		if(comparison == 0) {								//If word is already in tree, occurrence goes up
			root.occurrences++;
			return root;
			
		}else if( comparison < 0) {							//Traverse left subtree 
			root.left = add(root.left, word, lineNumber);
			return root;
		} else {											//Traverse right subtree
			root.right = add(root.right, word, lineNumber);
			return root;
		}
		
	}
	
	
	
	
	// returns true if the word is in the index
	public boolean contains(String word){
		return contains(this.root, word);
	}
	
	private boolean contains(IndexNode root, String word) {
		if(root == null) {
			return false;
		}
		
		int comparison = word.compareTo(root.word);
		
		if(comparison == 0) {								//We found the word 
			return true;
			
		} else if(comparison < 0) {							//Traverse left subtree
			return contains(root.left, word);
			
		} else {
			return contains(root.right, word);				//Traverse right subtree
		}
		
	}
	
	
	
	
	// call your recursive method
	// use book as guide
	public void delete(String word){
		this.root = this.delete(this.root, word);
	}
	
	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	private IndexNode delete(IndexNode root, String word){
		if(root == null) {
			return null;
		}
		
		int comparison = word.compareTo(root.word);
		
		if(comparison < 0) {										//Traverse to remove word from left subtree
			root.left = delete(root.left, word);
			return root;
			
		}else if(comparison > 0) {									//Traverse to remove word from right subtree
			root.right = delete(root.right, word);
			return root;
			
		}else {
			if(root.left == null && root.right == null) {			//Word to be removed has no children
				return null;
				
			}else if(root.left != null && root.right ==null) {		//Word to be removed has left child 
				return root.left;
				
			}else if(root.left == null && root.right != null) {		//Word to be removed has right child 
				return root.right;
				
			}else {													//We have to traverse left highest value down left subtree to replace position
				IndexNode current = root.left;
				while(current.right != null) {
					current = current.right;
				}
				root.word = current.word;
				root.left = delete(root.left, root.word);
				return root;
			}
			
		}
	}
	
	
	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	public void printIndex(){
		System.out.println(toString(this.root));
		
	}
	
	
	private String toString(IndexNode root) {
		if(root == null) {
			return "";
		}
		
		StringBuilder bob = new StringBuilder();
		bob.append(toString(root.left));
		bob.append(" ");
		bob.append(root);
		bob.append(" ");
		bob.append(toString(root.right));
		
		return bob.toString();
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		IndexTree index = new IndexTree();
		Scanner scanner = new Scanner(new File("pg100.txt"));
		int lineNumber = 0;
		
		
		while(scanner.hasNextLine()) {						// add all the words to the tree
			String line = scanner.nextLine();
			lineNumber++;
			String[] words = line.split("\\s+");
			for(String word : words) {
				word = word.replaceAll(":", "");
				word = word.replaceAll(",", "");
				word = word.replaceAll(".", "");
				index.add(word, lineNumber);
			}
			
		}
		
		// print out the index
		index.printIndex();
		
		// test removing a word from the index
		index.delete("the");

		
		scanner.close();
	}
}
