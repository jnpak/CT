package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_����_��� {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		System.out.println(sol(N));
	}
	public static int sol(int n) {
		int mok5,mok3=0,na5,na3;
		
		// �Է� N�� 5�� ������ ��� �������� ����
		mok5=n/5;
		na5=n%5;
		
		while(na5!=0) { //
			// �������� 3���� ������ ��� �������� ����
			mok3=na5/3;
			na3=na5%3;
			
			if(na3 == 0)break;
			else {
				na5 +=5; // na5�� 5�� ���ϰ�
				mok5--;  // 5�� ���� ���� 1 ���ҽ�Ŵ
				if(mok5 == -1) {
					return -1; // 5�� ���� ���µ� ���ҽ����� �� -1
				}
			}
		}
		return mok5+mok3;
	}
}
