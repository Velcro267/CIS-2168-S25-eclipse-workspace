import java.util.*;
import java.io.*;

public class Hangman_ {

    // Groups words together by length --> Done
    private static Map<Integer, List<String>> groupWords() {
        Map<Integer, List<String>> out = new HashMap<>();
        try {
            Scanner wordFile = new Scanner(new File("temple_code/cis2168/HashMap/words.txt"));
            while (wordFile.hasNext()) {
                String word = wordFile.next().toLowerCase();
                if (!out.containsKey(word.length()))
                    out.put(word.length(), new LinkedList<>());
                out.get(word.length()).add(word);
            }
            wordFile.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found"); 
        }
        return out;
    }

    // Gets the words that are a certain length --> Done
    public static List<String> getPossibleWords(int wordLen) {
        Map<Integer, List<String>> wordMap = groupWords();
        return wordMap.getOrDefault(wordLen, null);
    }

    public static String getBestFamily(Map<String, List<String>> wordFamily,/*Set<Character> guessedLetters*/ char guess, List<String> possibleWords, String boardState) {
        String bestFamily = boardState;
        for (String word: possibleWords) {
            String newState = boardState;
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) == guess && boardState.charAt(i) == '_') {
                    newState = newState.substring(0, i) + word.charAt(i) + newState.substring(i + 1);
                }
            }
            if (!wordFamily.containsKey(newState))
                wordFamily.put(newState, new LinkedList<>());

            wordFamily.get(newState).add(word);
            bestFamily = wordFamily.get(newState).size() > wordFamily.getOrDefault(bestFamily, new LinkedList<>()).size()? newState: bestFamily;
        }
        return bestFamily;
    }
    
    public static void play(Scanner in, int numAttempts, List<String> wordList) {
        String curState = "";

        for (int i = 0; i < wordList.get(0).length(); ++i)
            curState += "_";

        Set<Character> guessedLetters = new HashSet<>();

        char guess;
        while (numAttempts > 0 && (!curState.equals(wordList.get(0)) || wordList.size() > 1)) { // while attempts remain and words still available or not fully solved

            Map<String, List<String>> map = new HashMap<>(); // remaking the map keeps all groupings disjoint (because LLs are used)
            System.out.println("Current: " + curState); // prints current state

            System.out.print("Used letters: "); // prints exhausted letters
            for (char ltr: guessedLetters)
                if (curState.indexOf(ltr) == -1)
                    System.out.print(ltr);
            System.out.println();

            do { // takes in a valid (unused) guess
                System.out.println("Enter a guess");
                guess = in.nextLine().charAt(0);
            } while (guessedLetters.contains(guess));
            guessedLetters.add(guess);

            String newState = getBestFamily(map, guess, wordList, curState); // returns key to the largest group of words

            if (curState.equals(newState))
                System.out.println("Wrong Guess...\n");
            else
                System.out.println(guess + " was correct");

            curState = newState; // updates board state
            wordList = map.get(curState); // updates possible words after each guess

            System.out.println("Potential words: " + wordList); // debugging

            
            if (numAttempts == 1) { // offers an extension to user once all attempts are exhausted
                System.out.println("Ran out of attempts. Would you like to continue?");
                if (in.nextLine().charAt(0) == 'y') {
                    System.out.println("5 more tries added");
                    numAttempts += 6; // after decrement have 5 remaining attempts
                }
            }
            numAttempts--;
        }
        System.out.println(wordList.get(0).equals(curState)? "Congrats. You win": "Ran out of attempts. Word was: " + wordList.get(0));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isPlaying = true;
        while (isPlaying) {
            List<String> possibleWords = null;

            // ensures words exist before beginning
            int wordLen = -1;
            while ((possibleWords = getPossibleWords(wordLen)) == null) {
                System.out.println("How long of a word will you be guessing?");
                wordLen = in.nextInt();
            }

            int numAttempts;
            do
                System.out.println("How many attempts do you want to make?");
            while ((numAttempts = in.nextInt()) < 0);

            in.nextLine(); // clears input

            play(in, numAttempts, possibleWords);
            
            String response;
            do {
                System.out.println("Continue Playing? (y/n)");
                response = in.nextLine();
                if (response.equals("n"))
                    isPlaying = false;
            } while (!response.equals("y") && !response.equals("n"));
            
        }
        in.close();
    }
}