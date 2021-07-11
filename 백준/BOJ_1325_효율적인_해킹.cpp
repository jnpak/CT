//백준_1325_효율적인 해킹
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
vector<int> v[10001];
int dp[10001]={0,};
int cur;

int recv(int node) {
	cur += 1;
	if (dp[node]) {
		return dp[node];
	}
	dp[node] = 1;
	for (int i = 0; i < v[node].size(); i++) {
		dp[node] += recv(v[node][i]);
	}
	return dp[node];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		v[b].push_back(a);
	}
	int _max = 0;
	for (int i = 1; i <= n; i++) {
		_max = max(_max, recv(i));
	}
	for (int i = 1; i <= n; i++) {
		if (dp[i] == _max) {
			cout << i << " ";
		}
	}
	return 0;
}