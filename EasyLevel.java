package WordScramble;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class EasyLevel {
	
	HashMap<String, ArrayList<String>> hashmap = new HashMap<String, ArrayList<String>>();
	Integer foundWords = 0;
	ArrayList<String> guessList = new ArrayList<String>();
	boolean equalLists;
	int score = 0;
	
	public void startEasy() {
		
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
	    hashmap.put("atc", catList);
	    
	    ArrayList<String> panList = new ArrayList<String>();
	    panList.add("pan");
	    panList.add("nap");
	    panList.add("ap");
	    panList.add("a");
	    panList.add("pa");
	    panList.add("an");
	    hashmap.put("npa", panList);
	    
	    ArrayList<String> logList = new ArrayList<String>();
	    logList.add("log");
	    logList.add("go");
	    logList.add("lo");
	    hashmap.put("ogl", logList);
	    
	    ArrayList<String> ratList = new ArrayList<String>();
	    ratList.add("rat");
	    ratList.add("at");
	    ratList.add("a");
	    hashmap.put("atr", ratList);
	    
	    ArrayList<String> ballList = new ArrayList<String>();
	    ballList.add("ball");
	    ballList.add("a");
	    ballList.add("all");
	    ballList.add("lab");
	    hashmap.put("llba", ballList);
	    
	    ArrayList<String> lampList = new ArrayList<String>();
	    lampList.add("lamp");
	    lampList.add("a");
	    lampList.add("am");
	    lampList.add("ap");
	    lampList.add("lap");
	    lampList.add("amp");
	    lampList.add("pal");
	    hashmap.put("lmpa", lampList);
	    
	    ArrayList<String> goatList = new ArrayList<String>();
	    goatList.add("goat");
	    goatList.add("a");
	    goatList.add("go");
	    goatList.add("got");
	    goatList.add("to");
	    goatList.add("got");
	    hashmap.put("gtoa", goatList);
	    
	    ArrayList<String> noseList = new ArrayList<String>();
	    noseList.add("nose");
	    noseList.add("no");
	    noseList.add("so");
	    noseList.add("son");
	    noseList.add("on");
	    noseList.add("one");
	    hashmap.put("snoe", noseList);
	    
	    ArrayList<String> wormList = new ArrayList<String>();
	    wormList.add("worm");
	    wormList.add("or");
	    wormList.add("row");
	    wormList.add("mow");
	    hashmap.put("mrwo", wormList);
	    
	    String originalWord = selectRandomWord();
	    
	    int allowedPlays = hashmap.get(originalWord).size();
	    
		System.out.println("Your letters are: " + originalWord + "\n" + "You have " + allowedPlays + " chances to find all of the words" + "\n");
	    System.out.println("Please type in your word: " + "\n");
	   
		while(playing) {
			
			String guess = getUserGuess();
			Collections.sort(hashmap.get(originalWord));
		    Collections.sort(guessList);
		    String scoreboard = getScoreboard();
		    
		    if(hashmap.get(originalWord).equals(guessList)) {
		    	
		    	System.out.println("Congratulations! You found all the words for" + hashmap.get(originalWord) + "\n" + scoreboard);
		    	
				playing = false;
				
			} else {
				
				if(allowedPlays==1) {
					score = score - 1;
					System.out.println("Sorry, you didn't find all the words. You found " + foundWords + " word(s)." + "\n" + "Here is your score:" + score + "\n" + scoreboard);
					playing = false;
				}
				
				else if(hashmap.get(originalWord).contains(guess) && !guessList.contains(guess)) {
					
					score = score + 5;
					
					allowedPlays --;
					foundWords += 1;
					guessList.add(guess);
					System.out.println("Congratulations! You found " + foundWords + " words for: " + originalWord + "." + " Here is your score:" + score + "\n" + "Please type a new your word: " + "\n" + "You have " + allowedPlays + " chances to find the rest of the words" + "\n");
					
					Collections.sort(hashmap.get(originalWord));
				    Collections.sort(guessList);
					
					if(hashmap.get(originalWord).equals(guessList)) {
						System.out.println("Congratulations! You found all the words for" + hashmap.get(originalWord) + "\n" + scoreboard);
						playing = false;
					}
					
				} else {
					if (score < 0 || score == 0) {
						score = 0;
						allowedPlays --;
						System.out.println("Sorry, try again." + " Here is your score:" + score + "\n" + "You have " + allowedPlays + " chances to find the rest of the words" + "\n");
					}
					if (score > 0) {
						score = score - 1;
						allowedPlays --;
						System.out.println("Sorry, try again." + " Here is your score:" + score + "\n" + "You have " + allowedPlays + " chances to find the rest of the words" + "\n");
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
