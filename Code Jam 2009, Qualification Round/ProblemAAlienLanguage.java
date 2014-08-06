import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemAAlienLanguage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sc.nextInt(); // Words length, like i care about that..
		int howManyWords = sc.nextInt(); 
		int nTests = sc.nextInt();
		String[] words = new String[howManyWords];	// Arrays of string where the word dictionary will be
		sc.nextLine();
		for(int i = 0; i < howManyWords; i++){
			words[i] = sc.nextLine();
		}
		for(int _ = 0; _ < nTests; _++){
			int count = 0;
			String regex = sc.nextLine();
			regex = regex.replace("(", "[").replace(")", "]");
			Pattern pattern = Pattern.compile(regex);
			for(int j = 0; j < howManyWords; j++){
				Matcher matcher = pattern.matcher(words[j]);
				if(matcher.find()){
					count++;
				}
			}
			System.out.println("Case #" + (_+1) + ": " + count);
		}
		sc.close();
	}
}
