package WordScramble;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class HardLevel {
	
	HashMap<String, ArrayList<String>> hashmap = new HashMap<String, ArrayList<String>>();
	Integer foundWords = 0;
	ArrayList<String> guessList = new ArrayList<String>();
	boolean equalLists;
	int score = 0;
	
	public void startHard() {
		
		boolean playing = true;
		int score = 0;
		
		ArrayList<String> dazeList = new ArrayList<String>();
		dazeList.add("daze");
		dazeList.add("a");
		dazeList.add("zad");
		dazeList.add("zade");
	    hashmap.put("zaed", dazeList);
	    
	    ArrayList<String> MississippiList = new ArrayList<String>();
	    MississippiList.add("mississippi");
	    MississippiList.add("i");
	    MississippiList.add("i");
	    MississippiList.add("i");
	    MississippiList.add("i");
	    MississippiList.add("sip");
	    MississippiList.add("sip");
	    MississippiList.add("miss");
	    MississippiList.add("miss");
	    MississippiList.add("piss");
	    MississippiList.add("piss");
	    MississippiList.add("piss");
	    hashmap.put("ispmisipsis", MississippiList);
	    
	    ArrayList<String> HampshireList = new ArrayList<String>();
	    HampshireList.add("hampshire");
	    HampshireList.add("hemp");
	    HampshireList.add("shire");
	    HampshireList.add("i");
	    HampshireList.add("a");
	    HampshireList.add("am");
	    HampshireList.add("amp");
	    HampshireList.add("ship");
	    HampshireList.add("reap");
	    HampshireList.add("heap");
	    HampshireList.add("sheap");
	    HampshireList.add("sham");
	    HampshireList.add("ham");
	    hashmap.put("eharsphmi", HampshireList);
	    
	    ArrayList<String> xavierList = new ArrayList<String>();
	    xavierList.add("xavier");
	    xavierList.add("a");
	    xavierList.add("i");
	    xavierList.add("var");
	    xavierList.add("ex");
	    hashmap.put("avxire", xavierList);
	    
	    ArrayList<String> exorcizeList = new ArrayList<String>();
	    exorcizeList.add("exorcize");
	    exorcizeList.add("ex");
	    exorcizeList.add("i");
	    exorcizeList.add("or");
	    exorcizeList.add("rice");
	    exorcizeList.add("steal");
	    exorcizeList.add("roe");
	    hashmap.put("rezxcoei", exorcizeList);
	    
	    String originalWord = selectRandomWord();
	    
	    ArrayList<String> scoreList = new ArrayList<String>();
	    
	    System.out.println("Your word is: " + originalWord + "\n");
	    System.out.println("Please type in the original word: " + "\n");
	    
	    
		while(playing) {
			String guess = getUserGuess();

			Collections.sort(hashmap.get(originalWord));
		    Collections.sort(guessList);
		    
		    if(hashmap.get(originalWord).equals(guessList)) {
		    	
		    	System.out.println("Congratulations! You found all the words for" + hashmap.get(originalWord) + "\n");
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
	
	public String getScoreboard() {
		
		ArrayList<String> scoreList = new ArrayList<String>();
		String scoreAsString = Integer.toString(score - 1);
		
    	Collections.sort(scoreList);
    	
    	scoreList.add(scoreAsString + " " + Run.user);
    	
    	String scoreboard =  "S C O R E B O A R D" + "\n" + scoreList;
    	
		return scoreboard;
	}
		
	public String getUserGuess() {
		Scanner sn = new Scanner(System.in);
		return sn.nextLine();
	}
	
	public String selectRandomWord() {
		Random r = new Random();
		Object []values = hashmap.values().toArray();
		int listnumber  = r.nextInt(values.length);

		Set<String>keys = hashmap.keySet();
		String[] g = keys.toArray(new String[keys.size()]);
		return g[listnumber];
		
	}
}
