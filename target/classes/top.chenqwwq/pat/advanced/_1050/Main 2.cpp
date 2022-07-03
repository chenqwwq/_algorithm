//
// Created by 陈炳鑫 on 2022/4/26.
//


#include <iostream>
#include <cstring>

using namespace std;

int main() {
    string s1, s2;
    getline(cin, s1);
    getline(cin, s2);
    bool hash[129];
    memset(hash,0, sizeof(hash));
    for (char i: s2)hash[i] = true;
    string ans;
    for (char c: s1) {
        if (!hash[c]) ans += c;
    }
    printf("%s\n", ans.c_str());
    return 0;
}