//
// Created by chenqwwq on 2022/9/3.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n;
    cin >> t;
    while (t--) {
        cin >> n;
        if (n == 2) cout << 1 << endl;
        else if (n == 3) cout << 7 << endl;
        else if (n & 1) {
            cout << 7;
            for (int i = 3; i < n; i += 2) cout << 1;
            cout << endl;
        }else{
            for(int i = 0;i < n;i+=2)cout << 1;
            cout << endl;
        }
    }
    return 0;
}