//
// Created by chenqwwq on 2022/7/23.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m, k;
    cin >> n >> m >> k;
    cout << (m >= n && k >= n ? "Yes" : "No") << endl;
    return 0;
}