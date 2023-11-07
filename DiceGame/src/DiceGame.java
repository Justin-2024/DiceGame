import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	private static String[][] language;
	private static int lang =0;
	

	public static void main(String[] args) {
		int die1;
		int die2;
		String[] playerChoices;
		die1 = roll();
		die2 = roll();
		String choice;
		String langChoice = getInput("Enter Language: \n[0] English\n[1] Hawaiian Pidgin");
		language = initLang();
		lang = Integer.parseInt(langChoice);
		choice = getInput(language[lang][0]);
		choice = choice.toLowerCase();
		int count = 0;
		String playerCount = getInput(language[lang][1]);
		count = Integer.parseInt(playerCount);
		playerChoices = new String[count];
		while(choice.equals(language[lang][2])) {
			
			for(int c= 0; c < count; c++) {
			playerChoices[c] = getInput(language[lang][3]+(c+1)+language[lang][4]);
			
			}
			System.out.println(language[lang][5]+die1+language[lang][6]+die2);
			//Start a new loop here.
			for(int c=0; c<count;c++) {
				if(didIWin(die1,die2,playerChoices[c]))
				{
					System.out.println(language[lang][3]+(c+1)+language[lang][7]);
				}else
				{
					System.out.println(language[lang][3]+(c+1)+language[lang][8]);
				}
			}
			
			choice = getInput(language[lang][9]);
			choice = choice.toLowerCase();
			die1 = roll();
			die2 = roll();
		}
	}
	private static String[][] initLang() {
		String [][] temp = new String[][] {
			//english 0
			{
				"Do you want to play?\nYes\nNo", // 0
				"How many players are there?", // 1
				"yes", // 2
				"Player", // 3
				": [0] Even\n[1] Odd", // 4
				"Die 1: ", // 5
				"\nDie 2: ", // 6
				" wins!", // 7
				" loses!", // 8
				"Do you want to play?\nYes\nNo" // 9
			},
			// hawaiian pidgin 1
			{
				"Like try?\nYessah\nNo Need", // 0
				"How many da kine?", // 1
				"yessah", // 2
				"Brahhda ", // 3
				":\n[0] Even\n[1] Odd", // 4
				"One Dice: ", // 5
				"\nTwo Dice: ", // 6
				" winnah!", // 7
				" no can win!", // 8
				"Like play again?\nYessah\nNo Need" // 9
			},
			
		};
		return temp;
	}
	private static boolean didIWin(int die1, int die2, String choice)
	{
		
		return false;
	}
	
	
	private static int roll()
	{
		return roll(6,1);
	}
	private static int roll(int sides,int start) {
		Random roller = new Random();
		return roller.nextInt(sides)+start;
	}
	private static String getInput(String text) {
		Scanner input = new Scanner(System.in);
		String choice = "";
		try 
		{
			System.out.println(text);
			choice = input.nextLine();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return choice;
	}
	
	private static boolean isInputInteger(String input) {
		boolean isAnInteger = true;
		for(int c = 0; c < input.length();c++) {
			char letter = input.charAt(c);
			//'-' is 45 '0 - 9' 48 - 57
			if(c!=0 &&!(letter >= 48 && letter<= 57))
			{
				isAnInteger = false;
			}else if(letter != 45 && !(letter >= 48 && letter <= 57))
			{
				isAnInteger = false;
			}
		}
		return isAnInteger;
	}
}
