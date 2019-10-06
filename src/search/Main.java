package search;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] strs = sc.nextLine().split(" ");
		String match = sc.next();
		for (int i = 0; i < strs.length; i++) {
			if(match.equals(strs[i])) {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println("Not found");
	}

}
