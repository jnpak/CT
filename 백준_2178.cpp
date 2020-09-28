//백준 2178
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <queue>

using namespace std;

#define MAX 101

int map[MAX][MAX];
int cnt[MAX][MAX];
int dx[4] = { 0,-1,0,1 };
int dy[4] = { -1,0,1,0 };

int main() {
	int N, M;

	scanf("%d %d", &N, &M);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			scanf("%1d", &map[i][j]);
		}
	}

	queue<pair<int, int>> q;
	q.push(make_pair(1,1));
	cnt[1][1] = 1;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 1 || nx > N || ny < 1 || ny > M)continue;
			if(map[nx][ny]==1&&cnt[nx][ny]==0) {
				q.push(make_pair(nx, ny));
				cnt[nx][ny] = cnt[x][y] + 1;
			}
		}
	}

	printf("%d", cnt[N][M]);

	return 0;
}

// 문제특징 
// pair, 상하좌우 이동을 배열값 더하기로 만들어서 사용
// 숫자 %1d로 한칸씩 입력받기
// 