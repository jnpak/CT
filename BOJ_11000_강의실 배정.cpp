//백준_11000_강의실 배정
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

pair<int, int> p[200001];
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> p[i].first >> p[i].second;
	}

	sort(p, p + n);

	pq.push(p[0].second);

	for (int i = 1; i < n; i++) {
		if (pq.top() <= p[i].first) {
			pq.pop();
			pq.push(p[i].second);
		}
		else {
			pq.push(p[i].second);
		}
	}

	cout << pq.size() << endl;

	return 0;
}
//pair 초기화