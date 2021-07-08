import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프_옮기기_1 {
	static int N, map[][], cnt = 0;

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0, 1, 0);
		System.out.println(cnt);
	}

	private static void DFS(int x, int y, int state) {
		if (x == N - 1 && y == N - 1) {
			cnt++;
			return;
		}
		// 가로 상태 가로 이동
		if (state == 0 && y + 1 < N && map[x][y + 1] == 0) {
			DFS(x, y + 1, 0);
		}
		// 세로 상태 세로 이동
		if (state == 1 && x + 1 < N && map[x + 1][y] == 0) {
			DFS(x + 1, y, 1);
		}
		// 대각선 상태 가로이동
		if (state == 2 && y + 1 < N && map[x][y + 1] == 0) {
			DFS(x, y + 1, 0);
		}
		// 대각선 상태 세로이동
		if (state == 2 && x + 1 < N && map[x + 1][y] == 0) {
			DFS(x + 1, y, 1);
		}
		// 대각선이동
		if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
			DFS(x + 1, y + 1, 2);
		}
	}
}
