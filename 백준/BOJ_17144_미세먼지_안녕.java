import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지_안녕 {

	static int x_vacumm;
	static int R, C, T;

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) { 
					x_vacumm = i; // 아래쪽 공기청정기 위치
				}
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();
		
		while (T-- > 0) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(map[i][j]>=5) {
						q.add(new int[] { i, j, map[i][j] });
						map[i][j] = 0;						
					}
				}
			}
			
			while (!q.isEmpty()) {
				int x= q.peek()[0];
				int y=q.peek()[1];
				int value=q.peek()[2];
				int amount = value/5;

				q.poll();
				for(int i=0;i<4;i++) {
					int nx = x+ dx[i];
					int ny = y +dy[i];
					if(nx>=0&&ny>=0&&nx<R&&ny<C&&map[nx][ny]>=0) {
						map[nx][ny]+=amount;
						value-=amount;
					}
				}
				map[x][y]+=value;
			}
			activate();
		}
		
		// 미세먼지양 계산
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>=1)sum+=map[i][j];
			}
		}
		System.out.println(sum);
	}

	private static void activate() {
		int top = x_vacumm-1;
		int down = x_vacumm; //아래쪽 공기청정기 x 좌표

		// 위 청소기
		for (int i = top - 1; i > 0; i--) {			//아래로
			map[i][0] = map[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) {			//왼쪽으로
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < top; i++) {			//위로
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {			//오른쪽으로
			map[top][i] = map[top][i - 1];
		}
		map[top][1]=0;
		// 아래 청소기
		for (int i = down + 1; i < R - 1; i++) {		//위로
			map[i][0] = map[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) {			//왼쪽으로
			map[R - 1][i] = map[R - 1][i + 1];
		}
		for (int i = R - 1; i > down; i--) {			//아래로
			map[i][C - 1] = map[i - 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {			//오른쪽으로
			map[down][i] = map[down][i - 1];
		}
		map[down][1]=0;
	}

}
