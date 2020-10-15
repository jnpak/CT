//백준_10773
#include <iostream>
#include <vector>

using namespace std;

int main() {
	int k;
	cin >> k;
	vector<int> v;
	for (int i = 0; i < k; i++) {
		int data;
		cin >> data;
		if (data == 0) {
			if (!v.empty()) {
				v.pop_back();
			}
		}
		else {
			v.push_back(data);
		}
	}
	int sum=0;
	for (auto it = v.begin(); it != v.end();it++) {
		sum += *it;
	}
	cout << sum << '\n';
	return 0;
}