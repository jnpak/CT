import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범_검거 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, M, L;
	static int[][] map;
	static boolean[][] visited;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(input.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝

			BFS(R, C);

			// check
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j])
						cnt++;
				}
			}
			output.append("#" + tc + " " + cnt + "\n");
		} // tc
		System.out.println(output);
	}// main

	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		visited[r][c] = true;
		L--;
		q.add(new int[] { r, c });
		
		while (L-- > 0) {

			int num = q.size();
			while (!q.isEmpty()) {
				if (num == 0)
					break;
				num--;
				int x = q.peek()[0];
				int y = q.peek()[1];
				q.poll();
				int type = map[x][y];
				boolean[] flag = new boolean[4];// 1 상 2 하 3 좌 4 우 true -> 못감
				switch (type) {
				case 1:
					break;
				case 2:
					flag[2] = true;
					flag[3] = true;
					break;
				case 3:
					flag[0] = true;
					flag[1] = true;
					break;
				case 4:
					flag[1] = true;
					flag[2] = true;
					break;
				case 5:
					flag[0] = true;
					flag[2] = true;
					break;
				case 6:
					flag[0] = true;
					flag[3] = true;
					break;
				case 7:
					flag[1] = true;
					flag[3] = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					if (flag[i])
						continue;
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]&&map[nx][ny]!=0) {
						if(i==0) { //이동방향이 위쪽
							if(map[nx][ny]==3||map[nx][ny]==4||map[nx][ny]==7) continue;
						}else if(i==1) {//이동방향이 아래쪽
							if(map[nx][ny]==3||map[nx][ny]==5||map[nx][ny]==6) continue;
						}else if(i==2) {//이동방향이 왼쪽
							if(map[nx][ny]==2||map[nx][ny]==6||map[nx][ny]==7) continue;
						}else {//이동방향이 오른쪽
							if(map[nx][ny]==2||map[nx][ny]==4||map[nx][ny]==5) continue;
						}
						visited[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
				}

			}

		}
	}

}
