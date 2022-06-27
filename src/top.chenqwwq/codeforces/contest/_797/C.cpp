//
// Created by chenqwwq on 2022/6/8.
//


#include "iostream"

using namespace std;
int maxn = 2e5 + 1;

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
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            cur = max(a[i], cur);
            cout << b[i] - cur;
            if (i < n - 1) cout << " ";
            cur = b[i];
        }
        cout << endl;
    }
    return 0;
}