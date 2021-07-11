//백준_1149_RGB거리
#include <iostream>
#include <algorithm>

using namespace std;

int arr[1001][3];
int dp[1001][3];

int main() {
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> arr[i][j];
		}
	}
	for (int i = 0; i < 3; i++)
		dp[0][i] = arr[0][i];

	for (int i = 1; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			dp[i][j] = 2e9;
			for (int k = 0; k < 3; k++) {
				if (k != j) {
					dp[i][j] = min(dp[i][j], dp[i - 1][k] + arr[i][j]);
				}
			}
		}
	}
	cout << min(dp[n - 1][0], min(dp[n - 1][1], dp[n - 1][2]));
	return 0;
}