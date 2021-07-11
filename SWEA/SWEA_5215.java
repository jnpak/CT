package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_5215 {

	static int[][] info = new int[20][2]; // 점수, 칼로리 저장 배열
	static boolean[] selected;
	static int max_cal = 0; // 최대 칼로리
	static int N = 0; // 재료 개수
	static int max_result = 0;

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) { // 테스트케이스
			StringTokenizer st = new StringTokenizer(input.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			max_cal = Integer.parseInt(st.nextToken()); // 제한 칼로리

			// 1번 실패
//			double[][] info = new double[N][3]; // 점수, 칼로리, 칼로리 당 점수 정보 저장 배열
//			for(int i=0;i<N;i++) {
//				st = new StringTokenizer(input.readLine());
//				info[i][0]=Integer.parseInt(st.nextToken());
//				info[i][1]=Integer.parseInt(st.nextToken());
//				info[i][2]=(double)info[i][0]/info[i][1];
//			}
//			
//			//칼로리 당 점수가 높은 순으로 정렬
//			Arrays.sort(info, new Comparator<double[]>() {
//				public int compare(double[] t1, double[] t2) {
//					if(t1[2]==t2[2]) return Double.compare(t1[1],t2[1]); //점수가 같다면 칼로리가 낮은순으로
//					return Double.compare(t2[2],t1[2]);
//				}
//			});
//			
//			//출력		
//			for(int i=0;i<N;i++) {
//				System.out.println(info[i][0] + " " + info[i][1] + " " + info[i][2]);
//			}
//			
//			int result=0;  // 현재 점수
//			int cur_cal=0; // 현재 칼로리
//			for(int i=0;i<N;i++) {
//				if(cur_cal+info[i][1]<=cal) { //현재 칼로리가 제한 칼로리보다 낮다면 추가
//					cur_cal+=info[i][1]; //칼로리 추가
//					result+=info[i][0]; //점수 추가
//				}
//				else {}
//			}			
//			

			// 2번 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(input.readLine());
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = Integer.parseInt(st.nextToken());
			}
			int idx =0;
			max_result=find(idx, 0, max_cal);

			output.append("#").append(tc).append(" ").append(max_result).append("\n");
		} // tc
		System.out.println(output);
	}// main

	public static int find(int idx, int score, int remain) {
		if(remain<0) {
			return 0;
		}
		if(remain==0) {
			return score;
		}
		if(idx == info.length) {
			return score;
		}
		
		int v1 = find(idx+1, score, remain);
		int v2 = find(idx+1, score+ info[idx][0], remain-info[idx][1]);
		return Math.max(v1, v2);
	}
}
