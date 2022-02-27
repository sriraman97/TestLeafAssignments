package week1.day2;

public class NegativeToPositiveNumber {
	
	public static void main(String[] args) {
		
		int num = -40;
		int convertedNum = num < 0 ? num * -1 : num;
		System.out.println("The number " + num + " is converted to " + convertedNum);
	}

}
