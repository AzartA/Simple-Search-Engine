package search;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of people:");
		int n =sc.nextInt();
		sc.nextLine(); // omit \n after integer
		String[] lines = new String[n];
		System.out.println("Enter all people:");
		for (int i = 0; i < n; i++) {
			lines[i] = sc.nextLine();
		}
		System.out.println("Enter the number of search queries:");
		int m =sc.nextInt();
		sc.nextLine(); // omit \n after integer
		for (int i = 0; i < m; i++) {
			System.out.println("Enter a search querie:");
			System.out.println("Found people: \n" + search(sc.nextLine(),lines));
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

}
