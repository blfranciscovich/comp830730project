package WordScramble;

//import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

public class Timer implements java.lang.Runnable{
	
	public void run() {
        this.runTimer();
    }

    public void runTimer(){
        int i = 20;
         while (i>0){
        	 boolean timer = true;
          //System.out.println("Remaining: "+ i + " seconds");
          try {
            i--;
            Thread.sleep(1000L);    // 1000L = 1000ms = 1 second
           }
           catch (InterruptedException e) {
        	   System.out.println("Error");
           }
         }
         if (i==0) {
        	 boolean timer = false;
         }
    }

}