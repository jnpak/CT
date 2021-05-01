package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
	static int[][] nums; // 1번 ~ 9번 선수들의 기록
	static int[] order; // 타순
	static boolean[] isSelected;
	static int max_score = Integer.MIN_VALUE;

	static int N;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = null;
		N = Integer.parseInt(input.readLine());
		nums = new int[N + 1][10];
		order = new int[10];
		isSelected = new boolean[10];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 1; j <= 9; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		order[1] = 4;
		// 순서정하기
		perm(2);
		System.out.println(max_score);
	}

	private static void perm(int cnt) {
		if (cnt == 10) {

			max_score = Math.max(max_score, game(order));
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (isSelected[i])
				continue;
			if( i== 4) continue;
			order[cnt] = i;
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}

	}

	private static int game(int[] order) {

		int score = 0; //스코어
		int time = 0; //이닝
		int idx = 1; //인덱스

		while (time++ != N) {
			int[] record = new int[10];
			for(int i=1;i<=9;i++) {
				// 1번선수의 위치 => order[1] - 4 record[4]번 타자의 기록을 nums[이닝][1번선수]
				record[order[i]] = nums[time][i];
			}
			
			// game
			int out = 3;
			int[] arr = new int[5]; // 1,2,3루,홈
			while(true) {
				// 안타, 2루타, 3루타, 홈런, 아웃
				int hit = record[idx++]; 
				
				if(hit == 1) {
					if(arr[3]==1) {arr[4]++; arr[3]=0;}
					if(arr[2]==1) {arr[3]=1; arr[2]=0;}
					if(arr[1]==1) {arr[2]=1; arr[1]=0;}
					arr[1] = 1;
				}else if(hit == 2) {
					if(arr[3]==1) {arr[4]++; arr[3]=0;}
					if(arr[2]==1) {arr[4]++; arr[2]=0;}
					if(arr[1]==1) {arr[3]=1; arr[1]=0;}
					arr[2] = 1;					
				}else if(hit == 3) {
					if(arr[3]==1) {arr[4]++; arr[3]=0;}
					if(arr[2]==1) {arr[4]++; arr[2]=0;}
					if(arr[1]==1) {arr[4]++; arr[1]=0;}
					arr[3] = 1;
				}else if(hit == 4) {
					if(arr[3]==1) {arr[4]++; arr[3]=0;}
					if(arr[2]==1) {arr[4]++; arr[2]=0;}
					if(arr[1]==1) {arr[4]++; arr[1]=0;}
					arr[4]++;
				}else {
					out--; 
				}// 3 + 8 + 8 +
				score += arr[4]; // 홈에 들어온 사람 수만큼 +
				arr[4]=0;
				if(idx == 10) idx = 1;
				if(out==0) break; // 아웃 세개면 break
			}
		}
		return score;
	}

}
