//
// Created by chenqwwq on 2022/6/18.
//


#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m;
    cin >> n;
    int vis[101];
    for (int &num: vis) num = 0;
    int mmax = 0, ans = 0;
    for (int i = 0; i < n; ++i) {
        cin >> m;
        if (++vis[m] > mmax) {
            mmax = ans = vis[m];
        }
    }
    cout << ans << endl;
    return 0;
}