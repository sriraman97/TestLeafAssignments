package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator calc = new Calculator();
		
		System.out.println(calc.add(7, 7, 7));
		System.out.println(calc.sub(5, 2));
		System.out.println(calc.mul(3.0, 2.5));
		System.out.println(calc.divide(1.5f, 3.0f));
	}

}
