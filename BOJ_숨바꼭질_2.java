import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_숨바꼭질_2 {

	static int cnt[] = new int[100001];
	static int min = Integer.MAX_VALUE;
	static int count=0;
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		BFS(N,K);
		
		 if (N >= K) {
	            System.out.println((N-K) + "\n1");
	            return;
	        }
		
		System.out.println(min);
		System.out.println(count);
	}
	
	public static void BFS(int N, int K) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(N);
		cnt[N] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();

			if(min < cnt[cur]) return;
			
			int[] arr = {cur-1,cur+1,cur*2};
			
			for(int next : arr) {
				if(next < 0 || next > 100000) continue;
				
				if(next == K) {
					min = cnt[cur];
					count++;
				}
				
				if(cnt[next] == 0 || cnt[next] == cnt[cur] + 1) {
					q.add(next);
					cnt[next] = cnt[cur] + 1;
				}
				
			}
			
		}
		
	}
}
