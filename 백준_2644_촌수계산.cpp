//백준_2644_촌수계산
#include <iostream>
using namespace std;

int n, a, b, m, ans;
int arr[101][101];

void solve(int cur, int end, int before, int cnt) {
	if (cur == end) {
		ans = cnt;
		return;
	}
	for (int i = 1; i <= n; i++) {
		if (arr[cur][i] == 0)continue;
		if (i == before)continue;
		solve(i,end , cur, cnt + 1);
	}
}

int main() {
	cin >> n >> a >> b >> m;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		arr[x][y] = arr[y][x] = 1;
	}

	solve(a, b, 0, 0);
	cout << (ans != 0 ? ans : -1);
	return 0;
}