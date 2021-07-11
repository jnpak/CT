//백준_9012
#include <iostream>
#include <vector>
#include <stack>
using namespace std;

vector<char> print;
void push() { print.push_back('+'); }
void pop() { print.push_back('-'); }

int main() {
	int n;
	cin >> n;

	vector<int> v;
	stack<int> s;

	for (int i = 0; i < n; i++) {
		int data;
		cin >> data;
		v.push_back(data);
	}
	vector<int>::iterator it = v.begin();

	for (int i = 1; i <= n; i++) {
		s.push(i);
		push();
		while (!s.empty()) {
			if (*it != s.top())break;
			else {
				s.pop();
				pop();
				it++;
			}
		}
	}
	
	if (s.empty()) {
		for (int i = 0; i < print.size(); i++) {
			cout << print[i] << '\n';
		}
	}
	else cout << "NO";
	return 0;
}