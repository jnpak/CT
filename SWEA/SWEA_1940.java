package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1940 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(input.readLine()); // 명령 개수
			int loc =0; // 이동거리
			int cur_speed =0; // 현재속력
			for(int i=0;i<N;i++) { //command N개
			StringTokenizer st = new StringTokenizer(input.readLine());
			int command = Integer.parseInt(st.nextToken());
				if(command ==1) {
					int speed =Integer.parseInt(st.nextToken());
					cur_speed+=speed;
					loc+=cur_speed;
				}else if(command==2){
					int speed =Integer.parseInt(st.nextToken());
					cur_speed-=speed;
					if(cur_speed<0)cur_speed=0;
					loc+=cur_speed;
				}else {
					loc+=cur_speed;
				}
			}
			output.append("#").append(tc).append(" ").append(loc).append("\n");
		}//tc
		System.out.println(output);
	}//main

}
