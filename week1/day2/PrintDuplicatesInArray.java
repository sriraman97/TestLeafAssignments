package week1.day2;

public class PrintDuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20,12};//
		int i = 0;
		while(i < arr.length) {
			int j = i+1;
			while(j < arr.length) {
				if(arr[i] == arr[j])
					System.out.print(arr[i] + " ");
				j++;
			}
			i++;
		}
		}
	}
