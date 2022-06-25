//
// Created by chenqwwq on 2022/6/14.
//


#include "stdc++.h"
#include "common.h"

#include "iostream"

using namespace std;

int main() {
    int maxn = 2e5;
    int pre[maxn];
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n, s, m;
    cin >> t;
    while (t--) {
        cin >> n >> s;
        int sum = 0, mid = (n + 1) >> 1;
        for (int i = 0; i < n; ++i) {
            cin >> m;
            sum += m;
            pre[i <= mid ? i : n - i] += m;
        }
        int l = 0, r = mid;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if(pre[mid])
        }
    }
}