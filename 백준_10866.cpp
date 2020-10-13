//백준_10866
#include <iostream>
#include <deque>

using namespace std;

int main() {
	int N;
	cin >> N;

	deque<int> dq;
	int num;

	for (int i = 0; i < N; i++) {
		string str;
		cin >> str;

		if (str == "push_front") {
			int data;
			cin >> data;
			dq.push_front(data);
		}
		else if (str == "push_back") {
			int data;
			cin >> data;
			dq.push_back(data);
		}
		else if (str == "pop_front") {
			if (dq.empty()) cout << -1 << '\n';
			else {
				cout << dq.front() << '\n';
				dq.pop_front();
			}
		}
		else if (str == "pop_back") {
			if (dq.empty()) cout << -1 << '\n';
			else {
				cout << dq.back() << '\n';
				dq.pop_back();
			}
		}
		else if (str == "size") {
			cout << dq.size() << '\n';
		}else if (str == "empty") {
			cout << dq.empty() << '\n';
		}
		else if (str == "front") {
			if (dq.empty()) cout << -1 << '\n';
			else cout << dq.front() << '\n';
		}
		else if (str == "back") {
			if (dq.empty()) cout << -1 << '\n';
			else cout << dq.back() << '\n';
		}
	}
	return 0;

}