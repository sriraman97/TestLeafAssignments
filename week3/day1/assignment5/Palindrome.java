package week3.day1.assignment5;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String actual = "madam";
		String reversed = "";
		int i = actual.length()-1;
		
		while(i>=0) {
			reversed += actual.charAt(i);
			i--;
		}
		System.out.println(actual.equals(reversed) ? "Palindrome" : "Not a palindrome");
	}

}
