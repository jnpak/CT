package coding;

import java.util.Scanner;

class SWEA1289 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			String memory = sc.nextLine();

			int prevnum = 0;
			int cnt = 0;
			for (int i = 0; i < memory.length(); i++) {
				int num = memory.charAt(i) - '0';
				if (num == prevnum)
					continue;
				else {
					cnt++;
					prevnum = num;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}