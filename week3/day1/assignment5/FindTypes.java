package week3.day1.assignment5;

public class FindTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		int  letter = 0, space = 0, num = 0, specialChar = 0, i = 0;
		//char[] charArrayTest = test.toCharArray();
		
		while(i<test.length()) {
			
			if(Character.isAlphabetic(test.charAt(i)))
				letter ++;
			else if(Character.isDigit(test.charAt(i)))
				num++;
			else if(Character.isSpace(test.charAt(i)))
				space++;
			else
				specialChar++;
			i++;
		}
		System.out.println("Number of letters: " + letter + " , Number of numbers: " + num + " , Number of spaces: " + space + ", Number of splChars: "+ specialChar);
	}

}
