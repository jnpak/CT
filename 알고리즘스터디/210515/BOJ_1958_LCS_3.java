import java.util.Scanner;

public class BOJ_1958_LCS_3 {
	static int[][][] dp = new int[101][101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String str3 = sc.nextLine();
		
		int answer = LCS(str1,str2,str3);
		System.out.println(answer);

	}
	private static int LCS(String str1, String str2, String str3) {
		
		for(int i=1;i<=str1.length();i++) {
			char c1 = str1.charAt(i-1);
			
			for(int j=1;j<=str2.length();j++) {
				char c2 = str2.charAt(j-1);
				
				for(int k=1;k<=str3.length();k++) {
					char c3 = str3.charAt(k-1);
					
					dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
					
					if(c1 == c2 && c2 == c3) 
						dp[i][j][k] = dp[i-1][j-1][k-1] + 1;		
				}
			}
		}
		return dp[str1.length()][str2.length()][str3.length()];
	}

}
