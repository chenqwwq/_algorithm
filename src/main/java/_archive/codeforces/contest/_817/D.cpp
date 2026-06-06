//
// Created by chenqwwq on 2022/8/30.
//

#include "bits/stdc++.h"
#include "iostream"

using namespace std;
typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n;
    string s;
    cin >> t;
    while (t--) {
        priority_queue<int> pq;
        cin >> n >> s;
        ll ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = s[i] == 'L' ? i : n - i - 1;
            ans += cur;
            int diff = n - cur - 1 - cur;
            pq.push(diff);
        }
        while (!pq.empty()) {
            if (pq.top() > 0) ans += pq.top();
            pq.pop();
            cout << ans;
            if(pq.size() > 0) cout << " ";
        }
        cout << endl;
    }
    return 0;
}