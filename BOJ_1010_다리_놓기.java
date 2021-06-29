import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_다리_놓기 {
	static int[][] dp = new int[30][30];
	static BufferedReader input =  new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		
		StringBuilder output = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			output.append(Combination(M,N)).append('\n');
		}//tc
		System.out.println(output);
	}
	private static int Combination(int n, int r) {
		
		if(dp[n][r] > 0) return dp[n][r];
		
		if(n == r || r == 0) return dp[n][r] = 1;
		
		return dp[n][r] = Combination(n - 1, r - 1) + Combination(n - 1, r);
	}

}
