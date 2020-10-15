//백준_17144

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Dust {
	int x;
	int y;
	int amount;
};

int R, C, T;
int map[50][50];
vector<pair<int, int>> vecuum;
queue<Dust> dust;

//           상하좌우
int mx[4] = { -1,1,0,0 };
int my[4] = { 0,0,-1,1 };

void Activate_cleaner() {
	//윗 공기 청정기 작동
	int x, a = vecuum[0].first;
	int y = vecuum[0].second;
	int nx = x + mx[0];
	int ny = y + my[0];
	map[x - 1][y] = 0;

	for (int i = 0; i < a - 1; i++) {
		nx += mx[0]; ny += my[0];	x += mx[0];	y += my[0];
		map[nx][ny] = map[x][y];
	}
	for (int i = 0; i < C - 1; i++) {
		nx += mx[3]; ny += my[3];	x += mx[3];	y += my[3];
		map[nx][ny] = map[x][y];
	}
	for (int i = 0; i < a; i++) {
		nx += mx[1]; ny += my[1];	x += mx[1];	y += my[1];
		map[nx][ny] = map[x][y];
	}
	for (int i = 0; i < C - 2; i++) {
		nx += mx[2]; ny += my[2];	x += mx[2];	y += my[2];
		map[nx][ny] = map[x][y];
	}
	//아래 공기 청정기 작동
	x, a = vecuum[1].first;
	y = vecuum[1].second;
	nx = x + mx[1];
	ny = y + my[1];
	map[x + 1][y] = 0;

	for (int i = 0; i < R - a - 1; i++) {
		nx += mx[1]; ny += my[1];	x += mx[1];	y += my[1];
		map[nx][ny] = map[x][y];
	}
	for (int i = 0; i < C - 1; i++) {
		nx += mx[3]; ny += my[3];	x += mx[3];	y += my[3];
		map[nx][ny] = map[x][y];
	}
	for (int i = 0; i < R - a; i++) {
		nx += mx[0]; ny += my[0];	x += mx[0];	y += my[0];
		map[nx][ny] = map[x][y];
	}
	for (int i = 0; i < C - 2; i++) {
		nx += mx[2]; ny += my[2];	x += mx[2];	y += my[2];
		map[nx][ny] = map[x][y];
	}
}

int main() {

	cin >> R >> C >> T;

	//입력
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> map[i][j];
			if (map[i][j] == -1) vecuum.push_back(make_pair(i, j));
			else if (map[i][j] >= 1) {
				Dust D;
				D.x = i;
				D.y = j;
				D.y = map[i][j];
				dust.push(D);
			}
		}
	}
	while (!dust.empty) {
		int x = dust.front().x;
		int y = dust.front().y;

		int value;
	}



	Activate_cleaner();	

	// 미세먼지 카운트
	int cnt;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if ((map[i][j]) != 0 || (map[i][j] != -1)) cnt += map[i][j];
		}
	}
	cout << cnt;
	return 0;

}