import java.util.Scanner;

public class BOJ_5582_공통_부분_문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int ans = 0;
		
		int l1 = str1.length();
		int l2 = str2.length();
		
		int[][] dp = new int[l1+1][l2+1];
		
		for(int i=1;i<=l1;i++) {
			for(int j=1;j<=l2;j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		System.out.println(ans);
	}

}