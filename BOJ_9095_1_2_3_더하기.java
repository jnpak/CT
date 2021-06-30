package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095_1_2_3_더하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(input.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(input.readLine());
			int[] dp = new int[n+1];
			dp[1]=1;
			if(n>=2) dp[2]=2;
			if(n>=3) dp[3]=4;
			
			for(int i=4;i<=n;i++) {
				dp[i]= dp[i-3] + dp[i-2] + dp[i-1];
			}
			System.out.println(dp[n]);
		}//tc
	}

}
