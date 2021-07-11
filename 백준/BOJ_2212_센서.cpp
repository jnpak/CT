//백준_2212_센서
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, k;
	cin >> n>> k;
	
	vector<int> v;
	vector<int> dist;

	for (int i = 0; i < n; i++) {
		int data;
		cin >> data;
		v.push_back(data);
	}

	sort(v.begin(), v.end());
	v.erase(unique(v.begin(), v.end()), v.end());

	int pre = v[0];
	for (int i = 1; i < v.size(); i++) {
		dist.push_back(v[i] - pre);
		pre = v[i];
	}

	sort(dist.rbegin(), dist.rend());

	int ans = 0;
	for (int i = 0; i < dist.size(); i++) {
		if (i < k - 1) continue;
		ans += dist[i];
	}
	cout << ans << '\n';
	return 0;
}