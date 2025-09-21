//
// Created by chenqwwq on 2022/8/30.
//

#include <bits/stdc++.h>
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n;
    string s,example = "Timur";
    sort(example.begin(),example.end());
    cin >> t;
    while (t--) {
        cin >> n >> s;
        if(s.length() != example.length()) {
            cout << "NO" << endl;
            continue;
        }
        sort(s.begin(),s.end());
        cout << (s == example ? "YES" :"NO") << endl;
    }
    return 0;
}