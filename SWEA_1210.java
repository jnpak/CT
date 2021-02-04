package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1210 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int a = 0;
		int[][] map = new int[100][100];

		for (int tc = 1; tc <= 10; tc++) {
			a = Integer.parseInt(input.readLine());

			for (int i = 0; i < 100; i++) {
				String[] str = input.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}

			int x = 99;// 시작좌표의 x
			int y = 0;// 시작좌표의 y

			for (int i = 0; i < 100; i++) {
				if (map[99][i] == 2)
					y = i;
			}

			while (x >0) { 
				//오른쪽
				if((y+1<100)&&map[x][y+1]==1) {
					do {
						y++;
					}while((y+1<100)&&map[x][y+1]==1);
				}
				//왼쪽
				else if((y-1>=0)&&map[x][y-1]==1) {
					do {
						y--;
					}while((y-1>=0)&&map[x][y-1]==1);
				}
				//위로이동
				x--;
			}
			output.append("#").append(tc).append(" ").append(y).append("\n");
		} // tc
		System.out.println(output);
	}// main

}
