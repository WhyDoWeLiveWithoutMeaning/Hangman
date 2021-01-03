import java.util.Scanner;
import java.util.ArrayList;

class Funee{
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		String[] man = {"-----\n|   |\n|\n|\n|\n-----\n",
		       "-----\n|   |\n|   0\n|\n|\n-----\n",
		       "-----\n|   |\n|   0\n|   |\n|\n-----\n",
		       "-----\n|   |\n|   0\n|  ||\n|\n-----\n",
		       "-----\n|   |\n|   0\n|  |||\n|\n-----\n",
		       "-----\n|   |\n|   0\n|  |||\n|  /\n-----\n",
		       "-----\n|   |\n|   0\n|  |||\n|  / \\ \n-----\n"};
		String secretWord = "Super Secret Word".toLowerCase();
		ArrayList<Character> usedLetters = new ArrayList<Character>();
		int dev = 0;
		boolean win = false;
		boolean lose = false;
		
		while (true) {
			System.out.println("Guess a letter: ");
			String xw = in.next();
			char x = xw.charAt(0);
			try {
				int z = Integer.parseInt(String.valueOf(x));
				System.out.println(z);
				System.out.println("Enter a letter please");
				continue;
			} catch (Exception e) {
				if (xw.length() != 1 || xw == " ") {
					System.out.println("Guess One letter please");
					continue;
				}
				if (inside(usedLetters, x)) {
					System.out.println("You already guessed that word");
				} else {
					usedLetters.add(x);
					if (inside(secretWord.toCharArray(), x)) {
						System.out.println("You guessed right");
					} else {
						dev++;
						if (dev >= man.length - 1) {
							lose = true;
						}
						System.out.println("You guessed wrong");
					}
					String finalWord = fakeWord(secretWord, usedLetters);
					if (!inside(finalWord.toCharArray(), '_')) {
						win = true;
					}
					
					System.out.println(man[dev]);
					System.out.println();
					System.out.println(finalWord);
					System.out.println();
					System.out.println();
					
					if (win) {
						System.out.println("You Won");
						break;
					} else if (lose){
						System.out.println("You lost");
						break;
					}
				}
			}
		}
		in.close();
	}
	
	public static String fakeWord(String word, ArrayList<Character> guessed) {
		String temp = "";
		for (int i = 0; i < word.length(); i++) {
			if (inside(guessed, word.charAt(i)) || word.charAt(i) == ' ') {
				temp = temp + word.charAt(i) + " ";
			} else {
				temp = temp + "_ ";
			}
		}
		return temp;
	}
	
	public static boolean inside(ArrayList<Character> check, char c) {
		for (char i : check) {
			if (i == c) {
				return true;
			}
		}
		return false;
	}
	public static boolean inside(char[] check, char c) {
		for (char i : check) {
			if (i == c) {
				return true;
			}
		}
		return false;
	}
}
