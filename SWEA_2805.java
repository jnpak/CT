package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(input.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = input.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int result = 0;
			
			// 수확
			// 정사각형에서 i=j 인 부분을 제외하고 왼쪽 밑은 i가 j보다 크고 이고 오른쪽 위는 i보다 j가 더 크다
			// N/2 를 하면 나머지가 없어 0부터 시작하는 인덱스에서 중간 값은 N/2 이다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i <= N / 2)// 위쪽 영역
					{
						if (i + j <= N / 2 - 1)// 왼쪽 위 부분은 i+j를 더했을 때 중간 값에서 -1 한 값보다 작거나 같다
						{
						} else if (j - i >= N / 2 + 1) // 오른쪽 위 부분은 j가 항상 i보다 큰 영역이며 j-i 한 값은 중간값에서 +1 과 같거나 크다
						{
						} else {
							result += map[i][j];
						}
					} else if (i > N / 2) // 아래쪽 영역
					{
						if (i - j >= N / 2 + 1) // 왼쪽 밑
						{
						} else if (i + j >= N / 2 * 3 + 1)// 오른쪽 밑
						{
						} else {
							result += map[i][j];
						}
					}
				}
			}
			output.append("#").append(tc).append(" ").append(result).append("\n");
		} // tc
		System.out.println(output);
	}// main

}
