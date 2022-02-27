package week1.day2;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3,2,11,4,6,7};
		int b[] = {1,2,8,4,9,7};
		int i = 0;
		while(i < a.length) {
			int j = 0;
			while(j < b.length) {
				if(a[i] == b[j])
					System.out.print(a[i] + " ");
				j++;
			}
			i++;
		}
	}

}
