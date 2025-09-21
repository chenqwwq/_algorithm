//
// Created by 陈炳鑫 on 2022/4/18.
//


#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool cmp(const string &s1, const string &s2) {
    return s1 + s2 < s2 + s1;
}

int main() {
    int n;
    scanf("%d", &n);
    vector<string> v(n);
    string str;
    for (int i = 0; i < n; ++i) {
        cin >> str;
        v[i] = str;
    }
    sort(v.begin(), v.end(), cmp);
    string ans;
    for (const auto &st: v) ans += st;
    while (ans[0] == '0') ans = ans.substr(1, ans.size() - 1);
    printf("%s\n", (ans.empty() ? "0" : ans.c_str()));
    return 0;
}