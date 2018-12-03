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
		boolean playing = true;
		int score = 0;

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

	    ArrayList<String> scoreList = new ArrayList<String>();

	    System.out.println("Your word is: " + originalWord + "\n");
	    System.out.println("Please type in the original word: " + "\n");


		while(playing) {
			String guess = getUserGuess();

			Collections.sort(dogList);
		    Collections.sort(guessList);

		    if(dogList.equals(guessList)) {

		    	System.out.println("Congratulations! You found all the words for" + hashmap.get("odg") + "\n");
		    	String scoreAsString = Integer.toString(score);
		    	Collections.sort(scoreList);
		    	scoreList.add(scoreAsString + " " + Run.user);
		    	System.out.println("S C O R E B O A R D");
		    	System.out.println(scoreList);
				playing = false;

			} else {

				if(dogList.contains(guess) && !guessList.contains(guess)) {

					score = score + 5;
					System.out.println("Please type in the original word: " + "\n");

					foundWords += 1;
					guessList.add(guess);
					System.out.println("Congratulations! You found " + foundWords + " words for: " + originalWord + "." + " Here is your score:" + score + "\n");

					Collections.sort(dogList);
				    Collections.sort(guessList);

					if(dogList.equals(guessList)) {
						System.out.println("Congratulations! You found all the words for " + originalWord + " " + hashmap.get("odg") + "\n");
						playing = false;
					}

				}else {
					if (score < 0 || score == 0) {
						score = 0;
						System.out.println("Sorry, try again." + " Here is your score:" + score);
					}
					if (score > 0) {
						score = score - 1;
						System.out.println("Sorry, try again." + " Here is your score:" + score);
					}
				}
			}
		}
	}

	public String getUserGuess() {
		Scanner sn = new Scanner(System.in);
		return sn.nextLine();
	}

	public String selectRandomWord() {
		Random r = new Random();

		int rPos = ThreadLocalRandom.current().nextInt(0, EASY_WORD_DATABASE.length);
		return EASY_WORD_DATABASE[rPos];
	}
}
