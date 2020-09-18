#include <stdio.h>

int main() {
	double wav;	
	long long int h, b, c, s;
	scanf("%lld %lld %lld %lld", &h, &b, &c, &s);
	wav = h * b * c * s;
	printf("%.1lf MB", wav/(8*1024*1024));

	return 0;
}

// h * b * c * s 곱할 때 int선언하면 오버플로우되어 오류