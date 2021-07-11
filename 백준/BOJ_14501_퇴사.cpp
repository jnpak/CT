//백준_14501_퇴사

#include <iostream>
#include <algorithm>
using namespace std;

int N;
int max_value;
int time[17];
int profit[17];

void DFS(int day, int value) {
	if (day + time[day] <= N + 1) {
		value += profit[day];
		day += time[day];
		max_value = max(value, max_value);

		for (int i = day; i <= N; i++) {
			DFS(i, value);
		}
	}
	else {
		return;
	}
}

int main() {
	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> time[i] >> profit[i];
	}

	for (int i = 1; i <= N; i++) {
		DFS(i,0);
	}

	cout << max_value << endl;
	return 0;
}