import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7579_앱 { // 배낭문제
	static class app implements Comparable<app> {
		int memory, cost;
		float rate;

		public app(int memory, int cost) {
			this.memory = memory;
			this.cost = cost;
			this.rate = (float) memory / (float) (cost + 0.0001f);
		}

		@Override
		public int compareTo(app o) {
			return (int) (o.rate - this.rate);
		}

	}

	static int N, M;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		app[] ap = new app[N];

		// app 입력
		st = new StringTokenizer(input.readLine());
		StringTokenizer st2 = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			ap[i] = new app(a, b);
		}

		Arrays.sort(ap);

		int cur_memory = 0;
		int cost = 0;
		boolean[] isSelected = new boolean[N];
		while (true) {
			if(cur_memory > M) break;
			for (int i = 0; i < N; i++) {
				if (ap[i].memory < (M - cur_memory) && !isSelected[i]) {
					isSelected[i] = true;
					cur_memory += ap[i].memory;
					cost += ap[i].cost;
				}
			}
		}
		System.out.println(cost);

	}

}
