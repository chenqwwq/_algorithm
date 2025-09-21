//
// Created by chenqwwq on 2022/8/1.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    typedef long long ll;
    int t;
    cin >> t;
    while (t--){
        ll n1, n2, n3;
        cin >> n1 >> n2 >> n3;
        cout << ((n1 + n2 + n3) >> 1) << endl;
    }
    return 0;
}