#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    sort(phone_book.begin(),phone_book.end());
    
    for(int i=0;i<phone_book.size()-1;i++){
       if(phone_book[i] == phone_book[i+1].substr(0,phone_book[i].size())) return false;
    }
    return answer;
}

vector의 원소개수수 size()

string 문자열 리턴함수 substr(pos:첫번째문자 위치, count 부분문자열 길이)
ex)
string a = "0123"
a.substr(1,2); 
>> 23