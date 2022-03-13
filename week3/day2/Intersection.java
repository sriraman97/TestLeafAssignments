package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = Arrays.asList(3,2,11,4,6,7);
		List<Integer> list2 = Arrays.asList(1,2,8,4,9,7);
		
		for (Integer elementInList1 : list1) {
			for (Integer elementInList2 : list2) {
				System.out.print(elementInList1 == elementInList2 ? elementInList1 + " " : "");
			}
		}
	}

}
