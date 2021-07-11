package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1859_백만_장자_프로젝트 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {

			// 초기화,입력
			int N = Integer.parseInt(input.readLine());
			int[] price = new int[N];
			StringTokenizer st = new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			//
			long profit=0; // 최대이익
			Stack<Integer> s = new Stack<>();
			int max = Integer.MIN_VALUE; // 현재 최대값
			for (int i = N-1; i >= -1; i--) {
				//System.out.print("+"+i+"+");
				if (i==-1) {
					while(!s.isEmpty()) {
						profit+=Math.abs(max-s.peek());
						//System.out.print("profit:" +profit);
						s.pop();
					}
				}else if (price[i] > max) {
					while(!s.isEmpty()) {
						profit+=Math.abs(max-s.peek());
						//System.out.print("profit:" +profit);
						s.pop();
					}
					max = price[i];
				} else {
					s.add(price[i]);

				}

			}
			output.append("#" + tc + " " + profit + "\n");

		} //tc
		System.out.println(output);
	}

}
