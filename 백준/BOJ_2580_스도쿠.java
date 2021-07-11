package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {

	static int[][] map = new int[9][9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			for(int j=0;j<9;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		DFS(0,0);
	}
	public static boolean check(int row, int col, int value) {
		for(int i=0;i<9;i++) {
			if(map[row][i]== value)
				return false;
		}
		for(int i=0;i<9;i++) {
			if(map[i][col] ==value)
				return false;
		}
		int r = (row/3)*3;
		int c = (col/3)*3;
		
		for(int i=r;i<r+3;i++) {
			for(int j=c;j<c+3;j++) {
				if(map[i][j]==value)
					return false;
			}
		}
		return true;
	}
	
	public static void DFS(int row, int col) {
		if(col ==9) {
			DFS(row +1,0);
			return;
		}
		if(row ==9) {
			StringBuilder output = new StringBuilder();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					output.append(map[i][j]+ " ");
				}
				output.append("\n");
			}
			System.out.println(output);
			System.exit(0);
		}
		if(map[row][col]==0) {
			for(int i=1;i<=9;i++) {
				if(check(row,col, i)) {
					map[row][col] = i;
					DFS(row, col+1);
				}
			}
			map[row][col]=0;
			return;
		}
		DFS(row,col +1);
	}
}