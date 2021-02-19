package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int[] dx= {-1,1,0,0,};
	static int[] dy= {0,0,-1,1};
	
	static char[][] map;
	static int R,C,max=0;
	static boolean[] check;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {

		//초기화
		StringTokenizer st = new StringTokenizer(input.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map = new char[R][];
		check=new boolean[26];
		
		//입력
		for(int i=0;i<R;i++) {
			map[i]=input.readLine().toCharArray();
		}
		
		DFS(0,0,1);
		System.out.println(max);
		
	}//main
	public static void DFS(int x,int y,int cnt) {

		check[map[x][y]-'A']=true;
		for(int i=0;i<4;i++) {
			int nx= x+ dx[i];
			int ny=y+dy[i];
			if(nx<0||nx>=R||ny<0||ny>=C)continue;
			if(!check[map[nx][ny]-'A']) {
				DFS(nx,ny,cnt+1);
			}
		}
		check[map[x][y]-'A']=false;
		max = Math.max(max, cnt);
		
		
	}

}
