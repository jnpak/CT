package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158_개미 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		int w = Integer.parseInt(st.nextToken());   //넓이
		int h = Integer.parseInt(st.nextToken());   //높이
		st = new StringTokenizer(input.readLine());
		int p = Integer.parseInt(st.nextToken());   //현재 x위치
		int q = Integer.parseInt(st.nextToken());   //현재 y위치
		int t = Integer.parseInt(input.readLine()); //이동횟수
		p=w-Math.abs(w-(p+t)%(w*2));
		q=h-Math.abs(h-(q+t)%(h*2));
		System.out.println(p+" "+ q);
	}
}
