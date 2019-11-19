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

	/**
	 * @param args
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
					
				System.out.println("Enter a name or email to search all suitable people:");
				
				System.out.println(match(sc.nextLine(), lines));
				//System.out.println("Found people: \n" + search(sc.nextLine(),lines));
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
	private static String match(String match, String[] sourse) {
		if("".equals(match)) return "Empty line!";
		Map <String, Set<Integer>> words = new HashMap<>();
		for(int i = 0; i<sourse.length;i++) {
			for (String l:sourse[i].split("\\s")) {
				int i1 = i;
				words.compute(l.toLowerCase(), (k,v) -> {
					if(v==null) {
						Set<Integer> set1 = new HashSet<Integer>(5);
						set1.add(i1); 
						return set1;
					}else {
						v.add(i1);
						return v;
					}
				});
			}
		}
		//words.forEach((k,v) -> System.out.println(k + " -> " + v.toString()));
		
		Set<Integer> lnum = words.get(match.toLowerCase());
		if(lnum == null) return "No matching people found.\n";
		StringBuilder sb = new StringBuilder();
		sb.append(lnum.size());
		sb.append(" persons found:");
		sb.append(System.lineSeparator());
		for(Integer l: lnum) {
			sb.append(sourse[l]);
			sb.append(System.lineSeparator());
		}
		return sb.toString();
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
		
		return new String(Files.readAllBytes(Paths.get(fileName))).split("\\R");
		
    }

}
