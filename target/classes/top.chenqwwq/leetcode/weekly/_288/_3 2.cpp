//
// Created by 陈炳鑫 on 2022/4/10.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string minimizeResult(string expression) {
        stringstream ss(expression);
        string n1, n2;
        getline(ss, n1, '+');
        getline(ss, n2, '+');
        int num1 = atoi(n1.c_str()), num2 = atoi(n2.c_str());

        vector<pair<int, int>> p1, p2;
        int tmp = num1;
        int low = 0,base = 1;
        while (tmp) {
            low = low + (tmp % 10) * base;
            tmp /= 10;
            p1.emplace_back((num1 - low) / base / 10, low);
            base *= 10;
        }
        tmp = num2;
        low = 0;
        base = 1;
        p2.emplace_back(num2,0);
        while (tmp) {
            low = low + (tmp % 10) * base;
            tmp /= 10;
            p2.emplace_back((num2 - low) / base / 10,low);
            base *= 10;
        }
        p2.pop_back();

        int min = INT_MAX;
        string ans;
        for (int i = 0; i < p1.size() ; ++i) {
            for (int j = 0; j < p2.size(); ++j) {
                int res = max(p1[i].first,1) * (p1[i].second + p2[j].first) * max(p2[j].second,1);
                if(res < min){
                    min = res;
                    ans = (p1[i].first != 0  ? to_string(p1[i].first) :"")
                            + "(" + to_string(p1[i].second) + "+" + to_string(p2[j].first) + ")" +
                            (p2[j].second != 0 ? to_string(p2[j].second) : "");
                }
            }
        }
        return ans;
    }
};
int main(){
    (new Solution)->minimizeResult("247+38");
}
