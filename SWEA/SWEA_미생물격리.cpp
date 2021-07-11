//SWEA_미생물격리

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct bug {
	int x;
	int y;
	int cnt;
	int dir;
};

int T, N, M, K;
int mx[5] = { 0,-1,1,0,0 };
int my[5] = { 0,0,0,-1,1 };
vector<int> map[100][100];

int main() {

	cin >> T;

	for (int testcase = 1; testcase <= T; testcase++) {
		cin >> N >> M >> K;

		vector<bug> v(K);
		for (int i = 0; i < K; i++) {
			cin >> v[i].x >> v[i].y >> v[i].cnt >> v[i].dir;
			map[v[i].x][v[i].y].push_back(i);
		}

		while (M--) {
			for (int i = 0; i < K; i++) {
				if (v[i].cnt == 0) continue;
				map[v[i].x][v[i].y].clear();
			}

			for (int i = 0; i < K; i++) {
				if (v[i].cnt == 0) continue;
				v[i].x += mx[v[i].dir];
				v[i].y += my[v[i].dir];
				map[v[i].x][v[i].y].push_back(i);
			}

			for (int i = 0; i < K; i++) {
				if (v[i].cnt == 0) continue;

				if (v[i].x == 0 || v[i].y == 0 || v[i].x == N - 1 || v[i].y == N - 1) {
					v[i].cnt = v[i].cnt / 2;

					if (v[i].dir == 1) v[i].dir = 2;
					else if (v[i].dir == 2) v[i].dir = 1;
					else if (v[i].dir == 3) v[i].dir = 4;
					else v[i].dir = 3;

				}
				else if (map[v[i].x][v[i].y].size() > 1) {
		
					int x = v[i].x;
					int y = v[i].y;
					int max_bugs_num = 0;
					int max_bugs_cnt = 0;
					int max_bugs_dir = 0;
					int sum = 0;
					for (int i = 0; i < map[x][y].size(); i++) {
						sum += v[map[x][y][i]].cnt; // 같은 공간의 미생물은 모두 합함
						//최대 미생물을 가진 군집을 찾고
						if (max_bugs_cnt < v[map[x][y][i]].cnt) {
							max_bugs_cnt = v[map[x][y][i]].cnt;
							max_bugs_dir = v[map[x][y][i]].dir;
							max_bugs_num = map[x][y][i];
						}
						v[map[x][y][i]].cnt = 0;
					}
					v[max_bugs_num].cnt = sum;
					v[max_bugs_num].dir = max_bugs_dir;
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < K; i++) {
			ans += v[i].cnt;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j].clear();
			}
		}

		cout << "#" << testcase << " " << ans << "\n";
	}

	return 0;
}