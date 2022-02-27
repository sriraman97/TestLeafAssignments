package week1.day2;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long result = 1;
		for(int i = 20; i > 0; i--) {
			result *= i;
		}
		System.out.println("Result = " + result);
	}

}
