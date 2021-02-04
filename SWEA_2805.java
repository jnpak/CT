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
			
			// ��Ȯ
			// ���簢������ i=j �� �κ��� �����ϰ� ���� ���� i�� j���� ũ�� �̰� ������ ���� i���� j�� �� ũ��
			// N/2 �� �ϸ� �������� ���� 0���� �����ϴ� �ε������� �߰� ���� N/2 �̴�
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i <= N / 2)// ���� ����
					{
						if (i + j <= N / 2 - 1)// ���� �� �κ��� i+j�� ������ �� �߰� ������ -1 �� ������ �۰ų� ����
						{
						} else if (j - i >= N / 2 + 1) // ������ �� �κ��� j�� �׻� i���� ū �����̸� j-i �� ���� �߰������� +1 �� ���ų� ũ��
						{
						} else {
							result += map[i][j];
						}
					} else if (i > N / 2) // �Ʒ��� ����
					{
						if (i - j >= N / 2 + 1) // ���� ��
						{
						} else if (i + j >= N / 2 * 3 + 1)// ������ ��
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
