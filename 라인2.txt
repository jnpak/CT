#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> ball, vector<int> order) {
    vector<int> answer;
    /*
    vector<int>::iterator it = order.begin();

    while (it != order.end()) {
        if (*it == ball.front()) {
            answer.push_back(ball.front());
            ball.erase(ball.begin());
            order.erase(it);
            it = order.begin();
        }
        else if (*it == ball.back()) {
            answer.push_back(ball.back());
            ball.erase(ball.end());
            order.erase(it);
            it = order.begin();
        }
        else {
            ++it;
        }
    }
    */
    int size = order.size();
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < order.size(); j++) {
            if (order[j] == ball.front()) {
                answer.push_back(ball.front());
                ball.erase(ball.begin());
                order.erase(order.begin() + j);
                break;
            }
            else if (order[j] == ball.back()) {
                answer.push_back(ball.back());
                ball.pop_back();
                order.erase(order.begin() + j);
                break;
            }
            else {}
        }
    }
    return answer;
}