package week1.day2;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number = 123, sum = 0, i = 0;
		
		while(number > 0) {
			sum += number%10;
			number /= 10;
		}
		
		System.out.println("Sum of digits = " + sum);
	}

}
