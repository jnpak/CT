package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_2805_농작물_수확하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(input.readLine());
			int[][] map = new int[N][N];
			for(int i=0;i<N;i++) {
				String str = input.readLine();
				for(int j=0;j<N;j++) {
					map[i][j]=str.charAt(j)-'0';
				}
			}
			//System.out.println(Arrays.deepToString(map));
			int sum=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i+j<N/2)continue;         //좌상
					else if(j-i>N/2) continue;   //우상
					else if(i-j>N/2) continue;   //좌하
					else if(i+j>N/2*3) continue; //우하
					else sum+=map[i][j]; 
				}
			}
			output.append("#"+tc+" "+sum+"\n");
		}//tc
		System.out.println(output);
	}//main

}
