//
// Created by chenqwwq on 2022/8/28.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

string getStr(int num) {
    string ans;
    while (num) {
        ans = to_string(num % 10) + ans;
        num /= 10;
    }
    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, num;
    cin >> n;

    char c;
    map<int, pair<int, string>> hash;
    while (n--) {
        cin >> c >> num;
        if (c == '+') {
            if (hash.find(num) != hash.end()) hash[num].first++;
            else hash[num] = {1, getStr(num)};
        } else if (c == '-') {
            if (hash.find(num) != hash.end()) hash[num].first = max(0, hash[num].first - 1);
        }else{
            
        }
    }
}