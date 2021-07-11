import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		int num1 = 0;	
		int num2 = 0;	
		for(int i=0; i<arr.length; i++) {
			arr[i] = scan.nextInt();
			sum += arr[i];
		}
		// 2중 for문을 돌면서 총합계에서 두명을 빼서 난쟁이가 아닌 둘을 색출
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i; j<arr.length; j++) {
				if(sum - arr[i] - arr[j] == 100 && i != j) {
					num1 = i;
					num2 = j;
					break; 
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(i == num1 || i == num2) // 일곱 난쟁이가 아닌 둘을 빼고
				continue;
			System.out.println(arr[i]);
		}
		
		scan.close();
	}

}