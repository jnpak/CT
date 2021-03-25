package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int col, row;
	static int[][] map;
	static boolean[][] visited;
	static int num;

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		
		

		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		while(check()) {
			visited = new boolean[col][row];
			cnt++;
			DFS(0,0);
			count();
			mark();
			melt();	
		}
		
		System.out.println(cnt);
		System.out.println(num);

	}

	//공기 표시
	public static void DFS(int x, int y) {
		visited[x][y]=true;
		
		for(int i =0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0&&ny>=0&&nx<col&&ny<row&&map[nx][ny]==0&&!visited[nx][ny]) {
				DFS(nx,ny);
			}
		}
		
	}
	
	public static void mark() {
		for(int i=0;i<col;i++) {
			for(int j=0;j<row;j++) {
				if(!visited[i][j]) {
					boolean flag=false;
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(nx>=0&&ny>=0&&nx<col&&ny<row&&visited[nx][ny]) flag=true;
						
					}
					if(flag) map[i][j]=2;
				}
			}
		}
	}

	public static void melt() {
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (map[i][j] == 2)
					map[i][j] = 0;
			}
		}
	}

	public static boolean check() {
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (map[i][j] == 1)
					return true;
			}
		}
		return false;
	}
	
	public static void count() {
		int cnt=0;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}
		num=cnt;
	}
}
