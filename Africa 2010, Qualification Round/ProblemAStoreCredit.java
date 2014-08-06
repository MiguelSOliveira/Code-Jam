import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ProblemAStoreCredit {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		PrintWriter file = new PrintWriter("output.txt");
		
		int numberOfCases = sc.nextInt();
		for(int i = 0; i < numberOfCases; i++){
			int credit = sc.nextInt();
			sc.nextInt(); //Number of items...Couldn't care less.
			sc.nextLine();
			String[] itemPrices = sc.nextLine().split(" ");
			String answer = "Case #"+(i+1)+": ";
			for(int j = 0; j < itemPrices.length; j++){
				for(int n = j; n < itemPrices.length; n++){
						if(Integer.parseInt(itemPrices[j]) + Integer.parseInt(itemPrices[n]) == credit && j != n){
							answer += (j+1)+" "+(n+1);
						}
					}
				}
			file.write(answer+"\n");
			}
		file.close();
		sc.close();
		}
	}