//백준_11003_최솟값 찾기
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

typedef pair<int, int> pii;
pii p[5000001];
int n, l;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	cin >> n >> l;
	for (int i = 0; i < n; i++) {
		cin >> p[i].first;
		p[i].second = i;
	}

	priority_queue < pii, vector<pii>, greater<pii>> pq;
	for (int i = 0; i < l; i++) {
		pq.push(p[i]);
		cout << pq.top().first << " ";
	}

	for (int i = l; i < n; i++) {
		pq.push(p[i]);
		while (!pq.empty()) {
			int _min = pq.top().first;
			int _idx = pq.top().second;
			if (i - l + 1 <= _idx) {
				cout << _min << " ";
				break;
			}
			else {
				pq.pop();
			}
		}
	}
	return 0;
}