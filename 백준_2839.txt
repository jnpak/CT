//백준_2839
 
#include <stdio.h>

int solution(int n) {

	int mok5, mok3 = 0, na5, na3;

	mok5 = n / 5; // 5로 나눈몫
	na5 = n % 5; // 5로 나눈 나머지

	while (na5 != 0) { // 나머지가 0이 아니면
		mok3 = na5 / 3; // 나머지를 3으로 나눔
		na3 = na5 % 3; // 3으로 나눈 나머지

		if (na3 == 0) { // 나머지가 0이면
			break;
		}
		else
		{
			na5 += 5; // 5의 몫을 1 줄이고 나머지에 값 5를 추가
			mok5--;
			if (mok5 == -1) { //5의몫이 -1이면 리턴 -1
				return -1;
			}
		}
	}

	return mok5 + mok3;
}

int main() {
	int N;

	scanf("%d", &N);

	printf("%d", solution(N));
}

// 그리드