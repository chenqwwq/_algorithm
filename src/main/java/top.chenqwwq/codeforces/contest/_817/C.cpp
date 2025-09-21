//
// Created by chenqwwq on 2022/8/30.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n;
    string ss[3][1001];
    cin >> t;
    map<string,set<int>> cnt;
    while (t--) {
        cnt.clear();
        cin >> n;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                cin >> ss[i][j];
                if(cnt.find(ss[i][j]) == cnt.end()) cnt[ss[i][j]] = {i};
                else cnt[ss[i][j]].insert(i);
            }
        }
        for(int i = 0;i < 3;i++){
            int ans = 0;
            for(int j = 0;j < n;j++){
                if(cnt[ss[i][j]].size() == 1) ans += 3;
                else if(cnt[ss[i][j]].size() == 2) ans += 1;
            }
            cout << ans;
            if(i != 2) cout << " ";
        }
        cout << endl;
    }
    return 0;
}