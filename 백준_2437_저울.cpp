//백준_2437
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int n;
	cin >> n;

	vector<int> chuu;
	for (int i = 0; i < n; i++) {
		int data;
		cin >> data;
		chuu.push_back(data);
	}
	sort(chuu.begin(), chuu.end());

	int sum = 0;
	int result=0;
	for (int i = 0; i < n; i++) {
		if (chuu[i] > sum + 1) {
			result = sum + 1;
			break;
		}
		else {
			sum += chuu[i];
		}
	}
	cout << result;
	return 0;
}