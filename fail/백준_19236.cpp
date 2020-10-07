//백준_19236_틀린케이스

#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

struct Fish {
	int num;
	int Direction; //1,2,3,4,5,6,7,8
};

int mx[9] = {0,-1,-1,0,1,1,1,0,-1};
int my[9] = {0,0,-1,-1,-1,0,1,1,1};
int max_num=0,num=0;

Fish map[4][4];

void move() {
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			if (map[i][j].num != -1) {

				int D = map[i][j].Direction;

				for (int k = 0; k < 8; k++) {
					int nx = i + mx[D];
					int ny = i + my[D];
					if (nx < 0 || ny < 0 || nx>3 || ny>3||(map[nx][ny].num!=-1)) {
						if (D != 8) { D++; }
						else { D = 1; }
						continue;					
					}

					Fish temp;
					temp = map[nx][ny];
					map[nx][ny] = map[i][j];
					map[i][j] = temp;
					break;
				}
			}
		}
	}
}

void DFS(int x, int y) {
	num += map[x][y].num;
	int D = map[x][y].Direction;
	max_num = max(max_num, num);
	move();

	for (int i = 1; i < 4; i++) {
		int nx = x + (i*mx[D]);
		int ny = y + (i*my[D]);
		if (nx < 0 || ny < 0 || nx < 4 || ny < 4) continue;
		if ((map[nx][ny].num) != 0) {
			DFS(nx, ny);
		}
	}
}

int main() {

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			cin >> map[i][j].num >> map[i][j].Direction;
		}
	}

	cout << max_num;
	return 0;
}