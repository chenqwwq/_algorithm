//
// Created by chenqwwq on 2022/6/8.
//


#include "iostream"

typedef long long ll;
using namespace std;


int main() {
    ll b[1001];
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int tt, n, k, m;
    cin >> tt;
    while (tt--) {
        ll ans = 0;
        for (int i = 0; i <= 1000; ++i) b[i] = 0;

        cin >> n >> k;
        for (int i = 0; i < n; ++i) {
            cin >> m;
            ans += m / k;
            b[m % k]++;
        }

        int l = 1, r = k - 1;
        while (r > 0 && l < r) {
            if (!b[r]) {
                r--;
                continue;
            }
            while (l < r) {
                if (!b[l]) {
                    l++;
                    continue;
                }
                if (r + l >= k) {
                    ll dif = min(b[r], b[l]);
                    ans += dif;
                    b[r] -= dif;
                    b[l] -= dif;
                    break;
                }
                l++;
            }
        }
        if (l == r && l + r >= k) ans += b[l] >> 1;
        cout << ans << endl;
    }
    return 0;
}