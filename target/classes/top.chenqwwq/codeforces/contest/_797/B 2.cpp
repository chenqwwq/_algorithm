//
// Created by chenqwwq on 2022/6/8.
//


#include "iostream"

using namespace std;
int maxn = 5e4;
int inf = 0x3f3f3f3f;


int main() {
    int a[maxn], b[maxn];
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int tt, n;
    cin >> tt;
    while (tt--) {
        cin >> n;
        for (int i = 0; i < n; ++i) cin >> a[i];
        for (int i = 0; i < n; ++i) cin >> b[i];
        int mmin = -inf, d = inf;
        bool ok = true;
        for (int i = 0; i < n; ++i) {
            if (a[i] < b[i]) {
                ok = false;
                break;
            }
            if (b[i] == 0) {
                // b 为 0 确定最少几次
                mmin = max(mmin, a[i] - b[i]);
            } else {
                // b 不为 0 确定最多几次
                int cur = a[i] - b[i];
                if (d == inf) d = cur;
                else if (d != cur) {
                    ok = false;
                    break;
                }
            }
        }
        printf("%s\n", ok && d >= mmin ? "YES" : "NO");
    }
    return 0;
}