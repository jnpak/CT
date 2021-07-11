import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이_판다 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int n,map[][],dp[][];
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		n = Integer.parseInt(input.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(input.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				max = Math.max(max, DFS(i,j));
			}
		}
		System.out.println(max);
	}
	private static int DFS(int x, int y) {
		if(dp[x][y] != 0) return dp[x][y];
		
		dp[x][y] = 1;
		
		int nx, ny;
		for(int i=0;i<4;i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			
			// 현재 위치의 대나무 보다 더 많은 대나무가 있을 경우
			if(map[x][y] < map[nx][ny]) {
				//현재의 생존일 수 는 현재길에서 다른길로 갔을 때 생존일 수 보다 새로 개척한 생존일 수가
				// 더 크다면 그방향으로의 DFS 값 + 1 을 현재의 생존일 수로 교체
				dp[x][y] = Math.max(dp[x][y], DFS(nx,ny) + 1);
				DFS(nx,ny);
			}
		}
		return dp[x][y];
		
	}

}
