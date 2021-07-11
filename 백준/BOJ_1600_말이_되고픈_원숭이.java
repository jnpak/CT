package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이_되고픈_원숭이 {

	static int K, W, H, result = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] hx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static class Node {
		int x, y, k, c;

		public Node(int x, int y, int k, int c) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.c = c;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(input.readLine());
		StringTokenizer st = new StringTokenizer(input.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0][0][K] = true;
		BFS();
	}

	public static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0, 0, K, 0));
		while (!q.isEmpty()) {
			Node n = q.poll();

			if (n.x == H - 1 && n.y == W - 1) {
				System.out.println(n.c);
				return;
			}

			if (n.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = n.x + hx[i];
					int ny = n.y + hy[i];
					if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 1 || visited[nx][ny][n.k])	continue;
					visited[nx][ny][n.k-1] = true;
					q.add(new Node(nx, ny, n.k - 1, n.c + 1));
				}
			}
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 1 || visited[nx][ny][n.k]) continue;
				visited[nx][ny][n.k] = true;
				q.add(new Node(nx, ny, n.k, n.c + 1));
			}
		}
		System.out.println("-1");
		return;
	}

}
