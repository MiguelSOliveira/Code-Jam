import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ProblemBReverseWords {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		PrintWriter file = new PrintWriter("output.txt");
		
		int nCases = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < nCases; i++){
			String stringToReverse = sc.nextLine();
			int stringToReverseNumWords = stringToReverse.split(" ").length;
			Scanner scannerStringToReverse = new Scanner(stringToReverse);
			String[] currentscannerStringToReverse = new String[stringToReverseNumWords];
			for(int n = 0; scannerStringToReverse.hasNext(); n++){
				currentscannerStringToReverse[n] = scannerStringToReverse.next();
			}
			for(int k = 0, m = stringToReverseNumWords-1; k < stringToReverseNumWords/2; k++, m--){ // Reverse words order
					String temp = currentscannerStringToReverse[k];
					currentscannerStringToReverse[k] = currentscannerStringToReverse[m];
					currentscannerStringToReverse[m] = temp;
			}
			String answer = "Case #"+(i+1)+": ";
			for (String string : currentscannerStringToReverse) {
					answer += string+" ";
			}
			file.write(answer+"\n");
		}
		file.close();
		sc.close();
	}
}
