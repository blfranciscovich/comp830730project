package WordScramble;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MediumLevel {
	
	HashMap<String, ArrayList<String>> hashmap = new HashMap<String, ArrayList<String>>();
	Integer foundWords = 0;
	ArrayList<String> guessList = new ArrayList<String>();
	boolean equalLists;
	
	public void startMedium() {
		
		boolean playing = true;
		int score = 0;
		
		ArrayList<String> groundList = new ArrayList<String>();
		groundList.add("ground");
		groundList.add("go");
		groundList.add("round");
		groundList.add("rod");
		groundList.add("run");
		groundList.add("dung");
		groundList.add("dong");
		groundList.add("dog");
		groundList.add("do");
		groundList.add("go");
		groundList.add("gourd");
		groundList.add("god");
		groundList.add("gun");
		groundList.add("nog");
	    hashmap.put("nrogud", groundList);
	    
	    ArrayList<String> friendList = new ArrayList<String>();
	    friendList.add("friend");
	    friendList.add("fern");
	    friendList.add("rein");
	    friendList.add("in");
	    friendList.add("i");
	    friendList.add("rid");
	    friendList.add("rind");
	    friendList.add("find");
	    friendList.add("din");
	    friendList.add("end");
	    friendList.add("ned");
	    hashmap.put("dfiern", friendList);
	    
	    ArrayList<String> poundList = new ArrayList<String>();
	    poundList.add("pound");
	    poundList.add("on");
	    poundList.add("no");
	    poundList.add("pond");
	    poundList.add("pod");
	    poundList.add("dun");
	    poundList.add("nod");
	    poundList.add("pun");
	    hashmap.put("opndu", poundList);
	    
	    ArrayList<String> powerList = new ArrayList<String>();
	    powerList.add("power");
	    powerList.add("pow");
	    powerList.add("woe");
	    powerList.add("pore");
	    powerList.add("wore");
	    powerList.add("we");
	    powerList.add("ew");
	    powerList.add("pew");
	    powerList.add("woe");
	    hashmap.put("pwroe", powerList);
	    
	    ArrayList<String> castleList = new ArrayList<String>();
	    castleList.add("castle");
	    castleList.add("cat");
	    castleList.add("at");
	    castleList.add("a");
	    castleList.add("ate");
	    castleList.add("steal");
	    castleList.add("teal");
	    castleList.add("tea");
	    castleList.add("eat");
	    castleList.add("eats");
	    castleList.add("stale");
	    castleList.add("cate");
	    hashmap.put("ecstal", castleList);
	    
	    ArrayList<String> winterList = new ArrayList<String>();
	    winterList.add("winter");
	    winterList.add("win");
	    winterList.add("net");
	    winterList.add("went");
	    winterList.add("in");
	    winterList.add("ren");
	    winterList.add("trein");
	    winterList.add("ret");
	    winterList.add("wet");
	    hashmap.put("iwentr", winterList);
	    
	    ArrayList<String> hollywoodList = new ArrayList<String>();
	    hollywoodList.add("hollywood");
	    hollywoodList.add("holly");
	    hollywoodList.add("wood");
	    hollywoodList.add("wool");
	    hollywoodList.add("dool");
	    hollywoodList.add("woody");
	    hollywoodList.add("wholly");
	    hashmap.put("lhwlooody", hollywoodList);
	    
	    ArrayList<String> cupcakeList = new ArrayList<String>();
	    cupcakeList.add("cupcake");
	    cupcakeList.add("cup");
	    cupcakeList.add("cake");
	    cupcakeList.add("up");
	    cupcakeList.add("cap");
	    cupcakeList.add("cape");
	    cupcakeList.add("ape");
	    cupcakeList.add("pea");
	    cupcakeList.add("a");
	    cupcakeList.add("ap");
	    cupcakeList.add("ape");
	    hashmap.put("cpcuaek", cupcakeList);
	    
	    ArrayList<String> pencilList = new ArrayList<String>();
	    pencilList.add("pencil");
	    pencilList.add("pen");
	    pencilList.add("nile");
	    pencilList.add("line");
	    pencilList.add("pile");
	    pencilList.add("neil");
	    pencilList.add("lien");
	    pencilList.add("len");
	    pencilList.add("pin");
	    pencilList.add("i");
	    hashmap.put("pcilen", pencilList);
	    
	    ArrayList<String> automobileList = new ArrayList<String>();
	    automobileList.add("automobile");
	    automobileList.add("mobile");
	    automobileList.add("auto");
	    automobileList.add("blot");
	    automobileList.add("bet");
	    automobileList.add("tab");
	    automobileList.add("bat");
	    automobileList.add("mob");
	    automobileList.add("boul");
	    automobileList.add("a");
	    automobileList.add("am");
	    automobileList.add("an");
	    automobileList.add("ant");
	    automobileList.add("bile");
	    automobileList.add("to");
	    automobileList.add("tom");
	    automobileList.add("let");
	    automobileList.add("met");
	    automobileList.add("mat");
	    automobileList.add("tomb");
	    hashmap.put("aiuomoblet", automobileList);
	    
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
