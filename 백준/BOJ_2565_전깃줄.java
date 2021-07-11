package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565_전깃줄 {
	
	static class Pair implements Comparable<Pair>{
		int a,b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int compareTo(Pair o) {
			return this.a-o.a;
		}
	}
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(input.readLine());
		StringTokenizer st = null;
		Pair[] p = new Pair[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			p[i] = new Pair(a,b);
		}
		Arrays.sort(p);
		int[] LIS = new int[n];
		for(int k=0;k<n;k++) {
			LIS[k]=1;
			for(int i=0;i<k;i++) {
				if(p[i].b < p[k].b) {
					LIS[k] = Math.max(LIS[k], LIS[i]+1);
				}
			}
		}
		Arrays.sort(LIS);;
		System.out.println(n - LIS[n-1]);

	}

}
