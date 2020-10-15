//백준_15828
#include <iostream>
#include <queue>

using namespace std;

int main() {
	int n; //버퍼크기
	cin >> n;

	queue<int> q;
	while (1) {
		int data;
		cin >> data;
		if (data >0) {
			if (q.size() < n) q.push(data);
		}
		else if (data == 0) {
			q.pop();
		}
		else {
			break;
		}
	}

	if (q.empty()) {
		cout << "empty" << '\n';
	}
	else {
		while (!q.empty()) {
			cout << q.front() << " ";
			q.pop();
		}
	}
	return 0;
}