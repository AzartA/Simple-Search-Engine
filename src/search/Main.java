package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


public class Main  {
	static Searcher option;
	
	/**
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String[] lines = readFileAsString("names.txt");
		
		while(true) {
			System.out.println("\r\n=== Menu ===\r\n" + 
					"1. Find a person\r\n" + 
					"2. Print all people\r\n" + 
					"0. Exit\r\n Your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 0:
				System.out.println("Bye!");
				return;
			case 1:
				System.out.println("Select a matching option: ALL, ANY, NONE");
				String opts = sc.nextLine();
				switch (opts) {
				case "ALL":
					setOption(new AllOption());
					break;
				case "NONE":
					setOption(new NoneOption());
					break;
				case "ANY":
					setOption(new AnyOption());
					break;
				default:
					System.out.println("No such option!");
					break;
				}
				System.out.println("Enter a name or email to search all suitable people:");
				
				System.out.println(match(sc.nextLine(), lines));
				break;
			case 2:
				System.out.println("=== List of people ===");
				for (String ln : lines) {
					System.out.println(ln);
				}
				break;
			default:
				System.out.println("Incorrect option! Try again.");
				break;
			}
		}
		
	}
	
	private static void setOption(Searcher opt) {
		option = opt;
	}
	
	private static String match(String match, String[] sourse) {
		return option.search(match, sourse);
	}
	 
	private static String[] readFileAsString(String fileName) throws IOException{
		return new String(Files.readAllBytes(Paths.get(fileName))).split("\\R");
	}

}
