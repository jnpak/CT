import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2115_갤러리 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][][] visited;
	static int M, N, count;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visited = new boolean[M][N][4];
		for (int i = 0; i < M; i++) {
			String str = input.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				if (map[i][j] == '.')
					check(i, j);
		}

		System.out.println(count);
	}

	private static void check(int x, int y) {
		// 0상 1하 2좌 3우
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= M || ny >= N)
				continue; // 범위 밖
			if (map[nx][ny] == 'X')
				continue; // 벽이면

			if (i == 0 || i == 1) {// 위쪽이나 아래쪽 방향
				if (!visited[nx][ny][2] && !visited[x][y][2] && map[x][y - 1] == 'X' && map[nx][ny - 1] == 'X') { // 왼쪽에
																													// 그림
																													// 없고
																													// 벽이면
					visited[nx][ny][2] = true;
					visited[x][y][2] = true;
					count++;
				}
				if (!visited[nx][ny][3] && !visited[x][y][3] && map[x][y + 1] == 'X' && map[nx][ny + 1] == 'X') { // 오른쪽에
																													// 그림
																													// 없고
																													// 벽이면
					visited[nx][ny][3] = true;
					visited[x][y][3] = true;
					count++;
				}
			} else {
				if (!visited[nx][ny][0] && !visited[x][y][0] && map[x - 1][y] == 'X' && map[nx - 1][ny] == 'X') { // 위쪽에
																													// 그림
																													// 없고
																													// 벽이면
					visited[nx][ny][0] = true;
					visited[x][y][0] = true;
					count++;
				}
				if (!visited[nx][ny][1] && !visited[x][y][1] && map[x + 1][y] == 'X' && map[nx + 1][ny] == 'X') { // 아래쪽에
																													// 그림
																													// 없고
																													// 벽이면
					visited[nx][ny][1] = true;
					visited[x][y][1] = true;
					count++;
				}
			}
		}
	}

}