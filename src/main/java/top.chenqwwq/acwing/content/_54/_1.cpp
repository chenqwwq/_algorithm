//
// Created by chenqwwq on 2022/6/4.
//


#include "common.h"
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n ;
    cin >> n;
    string str;
    cin >> str;
    int cnt[26];
    for (auto &c : cnt) c = 0;
    for (auto c: str) cnt[tolower(c) - 'a']++;
    printf("%s\n", any_of(cnt, cnt + 26, [](int a) { return a == 0; }) ? "NO" : "YES");
    return 0;
}