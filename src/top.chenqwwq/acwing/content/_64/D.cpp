//
// Created by chenqwwq on 2022/8/28.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    typedef  long long ll;
    typedef pair<ll, ll> pii;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    ll n, a, b, x;
    ll vx, vy;
    ll ans = 0;
    map<pii, ll> st;
    map<ll, ll> cnt;
    cin >> n >> a >> b;
    while (n--) {
        cin >> x >> vx >> vy;
        ll y = a * vx - vy;
        ans += cnt[y] - st[{vx, vy}];
        cnt[y]++;
        st[{vx,vy}]++;
    }
    cout << (ans << 1) << endl;
    return 0;
}