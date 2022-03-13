package week3.day2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSecondLargest {
	
	public static void main(String[] args) {
		
		List<Integer> listOfNumbers = Arrays.asList(3,2,11,4,6,7);
		Collections.sort(listOfNumbers);
		System.out.println(listOfNumbers.get(listOfNumbers.size()-2));
}
}
