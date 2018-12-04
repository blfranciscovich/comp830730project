package comp840project;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class EasyLevel {

	HashMap<String, ArrayList<String>> hashmap = new HashMap<String, ArrayList<String>>();
	Integer foundWords = 0;
	ArrayList<String> guessList = new ArrayList<String>();
	boolean equalLists;

	public void startEasy() {

		//new


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

	    String originalWord = selectRandomWord();
	    String[] wordArray = hashmap.get(originalWord).toArray(new String[hashmap.size()]);
		//new
		//System.out.print(wordArray[0]);

	    ArrayList<String> scoreList = new ArrayList<String>();

	    System.out.println("Your word is: " + originalWord + "\n");
	    System.out.println("Please type in the original word: " + "\n");


		while(playing) {
			String guess = getUserGuess();

			//Collections.sort(originalWord);
			Collections.sort(hashmap.get(originalWord));
		    Collections.sort(guessList);

		    if(hashmap.get(originalWord).equals(guessList)) {

		    	System.out.println("Congratulations! You found all the words for" + hashmap.get("odg") + "\n");
		    	String scoreAsString = Integer.toString(score);
		    	Collections.sort(scoreList);
		    	scoreList.add(scoreAsString + " " + Run.user);
		    	System.out.println("S C O R E B O A R D");
		    	System.out.println(scoreList);
				playing = false;

			} else {

				if(hashmap.get(originalWord).contains(guess) && !guessList.contains(guess)) {

					score = score + 5;
					System.out.println("Please type in the original word: " + "\n");

					foundWords += 1;
					guessList.add(guess);
					System.out.println("Congratulations! You found " + foundWords + " words for: " + originalWord + "." + " Here is your score:" + score + "\n");

					Collections.sort(hashmap.get(originalWord));
				    Collections.sort(guessList);

					if(hashmap.get(originalWord).equals(guessList)) {
						System.out.println("Congratulations! You found all the words for " + originalWord + " " + "\n");
						//System.out.println("Congratulations! You found all the words for " + originalWord + " " + hashmap.get("odg") + "\n");
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

//ALL NEW STUFF
	public String selectRandomWord() {
		Random r = new Random();
		Object []values = hashmap.values().toArray();
		int listnumber  = r.nextInt(values.length);


		//String[] words  = (String[]) values[listnumber];

		//String[] g = (String[]) hashmap.keySet().toArray();
		Set<String>keys = hashmap.keySet();
		String[] g = keys.toArray(new String[keys.size()]);
		return g[listnumber];

		//return words;
	}
}
