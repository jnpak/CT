package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9207_페그_솔리테어 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static int min_num, min_time;

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());

		map = new char[5][9];
		for (int tc = 1; tc <= N; tc++) {
			for (int i = 0; i < 5; i++) {
				String str = input.readLine();
				for (int j = 0; j < 9; j++) {
					map[i][j] = str.charAt(j);

				}
			}

			if (tc != N)
				input.readLine();

			min_num = Integer.MAX_VALUE;
			min_time = Integer.MAX_VALUE;
			DFS(0);
			System.out.println(min_num + " " + min_time);
		} // tc
	}// main

	private static void DFS(int cnt) {
		boolean flag = false;

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 9; c++) {
				if (map[r][c] == 'o') {
					int x = r;
					int y = c;

					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						int nxx = x + dx[i] * 2;
						int nyy = y + dy[i] * 2;
//			System.out.println("x : " + x + " y : " +y);
//			System.out.println("nx : " + nx + " y : " +ny);
//			System.out.println("nxx : " + nxx + " y : " +nyy);

						if (nxx >= 0 && nyy >= 0 && nxx < 5 && nyy < 9) {
							if (map[nx][ny] == 'o' && map[nxx][nyy] == '.') {
								flag = true;

								map[x][y] = '.';
								map[nx][ny] = '.';
								map[nxx][nyy] = 'o';
								DFS(cnt + 1);
								map[nxx][nyy] = '.';
								map[nx][ny] = 'o';
								map[x][y] = 'o';

							}
						}
					}
				}
			}
		}
		if (!flag) {
			int num = 0;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 9; j++) {
					if (map[i][j] == 'o')
						num++;
				}
			}
			if (min_num > num) {
				min_num = num;
				min_time = cnt;
			} else if (min_num == num && min_time > cnt) {
				min_time = cnt;
			}
		}
		return;
	}

}
