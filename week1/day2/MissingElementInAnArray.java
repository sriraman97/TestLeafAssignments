package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 0, arr[] = {1,2,3,4,7,6,8};
		int j = i+1;
		Arrays.sort(arr);
		
		while(i<arr.length) {
			if(arr[i] != j) {
				System.out.println("Missing number " + j);
				break;
			}
			i++;j++;
		}

	}

}
