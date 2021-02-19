package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가_만든_맛있는_음식 {
	static int N;
	static int[][] info;

	static int result = Integer.MAX_VALUE; // 맛의 차이
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		info = new int[N][2];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			info[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			info[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}
		// 재료 선택 (부분집합)
		cook(0, 1, 0);
		System.out.println(result);
	}// main

	public static void cook(int cnt, int sin, int sseun) {
		if (cnt == N) {
			if(sin==1&&sseun==0)return;
			if (result > Math.abs(sin - sseun)) {
				//System.out.print(sin+ "--" + sseun+"\n");
				result = Math.abs(sin - sseun);
			}
			return;
		}

		else {

			cook(cnt + 1, sin * info[cnt][0], sseun + info[cnt][1]);

			cook(cnt + 1, sin, sseun);
		}

	}

}
