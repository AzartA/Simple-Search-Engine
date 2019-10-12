package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main  {

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
					
				System.out.println("Enter a name or email to search all suitable people:");
				System.out.println("Found people: \n" + search(sc.nextLine(),lines));
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

	private static String search(String match, String[] source) {
		match = match.strip();
		if(match.split(" ").length>1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (String src : source) {
			if((src.toLowerCase()).contains(match.toLowerCase())) {
				sb.append(src);
				sb.append("\n");
			}
		}
		return sb.toString();
		
	}
	 
	private static String[] readFileAsString(String fileName) throws IOException{
		
		return new String(Files.readAllBytes(Paths.get(fileName))).split("\r\n");
		
    }

}
