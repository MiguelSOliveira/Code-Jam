import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ProblemCT9Spelling {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		PrintWriter file = new PrintWriter("output.txt");
		Map<Character, Integer> keyboard = new HashMap<>();
		keyboard.put('a', 2);
		keyboard.put('b', 22);
		keyboard.put('c', 222);
		keyboard.put('d', 3);
		keyboard.put('e', 33);
		keyboard.put('f', 333);
		keyboard.put('g', 4);
		keyboard.put('h', 44);
		keyboard.put('i', 444);
		keyboard.put('j', 5);
		keyboard.put('k', 55);
		keyboard.put('l', 555);
		keyboard.put('m', 6);
		keyboard.put('n', 66);
		keyboard.put('o', 666);
		keyboard.put('p', 7);
		keyboard.put('q', 77);
		keyboard.put('r', 777);
		keyboard.put('s', 7777);
		keyboard.put('t', 8);
		keyboard.put('u', 88);
		keyboard.put('v', 888);
		keyboard.put('w', 9);
		keyboard.put('x', 99);
		keyboard.put('y', 999);
		keyboard.put('z', 9999);
		
		int numberOfCases = 0;
		int limit= sc.nextInt();
		sc.nextLine();
		while(++numberOfCases < limit+1){
			String answer = "Case #"+numberOfCases+": ";
			char[] message = sc.nextLine().toCharArray(); //Turns the string into a char array
			for(int character = 0; character < message.length; character++){
				if(keyboard.get(message[character]) != null){ //If the character is not a space
					char lastChar = keyboard.get(message[character]).toString().charAt(0);
					if(answer.endsWith(""+lastChar)){ //If the character is in the same key as the previous letter
						answer += " " + keyboard.get(message[character]); //Add a space
					}
					else { //If it is not the same
						answer += keyboard.get(message[character]);
					}
				} 
				else if(message[character] == ' '){ //If the character is a space
					if(answer.endsWith("0")){
						answer += " 0";
					}
					else { // If it is not a space
						answer += '0';
					}
				}
			}
			file.println(answer);
		}
		file.close();
		sc.close();
	}
}
