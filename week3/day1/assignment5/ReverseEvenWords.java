package week3.day1.assignment5;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test = "I am a software tester"; 
		String output = "";
		String[] splitTest = test.split(" ");
		int i = 0;
		while(i<splitTest.length) {
			if(i%2 != 0) {
				char[] charArray = splitTest[i].toCharArray();
				int j = charArray.length-1;
				String rev = "";
				while(j>=0) {
					rev += charArray[j];
					j--;
				}
				output = output + rev + " ";
			}
			else
				output += splitTest[i] + " ";
			i++;
		}
		System.out.println(output);
	}

}
