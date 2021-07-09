package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_16236 {

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt(input.readLine());

		int[][] map = new int[N][N];
		LinkedList<Shark> q = new LinkedList<>(); // Ž���� Ž�� ť

		int size = 2;
		for (int i = 0; i < N; i++) {
			String[] str = input.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 9) {
					q.add(new Shark(i, j, size));
					map[i][j] = 0;
				}
			}
		}
		int eat = 0;
		int time = 0;
		// �˻�
		while (true) {
			LinkedList<Shark> fish = new LinkedList<>(); // ����⸦ ��� ť
			int[][] dist = new int[N][N]; // ����� ��ġ�κ��� �� ĭ�� �̵��Ÿ��� ��� �迭

			//������ ��� queue�� ä���ֱ� �� �� while��
			while (!q.isEmpty()) { // queue �� ������� ������ ����

				// queue �� ������ ��ǥ�� �Է�
				Shark s = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = s.x + dx[i];
					int ny = s.y + dy[i];

					// nx,ny <- ������ǥ

					// ��ǥ�� ���� ũ��ȿ� �ְ�, �̵��Ÿ��� ǥ������ �ʾҰ�, ����� ũ�� ���� �۴� -> �̵�����
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && dist[nx][ny] == 0 && map[nx][ny] <= size) {
						dist[nx][ny] = dist[s.x][s.y] + 1; // ������ �̵��Ÿ����� ��ĭ ����
						
						// 1~6 ������� ũ�� �̰�, �������� ũ�⺸�� �۴ٸ� -> �̵�����
						if (1 <= map[nx][ny] && map[nx][ny] <= 6 && map[nx][ny] < size) {
							fish.add(new Shark(nx, ny, dist[nx][ny])); // �����ť�� ����
							q.add(new Shark(nx, ny, dist[nx][ny])); // Ž�� ť�� ����
							continue;
						}
						q.add(new Shark(nx, ny, dist[nx][ny]));
					}
				}
			}
			// �������� ������ ����
			if (fish.size() == 0) {
				System.out.println(time);
				return;
			}
			Shark dFish = fish.get(0);
			
			//����� ť�� ù��° ��ġ�� �Է¹��� ��
			// ������ť�� �Ÿ��� ���� ª�� ����⸦ dFish�� �ִ´�
			for (int i = 1; i < fish.size(); i++) {
				if (dFish.dist > fish.get(i).dist) {
					dFish = fish.get(i);
				}

				//�Ÿ��� �����ϴٸ� ���� �켱�̱� ������ x���� �� ���� ����⸦ dFish�� �ִ´�
				if (dFish.dist == fish.get(i).dist) {
					if (dFish.x > fish.get(i).x) {
						dFish = fish.get(i);
						continue;
					} else if (dFish.x == fish.get(i).x) { // x���� ���ٸ� ���� �켱�̱� ������  y���� �� ���� ����⸦ �ִ´�
						if (dFish.y > fish.get(i).y)
							dFish = fish.get(i);
					}
				}
			}
			// ���� ������ ���� �� �ִ� ����⸦ ã����

			time += dFish.dist; //�̵��Ÿ���ŭ time�� �ø���
			eat++;
			map[dFish.x][dFish.y] = 0; // ���� ����� �ڸ� 0 ����
			
			//�ڱ� ������ ��ŭ �Ծ�� ������ ��
			if (eat == size) {
				size++;
				eat = 0;
			}
			q.add(new Shark(dFish.x, dFish.y, size)); // ���� ����� �ڸ��������� �ٽ� ����

		}

	}// main
}

class Shark {
	int x;
	int y;
	int dist;

	public Shark(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
