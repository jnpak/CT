//백준_2606_바이러스
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int n, m; // 컴퓨터수, 쌍의 수
vector<int> v[101];
bool check[101];

int BFS(int a) {
	queue<int> q;
	q.push(a);
	check[a] = 1;

	int cnt = 0;
	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		cnt++;
		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur][i];
			if (check[next]==0) {
				check[next] = 1;
				q.push(next);
			}
		}
	}
	return cnt;
}

int main() {

	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	cout << BFS(1)-1;
	return 0;
}