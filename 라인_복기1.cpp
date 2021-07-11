#include <string>
#include <vector>
#include <algorithm>
#include <stdio.h>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> boxes) {
    vector<int> temp;
    int answer = -1;
    for (int i = 0; i < boxes.size(); i++) {
        for (int j = 0; j < 2; j++) {
            temp.push_back(boxes[i][j]);
        }
    }
    sort(temp.begin(), temp.end());
    vector<int>::iterator it = temp.begin();
    while (it != temp.end()) {
        if (it == it + 1) {
            temp.erase(it + 1);
            temp.erase(it);
        }
        else {
            ++it;
        }
    }
    if (temp.size() % 2 == 0) {
        return -1;
    }
    else {
        answer = temp.size() / 2;
    }

    return answer;
}

int main() {
    vector<vector<int>> a;
    vector<int> b;
    b.push_back(1);
    b.push_back(2);
    a.push_back(b);
    b.push_back(2);
    b.push_back(1);
    a.push_back(b);
    b.push_back(3);
    b.push_back(3);
    a.push_back(b);
    b.push_back(4);
    b.push_back(5);
    a.push_back(b);

    printf("%d", solution(a));
}