#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    int count=0;
    
    for(int i=0;i<prices.size();i++){
        count=0;
        for(int j=i+1;j<prices.size();j++){
            if(prices[j]>=prices[i]){
                count++;
            } else {
                count++;
                break;
            }
        }
        answer.push_back(count);
    }
    return answer;
}

// c의 malloc로 풀다 cpp vector쓰니 너무편안..