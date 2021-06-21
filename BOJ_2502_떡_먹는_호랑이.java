package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2502_떡_먹는_호랑이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] fibo = new int[31][2]; // 30일 + 1 , 떡 구분
		fibo[1][0] = 1; // 첫째날 떡 A
		fibo[2][1] = 1; // 둘째날 떡 B

		for (int i = 3; i < 31; i++) {
			fibo[i][0] = fibo[i - 2][0] + fibo[i - 1][0];
			fibo[i][1] = fibo[i - 2][1] + fibo[i - 1][1];
		}
		for (int A = 1;; A++) {
			int res = K - fibo[D][0]*A;
			
			if(res % fibo[D][1] == 0) {
				System.out.println(A);
				System.out.println(res / fibo[D][1]);
				break;
			}
		}
	}

}
