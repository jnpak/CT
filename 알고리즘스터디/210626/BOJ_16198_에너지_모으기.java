package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16198_에너지_모으기 {
	static int N,max =Integer.MIN_VALUE;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		StringTokenizer st = new StringTokenizer(input.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		DFS(list, 0);
		System.out.println(max);
	}
	private static void DFS(ArrayList<Integer> list, int sum) {
		//요소 2개 남으면 종료
		if(list.size()==2) {
			if(max < sum) {
				max = sum;
			}
			return;
		}
		// 1번째 인덱스 부터 마지막 앞 인덱스 for문
		for(int i=1; i<list.size()-1; i++) {
			int tmp = list.get(i);
			int result = list.get(i-1) * list.get(i+1);
			
			//i인덱스 제거
			list.remove(i);
			//제거한 리스트로 다시 DFS
			DFS(list, sum + result);
			//제거했던 요소 추가
			list.add(i, tmp);
		}
		
	}

}
