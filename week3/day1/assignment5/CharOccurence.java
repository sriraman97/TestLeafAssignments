package week3.day1.assignment5;

public class CharOccurence {

	public static void main(String[] args) {
		
		String str = "welcome to chennai";
		char c = 'n';
		char[] charArrayStr = str.toCharArray();
		int i = 0, count = 0;
		while(i<charArrayStr.length) {
			if(charArrayStr[i] == c)
				count ++;
			i++;
		}
		System.out.println("character Count = " + count);
	}

}
