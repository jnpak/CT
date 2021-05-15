package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {
	private static final int MOD = 1234567891;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long fac[] = new long[N + 1];
			fac[0] = 1;
			for (int i = 1; i <= N; i++)
				fac[i] = (i * fac[i - 1]) % MOD;
			
			long bottom = (fac[N-R] * fac[R]) % MOD;
			bottom = power(bottom, MOD-2);
			output.append("#" + tc + " " + (fac[N] * bottom) % MOD + "\n");
		} // tc
		System.out.println(output);
	}// main

	private static long power(long a, long b) {
		if(b == 0) return 1;		
		else if(b == 1) return a;	
		
		if(b%2 ==0) {				// r이 짝수인 경우
			long tmp = power(a, b/2);
			return ((tmp * tmp)% MOD );
		}
		long tmp = power(a, b-1) % MOD;
		return (tmp * a) % MOD;
		
	}

}
