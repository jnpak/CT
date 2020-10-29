//프로그래머스_체육복
#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {

	for (auto it = lost.begin(); it != lost.end();) {
		bool check = false;
		for (auto it2 = reserve.begin(); it2 != reserve.end(); it2++) {
			int data = *it;
			int data2 = *it2;

			if (data == data2) {
				it = lost.erase(it);
				reserve.erase(it2);
				check = true;
				break;
			}
		}
		if (check == false) it++;
	}

	for (auto it = lost.begin(); it != lost.end();) {
		bool check = false;
		for (auto it2 = reserve.begin(); it2 != reserve.end(); it2++) {
			int data = *it;
			int data2 = *it2;

			if (data - 1 == data2) {
				it = lost.erase(it);
				reserve.erase(it2);
				check = true;
				break;
			}
			else if (data + 1 == data2) {
				it = lost.erase(it);
				reserve.erase(it2);
				check = true;
				break;
			}
		}
		if (check == false) it++;
	}
	return  n - lost.size();
}

// 벡터 이터레이터를 사용할 때 인덱스를 지웠을 때 지운인덱스 값을 
// 다시 이터레이터에 대입하면 이터레이터 순서가 어긋나지 않고 사용가능