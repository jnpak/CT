package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17521 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(st.nextToken());
		long seed = Integer.parseInt(st.nextToken());
		int[] value = new int[n];
		for (int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(input.readLine());
		}
//		for(int v : value) {
//			System.out.print(v+ " ");
//		}
		long coin = 0;
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				if (coin > 0) {
					seed += coin * value[i];
					coin = 0;
				}
			} else {
				if (value[i] < value[i + 1]) {
					if (coin == 0) {
						coin += seed / value[i];
						seed -= coin * value[i];
					}
				} else {
					if (coin > 0) {
						seed += coin * value[i];
						coin = 0;
					}

				}
			}
//			System.out.println(i+": "+seed);
		}
		System.out.println(seed);

	}// main

}
