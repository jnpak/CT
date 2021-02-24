package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1859_�鸸_����_������Ʈ {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {

			// �ʱ�ȭ,�Է�
			int N = Integer.parseInt(input.readLine());
			int[] price = new int[N];
			StringTokenizer st = new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			//
			long profit=0; // �ִ�����
			Stack<Integer> s = new Stack<>();
			int max = Integer.MIN_VALUE; // ���� �ִ밪
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
