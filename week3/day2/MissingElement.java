package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Integer> setOfNumbers = new TreeSet<Integer>(Arrays.asList(1,2,3,4,7,6,8));
		List<Integer> listOfSortedNumbers = new ArrayList<Integer>(setOfNumbers);
		int i = 1;
		for (Integer number : listOfSortedNumbers) {
			if(i != number) {
				System.out.println("Missing number " + i); break;
			}
			i++;
		}
	}

}
