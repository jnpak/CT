import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2660_회장뽑기 {
	static final int INF = 9999999;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[][] distance = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i != j) {
					distance[i][j] = INF;
				}
			}			
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1) break;
			
			distance[a][b] = distance[b][a] = 1;			
		}
		
		for(int k = 1; k <= N; k++) { // k는 경유지
			for(int i = 1; i <= N; i++) { // i에서부터
				for(int j =1; j <= N; j++) {// j로 갈 때 K를 거쳐가는 거리가 더 적다면 업데이트
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		int totalMin = Integer.MAX_VALUE;
		int[] scores = new int[N+1];
		for(int i = 1; i <= N; i++) {
			int max = 0;
			for(int j = 1; j <= N; j++) {
				max = Math.max(max, distance[i][j]);
			}
			scores[i] = max;
			totalMin = Math.min(totalMin, max);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=N;i++) {
			if(totalMin == scores[i]) list.add(i);
		}
		Collections.sort(list);
		
		System.out.println(totalMin + " " + list.size());
		for(int i=0;i<list.size();i++) {
			if(i == list.size()-1) System.out.print(list.get(i));
			else System.out.print(list.get(i) + " ");
		}
		
		
		
		
		
	}

}
