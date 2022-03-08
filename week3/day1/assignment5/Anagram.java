package week3.day1.assignment5;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "stops";
		String text2 = "potss"; 
		
		if(text1.length() == text2.length()) {
			
			char[] charArray1 = text1.toCharArray();
			char[] charArray2 = text2.toCharArray();
			
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			
			int i = 0; boolean isAnagram = true;
			while(i < charArray1.length) {
				if(charArray1[i] != charArray2[i]) {
					isAnagram = false;
					break;
				}
				i++;
			}
			System.out.println(isAnagram ? "Anagram": "Not anagram");
			
		}
		else
			System.out.println("2 words are not anagram");
	}

}
