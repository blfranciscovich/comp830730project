package comp840project;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) throws FileNotFoundException {
		Player p;
		String user;
		boolean signedIn = false;
		Scanner signIn = new Scanner(System.in);
		Scanner level = new Scanner(System.in);

		Scanner scanner = new Scanner(System.in);

		while (signedIn == false)
		{
		System.out.print("Hello! Please enter in a username: " + "\n");
		user = signIn.nextLine();
		if (user.length() < 3) {
			System.out.print("Please pick a username that is at least 3 characters long. " + "\n");
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
				//LevelDecorator firstString = new LevelString("Your word is apple, find the other words: find me, find me, fine me, find me, find me");
				//LevelOneDecorator wordReplace = new LevelOneDecorator(firstString);
				//System.out.println(wordReplace.decorateString("") + "\n");
				break;
			case "Medium":
			case "medium":
				break;
			case "Hard":
			case "hard":
				break;
			case "Exit":
			case "exit":
				signedIn = false;
				break;
			default:
				System.out.println("Command not recognised");

			}
		}
		scanner.close();
	}
}
