package ct;

import java.util.Scanner;

public class BOJ_2293_����_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] dp = new int[k + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			int coin = sc.nextInt();			// dp[3] = dp[3-coin(2)]
			for (int j = coin; j <= k; j++) {	// 3�� ����� ����� ���� 3-2�� �� 1�� ����� �����
				dp[j] += dp[j - coin];			// �����ٰ� ���� 2 �Ѱ��� ����� ����Ǽ��� 1�� 
			}									// ���� ���� �ȴ�. 1�� ����°���� �� + 2���� ���
		}										// 1�� ������ ����� �� 1�� 2������ ����� ��� 1��
												// ���Ͽ� dp[3] = 2�� ����� ���� ���´�.
		System.out.println(dp[k]);
		
	}											

}
