//백준_16234_인구 이동
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int map[50][50];
int visit[50][50];
vector<pair<int, int>> open;
int mx[4] = { 0,0,-1,1 };
int my[4] = { -1,1,0,0 };
int sum;
int _count;
int check;
int _move;

int n, l, r; // 국경선개방 조건 두나라인구차이 L명이상 R명 이하

void BFS(int a, int b) {
	if (visit[a][b] == 1) return;
	queue<pair<int, int>> q;
	visit[a][b] = 1;
	q.push(make_pair(a, b));

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + mx[i];
			int ny = y + my[i];
			if (nx<0 || ny<0 || nx>n - 1 || ny>n - 1) continue;
			int cha = abs(map[nx][ny] - map[x][y]);
			if (cha >= l && cha <= r && visit[nx][ny] == 0) {
				open.push_back(make_pair(nx, ny));
				q.push(make_pair(nx, ny));
				check = 1;
			}
		}
	}
}

int main() {

	cin >> n, l, r;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
		}
	}
	check = 1;
	while (check != 1) {
		open.push_back(make_pair(0, 0));
		check = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				BFS(i, j);
				if (visit[i][j] == 1) continue;
				_count = open.size();
				for (int i = 0; i < open.size(); i++) {
					sum += map[open[i].first][open[i].second];
				}
				int value;
				value = sum / _count;
				for (int i = 0; i < open.size(); i++) {
					map[open[i].first][open[i].second] = value;
				}
				sum = 0; _count = 0;
				open.clear();
			}
		}
		memset(visit, 0, sizeof(visit));
		if (check == 1) _move++;
	}

	cout << _move;
	return 0;
}