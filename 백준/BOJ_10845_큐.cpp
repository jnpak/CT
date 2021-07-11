//백준_10845_큐
#include <iostream>
#include <queue>
using namespace std;

int main() {

	int N;
	cin >> N;

	queue<int> q;
	int num;

	for (int i = 0; i < N; i++) {
		string str;
		cin >> str;

		if (str == "push") {
			int a;
			cin >> a;
			q.push(a);
		}
		else if (str == "pop") {
			if (!q.empty()) {
				num = q.front();
				q.pop();
			}
			else {
				num = -1;
			} 
			cout << num << '\n';
		}
		else if (str == "size") {
			cout << q.size() << '\n';
		}
		else if (str == "empty") {
			cout << q.empty() << '\n';
		}
		else if (str == "front") {
			if (q.empty()) {
				num = -1;
			}
			else {
				num = q.front();
			}
			cout << num << '\n';
		}
		else if (str == "back") {
			if (q.empty()) {
				num = -1;
			}
			else {
				num = q.back();
			}
			cout << num << '\n';
		}
	}
	return 0;
}