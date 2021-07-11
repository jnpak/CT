package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕_배달 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		System.out.println(sol(N));
	}
	public static int sol(int n) {
		int mok5,mok3=0,na5,na3;
		
		// 입력 N을 5로 나누고 몫과 나머지를 저장
		mok5=n/5;
		na5=n%5;
		
		while(na5!=0) { //
			// 나머지를 3으로 나누고 몫과 나머지를 저장
			mok3=na5/3;
			na3=na5%3;
			
			if(na3 == 0)break;
			else {
				na5 +=5; // na5에 5를 더하고
				mok5--;  // 5로 나눈 몫을 1 감소시킴
				if(mok5 == -1) {
					return -1; // 5의 몫이 없는데 감소시켰을 때 -1
				}
			}
		}
		return mok5+mok3;
	}
}
