package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열_돌리기_4 {
	static class rotate{
		int r, c, s;
		public rotate(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
	}
	static int N, M, K, map[][], copy[][], result_min = Integer.MAX_VALUE;
	static rotate[] info;
	static int[] order;
	static boolean[] isSelected;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		info = new rotate[K];
		order = new int[K];
		isSelected = new boolean[K];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(input.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			info[i]= new rotate(r,c,s);
		}
		
		perm(0);
		System.out.println(result_min);
	}
	private static void perm(int cnt) {
		if(cnt == K) {
			//나온 순열으로 배열돌리기
			result_min = Math.min(cal_rotate_min(order),result_min);
			return;
		}
		
		for(int i=0;i<K;i++) {
			if(isSelected[i]) continue;
			order[cnt] = i;
			isSelected[i]=true;
			perm(cnt+1);
			isSelected[i]=false;
		}
		
	}
	private static int cal_rotate_min(int[] order) {
		copy = new int[map.length][];
		for(int i=0; i< map.length; i++) {
			copy[i] = map[i].clone();
		}
		for(int i=0;i<K;i++) {
			rotate_start(info[order[i]]);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=N;i++) {
			int sum = 0;
			for(int j=1;j<=M;j++) {
				sum += copy[i][j];
			}
			min = Math.min(min, sum);
		}		
		System.out.println(min);
		return min;
		
		
		
	}
	private static void rotate_start(rotate info) {
		int r = info.r;
		int c = info.c;
		int s = info.s;
		
		while(s-->0) {
		int tmp = copy[r-s][c-s];
		
		//왼쪽줄 위로
		for(int i=r-s; i < r+s; i++) {
			copy[i][c-s] = copy[i+1][c-s];
		}
		//아랫줄 왼쪽으로
		for(int i=c-s; i < c+s; i++) {
			copy[r+s][i] = copy[r+s][i+1];
		}
		//오른쪽줄 아래로
		for(int i=r+s; i > r-s; i--) {
			copy[i][c+s] = copy[i-1][c+s];
		}
		//위쪽줄 오른쪽으로
		for(int i=c+s; i > c-s; i--) {
			copy[r-s][i] = copy[r-s][i-1];
		}
		copy[r-s][c-s+1]= tmp;
		}

	}

}
