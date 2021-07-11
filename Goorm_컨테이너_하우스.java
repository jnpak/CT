package solve;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Goorm_컨테이너_하우스 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, Comparator.comparing(Math::abs));

		int num = arr[arr.length - 1];
		boolean flag = true;
		if (num < 0)
			flag = false; // 음수
		else
			flag = true; // 양수

		int cnt = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (flag) {
				if (Math.abs(arr[i]) < Math.abs(num) && arr[i] < 0) {
					num = arr[i];
					flag = false;
					cnt++;
				}
			}else {
				if (Math.abs(arr[i]) < Math.abs(num) && arr[i] > 0) {
					num = arr[i];
					flag = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
}