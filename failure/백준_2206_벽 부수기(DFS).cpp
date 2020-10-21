#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
int map[1001][1001];
int visit[1001][1001];
int dist;

int mx[4] = { 0,1,0,-1 };
int my[4] = { 1,0,-1,0 };

void DFS(int x, int y, int cnt, int cut, int flag) {

	if (flag == 1) {
		dist = min(dist, cnt);
	}
	for (int i = 0; i < 4; i++) {
		int nx = x + mx[i];
		int ny = y + my[i];

		if (nx<0 || ny<0 || nx>n - 1 || ny>n - 1) continue;

		if (visit[nx][ny]) continue;

		if (map[nx][ny] == 1) {
			if (cut == 0) {
				map[nx][ny] = 1;
				visit[nx][ny] = 1;
				if (nx == n - 1 && ny == m - 1) flag = 1;
				DFS(nx, ny, cnt + 1, cut + 1, flag);
				map[nx][ny] = 0;
				visit[nx][ny] = 0;
			}
		}
		else {
			visit[nx][ny] = 1;
			if (nx == n - 1 && ny == m - 1) flag = 1;
			DFS(nx, ny, cnt + 1, cut, flag);
			visit[nx][ny] = 0;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	cin >> n >> m;
	for (int i = 0; i <= n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < m; j++) {
			int tmp = str[j] - '0';
			map[i][j] = tmp;
		}
	}

	visit[0][0] = 1;
	DFS(0, 0, 0, 0, 0);

	cout << dist;
	return 0;
}