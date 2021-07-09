//백준 2667
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <queue>
#include <vector>
#include <algorithm>
#define MAX 26

using namespace std;

int map[MAX][MAX];
int mx[4] = { 0,-1,0,1 };
int my[4] = { -1,0,1,0 };


int main() {
	int N, cnt = 0;
	queue<pair<int, int>> q;
	vector<int> v;


	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			scanf("%1d", &map[i][j]);
		}
	}


	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (map[i][j] == 1) {
				map[i][j] = 2;
				q.push(make_pair(i, j));
				while (!q.empty()) {
					int x = q.front().first;
					int y = q.front().second;
					q.pop();
					cnt++;

					for (int i = 0; i < 4; i++) {
						int nx = x + mx[i];
						int ny = y + my[i];
						if (nx < 1 || nx > N || ny < 1 || ny > N)continue;
						if (map[nx][ny] == 1) {
							q.push(make_pair(nx, ny));
							map[nx][ny] = 2;
						}
					}
				}
				v.push_back(cnt);
				cnt = 0;
			}
		}
	}

	printf("%d\n", v.size());
	sort(v.begin(), v.end());
	for (int i = 0; i < v.size(); i++) printf("%d\n", v[i]);

	return 0;
}

// 입력 배열이 붙어있어서 %1d 로입력받아야하는데 실수