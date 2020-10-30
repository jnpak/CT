//프로그래머스_위장
#include <string>
#include <vector>
#include <map>
using namespace std;

int solution(vector<vector<string>> clothes) {
    map<string, int> m; // key 값의 개수를 세는 map 컨테이너를 생성
    for (vector<string> c : clothes) {
        m[c[1]]++; // c[1] 자리는 eyeware, headgear 등 옷의 종류를 나타내는 요소
    }              // 종류를 m[eyeware] 가 되고 map 의 key인 eyeware 값이 1 증가되는 구문
                   // 그렇게 clothese 을 돌면 각 옷의 종류의 개수가 map의 key 마다 개수가들어감
    int answer = 1;
    map<string, int>::iterator it;
    for (it = m.begin(); it != m.end(); it++) {
        answer *= it->second + 1; // map의 세컨드 값은 옷 종류의 개수
    }                             // 각 옷 종류의 개수 +1 을 곱하면 옷의 조합
    return answer - 1;
}
// 옷의 종류에 +1을 하여 곱하는 이유는 옷을 안입는 경우도 포함하기 때문이다.
// 모든 조합을 곱 한 후 옷을 한개도 안입는 경우는 제외하기 때문에 총 경우의 수에서 -1 을 해준다.