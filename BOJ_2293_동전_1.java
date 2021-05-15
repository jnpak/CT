package ct;

import java.util.Scanner;

public class BOJ_2293_동전_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] dp = new int[k + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			int coin = sc.nextInt();			// dp[3] = dp[3-coin(2)]
			for (int j = coin; j <= k; j++) {	// 3을 만드는 경우의 수는 3-2를 한 1을 만드는 경우의
				dp[j] += dp[j - coin];			// 수에다가 코인 2 한개를 사용한 경우의수인 1을 
			}									// 더한 값이 된다. 1을 만드는경우의 수 + 2코인 사용
		}										// 1을 만느는 경우의 수 1과 2코인을 사용한 경우 1을
												// 더하여 dp[3] = 2인 경우의 수가 나온다.
		System.out.println(dp[k]);
		
	}											

}
