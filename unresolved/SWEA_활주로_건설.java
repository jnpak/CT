import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_활주로_건설 {

	static int N, X;
	static int[][] map;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(input.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			//검사
			int cnt=0;
			for(int i=0;i<N;i++) {
				if(col_check(i)) {
					cnt++;
				}
				if(row_check(i)) {
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt + "\n");
		} // tc
	}// main

	public static boolean col_check(int num) {
		int cur = 0, prv = 0;
		int point = 0;
		cur = map[num][0];
		point++;
		for (int i = 1; i < N; i++) {
			prv = cur;
			cur = map[num][i];
			if (prv < cur) { // 이전 높이 보다 현재 높이가 클 때 (높이가 커질 때)
				if(prv+1 != cur) return false;
				if (point >= X) { // 이전의 point(같은높이의길이) 경사로를 설치할 수 있는 길이 X와 같거나 클 때
					point = 1; // point를 1로 만들고 진행
					continue;
				} else
					return false;
			} else if (prv > cur) { // 이전 높이 보다 현재 높이가 작을 때 (높이가 줄어들 때)
				if(prv -1 != cur) return false;
				for (int j = 1; j <= X - 1; j++) { // 뒤칸의 높이들 검사 1칸 뒤부터 X-1칸까지
					if (i + j >= N)
						return false; // 맵을 벗어난다면 false
					if (cur == map[num][i + j])
						continue; // 현재 높이가 뒤칸과 같으면 통과
					else
						return false; // 아니면 리턴 false
				}
				i += X-1; // 검사를 마치고 인덱스를 X-1만큼 뒤로
				point = 0;	
			} else {
				point++;
			}
		}
		return true;
	}
	public static boolean row_check(int num) {
		int cur = 0, prv = 0;
		int point = 0;
		cur = map[0][num];
		point++;
		for (int i = 1; i < N; i++) {
			prv = cur;
			cur = map[i][num];
			if (prv < cur) { // 이전 높이 보다 현재 높이가 클 때 (높이가 커질 때)
				if(prv+1 != cur) return false;
				if (point >= X) { // 이전의 point(같은높이의길이) 경사로를 설치할 수 있는 길이 X와 같거나 클 때
					point = 1; // point를 1로 만들고 진행
					continue;
				} else
					return false;
			} else if (prv > cur) { // 이전 높이 보다 현재 높이가 작을 때 (높이가 줄어들 때)
				if(prv -1 != cur) return false;
				for (int j = 1; j <= X - 1; j++) { // 뒤칸의 높이들 검사 1칸 뒤부터 X-1칸까지
					if (i + j >= N)
						return false; // 맵을 벗어난다면 false
					if (cur == map[i+j][num])
						continue; // 현재 높이가 뒤칸과 같으면 통과
					else
						return false; // 아니면 리턴 false
				}
				i += X-1; // 검사를 마치고 인덱스를 X-1만큼 뒤로
				point = 0;
			} else {
				point++;
			}
		}
		return true;
	}
}
