package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int t = Integer.parseInt(input.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			int N = Integer.parseInt(input.readLine());
			int[][] map = new int[N][N];
			int cnt=1;
			int x=0;
			int y=-1;
			int idx=1;
			while(true) {
				for(int i=0;i<N;i++) {
					y=y+idx;
					map[x][y]=cnt;
					cnt++;
				}
				N--;
				for(int i=0;i<N;i++) {
					x=x+idx;
					map[x][y]=cnt;
					cnt++;
				}
				idx*=-1;
				if(N==0) break;
			}
			System.out.println("#"+tc);
			for(int i=0;i<map.length;i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}

		}//tc

	}//main

}
