package udemy;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void printCounts(String str) {
		char[] ary = str.toCharArray();
		Map<Character, Integer> countMap = new HashMap<>();
		for (char c : ary) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
 	}
	
	public static void main(String[] args) {
		printCounts("hello world");
	}
	
}
