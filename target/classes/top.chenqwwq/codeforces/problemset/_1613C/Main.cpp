//
// Created by chenqwwq on 2022/5/31.
//


#include "iostream"

using namespace std;
typedef long long ll;

int attack[101];

bool check(int n, ll k, ll h) {
    ll ans = 0;
    for (int i = 0; i < n - 1; ++i) {
        ans += min(ll(attack[i + 1] - attack[i]), k);
    }
    return ans + k >= h;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t, n;
    ll h;
    cin >> t;
    while (t--) {
        cin >> n >> h;
        for (int i = 0; i < n; ++i) cin >> attack[i];
        ll l = 0, r = h;
        while (l < r) {
            ll mid = (l + r) >> 1;
            if (check(n, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        printf("%lld\n", r);
    }
    return 0;

}