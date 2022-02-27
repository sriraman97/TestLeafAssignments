package week1.day2;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 2,number = 13;
		boolean isPrime = true;
		if(number == 1 || number ==0) {
			System.out.println("neither prime nor composite");
			return;
		}
		while(i < number) {
			if(number%i == 0) {
				isPrime = false;
				break;
			}
			i++;
		}
		System.out.println(isPrime ? number + " is a prime number" : number + " is not a prime number");
	}

}
