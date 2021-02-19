package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Ck {
	int x, y;

	public Ck(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_15686_치킨_배달 {
	static int N, M, idx=0; // N 크기, 최대 치킨집 M
	static int[][] map; // NxN 맵
	static int[][] copy;
	static int result;
	
	static Ck[] list = new Ck[13]; // 최대 치킨집 13개
	static Ck[] comb = new Ck[13]; // M개만 들어감

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 지도 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list[idx++]= new Ck(i,j);
					map[i][j] = 0;
				}
			}
		}
		
		
		//맵 복사 -> 카피배열에 <- 조합

		System.out.println();

	}// main
	
	private static void Combination(int cnt, int start) {
		if(cnt == M) {
			
			
		}else { // 
			for(int i=start;i<N;i++) {
				comb[cnt]=list[i];
				Combination(cnt+1,i+1);
			}
		}
	}
	
	//거리 계산
	private static int calc() {
		int min,sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copy[i][j]==1) { // 맵을 탐색하다가 1인 위치일 때 치킨집 조합 배열의 거리값을 모두 계산한 후 
					min=Integer.MAX_VALUE;
					for(int k=0;k<M;k++) {  //  제일 적은 값을 min 값으로
						min = Math.min(min,Math.abs(i-comb[k].x)+Math.abs(j-comb[k].y));
					}
					sum += min;
				}
			}
		}
		
	return sum;	
	}
}
