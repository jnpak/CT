//백준_14502
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
#define MAX 8

int mx[4] = { -1,1,0,0 };
int my[4] = { 0,0,-1,1 };
int N, M;
int max_cnt;
int map[MAX][MAX];
int map_copy[MAX][MAX];

vector<pair<int, int>> virus;

// 맵입력 -> 벽 세개 -> 바이러스 퍼짐 -> 카운트

int BFS() {
	queue <pair<int, int>> q;
	for (int i = 0; i < virus.size(); i++) q.push(make_pair(virus[i].first, virus[i].second));

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + mx[i];
			int ny = y + my[i];
			if (nx < 0 || ny < 0 || nx> N - 1 || ny > M - 1) continue;
			if (map_copy[nx][ny] == 0) {
				map_copy[nx][ny] = 2;
				q.push(make_pair(nx, ny));
			}
		}
	}
	int cnt = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map_copy[i][j] == 0) cnt++;
		}
	}
	max_cnt = max(cnt, max_cnt);
	return max_cnt;
}

void Make_Wall(int count) {
	if (count == 3) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map_copy[i][j] = map[i][j];
		 BFS();
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] == 0) {
				map[i][j] = 1;
				Make_Wall(count + 1);
				map[i][j] = 0;
			}
		}
	}
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] == 2) virus.push_back(make_pair(i, j));
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] == 0) {
				map[i][j] = 1;
				Make_Wall(1);
				map[i][j] = 0;
			}
		}
	}

	cout << max_cnt;
	return 0;
}