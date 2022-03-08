package week3.day1;

public class ClassroomAssignment_Strings {

	public static void main(String[] args) {
		
		String text1 = "Testleaf is located in Teynampet and above a tacobell";
		String text2 = "Education";
		
		//prints the words starting with t in text1
		
		String[] splitText1 = text1.split(" ");
		int i = 0;
		while(i < splitText1.length) {
			if(splitText1[i].startsWith("T") || splitText1[i].startsWith("t"))
				System.out.print(splitText1[i] + " ");
			i++;
		}
		System.out.println();
		
		//prints the vowels in text2
		
		i = 0;
		String text2LowerCase = text2.toLowerCase();
		while(i<text2LowerCase.length()) {
			char c = text2LowerCase.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				System.out.println(c);
			i++;
		}
	}

}
