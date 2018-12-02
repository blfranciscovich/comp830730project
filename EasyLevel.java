package comp840project;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class EasyLevel {

	HashMap<String, ArrayList<String>> hashmap = new HashMap<String, ArrayList<String>>();
	Integer foundWords = 0;
	ArrayList<String> guessList = new ArrayList<String>();
	boolean equalLists;


	private static String[] EASY_WORD_DATABASE = new String[]
			{ "odg"};

	public void startEasy() {
		String originalWord = selectRandomWord();
		String shuffled = getShuffledWord(originalWord);
		boolean playing = true;

		ArrayList<String> dogList = new ArrayList<String>();
		dogList.add("dog");
		dogList.add("go");
		dogList.add("do");
		dogList.add("god");
	    hashmap.put("odg", dogList);

	    ArrayList<String> catList = new ArrayList<String>();
	    catList.add("cat");
	    catList.add("act");
	    catList.add("at");
	    catList.add("a");
	    catList.add("tac");
	    hashmap.put("atc", catList);

	    System.out.println("Your word is: " + originalWord + "\n");
	    System.out.println("Please type in the original word: " + "\n");


		while(playing) {
			//System.out.println("Your word is: " + hashmap.get("odg") + "\n");
			String guess = getUserGuess();

			Collections.sort(dogList);
		    Collections.sort(guessList);

		    if(dogList.equals(guessList)) {

		    	System.out.println("Congratulations! You found all the words for" + hashmap.get("odg") + "\n");
				playing = false;

			} else if (!dogList.equals(guessList)) {

				if(dogList.contains(guess)) {


					System.out.println("Please type in the original word: " + "\n");

					foundWords += 1;
					guessList.add(guess);
					System.out.println("Congratulations! You found " + foundWords + " words for: " + originalWord + "\n");
				}else {
					System.out.println("Sorry, try again");
				}

			} else {
				System.out.println("An error occured");
			}

		}
	}


	public String getUserGuess() {
		Scanner sn = new Scanner(System.in);
		//System.out.println("Please type in the original word: " + "\n");
		return sn.nextLine();
	}

	public String selectRandomWord() {
		Random r = new Random();

		int rPos = ThreadLocalRandom.current().nextInt(0, EASY_WORD_DATABASE.length);
		return EASY_WORD_DATABASE[rPos];
	}

	public String getShuffledWord(String originalWord) {
		String shuffledWord = originalWord;
		int wordSize = originalWord.length();
		int shuffleCount = 10;

		for(int i=0;i<shuffleCount;i++) {
			int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
			int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);

			shuffledWord = swapCharacters(shuffledWord,position1,position2);
		}
		return shuffledWord;
	}

	private String swapCharacters(String shuffledWord, int position1, int position2) {
		char[] charArray = shuffledWord.toCharArray();
		char temp = charArray[position1];
		charArray[position1] = charArray[position2];
		charArray[position2] = temp;

		return new String(charArray);
	}

}
