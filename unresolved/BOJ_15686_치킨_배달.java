package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Ck {
	int x, y;

	public Ck(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_15686_ġŲ_��� {
	static int N, M, idx=0; // N ũ��, �ִ� ġŲ�� M
	static int[][] map; // NxN ��
	static int[][] copy;
	static int result;
	
	static Ck[] list = new Ck[13]; // �ִ� ġŲ�� 13��
	static Ck[] comb = new Ck[13]; // M���� ��

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// ���� �Է�
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list[idx++]= new Ck(i,j);
					map[i][j] = 0;
				}
			}
		}
		
		
		//�� ���� -> ī�ǹ迭�� <- ����

		System.out.println();

	}// main
	
	private static void Combination(int cnt, int start) {
		if(cnt == M) {
			
			
		}else { // 
			for(int i=start;i<N;i++) {
				comb[cnt]=list[i];
				Combination(cnt+1,i+1);
			}
		}
	}
	
	//�Ÿ� ���
	private static int calc() {
		int min,sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copy[i][j]==1) { // ���� Ž���ϴٰ� 1�� ��ġ�� �� ġŲ�� ���� �迭�� �Ÿ����� ��� ����� �� 
					min=Integer.MAX_VALUE;
					for(int k=0;k<M;k++) {  //  ���� ���� ���� min ������
						min = Math.min(min,Math.abs(i-comb[k].x)+Math.abs(j-comb[k].y));
					}
					sum += min;
				}
			}
		}
		
	return sum;	
	}
}
