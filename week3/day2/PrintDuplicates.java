package week3.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> duplicateList = Arrays.asList(14,12,13,11,15,14,18,16,17,19,18,17,20);
		Map<Integer, Boolean> numberMap = new HashMap<Integer, Boolean>();
		
		for (Integer number : duplicateList) { //load the map with default value as false
			numberMap.put(number, false);
		}
		
		for (Integer number : duplicateList) { //iterate the list, if value(key)== false -> set to true, otherwise print
			
			if(numberMap.get(number) == false)
				numberMap.put(number, true);
			else
				System.out.println("Duplicate number: " + number);
		}
	}
}
