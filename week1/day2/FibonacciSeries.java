package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 2, range = 8;
		int a[] = new int[range];
		a[0] = 0; a[1] = 1;
		while(i < a.length) {
			a[i] = a[i-1] + a[i-2];
			System.out.print(a[i-2] + " ");
			i++;
		}
		System.out.print(a[a.length-2] + " " +  a[a.length-1]);
	}

}
