//백준_11047
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int N, K,answer=0;
	vector<int> A;

	cin >> N;
	cin >> K;
	for (int i = 0; i < N; i++) {
		int t;
		cin >> t;
		A.push_back(t);
	}
	sort(A.rbegin(), A.rend());
	for (int i = 0; i < N; i++) {
		while (K - A[i] >= 0) {
			answer++;
			K -= A[i];
		}
	}
	cout << answer << endl;
	return 0;
}

//동전 배열의 위치마다 while문을 배치
//동전의 For문안의 while문이 있는게 특징