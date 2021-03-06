package WordScramble;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Run {
	public static String user;
	public static void main(String[] args) throws FileNotFoundException {
		
		boolean signedIn = false;
		Scanner signIn = new Scanner(System.in);
		Scanner level = new Scanner(System.in);

		Scanner scanner = new Scanner(System.in);

		while (signedIn == false)
		{
		System.out.print("Hello! Please enter in your initials: " + "\n");
		user = signIn.nextLine();
		if (user.length() < 3 || user.length() > 3) {
			
			System.out.print("Please only type in three letters " + "\n");
			signedIn = false;
		}
			else {
				signedIn = true;
				System.out.print("Welcome " + user + " enjoy the game!" + "\n");
		}
		}

		while (signedIn == true) {
			System.out.println("Choose a level: Easy, Medium, Hard, or type Exit to leave");
			String input = scanner.nextLine();
			String[] words = input.split(" ");

			switch(words[0]) {
			case "Easy":
			case "easy":
				EasyLevel easy = new EasyLevel();
				easy.startEasy();
				//Timer timer = new Timer();
				//timer.runTimer();
				break;
			case "Medium":
			case "medium":
				MediumLevel medium = new MediumLevel();
				medium.startMedium();
				break;
			case "Hard":
			case "hard":
				HardLevel hard = new HardLevel();
				hard.startHard();
				break;
			case "Exit":
			case "exit":
				System.out.println("Thank you for playing!");
				signedIn = false;
				break;
			default:
				System.out.println("Command not recognised");

			}
		}
		scanner.close();
	}
}