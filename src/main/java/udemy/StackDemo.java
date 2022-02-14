package udemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackDemo {

	public static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		char[] ary = s.toCharArray();
		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');

		for (char c : ary) {
			Character opening = map.get(c);
			if (c == '}' || c == '{' || c == ']' || c == '[' || c == '(' || c == ')') {
				if (opening == null) {
					stack.push(c);
				} else if (stack.isEmpty() || stack.pop() != opening) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s1 = "{[() 44] k}";
		String s2 = "{}[ ]()";
		String s3 = "{[(])}";
		String s4 = "{}[](";
		System.out.println("s1 is balanced: " + isBalanced(s1));
		System.out.println("s2 is balanced: " + isBalanced(s2));
		System.out.println("s3 is balanced: " + isBalanced(s3));
		System.out.println("s4 is balanced: " + isBalanced(s4));
	}
}
