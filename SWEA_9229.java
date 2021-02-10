package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
//SWEA_9299_한빈이와 Spot Mart
public class SWEA_9229 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] snack = new int[N];
			ArrayList<Integer> al = new ArrayList<>();
			
			st = new StringTokenizer(input.readLine());
			for(int i =0;i<N;i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j) continue;
					else {
						int sum=snack[i]+snack[j];
						if(sum <=M) {
							al.add(sum); // 무게의 합이 가능한 합을 리스트에 저장
							
						}
					}
				}
			}
			Collections.sort(al, Collections.reverseOrder()); //리스트 내림차순
			output.append("#").append(tc).append(" ");
			if(al.size() ==0) output.append(-1).append("\n"); //무게가 안된다면 -1 리턴
			else output.append(al.get(0)).append("\n"); //첫번째 인덱스가 가장 높은 무게의 합
		}//tc
		System.out.println(output);
	}//main

}
