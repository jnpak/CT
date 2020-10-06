//백준_1931
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Meeting {
	int start,end;
};

bool cmp(const Meeting &a, const Meeting &b) {
	if (a.end == b.end) { return a.start < b.start; }
	else { return a.end < b.end; }
}

int main() {
	int N;
	vector<Meeting> M;

	cin >> N;
	for (int i = 0; i < N; i++) {
		int a, b;
		cin >> a >> b;
		Meeting temp;
		temp.start = a, temp.end = b;
		M.push_back(temp);
	}
	sort(M.begin(), M.end(), cmp);
	int answer = 0, temp = 0;

	for (int i = 0; i < M.size(); i++) {
		if (temp <= M[i].start) {
			temp = M[i].end;
			answer += 1;
		}
	}
	cout << answer;
	return 0;
}

// Meeting 구조체 벡터 내용을 입력받을 때
// 바로 넣지말고 Meeting 구조체 변수를 선언하여 그 변수에 int 값을 넣고 다시 벡터에 삽입