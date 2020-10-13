//백준_10828
#include <iostream>
#include <stack>

using namespace std;

int main() {

	int N;
	cin >> N;

	int num;
	stack<int> s;

	for (int i = 0; i < N; i++) {
		string str;
		cin >> str;

		if (str == "push") {
			int data;
			cin >> data;
			s.push(data);

		}
		else if (str == "pop") {
			if (s.empty()) cout << -1 << '\n';
			else {
				cout << s.top() << '\n';
				s.pop();
			}

		}
		else if (str == "size") {
			cout << s.size() << '\n';
		}
		else if (str == "empty") {
			cout << s.empty() << '\n';
		}
		else if (str == "top") {
			if (s.empty()) cout << -1 << '\n';
			else cout << s.top() << '\n';
		}
	}
	return 0;
}