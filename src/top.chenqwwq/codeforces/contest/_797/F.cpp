//
// Created by chenqwwq on 2022/6/8.
//


#include "stdc++.h"
#include "common.h"

#include "iostream"

using namespace std;
const int maxn = 201;
int a[maxn], b[maxn];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n;
    string str;
    cin >> t;
    while (t--) {
        for (int i = 0; i < maxn; ++i) b[i] = i;
        cin >> n;
        cin >> str;
        for (int i = 0; i < n; ++i) {
            cin >> a[i];
            b[--a[i]] = i;
        }
    }
}