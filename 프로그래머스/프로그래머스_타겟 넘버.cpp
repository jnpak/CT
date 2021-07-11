//프로그래머스_타겟 넘버
#include <string>
#include <vector>
using namespace std;
int answer;
void DFS(vector<int> nums, int target, int cnt, int sum) {
    if (cnt == nums.size()) {
        if (sum == target) answer++;
        return;
    }
    DFS(nums, target, cnt + 1, sum - nums[cnt]);
    DFS(nums, target, cnt + 1, sum + nums[cnt]);
}
int solution(vector<int> numbers, int target) {
    DFS(numbers, target, 0, 0);
    return answer;
}