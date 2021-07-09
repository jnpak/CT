//백준_17144_미세먼지 안녕!

#include <iostream>
#include <vector>

using namespace std;

int R, C, T;
int map[50][50];
vector<int> vecuum;

int mx[4] = { -1,1,0,0 };
int my[4] = { 0,0,-1,1 };

void Activate_cleaner() {

	int up = vecuum[0];
	int low = vecuum[1];

	for (int i = up - 1; i > 0; i--) {
		map[i][0] = map[i - 1][0];
	}
	for (int j = 0; j < C - 1; j++) {
		map[0][j] = map[0][j + 1];
	}
	for (int i = 0; i < up; i++) {
		map[i][C - 1] = map[i + 1][C - 1];
	}
	for (int j = C - 1; j > 1; j--) {
		map[up][j] = map[up][j - 1];
	}
	map[up][1] = 0;

	for (int i = low+1; i < R - 1; i++) {
		map[i][0] = map[i + 1][0];
	}
	for (int j = 0; j < C - 1; j++) {
		map[R - 1][j] = map[R - 1][j + 1];
	}
	for (int i = R - 1; i > low; i--) {
		map[i][C - 1] = map[i - 1][C - 1];
	}
	for (int j = C - 1; j > 1; j--) {
		map[low][j] = map[low][j - 1];
	}
	map[low][1] = 0;
}

void spread() {
	int spread[50][50] = { 0 };

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (map[i][j] > 0) {
				int Dust = map[i][j] / 5;
				for (int k = 0; k < 4; k++) {
					int nx = i + mx[k];
					int ny = j + my[k];
					if (nx >= 0 && nx < R && ny >= 0 && ny < C && (map[nx][ny] != -1)) {
						spread[nx][ny] += Dust;
						spread[i][j] -= Dust;
					}
				}
			}
		}
	}

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			map[i][j] += spread[i][j];
		}
	}
}

int main() {

	cin >> R >> C >> T;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> map[i][j];
			if (map[i][j] == -1) vecuum.push_back(i);
		}
	}

	// T만큼 반복
	for (int i = 0; i < T; i++) {
		spread();
		Activate_cleaner();
	}

	// 미세먼지 카운트
	int cnt = 0;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (map[i][j] > 0) cnt += map[i][j];
		}
	}
	cout << cnt;
	return 0;
}