package udemy;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
	
	static void duplicateCharacters(String str) {
		Set<Character> characters = new HashSet<Character>();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!characters.add(c)) {
				System.out.println("duplicate character index: " + i);
				count++;
			}
		}
		System.out.println("# of duplicate characters: " + count);
	}
	
	public static void main(String[] args) {
		duplicateCharacters("Hello World");
	}

}
