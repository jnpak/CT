//백준_2217
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Integer[] k = new Integer[N];

		for (int i = 0; i < N; i++) {
			k[i] = sc.nextInt();
		}
		Arrays.sort(k, Collections.reverseOrder());

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, k[i-1]*i);
		}
		System.out.println(max);
		sc.close();
	}
}
