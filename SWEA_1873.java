package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1873 {

	static char[][] map = new char[20][20];
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] HW = input.readLine().split(" ");
			int H = Integer.parseInt(HW[0]);
			int W = Integer.parseInt(HW[1]);

			// 맵 입력
			for (int i = 0; i < H; i++) {
				map[i] = input.readLine().toCharArray();
			}
			
//			// 맵 확인
//			for (char[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			
			int N = Integer.parseInt(input.readLine());
			char[] move = input.readLine().toCharArray();

			int x = 0, y = 0, dir = 0;

			// 전차 위치와 방향 찾기
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						if (map[i][j] == '^')
							dir = 0;
						if (map[i][j] == 'v')
							dir = 1;
						if (map[i][j] == '<')
							dir = 2;
						if (map[i][j] == '>')
							dir = 3;
						x = i;
						y = j;
						break;
					}
				}
			}

			// start
			map[x][y] = '.';// 전차의 시작위치를 평지로 만듬
			for (int i = 0; i < N; i++) {
				if (move[i] == 'S') {
					//System.out.println(1);
					shoot(x, y, dir, H, W);
				} else if (move[i] == 'U') {
					dir = 0;
					if (x - 1 >= 0 && map[x - 1][y] == '.')
						x--;
				} else if (move[i] == 'D') {
					dir = 1;
					if (x + 1 < H && map[x + 1][y] == '.')
						x++;
				} else if (move[i] == 'L') {
					dir = 2;
					if (y - 1 >= 0 && map[x][y - 1] == '.')
						y--;
				} else if (move[i] == 'R') {
					dir = 3;
					if (y + 1 < W && map[x][y + 1] == '.')
						y++;
				}
			}

			// 맵에 전차 위치 표시
			if (dir == 0)
				map[x][y] = '^';
			else if (dir == 1)
				map[x][y] = 'v';
			else if (dir == 2)
				map[x][y] = '<';
			else if (dir == 3)
				map[x][y] = '>';

			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		} // tc

	}// main

	static void shoot(int x, int y, int d, int H, int W) {

		while (true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= H || ny < 0 || ny >= W) break;
			if (map[nx][ny] == '#') break;
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
				break;
			}
			x = nx;
			y = ny;
		}
	}

}