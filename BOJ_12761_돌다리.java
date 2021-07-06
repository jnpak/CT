import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12761_돌다리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[100001];
		Arrays.fill(dp, 999999);
		dp[N] = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == M) break;
			
			int[] temp = new int[8];
			temp[0] = cur + 1;
			temp[1] = cur - 1;
			temp[2] = cur + A;
			temp[3] = cur - A;
			temp[4] = cur + B;
			temp[5] = cur - B;
			temp[6] = cur * A;
			temp[7] = cur * B;
			
			for(int i=0; i<8;i++) {
				int next = temp[i];
				if(next < 0 || next > 100000 || dp[next] <= dp[cur] + 1) continue;
				dp[next] = dp[cur] +1;
				q.add(next);
			}
		}
		System.out.println(dp[M]);
	}
}
