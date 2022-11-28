//
// Created by chenqwwq on 2022/11/22.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

int main() {
    int t, n;
    string s;
    cin >> t;
    while (t--) {
        int m = 1;
        cin >> n >> s;
        for (char c: s) m = max(m, c - 'a' + 1);
        cout << m << endl;
    }
    return 0;
}