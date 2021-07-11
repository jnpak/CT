//백준_2503
#include <iostream>
#include <stack>

using namespace std;

int main() {
	string str;
	cin >> str;

	int sum=1;
	int result=0;
	int flag = 0;

	stack<char> st;
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == '('){
			st.push('(');
			sum *= 2;
		}
		else if (str[i] == '[') {
			st.push('[');
			sum *= 3;
		}
		else if (str[i] == ')') {
			if (st.empty()) {
				flag = 1;
				break;
			}
			if (st.top() == '(') {
				if (str[i - 1] == '(')result += sum;
				st.pop();
				sum /= 2;
			}
			else {
				flag = 1;
				break;
			}
		}
		else if (str[i] == ']') {
			if (st.empty()) {
				flag = 1;
				break;
			}
			if (st.top() == '[') {
				if (str[i - 1] == '[') result += sum;
				st.pop();
				sum /= 3;
			}
			else {
				flag = 1;
				break;
			}
		}
	}

	if (flag == 1||!st.empty()) {
		cout << 0 << '\n';
	}
	else {
		cout << result << '\n';
	}
}