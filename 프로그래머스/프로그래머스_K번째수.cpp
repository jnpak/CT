#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
	vector<int> answer;
	vector<int> temp;

	for (int i = 0; i < commands.size(); i++) {
		temp.assign(array.begin() + commands[i][0] - 1, array.begin() + commands[i][1]);
		sort(temp.begin(), temp.end());
		answer.push_back(temp[commands[i][2]-1]);
	}
	return answer;
}
// vector.assign(시작점,끝점) 벡터 할당
// 문자열은 substr 벡터는 copy나 assign으로 포인터사용해 할당