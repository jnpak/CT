//CodeUp-1099 : https://codeup.kr/problem.php?id=1099

#include <stdio.h>

int main() {
	int i, j, x = 2, y = 2;
	int map[11][11] = { };

	for (i = 1; i <= 10; i++) {
		for (j = 1; j <= 10; j++) {
			scanf("%d", &map[i][j]);
		}
	}
	while (map[x][y] != 2) 
	{
		map[x][y] = 9;
		if (map[x][y + 1] != 1)  y += 1; 
		else if (map[x + 1][y] != 1)  x +=1 ; 
		else  break;
	}
	map[x][y] = 9;
	for (i = 1; i <= 10; i++) {
		for (j = 1; j <= 10; j++) {
			printf("%d" ,map[i][j]);
		}
		printf("\n");
	}
	return 0;
}

// break; 문을 되도록 안쓰려고 했는데 break; 를 써야 루프를 나오는게 효율적
// break; 사용이 좋은건지 의문?