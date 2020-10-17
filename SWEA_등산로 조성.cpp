//SWEA_등산로 조성
#include <iostream>
#include <algorithm>
#include <memory.h>

using namespace std;

int n, k;

int map[8][8];
int visit[8][8];
int dist;
int highest;

int mx[4] = { -1,0,1,0 };
int my[4] = { 0,1,0,-1 };

void DFS(int x, int y, int cnt, int cut) {

	dist = max(dist, cnt);

	for (int i = 0; i < 4; i++) {
		int nx = x + mx[i];
		int ny = y + my[i];

		if (nx<0 || ny<0 || nx>n - 1 || ny>n - 1) continue;

		if (visit[nx][ny]) continue;

		if (map[nx][ny] >= map[x][y]) {
			if (cut == 0) {
				for (int depth = 1; depth <= k; depth++) {
					int tmp = map[nx][ny];
					int land = map[nx][ny] - depth;

					if (land < map[x][y]) {
						visit[nx][ny] = 1;
						map[nx][ny] = land;
						DFS(nx, ny, cnt + 1, cut + 1);
						map[nx][ny] = tmp;
						visit[nx][ny] = 0;
					}
				}
			}
		}
		else {
			visit[nx][ny] = 1;
			DFS(nx, ny, cnt + 1, cut);
			visit[nx][ny] = 0;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int t;
	cin >> t;

	for (int r = 1; r <= t; r++) {

		cin >> n >> k;
		highest = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> map[i][j];
				highest = max(highest, map[i][j]);
			}
		}

		memset(visit, 0, sizeof(visit));
		dist = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == highest && !visit[i][j]) {
					visit[i][j] = 1;
					DFS(i, j, 1,0);
					visit[i][j] = 0;
				}
			}
		}
		cout << "#" << r << " " << dist << "\n";
	}
	return 0;
}