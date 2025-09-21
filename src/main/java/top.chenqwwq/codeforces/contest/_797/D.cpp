//
// Created by chenqwwq on 2022/6/8.
//


#include "iostream"

using namespace std;
int inf = 0x3f3f3f3f;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int tt, n, k;
    string str;
    cin >> tt;
    while (tt--) {
        cin >> n >> k;
        cin >> str;
        int a = 0, ans = inf;
        for (int i = 0, j = 0; j < n; ++j) {
            if (str[j] == 'W') a++;
            if (j - i + 1 == k) {
                ans = min(ans, a);
                if (str[i++] == 'W') a--;
            }
        }
        cout << ans << endl;
    }
    return 0;
}