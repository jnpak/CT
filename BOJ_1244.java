package coding;

import java.util.Scanner;

public class BOJ_1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] status = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			status[i] = sc.nextInt();
		}

		int t = sc.nextInt();

		while (t-- > 0) {
			int sex = sc.nextInt();
			int idx = sc.nextInt();

			if (sex == 1) {
				for (int i = idx; i <= n; i += idx) {
					if (status[i] == 0)
						status[i] = 1;
					else
						status[i] = 0;
				}
			} else {
				if ((idx == 1 || idx == n) || status[idx - 1] != status[idx + 1]) {
					status[idx] = status[idx] == 0 ? 1 : 0;
				} else {
					int left = idx - 1;
					int right = idx + 1;
					status[idx] = status[idx] == 0 ? 1 : 0;
					while (left > 0 && right <= n) {
						if (status[left] == status[right]) {
							if (status[left] == 0)
								status[left] = 1;
							else
								status[left] = 0;
							if (status[right] == 0)
								status[right] = 1;
							else
								status[right] = 0;
							--left;
							++right;
						} else {
							break;
						}
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(status[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}

	}

}
