//
// Created by chenqwwq on 2022/8/28.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t,n;
    cin >> t;
    string s;
    while (t--) {
        cin >> n >> s;
        int ans = 0, cur = 0;
        bool exi = false;
        for (char i: s) {
            if (i == 'P') {
                if(exi) cur++;
            }else{
                ans = max(ans,cur);
                exi = true;
                cur = 0;
            }
        }
        cout << (max(cur,ans)) << endl;
    }
    return 0;
}