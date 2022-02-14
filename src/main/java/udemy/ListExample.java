package udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample {

	static String[] getUnassignedCodes(String[] allCodes, String[] assignedCodes) {
		List<String> list1 = new ArrayList<String>(Arrays.asList(allCodes));
		List<String> list2 = new ArrayList<String>(Arrays.asList(assignedCodes));
		
		list1.removeAll(list2);
		return list1.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
		String[] allCodes = {"001" , "002", "003", "004", "005"};
		String[] assignedCodes = {"002", "003"};
		String[] unassignedCodes = getUnassignedCodes(allCodes, assignedCodes);
		System.out.println(Arrays.asList(unassignedCodes));
	}
	
}
