//백준_11399
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int N, temp=0, answer=0;
	vector<int> P;

	cin >> N;
	for (int i = 0; i < N; i++) {
		int t;
		cin >> t ;
		P.push_back(t);
	}

	sort(P.begin(), P.end());
	for (int i = 0; i < P.size(); i++) {
		temp = temp + P[i];
		answer += temp;
	}

	cout << answer << endl;
	
	return 0;
}
// 쉽당