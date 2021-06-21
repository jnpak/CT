import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];

		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (!visited[i][j] && map[i][j] == 1) // 익은 토마토 큐에 추가
					q.add(new int[] { i, j });
			}
		}

		int day = 0;
		while (check()) {
			day++; // 날짜 증가
			boolean flag = false;
			
			int num = q.size();
			while (!q.isEmpty()) {
				if(num==0)break;
				num--;
				flag = true; // 큐를 사용했을 때
				int x = q.peek()[0];
				int y = q.peek()[1];
				q.poll();
				visited[x][y] = true;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && map[nx][ny]==0) {
						visited[nx][ny]=true;
						map[nx][ny] = 1;
						q.add(new int[] {nx,ny});
					}
				}
			}
			if(!flag) {
				day= -1;
				break;
			}
		}
		
		System.out.println(day);
	}

	public static boolean check() { // 안익은 토마토가 있는지 체크 있으면 false
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					return true;
			}
		}
		return false;
	}
}
