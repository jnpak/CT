//SWEA_등산로조성 (오답)

#include <vector>
#include <iostream>
#include <cstring>

using namespace std;

#define MAX 9
int map[MAX][MAX];
int visited[MAX][MAX];
int mx[4] = { 0,-1,0,1 };
int my[4] = { -1,0,1,0 };
int GDist = 0, Dist, N, top;


void DFS(int x, int y) {
	Dist++;
	visited[x][y] = 1;

	for (int i = 0; i < 4; i++) {
		int nx = x + mx[i];
		int ny = y + my[i];
		if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
		if (map[nx][ny] < map[x][y] && visited[nx][ny] == 0) {
			DFS(nx, ny);
		}
	}
}


int main(int argc, char **argv) {
	int T, K;
	vector<int> distv;
	vector<pair<int, int>> v;

	cin >> T;
	cin >> N >> K;

	for (int k = 0; k < T; k++) {
		top = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
				if (map[i][j] > top) {
					top = map[i][j];
					v.clear();
					v.push_back(make_pair(i, j));
				}
				else if (map[i][j] == top) {
					v.push_back(make_pair(i, j));
				}
				else {}
			}
		}



		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int t = 1; t <= K; t++) {
					map[i][j] = map[i][j] - t;
					for (int q = 0; q < v.size(); q++) {

						DFS(v[q].first, v[q].second);
						if (GDist < Dist)GDist = Dist;
						Dist = 0;
						memset(visited, 0, sizeof(visited));

					}
					map[i][j] = map[i][i] + t;
				}
			}
		}
		distv.push_back(GDist);
		GDist = 0;
	}

	for (int i = 1; i <= distv.size(); i++) {
		cout << "#" << i << " " << distv[i - 1] << "\n";
	}
	return 0;
}

// 오답임